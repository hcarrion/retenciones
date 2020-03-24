import { MaestroTablasJson } from './maestro-tablas-json';
import { ArchivoCargaJson } from './archivo-carga-json';
import { ImplicadosJson } from './implicados-json';
import { HistoriaSolicitudJson } from './historia-solicitud-json';

export class SolicitudesListaJson {
    idsolicitud: number;
    detalle: number;
    fecha: Date;
    idusuario: string;
    estadosolicitud: MaestroTablasJson;
    tipocarga: MaestroTablasJson;  
    tipoingreso: MaestroTablasJson;
    archivoCarga: ArchivoCargaJson;
    implicados: ImplicadosJson;
    historia: HistoriaSolicitudJson;
}
