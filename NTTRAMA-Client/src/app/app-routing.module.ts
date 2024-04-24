import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MoviesComponent } from './Components/movies/movies.component';
import { MovieComponent } from './Components/movie/movie.component';
import { LoginComponent } from './Components/login/login.component';
import { SignupComponent } from './Components/signup/signup.component';
import { ClientsComponent } from './Components/clients/clients.component';
import { ClientComponent } from './Components/client/client.component';
import { AuthGuard } from './Services/auth.guard.service';
import { ArtistsComponent } from './Components/artists/artists.component';
import { ArtistComponent } from './Components/artist/artist.component';
import { GenresComponent } from './Components/genres/genres.component';
const routes: Routes = [
  { path: '', redirectTo: '/movies', pathMatch: 'full' },
  { path: 'movies', component: MoviesComponent },
  { path: 'movie/:id', component: MovieComponent },
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'clients', component: ClientsComponent }, // Protected route
  { path: 'client/:id', component: ClientComponent } ,// Protected route
  {
    path: 'artists', component : ArtistsComponent },
    { path: 'artist/:id', component: ArtistComponent },
    { path: 'genres', component: GenresComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
