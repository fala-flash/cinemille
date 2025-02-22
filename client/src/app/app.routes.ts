import { Routes } from '@angular/router';
import { AdminProgrammazioneComponent } from './components/admin-programmazione/admin-programmazione.component';
import { PublicProgrammazioneComponent } from './components/public-programmazione/public-programmazione.component';

export const routes: Routes = [
{ path: '', redirectTo: '/public', pathMatch: 'full' },
  { path: 'public', component: PublicProgrammazioneComponent },
  { path: 'admin', component: AdminProgrammazioneComponent },
];
