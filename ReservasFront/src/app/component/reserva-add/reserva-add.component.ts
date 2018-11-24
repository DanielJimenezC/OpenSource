import { Component, OnInit } from '@angular/core';
import { MedioPago } from 'src/app/model/mediopago';
import { Restaurant } from 'src/app/model/restaurant';
import { Tipo } from 'src/app/model/tipo';
import { Reserva } from 'src/app/model/reserva';
import { ReservaService } from 'src/app/service/reserva.service';
import { MedioService } from 'src/app/service/medio.service';
import { RestaurantService } from 'src/app/service/restaurant.service';
import { TipoService } from 'src/app/service/tipo.service';

@Component({
  selector: 'app-reserva-add',
  templateUrl: './reserva-add.component.html',
  styleUrls: ['./reserva-add.component.css']
})
export class ReservaAddComponent implements OnInit {
  medios: MedioPago[];
  restaurantes: Restaurant[];
  tipos: Tipo[];
  reserva: Reserva = 
  {"id":0,
  "cantidad": 0,
	"fecha": '',
	"nombre": '',
	"medio": { "id": 0, "nombre":'', "descripcion":''},
	"tipo": { "id": 0, "nombre":'', "descripcion":'' },
	"restaurante": { "id":0, "nombre":'', "precio":0, "descripcion":''}}

  constructor(private serviceM: MedioService, private serviceR: RestaurantService,
    private serviceT: TipoService, private service: ReservaService) {}

  ngOnInit() {
    this.serviceM.getMedios().subscribe(data => (this.medios=data));
    this.serviceR.listRestaurant().subscribe(data => (this.restaurantes=data));
    this.serviceT.listTipo().subscribe(data => (this.tipos=data));
  }

  addReserva(){
    this.service.saveReserva(this.reserva).subscribe( data => {
      alert("Reserva guardada");
    });
  }

}
