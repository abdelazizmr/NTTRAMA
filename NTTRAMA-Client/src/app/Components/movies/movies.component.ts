import { Component, OnInit } from '@angular/core';
import { moviesData } from './movies-data'; // Import the static movie data

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
  movies = moviesData;
  currentPage = 1; 
  pageSize = 8; 
  constructor() { }

  ngOnInit(): void {
  }

  get pages(): number[] {
    const pageCount = Math.ceil(this.movies.length / this.pageSize);
    return Array(pageCount).fill(0).map((x, i) => i + 1);
  }
}
