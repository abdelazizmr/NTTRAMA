// movies.component.ts
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
  movies: any[] = [];
  currentPage = 1; 
  pageSize = 16; 
  filteredMovies!: any[];
  searchQuery: string = '';
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchMovies();
    this.filteredMovies = [...this.movies]; // Initialize filteredMovies with all movies

  }

  fetchMovies() {
    this.http.get<any>('http://localhost:8080/api/films').subscribe(data => {
      this.movies = data._embedded.films;

    });
  }
  filterMovies(searchQuery: string) {
    // Filter movies based on the search query
    this.filteredMovies = this.movies.filter(movie =>
      movie.title.toLowerCase().includes(searchQuery.toLowerCase()) ||
      movie.year.toString().includes(searchQuery.toLowerCase())
    );
  }
  
  get paginatedMovies() {
    const startIndex = (this.currentPage - 1) * this.pageSize;
    const endIndex = startIndex + this.pageSize;
    return this.movies.slice(startIndex, endIndex);
  }

  get pages(): number[] {
    const pageCount = Math.ceil(this.movies.length / this.pageSize);
    return Array(pageCount).fill(0).map((x, i) => i + 1);
  }

  goToPage(page: number) {
    this.currentPage = page;
  }

  nextPage() {
    if (this.currentPage < this.pages.length) {
      this.currentPage++;
    }
  }

  prevPage() {
    if (this.currentPage > 1) {
      this.currentPage--;
    }
  }
}
