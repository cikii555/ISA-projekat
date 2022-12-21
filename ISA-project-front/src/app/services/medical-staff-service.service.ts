import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {MedicalStaff} from "../model/medical-staff.model";

@Injectable({
  providedIn: 'root'
})
export class MedicalStaffServiceService {

  constructor(private http:HttpClient) { }
  apiHost: string = 'http://localhost:8080/api';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  data:any
  data1:any
  medicalStaff:any
  getCenterAdmin(id:number):Observable<any>{

    return this.http.get(this.apiHost+'/medical-staff/'+id)
  }

  updateCenterAdmin(center:any):Observable<any>{
    this.http.put<any>(this.apiHost+'/medical-staff/update',center,{headers: this.headers}).subscribe(res=>{console.log(this.data = res)})
    return this.data
  }

  changePasswordAdminCenter(password:any){
     this.http.put<any>(this.apiHost+'/medical-staff/password',password,{headers:this.headers}).subscribe(res=>{console.log(this.data1 = res)})

  }

  getMedicalStaff(centerId:any):Observable<any>{
   return this.http.get<any>(this.apiHost+'/medical-staff/medicalstaff/'+centerId)
  }

}
