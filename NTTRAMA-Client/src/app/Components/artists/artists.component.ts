import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-artists',
  templateUrl: './artists.component.html',
  styleUrls: ['./artists.component.css']
})
export class ArtistsComponent implements OnInit {
  artists: any[] = [];
  apiUrl = 'http://localhost:8080/api/artists';

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.fetchArtists().subscribe(artists => {
      this.artists = artists._embedded.artists;
    });
  }

  fetchArtists(): Observable<any> {
    return this.http.get(this.apiUrl);
  }
}
