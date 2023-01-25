import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BloodDonationAppointmentService {



  constructor( private  http:HttpClient) { }
  apiHost: string = 'http://localhost:8080/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });


  addNewAppointment(newappointment:any){
    console.log("hahahah")
     return this.http.post<any>(this.apiHost+'appointment/add', newappointment)
  }
  getScheduledAppointments(centerId:any):Observable<any>{
    return this.http.get<any>(this.apiHost+'appointment/scheduled/'+centerId)
  }

}
