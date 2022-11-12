import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MedicalStaffServiceService {

  constructor(private http:HttpClient) { }
  apiHost: string = 'http://localhost:8080/api';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  getCenterAdmin(id:number):Observable<any>{

    return this.http.get(this.apiHost+'/medical-staff/'+id)
  }

  updateCenterAdmin(center:any):Observable<any>{
    return this.http.put<any>(this.apiHost+'/medical-staff/update',center,{headers: this.headers})
  }

  changePasswordAdminCenter(center:any):Observable<any>{
    return this.http.put<any>(this.apiHost+'/medical-staff/password',center,{headers:this.headers})
  }

}
