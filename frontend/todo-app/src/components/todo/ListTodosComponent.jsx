import {useEffect, useState} from "react";
import {deleteTodoByUsernameAndId, retrieveAllTodosByUsername} from "./api/TodoApiService";
import {useAuth} from "./security/AuthContext";
import {useNavigate} from "react-router-dom";

export default function ListTodosComponent() {
    // const today = new Date();
    // const targetData = new Date(today.getFullYear(), today.getMonth(), today.getDay());

    const navigate = useNavigate();

    const [todos, setTodos] = useState([]);

    const [message, setMessage] = useState(null);

    const authContext = useAuth();
    const username = authContext.username;

    // const todos = [
    //     {id: 1, description: 'Learn React', done: false, targetDate: targetData},
    //     {id: 2, description: 'Learn Spring', done: false, targetDate: targetData},
    //     {id: 3, description: 'Learn AWS', done: false, targetDate: targetData},
    // ]

    useEffect(() => {
        refreshTodos();
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    function refreshTodos() {
        retrieveAllTodosByUsername(username).then(response => {
            console.log(response.data);
            setTodos(response.data);
        }).catch(error => console.log(error))
    }

    function deleteTodo(id) {
        deleteTodoByUsernameAndId(username, id).then(response => {
            console.log(response.data);
            setMessage(`Delete of todo ${id} successful`);
            refreshTodos();
        }).catch(error => console.log(error));
    }

    function updateTodo(id) {
        navigate(`/todo/${id}`);
    }

    return (
        <div className="container">
            <h1>Things you want todo</h1>
            {message && <div className="alert alert-success">{message}</div>}
            <div>
                <table className="table">
                    <thead>
                    <tr>
                        <th>Description</th>
                        <th>Done</th>
                        <th>Target Date</th>
                        <th>Delete</th>
                        <th>Update</th>
                    </tr>
                    </thead>
                    <tbody>
                    {todos.map(todo => (
                        <tr key={todo.id}>
                            <td>{todo.description}</td>
                            <td>{todo.done.toString()}</td>
                            <td>{todo.targetDate}</td>
                            {/*<td>{todo.targetDate.toDateString()}</td>*/}
                            <td><button className="btn btn-warning" onClick={() => deleteTodo(todo.id)}>Delete</button></td>
                            <td><button className="btn btn-success" onClick={() => updateTodo(todo.id)}>Update</button></td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}