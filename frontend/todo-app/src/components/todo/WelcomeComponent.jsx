import {Link, useParams} from "react-router-dom";
import {useState} from "react";
import {retrieveHelloWorldBeanPathVariable} from "./api/HelloWorldService";
import {useAuth} from "./security/AuthContext";

export default function WelcomeComponent() {
    const {username} = useParams();
    const authContext = useAuth();

    const [message, setMessage] = useState(null);

    function callHelloWorldRestApi() {
        retrieveHelloWorldBeanPathVariable(username, authContext.token)
            .then(response => {
                console.log(response);
                setMessage(response.data.message);
            })
            .catch(error => console.log(error))
            .finally(() => console.log('Cleanup'));
    }

    return (
        <div className="Welcome">
            <h1>Welcome, {username} !</h1>
            <div>
                Your todos. <Link to="/todos">Click here</Link> to view them.
            </div>
            <div>
                <button className='btn btn-success m-5' onClick={callHelloWorldRestApi}>Call Hello World</button>
            </div>
            <div className="text-info">
                {message}
            </div>
        </div>
    );
}