import { Component, OnInit } from '@angular/core';

import { Tipo } from 'src/app/model/tipo';
import { TipoService } from 'src/app/service/tipo.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tipo-add',
  templateUrl: './tipo-add.component.html',
  styleUrls: ['./tipo-add.component.css']
})
export class TipoAddComponent implements OnInit {
  tipo: Tipo = new Tipo();

  constructor(private router: Router, private service: TipoService) { }

  tipoAdd(): void {
    this.service.addTipo(this.tipo).subscribe(data=>
      {alert("Tipo creado de manera exitosa.");
    });
  }

  ngOnInit() {
  }

}
