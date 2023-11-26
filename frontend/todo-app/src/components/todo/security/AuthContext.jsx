import {createContext, useContext, useState} from "react";

export const AuthContext = createContext(undefined);
export const useAuth = () => useContext(AuthContext);

export default function AuthContextProvider({children}) {
    const [isAuthenticated, setIsAuthenticated] = useState(false);

    function login(username, password) {
        if(username === 'Arno' && password === 'dummy') {
            setIsAuthenticated(true);
            return isAuthenticated;
        } else {
            setIsAuthenticated(false);
            return isAuthenticated;
        }
    }

    function logout() {
        setIsAuthenticated(false);
    }

    return (
        <AuthContext.Provider value={{isAuthenticated, login, logout}}>
            {children}
        </AuthContext.Provider>
    );
}