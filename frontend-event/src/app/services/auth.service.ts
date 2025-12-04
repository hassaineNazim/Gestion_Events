import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class AuthService {
    // Assuming Gateway is running on port 8080 and routes /users/** to user-service
    // Adjust port if application.properties says otherwise
    private apiUrl = 'http://localhost:8088/user-service/auth';

    constructor(private http: HttpClient) { }

    register(user: any): Observable<any> {
        return this.http.post(`${this.apiUrl}/register`, user, { responseType: 'text' });
    }

    login(credentials: any): Observable<any> {
        return this.http.post(`${this.apiUrl}/token`, credentials, { responseType: 'text' }).pipe(
            tap(token => this.saveToken(token))
        );
    }

    saveToken(token: string): void {
        localStorage.setItem('token', token);
    }

    getToken(): string | null {
        return localStorage.getItem('token');
    }

    isLoggedIn(): boolean {
        return !!this.getToken();
    }

    logout(): void {
        localStorage.removeItem('token');
    }
}
