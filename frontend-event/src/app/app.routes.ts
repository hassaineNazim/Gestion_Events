import { Routes } from '@angular/router';
import { EventListComponent } from './event-list/event-list';

export const routes: Routes = [
    // Route par défaut : redirige vers /events
    { path: '', redirectTo: 'events', pathMatch: 'full' },
    
    // Route pour voir la liste
    { path: 'events', component: EventListComponent }
];