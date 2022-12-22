import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {IAdmin} from "../modelangular/admin";
@Injectable({
  providedIn: 'root'
})
export class TransfusionCenterServiceService {

  constructor(private http:HttpClient) { }
  data:any
  apiHost: string = 'http://localhost:8080/api';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  getBloodTransfusionCenter(id:number):Observable<any>{

    return this.http.get(this.apiHost+'/bloodtransfusioncenter/'+id)
  }

  updateBloodTransfusionCenter(center:any){
    console.log(center.name)
     this.http.put<any>(this.apiHost+'/bloodtransfusioncenter/update',center,{headers: this.headers})
       .subscribe(res=>{console.log(this.data = res)})
    return this.data
  }

  getAddress(id:number):Observable<any>{
    return this.http.get(this.apiHost+'/bloodtransfusioncenter/address/'+id)
  }

  getOtherCenterAdmins(id:number):Observable<IAdmin[]>{
    return this.http.get<IAdmin[]>(this.apiHost+'/bloodtransfusioncenter/admins/'+id);
  }
  getByCenterAdmin():Observable<any>{
    return this.http.get(this.apiHost+'/bloodtransfusioncenter/staff');
  }
}
