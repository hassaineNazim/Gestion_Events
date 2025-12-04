import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
    selector: 'app-register',
    standalone: true,
    imports: [CommonModule, FormsModule],
    template: `
    <div class="register-container">
      <h2>Inscription</h2>
      <form (ngSubmit)="onSubmit()">
        <div class="form-group">
          <label for="nom">Nom d'utilisateur</label>
          <input type="text" id="nom" [(ngModel)]="user.nom" name="nom" required>
        </div>
        <div class="form-group">
          <label for="email">Email</label>
          <input type="email" id="email" [(ngModel)]="user.email" name="email" required>
        </div>
        <div class="form-group">
          <label for="password">Mot de passe</label>
          <input type="password" id="password" [(ngModel)]="user.password" name="password" required>
        </div>
        <div class="form-group">
          <label for="role">Rôle</label>
          <select id="role" [(ngModel)]="user.role" name="role">
            <option value="PARTICIPANT">Participant</option>
            <option value="ORGANISATEUR">Organisateur</option>
          </select>
        </div>
        <button type="submit">S'inscrire</button>
      </form>
      <p *ngIf="errorMessage" class="error">{{ errorMessage }}</p>
    </div>
  `,
    styles: [`
    .register-container { max-width: 400px; margin: 50px auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; }
    .form-group { margin-bottom: 15px; }
    label { display: block; margin-bottom: 5px; }
    input, select { width: 100%; padding: 8px; box-sizing: border-box; }
    button { width: 100%; padding: 10px; background-color: #28a745; color: white; border: none; cursor: pointer; }
    button:hover { background-color: #218838; }
    .error { color: red; margin-top: 10px; }
  `]
})
export class RegisterComponent {
    user = { nom: '', email: '', password: '', role: 'PARTICIPANT' };
    errorMessage = '';

    constructor(private authService: AuthService, private router: Router) { }

    onSubmit() {
        this.authService.register(this.user).subscribe({
            next: (response) => {
                console.log('Registration successful', response);
                this.router.navigate(['/login']);
            },
            error: (err) => {
                console.error('Registration failed', err);
                this.errorMessage = 'Échec de l\'inscription.';
            }
        });
    }
}
