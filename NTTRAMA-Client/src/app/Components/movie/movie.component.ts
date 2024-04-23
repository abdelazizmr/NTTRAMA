import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http'; // Import HttpClient
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {
  movie: any; // Define movie property to hold movie data
  apiUrl = 'http://localhost:8080/api/films'; // Your API endpoint URL

  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit(): void {
    // Get movie id from route parameters
    this.route.params.subscribe(params => {
      const movieId = +params['id']; // Convert id to number
      // Fetch movie data from the API
      this.fetchMovie(movieId).subscribe(movie => {
        this.movie = movie;
      });
    });
  }

  // Method to fetch movie data from the API
  fetchMovie(movieId: number): Observable<any> {
    const url = `${this.apiUrl}/${movieId}`;
    return this.http.get(url).pipe(
      map((response: any) => response)
    );
  }
}
