import { Routes } from '@angular/router';
import { EventListComponent } from './event-list/event-list';
import { CreateEventComponent } from './create-event/create-event';
import { MyRegistrationsComponent } from './my-registrations/my-registrations';
import { EventParticipantsComponent } from './event-participants/event-participants';

export const routes: Routes = [
    // Route par défaut : redirige vers /events
    { path: '', redirectTo: 'events', pathMatch: 'full' },

    // Route pour voir la liste
    { path: 'events', component: EventListComponent },

    { path: 'create-event', component: CreateEventComponent },

    { path: 'my-registrations', component: MyRegistrationsComponent },

    { path: 'event-participants/:id', component: EventParticipantsComponent }
];
