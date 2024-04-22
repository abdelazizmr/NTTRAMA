import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { moviesData } from '../movies/movies-data';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {
  movie: any; // Define movie property to hold movie data

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    // Get movie id from route parameters
    this.route.params.subscribe(params => {
      const movieId = +params['id']; // Convert id to number
      // Find movie with matching id from moviesData
      this.movie = moviesData.find(movie => movie.id === movieId);
    });
  }
}
