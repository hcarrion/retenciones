import { MaestroTablasJson } from './maestro-tablas-json';
import { UsuarioJson } from './usuario-json';
import { ArchivoCargaJson } from './archivo-carga-json';
import { ImplicadosJson } from './implicados-json';

export class HistoriaSolicitudJson {
    idhistoria: number;
    idsolicitud: number;
    detalle: number;
    fecha: Date;
    idusuario: string;
    estadosolicitud: MaestroTablasJson;
    tipocarga: MaestroTablasJson;  
    tipoingreso: MaestroTablasJson;
    archivoCarga: ArchivoCargaJson;
    implicados: ImplicadosJson;
}
