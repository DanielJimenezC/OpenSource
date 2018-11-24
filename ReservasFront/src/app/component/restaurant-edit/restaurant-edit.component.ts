import { Component, OnInit, Input } from '@angular/core';

import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Restaurant } from 'src/app/model/restaurant';
import { RestaurantService } from 'src/app/service/restaurant.service';

@Component({
  selector: 'app-restaurant-edit',
  templateUrl: './restaurant-edit.component.html',
  styleUrls: ['./restaurant-edit.component.css']
})
export class RestaurantEditComponent implements OnInit {
  @Input() restaurante: Restaurant;

  constructor(private route: ActivatedRoute, private service: RestaurantService, private location: Location) {}

  ngOnInit() {
    this.getGenero();
  }

  getGenero(): void{
    const id = +this.route.snapshot.paramMap.get('id');
    this.service.getRestaurant(id).subscribe(restaurante => this.restaurante = restaurante);
  }

  editGenero(): void{
    this.service.editRestaurant(this.restaurante).subscribe(() => this.goBack());
  }

  goBack(): void{
    this.location.back();
  }
}
