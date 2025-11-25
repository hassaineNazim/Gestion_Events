import { Component, OnInit, ChangeDetectorRef } from '@angular/core'; // <--- 1. On importe le ChangeDetectorRef
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-event-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './event-list.html',
  styleUrl: './event-list.css'
})
export class EventListComponent implements OnInit {

  events: any[] = [];

  // On simule un utilisateur connecté (ID = 1) pour l'instant
  participantId = 1;

  // 2. On injecte le 'cd' (ChangeDetector) dans le constructeur
  constructor(private http: HttpClient, private cd: ChangeDetectorRef) { }

  ngOnInit(): void {
    this.recupererEvenements();
  }

  recupererEvenements() {
    this.http.get<any[]>('http://localhost:8082/events').subscribe({
      next: (data) => {
        console.log('Données AVANT affectation :', data);

        // 3. On met à jour la variable
        this.events = data;

        // 4. LA COMMANDE MAGIQUE : On force Angular à vérifier la vue maintenant
        this.cd.detectChanges();

        console.log('Données APRÈS affectation (dans la variable) :', this.events);
      },
      error: (err) => {
        console.error('Erreur :', err);
      }
    });
  }

  // --- NOUVELLE MÉTHODE À AJOUTER ---
  sInscrire(evenementId: number) {
    // L'objet qu'on envoie au registration-service
    const inscription = {
      evenementId: evenementId,
      participantId: this.participantId,
      statut: 'CONFIRMEE'
    };

    // Appel au Microservice Registration (Port 8083)
    this.http.post('http://localhost:8083/inscriptions', inscription).subscribe({
      next: (res) => {
        alert('Inscription réussie !');
        console.log('Réponse inscription:', res);
      },
      error: (err) => {
        console.error('Erreur inscription:', err);
        alert('Erreur lors de l\'inscription (Vérifiez que le service 8083 tourne)');
      }
    });
  }
}
