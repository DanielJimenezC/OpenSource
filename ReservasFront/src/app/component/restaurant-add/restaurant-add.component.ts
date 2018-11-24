import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router'
import { Restaurant } from 'src/app/model/restaurant';
import { RestaurantService } from 'src/app/service/restaurant.service';

@Component({
  selector: 'app-restaurant-add',
  templateUrl: './restaurant-add.component.html',
  styleUrls: ['./restaurant-add.component.css']
})
export class RestaurantAddComponent implements OnInit {
  restaurante: Restaurant = new Restaurant();

  constructor(private router: Router, private service: RestaurantService) {}

  restaurantAdd(): void{
    this.service.addRestaurant(this.restaurante)
    .subscribe(data => {alert("Restaurante Creado Satisfactoriamente");
  });
  }

  ngOnInit() {
  }

}
