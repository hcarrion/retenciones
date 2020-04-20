import { BuscarListaComando } from '../models/buscar-lista-comando';
import { ParametroRetencion } from '../models/parametro-retencion';
import { VariablesEntorno } from './variables-entorno';

export class ParametroRetencionServicio extends ParametroRetencion {
  listacomando: BuscarListaComando;
  ruta: VariablesEntorno;
}
