  import { Component, OnInit } from '@angular/core';
  import { ActivatedRoute } from '@angular/router';
  import { HttpClient } from '@angular/common/http';
  import { Observable } from 'rxjs';
  import { map } from 'rxjs/operators';
  import moment from 'moment'; 

  @Component({
    selector: 'app-movie',
    templateUrl: './movie.component.html',
    styleUrls: ['./movie.component.css']
  })
  export class MovieComponent implements OnInit {
    movie: any; 
    apiUrl = 'http://localhost:8080/api/films';
    movies!: any[]; 

    constructor(private route: ActivatedRoute, private http: HttpClient) { }

    ngOnInit(): void {  
      this.route.params.subscribe(params => {
        const movieId = +params['id']; 
      
        this.fetchMovie(movieId).subscribe(movie => {
          this.movie = movie;
        });
        
        this.fetchAllMovies().subscribe(movies => {
          this.movies = movies;
          console.log("hahiya lista MOVIES",this.movies); // Log the movies array

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

    // Method to fetch all movies
    fetchAllMovies(): Observable<any[]> {
      return this.http.get<any[]>(this.apiUrl).pipe(
        map((response: any) => response._embedded.films) // Extract films array from response
      );
    }

    // Method to format the date using Moment.js
    formatDate(dateString: string): string {
      return moment(dateString).format('DD-MM-YYYY');
    }
  }
