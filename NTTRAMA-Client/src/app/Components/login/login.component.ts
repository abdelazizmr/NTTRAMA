// login.component.ts
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../Services/auth.service'; 

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  loginError: string = ''; 

  constructor(private router: Router, private authService: AuthService) {}
  login(): void {
    this.authService.login(this.email, this.password).subscribe(
      (response) => {
        if (response.success) {
          console.log("wayiih ha nta dezti");
          this.router.navigate(['/clients']);
        } else {
          this.loginError = 'Invalid email or password.';
          setTimeout(() => {
            this.router.navigate(['/login']);
          }, 3000); 
        }
      },
      (error) => {
        console.error('An error occurred:', error);
      }
    );
  }
}
