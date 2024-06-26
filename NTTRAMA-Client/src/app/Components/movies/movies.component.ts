import { Component, EventEmitter, OnInit, Output,ChangeDetectorRef  } from '@angular/core';
import { HttpClient } from '@angular/common/http';



@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
  movies: any[] = [];
  paginatedMovies: any[] = [];
  currentPage: number = 1;
  pageSize: number = 16; 
  totalPages: number = 0;
  pages: number[] = [];

  constructor(private http: HttpClient,private cdr: ChangeDetectorRef) { }
  searchQuery!: string ;
  // @Output() searchQueryChange: EventEmitter<string> = new EventEmitter<string>();

  ngOnInit(): void {
    this.fetchMovies();
    this.cdr.detectChanges();
  }
  onSearchChange(): void {
    // Filter movies based on the search query
    this.paginatedMovies = this.movies.filter(movie =>
      movie.title.toLowerCase().includes(this.searchQuery.toLowerCase())
    );
    console.log(this.paginatedMovies )
  
    // Reset pagination to the first page
    this.setPage(1);
  }
  
  fetchMovies(): void {
    this.http.get<any>('http://localhost:8080/api/films').subscribe(data => {
      this.movies = data._embedded.films;
      this.totalPages = Math.ceil(this.movies.length / this.pageSize);
      this.setPage(1);
    });
  }

  setPage(page: number): void {
    this.currentPage = page;
    this.paginatedMovies = this.movies.slice((page - 1) * this.pageSize, page * this.pageSize);
    this.calculatePages();
  }

  calculatePages(): void {
    this.pages = [];
    for (let i = 1; i <= this.totalPages; i++) {
      this.pages.push(i);
    }
  }

  prevPage(): void {
    if (this.currentPage > 1) {
      this.setPage(this.currentPage - 1);
    }
  }

  nextPage(): void {
    if (this.currentPage < this.totalPages) {
      this.setPage(this.currentPage + 1);
    }
  }

  goToPage(page: number): void {
    this.setPage(page);
  }
}
