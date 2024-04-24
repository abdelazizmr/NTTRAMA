import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-artist',
  templateUrl: './artist.component.html',
  styleUrls: ['./artist.component.css']
})
export class ArtistComponent implements OnInit {
  artist: any;
  artists!: any[];

  constructor(private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const artistId = +params['id']; 

      this.fetchArtist(artistId).subscribe(artist => {
        this.artist = artist;
      });
    });

    this.fetchAllArtists().subscribe(artists => {
      this.artists = artists;
    });
  }

  fetchArtist(artistId: number): Observable<any> {
    const url = `http://localhost:8080/api/artists/${artistId}`;
    return this.http.get(url).pipe(
      map((response: any) => response)
    );
  }

  fetchAllArtists(): Observable<any[]> {
    const url = 'http://localhost:8080/api/artists';
    return this.http.get<any[]>(url).pipe(
      map((response: any) => response._embedded.artists)
    );
  }
}
