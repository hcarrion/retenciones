
import { IniciativaMainFire } from './iniciativa-main-fire';
import { ColaboradorDetalleFire } from './colaborador-detalle-fire';
export class ActividadFireMonitor {
    iniciativa: IniciativaMainFire;
    codigo: number;
    codigousuario: string;
    avances: string;
    horas: number;
    horastrabajadas: number;  
    fechainicio: Date;
    fechafin: Date;

    horasavance: string;
    titulo: string;
    dias: number[] = [];
    
    total: number;
    totalhoras: string;
    dia: number;
    tipo: string;
    codigoSVT: number;
    porcentaje: string;
    estado: string;
    asignado: ColaboradorDetalleFire[];
}

