import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FaixaEtaria } from '../model/faixaetaria';
@Injectable({
  providedIn: 'root',
})
export class FaixaEtariaService {
  constructor(private http: HttpClient) {}

  listFaixaEtaria(): Observable<FaixaEtaria[]> {
    const caminhoUrl = '/api/faixaetaria';
    return this.http.get<FaixaEtaria[]>(caminhoUrl);
  }
}
