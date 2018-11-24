import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Reserva } from '../model/reserva';

@Injectable({
  providedIn: 'root'
})
export class ReservaService {

  private baseURL = 'http://localhost:8080/reservas';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private http: HttpClient) {}

  listReservas(): Observable<Reserva[]>{
    return this.http.get(`${this.baseURL}/`).pipe(map(data => data as Reserva[]));
  }

  saveReserva(reserva: Reserva): Observable<Reserva>{
    return this.http.post<Reserva>(`${this.baseURL}/`, reserva, {headers: this.httpHeaders});
  }

  deleteReserva(id: number): Observable<Reserva>{
    return this.http.delete<Reserva>(`${this.baseURL}/${id}`, {headers: this.httpHeaders})
  }
}
