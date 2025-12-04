import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
    selector: 'app-login',
    standalone: true,
    imports: [CommonModule, FormsModule],
    template: `
    <div class="login-container">
      <h2>Connexion</h2>
      <form (ngSubmit)="onSubmit()">
        <div class="form-group">
          <label for="nom">Nom d'utilisateur</label>
          <input type="text" id="nom" [(ngModel)]="credentials.nom" name="nom" required>
        </div>
        <div class="form-group">
          <label for="password">Mot de passe</label>
          <input type="password" id="password" [(ngModel)]="credentials.password" name="password" required>
        </div>
        <button type="submit">Se connecter</button>
      </form>
      <p *ngIf="errorMessage" class="error">{{ errorMessage }}</p>
    </div>
  `,
    styles: [`
    .login-container { max-width: 400px; margin: 50px auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; }
    .form-group { margin-bottom: 15px; }
    label { display: block; margin-bottom: 5px; }
    input { width: 100%; padding: 8px; box-sizing: border-box; }
    button { width: 100%; padding: 10px; background-color: #007bff; color: white; border: none; cursor: pointer; }
    button:hover { background-color: #0056b3; }
    .error { color: red; margin-top: 10px; }
  `]
})
export class LoginComponent {
    credentials = { nom: '', password: '' };
    errorMessage = '';

    constructor(private authService: AuthService, private router: Router) { }

    onSubmit() {
        this.authService.login(this.credentials).subscribe({
            next: (token) => {
                console.log('Login successful', token);
                this.router.navigate(['/event-list']); // Redirect to event list
            },
            error: (err) => {
                console.error('Login failed', err);
                this.errorMessage = 'Échec de la connexion. Vérifiez vos identifiants.';
            }
        });
    }
}
