import {createContext, useContext, useState} from "react";

export const AuthContext = createContext(undefined);
export const useAuth = () => useContext(AuthContext);

export default function AuthContextProvider({children}) {
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [username, setUsername] = useState(null);

    function login(username, password) {
        console.log(username, password);
        if(username === 'Arno' && password === 'dummy') {
            console.log('Authenticated');
            setUsername(username);
            setIsAuthenticated(true);
            return true;
        } else {
            setIsAuthenticated(false);
            return false;
        }
    }

    function logout() {
        setIsAuthenticated(false);
    }

    return (
        <AuthContext.Provider value={{isAuthenticated, login, logout, username}}>
            {children}
        </AuthContext.Provider>
    );
}