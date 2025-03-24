import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';
import { AuthenticatedComponent } from './pages/authenticated/authenticated.component';
import { AuthGuard } from './services/auth-guard.service';

export const routes: Routes = [
    {
        path: "login",
        component: LoginComponent   
    },
    {
        path: "signup",
        component: SignupComponent
    },
    {
        path: "user",
        component: AuthenticatedComponent,
        canActivate: [AuthGuard]
    }
];
