import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-sessions',
  templateUrl: './sessions.component.html',
  styleUrls: ['./sessions.component.css']
})
export class SessionsComponent implements OnInit {
  movieSessions: any[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.loadMovieSessions();
  }

  loadMovieSessions(): void {
    this.http.get<any>('http://localhost:8080/api/movieSessions').subscribe((data: any) => {
      this.movieSessions = data._embedded.movieSessions;
    });
  }
}
