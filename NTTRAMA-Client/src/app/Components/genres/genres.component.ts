import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-genres',
  templateUrl: './genres.component.html',
  styleUrls: ['./genres.component.css']
})
export class GenresComponent implements OnInit {
  apiUrl = 'http://localhost:8080/api/genres';
  genres: any[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchGenres();
  }

  fetchGenres(): void {
    this.http.get<any>(this.apiUrl).subscribe(
      (data) => {
        this.genres = data._embedded.genres;
      },
      (error) => {
        console.error('Error fetching genres:', error);
      }
    );
  }
}
