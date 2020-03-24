import { MaestroTablasJson } from './maestro-tablas-json';
import { UsuarioJson } from './usuario-json';

export class ExpedientesJson {
    idExpediente: number;
    tipoexpediente: MaestroTablasJson;
    fecha_regsitro: Date;
    usuario: UsuarioJson; 
    estadoexpediente: MaestroTablasJson;
}
