import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MoviesComponent } from './Components/movies/movies.component';
import { MovieComponent } from './Components/movie/movie.component';
import { LoginComponent } from './Components/login/login.component';
import { HeaderComponent } from './Components/header/header.component';
import { FooterComponent } from './Components/footer/footer.component';
import { SignupComponent } from './Components/signup/signup.component';
import { ClientsComponent } from './Components/clients/clients.component';
import { ClientComponent } from './Components/client/client.component';
import { HttpClientModule } from '@angular/common/http';
import { ArtistsComponent } from './Components/artists/artists.component';
import { ArtistComponent } from './Components/artist/artist.component';
import { CarouselModule } from 'primeng/carousel';
import { GenresComponent } from './Components/genres/genres.component'; // Import CarouselModule

import { FormsModule } from '@angular/forms';
import { GenreComponent } from './Components/genre/genre.component'; // Import FormsModule


@NgModule({
  declarations: [
    AppComponent,
    MoviesComponent,
    MovieComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    SignupComponent,
    ClientsComponent,
    ClientComponent,
    ArtistsComponent,
    ArtistComponent,
    GenresComponent,
    GenreComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CarouselModule ,// Add CarouselModule here
    FormsModule 
    
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
