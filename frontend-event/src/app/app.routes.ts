import { Routes } from '@angular/router';
import { EventListComponent } from './event-list/event-list';
import { CreateEventComponent } from './create-event/create-event';
import { MyRegistrationsComponent } from './my-registrations/my-registrations';
import { EventParticipantsComponent } from './event-participants/event-participants';
import { authGuard } from './guards/auth.guard';

export const routes: Routes = [
    // Route par défaut : redirige vers /events
    { path: '', redirectTo: 'events', pathMatch: 'full' },

    // Route pour voir la liste
    { path: 'events', component: EventListComponent, canActivate: [authGuard] },

    { path: 'create-event', component: CreateEventComponent, canActivate: [authGuard] },

    { path: 'my-registrations', component: MyRegistrationsComponent, canActivate: [authGuard] },

    { path: 'event-participants/:id', component: EventParticipantsComponent },
    { path: 'login', loadComponent: () => import('./login/login.component').then(m => m.LoginComponent) },
    { path: 'register', loadComponent: () => import('./register/register.component').then(m => m.RegisterComponent) }
];
