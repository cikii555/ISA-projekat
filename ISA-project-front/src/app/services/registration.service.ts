import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RegClient } from '../model/regClient.model';
import { UpdateClient } from '../model/updateClient.model';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  apiHost: string = 'http://localhost:8080/auth';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient) { }

  registerUser(userReg: RegClient): Observable<RegClient> {
    return this.http.post<RegClient>(this.apiHost + '/register/client', userReg);
  }
  getClient(email: String): Observable<RegClient> {
    return this.http.get<RegClient>(this.apiHost + '/register/' + email, { headers: this.headers });
  }
  updateClient(userUpdate: UpdateClient): Observable<RegClient> {
    return this.http.put<RegClient>('http://localhost:8080/clients/update' , userUpdate);
  }
  sendVerificationMail(email: String): Observable<RegClient> {
    return this.http.get<RegClient>(this.apiHost + '/send-verification-mail/' + email, { headers: this.headers });
  }
  
}
