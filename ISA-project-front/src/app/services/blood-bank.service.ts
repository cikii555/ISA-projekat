import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BloodBankService {

  constructor(private http:HttpClient) { }
  apiHost: string = 'http://localhost:8080/api';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  bloodBankList:any


  getBloodBanks(centerId:number): Observable<any>{
    return this.http.get(this.apiHost+'/bloodtransfusioncenter/blood/'+centerId);
  }
}
