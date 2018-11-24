import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reserva } from 'src/app/model/reserva';
import { ReservaService } from 'src/app/service/reserva.service';

@Component({
  selector: 'app-reserva-list',
  templateUrl: './reserva-list.component.html',
  styleUrls: ['./reserva-list.component.css']
})
export class ReservaListComponent implements OnInit {

  reservas: Reserva[];

  constructor(private router: Router, private service: ReservaService) { }

  ngOnInit() {
    this.service.listReservas().subscribe(data => (this.reservas = data));
  }

  reservaDelete(reserva: Reserva): void{
    this.reservas = this.reservas.filter(r => r !== reserva);
    this.service.deleteReserva(reserva.id).subscribe();
  }

}
