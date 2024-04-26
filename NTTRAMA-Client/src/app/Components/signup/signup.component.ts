import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  firstName: string = '';
  lastName: string = '';
  email: string = '';
  password: string = '';
  newsletterSubscription: boolean = false;
  errorMessage: string = '';

  constructor(private http: HttpClient) { }

  onSubmit(): void {
    const userData = {
      firstName: this.firstName,
      lastName: this.lastName,
      email: this.email,
      password: this.password,
      newsletterSubscription: this.newsletterSubscription
    };

    this.http.post<any>('http://localhost:8080/api/user/register', userData)
      .subscribe(
        response => {
          // Handle successful sign-up
          console.log('Sign-up successful:', response);
          // Optionally, redirect the user to a different page
        },
        error => {
          // Handle sign-up error
          console.error('Sign-up error:', error);
          this.errorMessage = 'An error occurred during sign-up. Please try again later.';
        }
      );
  }
}
