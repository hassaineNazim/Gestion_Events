import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router'; // Pour rediriger l'utilisateur après l'enregistrement
import { FormsModule } from '@angular/forms'; // <--- INDISPENSABLE pour les formulaires
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-create-event',
  standalone: true,
  imports: [CommonModule, FormsModule], // <--- On ajoute FormsModule ici
  templateUrl: './create-event.html',
  styleUrl: './create-event.css'
})
export class CreateEventComponent {

  // L'objet qui va contenir les données du formulaire
  event: any = {
    titre: '',
    description: '',
    lieu: '',
    date: '',
    organisateurId: 1 // On met 1 en dur pour l'instant
  };

  constructor(private http: HttpClient, private router: Router) { }

  onSubmit() {
    // On envoie les données au Backend (Port 8082)
    this.http.post('http://localhost:8082/events', this.event).subscribe({
      next: (res) => {
        console.log('Succès !', res);
        // Une fois enregistré, on retourne à la liste des événements
        this.router.navigate(['/events']);
      },
      error: (err) => {
        console.error('Erreur :', err);
        alert('Erreur lors de la création');
      }
    });
  }
}