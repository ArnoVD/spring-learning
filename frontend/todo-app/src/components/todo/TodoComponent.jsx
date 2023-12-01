import {useNavigate, useParams} from "react-router-dom";
import {useAuth} from "./security/AuthContext";
import {createTodo, retrieveTodoByUserNameAndId, updateTodoByUsernameAndId} from "./api/TodoApiService";
import {useEffect, useState} from "react";
import {ErrorMessage, Field, Form, Formik} from "formik";
import moment from "moment";

export default function TodoComponent() {

    const authContext = useAuth();
    const navigate = useNavigate();
    const username = authContext.username;
    const id = useParams().id;

    const [todo, setTodo] = useState({});

    useEffect(() => {
        retrieveTodoById();
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [id]);

    function retrieveTodoById() {
        if(id === "-1") return;
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

    function onSubmit(values) {
        console.log(values);
        const todo = {"username": username, id: values.id, "description": values.description, "targetDate": values.targetDate, "done": false}

        if(id === "-1") {
            createTodo(username, todo).then(response => {
                console.log(response.data);
                navigate("/todos");
            }).catch(error => console.log(error));
        } else {
            updateTodoByUsernameAndId(username, id, todo).then(response => {
                console.log(response.data);
                navigate("/todos");
            }).catch(error => console.log(error));
        }
    }

    function validate(values) {
        let errors = {};

        if(values.description.length < 5) {
            errors.description = "Enter at least 5 characters in description";
        }

        if(values.targetDate === null || values.targetDate === undefined || values.targetDate === "" || !moment(values.targetDate).isValid()) {
            errors.description = "Enter a valid target date";
        }

        return errors;
    }

    return (
        <div className="container">
            <h1>Enter Todo Details</h1>
            <div>
                <Formik initialValues={{"description": todo.description, "targetDate": todo.targetDate}} enableReinitialize={true} onSubmit={onSubmit} validate={validate} validateOnChange={false} validateOnBlur={false}>
                    {(props) => (
                        <Form>
                            <ErrorMessage name="description" component="div" className="alert alert-warning"></ErrorMessage>
                            <ErrorMessage name="targetDate" component="div" className="alert alert-warning"></ErrorMessage>
                            <fieldset className="form-group">
                                <label>Description</label>
                                <Field type="text" className="form-control" name="description"></Field>
                            </fieldset>
                            <fieldset className="form-group">
                                <label>Target Date</label>
                                <Field type="date" className="form-control" name="targetDate"></Field>
                            </fieldset>
                            <div>
                                <button className="btn btn-success m-5" type="submit">Save</button>
                            </div>
                        </Form>
                    )}
                </Formik>
            </div>
        </div>
    )
}