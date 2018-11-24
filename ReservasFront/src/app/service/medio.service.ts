import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { MedioPago } from '../model/mediopago';

@Injectable({
  providedIn: 'root'
})
export class MedioService {
  private baseURL = 'http://localhost:8080/medios';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private http: HttpClient) {}

  getMedios():Observable<MedioPago[]>{
    return this.http.get(`${this.baseURL}/`).pipe(map(data=>data as MedioPago[]));
  }
}
