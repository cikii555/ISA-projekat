import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TransfusionCenter } from '../model/transfusionCenter.model';

@Injectable({
  providedIn: 'root'
})
export class CenterService {
  
  apiHost: string = 'http://localhost:8080';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  getCenters(): Observable<TransfusionCenter[]> {
    return this.http.get<TransfusionCenter[]>(this.apiHost + '/center', { headers: this.headers });
  }
  searchCentersByName(query:string): Observable<TransfusionCenter[]> {
    return this.http.get<TransfusionCenter[]>(this.apiHost + '/api/bloodtransfusioncenter/search/name='+query, { headers: this.headers });
  }
  searchCentersByCityName(query:string): Observable<TransfusionCenter[]> {
    return this.http.get<TransfusionCenter[]>(this.apiHost + '/api/bloodtransfusioncenter/search/city_name='+query, { headers: this.headers });
  }
  addAppointmentHistory(center: String): Observable<String> {
    return this.http.post<String>(this.apiHost + '/center/addAppointmentHistory/' + center, { headers: this.headers });
  }
}
