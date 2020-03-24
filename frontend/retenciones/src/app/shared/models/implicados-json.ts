import { MaestroTablasJson } from './maestro-tablas-json';
import { ExpedientesJson } from './expedientes-json';
import { ArchivoCargaJson } from './archivo-carga-json';
import { HistoriaSolicitudJson } from './historia-solicitud-json';

export class ImplicadosJson {
    idImplicado: number;
    Pais: string;
    Tipo_de_Documento: MaestroTablasJson; 
    Documento_de_Identidad: string;
    Apellido_Paterno: string;
    Apellido_Materno: string;
    Nombres: string;
    Nombres_Completo: string = this.Apellido_Paterno + ' ' + this.Apellido_Materno + '' + this.Nombres;
    estadoexpediente: MaestroTablasJson;
    expedientes: ExpedientesJson;
    archivocarga: ArchivoCargaJson;
    historia: HistoriaSolicitudJson;
}
