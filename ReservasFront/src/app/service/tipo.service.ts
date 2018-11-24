import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Tipo } from '../model/tipo';

@Injectable({
  providedIn: 'root'
})
export class TipoService {

  private baseURL = 'http://localhost:8080/tipos';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private http: HttpClient) {}
  
  addTipo(tipo:Tipo):Observable<Tipo>{
    return this.http.post<Tipo>(`${this.baseURL}/`, tipo, {headers: this.httpHeaders});
  }

  listTipo(): Observable<Tipo[]> {
    return this.http.get(`${this.baseURL}/`).pipe( map(data => data as Tipo[]) );
  }
}
