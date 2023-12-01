import {createContext, useContext, useState} from "react";
import {executeJwtAuthenticationService} from "../api/AuthenticationService";
import {apiClient} from "../api/ApiClient";

export const AuthContext = createContext(undefined);
export const useAuth = () => useContext(AuthContext);

export default function AuthContextProvider({children}) {
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [username, setUsername] = useState(null);
    const [token, setToken] = useState(null);

    // function login(username, password) {
    //     console.log(username, password);
    //     if(username === 'Arno' && password === 'dummy') {
    //         console.log('Authenticated');
    //         setUsername(username);
    //         setIsAuthenticated(true);
    //         return true;
    //     } else {
    //         setIsAuthenticated(false);
    //         return false;
    //     }
    // }

    // async function login(username, password) {
    //     // Base64 encoding of username and password
    //     const baToken = 'Basic ' + window.btoa(username + ':' + password);
    //
    //     try {
    //         const response = await executeBasicAuthenticationService(baToken);
    //
    //         if(response.status === 200) {
    //             setUsername(username);
    //             setToken(baToken);
    //             setIsAuthenticated(true);
    //
    //             // Intercept all requests and add the Authorization header
    //             apiClient.interceptors.request.use(config => {
    //                 console.log("Intercepting request")
    //                 config.headers.Authorization = baToken;
    //                 return config;
    //             });
    //
    //             return true;
    //         } else {
    //             logout();
    //             return false;
    //         }
    //     } catch (error) {
    //         logout();
    //         return false;
    //     }
    // }

    async function login(username, password) {
        try {
            const response = await executeJwtAuthenticationService(username, password);

            if(response.status === 200) {
                const jwtToken = 'Bearer ' + response.data.token;

                setUsername(username);
                setIsAuthenticated(true);
                setToken(jwtToken);

                // Intercept all requests and add the Authorization header
                apiClient.interceptors.request.use(config => {
                    console.log("Intercepting request")
                    config.headers.Authorization = jwtToken; // Add the token to the request
                    return config;
                });

                return true;
            } else {
                logout();
                return false;
            }
        } catch (error) {
            logout();
            return false;
        }
    }

    function logout() {
        setUsername(null);
        setToken(null);
        setIsAuthenticated(false);
    }

    return (
        <AuthContext.Provider value={{isAuthenticated, login, logout, username, token}}>
            {children}
        </AuthContext.Provider>
    );
}