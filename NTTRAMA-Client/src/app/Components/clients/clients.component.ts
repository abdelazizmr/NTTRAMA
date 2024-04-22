import { Component } from '@angular/core';
import { clientsData } from './clients-data'; // Import the static client data

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent {
  client = clientsData;

  constructor() { }

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
}
