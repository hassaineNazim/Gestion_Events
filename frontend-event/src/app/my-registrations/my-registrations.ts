import { Component, OnInit } from '@angular/core';
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

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    // Appel au service Registration (Port 8083)
    this.http.get<any[]>(`http://localhost:8083/inscriptions/participant/${this.participantId}`)
      .subscribe({
        next: (data) => {
          this.inscriptions = data;
          console.log('Mes inscriptions :', data);
        },
        error: (err) => {
          console.error('Erreur :', err);
        }
      });
  }
}