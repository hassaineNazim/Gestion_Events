import { Component, OnInit, ChangeDetectorRef } from '@angular/core'; // <--- 1. On importe le ChangeDetectorRef
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-event-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './event-list.html',
  styleUrl: './event-list.css'
})
export class EventListComponent implements OnInit {

  events: any[] = [];

  // 2. On injecte le 'cd' (ChangeDetector) dans le constructeur
  constructor(private http: HttpClient, private cd: ChangeDetectorRef) {}

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
}