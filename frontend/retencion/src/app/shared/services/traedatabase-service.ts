import { Injectable } from '@angular/core';
import { VariablesEntorno } from './variables-entorno';
import { HttpClient } from '@angular/common/http';
import { ParametroRetencion } from '../models/parametro-retencion';
import { BuscarListaComando } from '../models/buscar-lista-comando';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
  })
export class TraedatabaseService {
  public variablesEntorno = new VariablesEntorno;
  private urlEndPoint: string = this.variablesEntorno.urlApi;
  constructor(private http: HttpClient) { 

  }
  queryOptionDateBase(buscar:BuscarListaComando): Observable<ParametroRetencion[]> {
    return this.http.post<ParametroRetencion[]>(this.urlEndPoint,buscar);
  }
}
