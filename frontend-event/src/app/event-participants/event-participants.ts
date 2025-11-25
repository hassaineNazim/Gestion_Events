import { Component, OnInit, ChangeDetectorRef } from '@angular/core'; // <--- 1. Import
import { ActivatedRoute, RouterModule } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-event-participants',
  standalone: true,
  imports: [CommonModule, RouterModule],
  // Vérifiez vos noms de fichiers :
  templateUrl: './event-participants.html',
  styleUrl: './event-participants.css'
})
export class EventParticipantsComponent implements OnInit {

  inscriptions: any[] = [];
  eventId: any;

  // 2. Injection du 'cd'
  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private cd: ChangeDetectorRef
  ) { }

  ngOnInit(): void {
    this.eventId = this.route.snapshot.paramMap.get('id');
    this.recupererParticipants();
  }

  recupererParticipants() {
    this.http.get<any[]>(`http://localhost:8083/inscriptions/evenement/${this.eventId}`)
      .subscribe({
        next: (data) => {
          console.log('Participants :', data);

          this.inscriptions = data;

          // 3. LA LIGNE QUI RÉVEILLE ANGULAR
          this.cd.detectChanges();
        },
        error: (err) => {
          console.error('Erreur :', err);
        }
      });
  }
}