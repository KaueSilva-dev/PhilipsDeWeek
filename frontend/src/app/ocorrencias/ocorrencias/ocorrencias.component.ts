import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { FaixaEtaria } from '../model/faixaetaria';
import { Incidencias } from '../model/incidencias';
import { Regiao } from '../model/regiao';
import { RegiaoService } from '../service/regiao.service';
import { IncidenciaService } from '../service/incidencias.service';
import { FaixaEtariaService } from '../service/faixa-etaria.service';

@Component({
  selector: 'app-ocorrencias',
  templateUrl: './ocorrencias.component.html',
  styleUrls: ['./ocorrencias.component.css'],
})
export class OcorrenciasComponent implements OnInit, OnDestroy {
  incidencia: Incidencias[] = [];
  regioes: Regiao[] = [];
  faixaEtaria: FaixaEtaria[] = [];

  readonly subscriptions = new Subscription();

  constructor(
    private regiaoService: RegiaoService,
    private incidenciasService: IncidenciaService,
    private faixaEtariaService: FaixaEtariaService
  ) {}

  ngOnInit(): void {
    this.listarRegioes();
    this.listarIncidencias();
    this.listarFaixaEtaria();
  }
  ngOnDestroy(): void {
    this.subscriptions.unsubscribe();
  }

  private listarRegioes(): void {
    const subscription = this.regiaoService
      .listRegiao()
      .subscribe((regioes) => {
        this.regioes = regioes;
      });
    this.subscriptions.add(subscription);
  }

  listarIncidencias(): void {
    const subscriptionIncidencia = this.incidenciasService
      .listIncidencias()
      .subscribe((incidencia) => {
        this.incidencia = incidencia;
      });
    this.subscriptions.add(subscriptionIncidencia);
  }

  listarFaixaEtaria(): void {
    const subscriptionFaixas = this.faixaEtariaService
      .listFaixaEtaria()
      .subscribe((faixas) => {
        this.faixaEtaria = faixas;
      });
    this.subscriptions.add(subscriptionFaixas);
  }
}
