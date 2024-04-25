import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-genre',
  templateUrl: './genre.component.html',
  styleUrls: ['./genre.component.css']
})
export class GenreComponent implements OnInit {
  genreId!: number;
  genreName!: string;
  movies: any[] = [];

  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.genreId = +params['id']; // Get genreId from route parameters
      this.loadGenreAndMovies(this.genreId);
    });
  }

  loadGenreAndMovies(genreId: number): void {
    this.http.get<any>(`http://localhost:8080/api/genres/${genreId}`).subscribe((genreData: any) => {
      this.genreName = genreData.genre_name;
      this.http.get<any[]>(genreData.films).subscribe((moviesData: any) => {
        if (moviesData._embedded && moviesData._embedded.films) {
          this.movies = moviesData._embedded.films;
          console.log("movies array :", this.movies)
        } else {
          this.movies = []; // No films found
        }
      });
    });
  }
}
