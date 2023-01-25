import { FutureAppointments } from './../model/future-appointments.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from '../model/center-appointment.model';

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


  addReportForAppointment(report:any){
    return this.http.post<any>(this.apiHost+'/appointment/report',report)
  }

  searchAppointmentsByName(query:string):Observable<any>{
    return this.http.get(this.apiHost+'/appointment/search/firstname='+query,)
  }
  searchAppointmentsBySurname(query:string):Observable<any>{
    return this.http.get(this.apiHost+'/appointment/search/lastname='+query,)
  }

  getAppointmentHistory(id:number){
    return this.http.get(this.apiHost+'/appointment/history/'+id)
  }
  getAppointment(id:number):any{

  }


  getCenterAppointments(id:any): Observable<Appointment[]> {
    return this.http.get<Appointment[]>(this.apiHost + '/appointment/center/'+id, {headers: this.headers});
  }
  takeAppointment(id:any): Observable<any> {
    return this.http.post<any>(this.apiHost + '/appointment/schedule/' + id, { headers: this.headers });
  }
  canDonate(): Observable<boolean>{
    return this.http.get<boolean>(this.apiHost + '/appointment/canDonate', {headers: this.headers});
  }

  didntShowUp(clientId:any){
    return this.http.get<any>(this.apiHost+'/clients/penalties/'+clientId)
  }

  canClientDonateBlood(clientId:any){
    return this.http.get<any>(this.apiHost+'/clients/can/'+clientId)
  }
  finishReport(report:any){
    this.http.post(this.apiHost+'/appointment/report',report)
  }

}

