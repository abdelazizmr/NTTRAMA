import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { CLIENT_RENEG_LIMIT } from 'tls';

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

    this.http.get<any>(`http://localhost:8080/api/genres/${this.genreId}`)
    .subscribe((genrename: any) => {
      this.genreName = genrename.genre_name;
      // console.log("genre name :", this.genreName)

    });
      
    });
  }

  loadGenreAndMovies(genreId: number): void {
    this.http.get<any>(`http://localhost:8080/api/genres/${genreId}/films`)
    .subscribe((moviesData: any) => {
      this.movies = moviesData._embedded.films;
      // console.log("data :", this.movies)

    });
  }
}

