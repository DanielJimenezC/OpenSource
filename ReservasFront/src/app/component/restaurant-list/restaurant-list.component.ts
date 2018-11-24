import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Restaurant } from 'src/app/model/restaurant';
import { RestaurantService } from 'src/app/service/restaurant.service';

@Component({
  selector: 'app-restaurant-list',
  templateUrl: './restaurant-list.component.html',
  styleUrls: ['./restaurant-list.component.css']
})
export class RestaurantListComponent implements OnInit {

  restaurantes: Restaurant[];

  constructor(private router: Router, private service: RestaurantService) { }

  ngOnInit() {
    this.service.listRestaurant().subscribe(data => (this.restaurantes = data));
  }

}
