import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { clientsData } from '../clients/clients-data'; // Import the static client data

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {
  client: any; 
  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    const clientId = this.route.snapshot.paramMap.get('id');
    this.client = clientsData.find(client => client.id === Number(clientId));
  }
}
