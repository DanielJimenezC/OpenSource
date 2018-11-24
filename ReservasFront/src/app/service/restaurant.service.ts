import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Restaurant } from '../model/restaurant';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  private baseURL = 'http://localhost:8080/restaurantes';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private http: HttpClient) {}

  addRestaurant(restaurant: Restaurant):Observable<Restaurant>{
    return this.http.post<Restaurant>(`${this.baseURL}/`, restaurant, {headers: this.httpHeaders});
  }

  listRestaurant(): Observable<Restaurant[]>{
    return this.http.get(`${this.baseURL}/`).pipe(map(data => data as Restaurant[]));
  }

  editRestaurant(restaurant: Restaurant): Observable<Restaurant>{
    return this.http.put<Restaurant>(`${this.baseURL}/${restaurant.id}`, restaurant, {headers: this.httpHeaders});
  }

  getRestaurant(id: number): Observable<Restaurant>{
    return this.http.get<Restaurant>(`${this.baseURL}/${id}`).pipe();
  }
}
