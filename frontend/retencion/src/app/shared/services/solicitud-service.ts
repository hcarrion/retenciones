import { BuscarListaComando } from '../models/buscar-lista-comando';
import { VariablesEntorno } from './variables-entorno';
import { Solicitud } from '../models/solicitud';

export class SolicitudService extends Solicitud {
    public listacomando: BuscarListaComando;
    public ruta: VariablesEntorno;
    public inserta: string="CANALES░KSOL002░"+
                  ":CANTIDAD_HOJAS¬" + 
                  ":COD_AGEN_RECEP¬" + 
                  ":COD_AGEN_REGIS¬" + 
                  ":COD_DCTO_INGRESADO¬" + 
                  ":COD_ENTIDAD¬" + 
                  ":COD_PRIORIDAD¬" +
                  ":COD_REQUERIMIENTO¬" + 
                  ":DIAS_MAX_RPTA¬" + 
                  "':FECHA_RECEP'¬" +
                  "':FECHA_REGISTRO'¬" + 
                  "':HORA_REGISTRO'¬" + 
                  ":ID_SECUENCIA_EVENTO_ULTI¬" + 
                  ":NUM_DOC_INGRESADO¬" + 
                  "':TEXTO_RESPUESTA'¬" + 
                  "':USER_REGISTRO'¬" +
                  ":ID_CARTA¬" + 
                  "' '¬";
}
