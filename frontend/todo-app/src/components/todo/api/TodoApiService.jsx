import {apiClient} from "./ApiClient";

export const retrieveAllTodosByUsername = (username) => apiClient.get(`/users/${username}/todos`);
export const retrieveTodoByUserNameAndId = (username, id) => apiClient.get(`/users/${username}/todos/${id}`);
export const createTodo = (username, todo) => apiClient.post(`/users/${username}/todos`, todo);
export const updateTodoByUsernameAndId = (username, id, todo) => apiClient.put(`/users/${username}/todos/${id}`, todo);
export const deleteTodoByUsernameAndId = (username, id) => apiClient.delete(`/users/${username}/todos/${id}`);