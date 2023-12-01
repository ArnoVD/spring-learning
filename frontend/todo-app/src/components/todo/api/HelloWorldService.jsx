import {apiClient} from "./ApiClient";

export const retrieveHelloWorldBean
    = () => apiClient.get('/hello-world-bean');

export const retrieveHelloWorldBeanPathVariable = (name) => apiClient.get(`/hello-world/path-variable/${name}`);