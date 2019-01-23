import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Idea } from './idea';
import { Observable } from 'rxjs';

@Injectable()
export class IdeaService {
  public API = '//localhost:8080/ideas';
  constructor(private http: HttpClient) {
    console.log('Servicio de idea funcionando correctamente');
  }

  getAll(): Observable<any> {
    return this.http.get(this.API + '/');
  }

  public addIdea(idea){
    return this.http.post<Idea>(this.API + "/create",idea);
  }

  save(idea: any): Observable<any> {
    let result: Observable<Object>;
    result = this.http.post(this.API + '/create', idea);
    return result;
  }
}
