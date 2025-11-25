import { Component, OnInit, ChangeDetectorRef } from '@angular/core'; // <--- 1. Import du ChangeDetectorRef
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-my-registrations',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './my-registrations.html',
  styleUrl: './my-registrations.css'
})
export class MyRegistrationsComponent implements OnInit {

  inscriptions: any[] = [];
  participantId = 1;

  // 2. Injection du 'cd' dans le constructeur
  constructor(private http: HttpClient, private cd: ChangeDetectorRef) { }

  ngOnInit(): void {
    this.http.get<any[]>(`http://localhost:8083/inscriptions/participant/${this.participantId}`)
      .subscribe({
        next: (data) => {
          console.log('Données reçues :', data);

          this.inscriptions = data; // Mise à jour de la variable

          // 3. LA COMMANDE MAGIQUE : On force l'affichage
          this.cd.detectChanges();
        },
        error: (err) => {
          console.error('Erreur :', err);
        }
      });
  }
}