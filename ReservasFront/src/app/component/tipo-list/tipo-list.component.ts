import { Component, OnInit } from '@angular/core';
import { Tipo } from 'src/app/model/tipo';
import { Router } from '@angular/router';
import { TipoService } from 'src/app/service/tipo.service';

@Component({
  selector: 'app-tipo-list',
  templateUrl: './tipo-list.component.html',
  styleUrls: ['./tipo-list.component.css']
})
export class TipoListComponent implements OnInit {

  tipos: Tipo[];

  constructor(private router: Router, private service: TipoService) { }

  ngOnInit() {
    this.service.listTipo().subscribe(data => (this.tipos = data));
  }

}
