import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { MatSortModule } from '@angular/material/sort';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { OcorrenciasRoutingModule } from './ocorrencias-routing.module';
import { OcorrenciasComponent } from './ocorrencias/ocorrencias.component';
import { FaixaEtariaService } from './service/faixa-etaria.service';
import { IncidenciaService } from './service/incidencias.service';
import { RegiaoService } from './service/regiao.service';

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    MatSortModule,
    MatCardModule,
    MatTableModule,
    MatToolbarModule,
    OcorrenciasRoutingModule,
  ],
  declarations: [OcorrenciasComponent],
  providers: [IncidenciaService, FaixaEtariaService, RegiaoService],
})
export class OcorrenciasModule {}
