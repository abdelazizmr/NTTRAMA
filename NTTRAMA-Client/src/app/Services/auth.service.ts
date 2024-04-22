// auth.service.ts
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { clientsData } from '../Components/clients/clients-data';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  loggedInUser: string = '';

  constructor() {}

  login(email: string, password: string): Observable<any> {
    return new Observable(observer => {
      const client = clientsData.find(client => client.email === email && client.password === password);
      if (client) {
        this.loggedInUser = client.email;
        observer.next({ success: true });
        observer.complete();
      } else {
        observer.next({ success: false });
        observer.complete();
      }
    });
  }

  logout(): void {
    this.loggedInUser = '';
  }

  isLoggedIn(): string {
    return this.loggedInUser;
  }
}
