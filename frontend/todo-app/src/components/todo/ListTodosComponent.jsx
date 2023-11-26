export default function ListTodosComponent() {
    const today = new Date();
    const targetData = new Date(today.getFullYear(), today.getMonth(), today.getDay());

    const todos = [
        {id: 1, description: 'Learn React', done: false, targetDate: targetData},
        {id: 2, description: 'Learn Spring', done: false, targetDate: targetData},
        {id: 3, description: 'Learn AWS', done: false, targetDate: targetData},
    ]

    return (
        <div className="container">
            <h1>Things you want todo</h1>
            <div>
                <table className="table">
                    <thead>
                    <tr>
                        <th>Description</th>
                        <th>Done</th>
                        <th>Target Date</th>
                    </tr>
                    </thead>
                    <tbody>
                    {todos.map(todo => (
                        <tr key={todo.id}>
                            <td>{todo.description}</td>
                            <td>{todo.done.toString()}</td>
                            <td>{todo.targetDate.toDateString()}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
}