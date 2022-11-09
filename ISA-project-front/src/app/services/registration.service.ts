import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  apiHost: string = 'http://localhost:8080/auth';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  registerUser(userReg: any): Observable<any> {
    return this.http.post<any>(this.apiHost + '/register/client', userReg, { headers: this.headers });
  }
}
