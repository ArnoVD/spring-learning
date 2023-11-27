import './TodoApp.css';
import {BrowserRouter, Routes, Route, Navigate} from "react-router-dom";
import LoginComponent from "./LoginComponent";
import LogoutComponent from "./LogoutComponent";
import WelcomeComponent from "./WelcomeComponent";
import ListTodosComponent from "./ListTodosComponent";
import HeaderComponent from "./HeaderComponent";
import FooterComponent from "./FooterComponent";
import ErrorComponent from "./ErrorComponent";
import AuthContextProvider, {useAuth} from "./security/AuthContext";
import TodoComponent from "./TodoComponent";

function AuthenticatedRoute({children}) {
    const authContext = useAuth();
    const isAuthenticated = authContext.isAuthenticated;

    if (isAuthenticated) return children;

    return <Navigate to="/login" />;
}

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <AuthContextProvider>
                <BrowserRouter>
                    <HeaderComponent />
                    <Routes>
                        <Route path="/" element={<LoginComponent />} />
                        <Route path="/login" element={<LoginComponent />} />

                        <Route path="/welcome/:username" element={
                            <AuthenticatedRoute>
                                <WelcomeComponent />
                            </AuthenticatedRoute>
                        } />
                        <Route path="/todos" element={
                            <AuthenticatedRoute>
                                <ListTodosComponent />
                            </AuthenticatedRoute>
                        } />
                        <Route path="/todo/:id" element={
                            <AuthenticatedRoute>
                                <TodoComponent />
                            </AuthenticatedRoute>
                        } />
                        <Route path="/logout" element={
                            <AuthenticatedRoute>
                                <LogoutComponent />
                            </AuthenticatedRoute>
                        } />

                        <Route path="*" element={<ErrorComponent />} />
                    </Routes>
                    <FooterComponent />
                </BrowserRouter>
            </AuthContextProvider>
        </div>
    );
}