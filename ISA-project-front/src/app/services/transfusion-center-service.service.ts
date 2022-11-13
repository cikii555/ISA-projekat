import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class TransfusionCenterServiceService {

  constructor(private http:HttpClient) { }

  apiHost: string = 'http://localhost:8080/api';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  getBloodTransfusionCenter(id:number):Observable<any>{

    return this.http.get(this.apiHost+'/bloodtransfusioncenter/'+id)
  }

  updateBloodTransfusionCenter(center:any):Observable<any>{
    return this.http.put<any>(this.apiHost+'/bloodtransfusioncenter/update',center,{headers: this.headers})
  }

  getAddress(id:number):Observable<any>{
    return this.http.get(this.apiHost+'/bloodtransfusioncenter/address/'+id)
  }

  /*getOtherCenterAdmins(id:number):Observable<any>{
    //return this.get
  }*/
}
