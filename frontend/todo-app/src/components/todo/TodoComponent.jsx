import {useParams} from "react-router-dom";
import {useAuth} from "./security/AuthContext";
import {retrieveTodoByUserNameAndId} from "./api/TodoApiService";
import {useEffect, useState} from "react";

export default function TodoComponent() {

    const authContext = useAuth();
    const username = authContext.username;
    const id = useParams().id;

    const [todo, setTodo] = useState({});

    useEffect(() => {
        retrieveTodoById();
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [username, id]);

    function retrieveTodoById() {
        retrieveTodoByUserNameAndId(username, id).then(response => {
            console.log(response.data);
            setTodo({
                id: response.data.id,
                description: response.data.description,
                done: response.data.done,
                targetDate: response.data.targetDate
            });
        }).catch(error => console.log(error));
    }

    return (
        <div className="container">
            <h1>Enter Todo Details</h1>
            <div>

            </div>
        </div>
    )
}