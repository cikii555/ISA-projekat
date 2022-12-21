import { FutureAppointments } from './../model/future-appointments.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  apiHost: string = 'http://localhost:8080';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  getFutureAppointments(): Observable<FutureAppointments[]> {
    return this.http.get<FutureAppointments[]>(this.apiHost + '/appointment', {headers: this.headers});
  }
  cancelAppointment(id:any): Observable<any> {
    return this.http.patch<any>(this.apiHost + '/appointment/cancel/' + id, { headers: this.headers });
  }
}
