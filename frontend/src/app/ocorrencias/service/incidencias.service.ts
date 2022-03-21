import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Incidencias } from '../model/incidencias';

@Injectable({
  providedIn: 'root',
})
export class IncidenciaService {
  constructor(private http: HttpClient) {}
  listIncidencias(): Observable<Incidencias[]> {
    const caminho = '/api/incidencia';
    return this.http.get<Incidencias[]>(caminho);
  }
}
