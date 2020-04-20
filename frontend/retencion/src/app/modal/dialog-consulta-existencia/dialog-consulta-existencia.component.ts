import { Component, OnInit } from '@angular/core';
import {Sort} from '@angular/material/sort';
import { MatTableDataSource, MatDatepickerInputEvent, MatDialog, MatDialogRef } from '@angular/material';
import { FormControl, FormGroup } from '@angular/forms';
import { SingleLineLabel, MultiLineLabel, MultiDataSet } from 'ng2-charts';
export declare type Label = SingleLineLabel | MultiLineLabel;
import * as pluginDataLabels from 'chartjs-plugin-datalabels';
import { ChartType } from 'chart.js';

export interface Dessert {
  pais: string,
  tipodocumento: string,
  numerodocumento: string,
  apellidosnombres:string,
  origenbusqueda:string
}

export interface DessertC {
  cuenta: string,
  tipoproducto: string,
  fechaalta: string,
  fechaultestado:string,
  estado:string
}
@Component({
  selector: 'app-dialog-consulta-existencia',
  templateUrl: './dialog-consulta-existencia.component.html',
  styleUrls: ['./dialog-consulta-existencia.component.css']
})
export class DialogConsultaExistenciaComponent implements OnInit {
  desserts: Dessert[] = [
    {pais:"1",tipodocumento:"DNI",numerodocumento:"40292320",apellidosnombres:"SAAVEDRA SALAZAR, JORGE",origenbusqueda:"BT"},
    {pais:"2",tipodocumento:"DNI",numerodocumento:"10766098",apellidosnombres:"ROJAS RUIZ, SANDRO",origenbusqueda:"BT"},
    {pais:"3",tipodocumento:'CARNET EXTRANJERIA',numerodocumento:"10302030",apellidosnombres:"CARDENAS QUISPE, LUIS",origenbusqueda:"NURIA"},
    {pais:"4",tipodocumento:'PASAPORTE',numerodocumento:"08765432",apellidosnombres:"QUISPE VASQUEZ, LUIS",origenbusqueda:"BT"},
    {pais:"5",tipodocumento:"DNI",numerodocumento:"06789090",apellidosnombres:"PEREZ DIAS, LUIS",origenbusqueda:"BT"},
    {pais:"6",tipodocumento:"DNI",numerodocumento:"06345678",apellidosnombres:"PORRAS ROJAS, ISMAEL",origenbusqueda:"BT"},
    {pais:"7",tipodocumento:"DNI",numerodocumento:"03403546",apellidosnombres:"ROJAS ROJAS, POMA",origenbusqueda:"NURIA"},
    {pais:"8",tipodocumento:"DNI",numerodocumento:"14567890",apellidosnombres:"CABANILLAS SANCHEZ, ILIDIO",origenbusqueda:"NURIA"},
    {pais:"9",tipodocumento:"DNI",numerodocumento:"70789887",apellidosnombres:"POMA ROSAS, PEREZ",origenbusqueda:"NURIA"},
    {pais:"10",tipodocumento:"DNI",numerodocumento:"34567890",apellidosnombres:"CABANILLAS SOZA, ANTONIO",origenbusqueda:"BT"}
    ];

    dessertsc: DessertC[] = [
      {cuenta:"0909090999",tipoproducto:"CTS",fechaalta:"14/03/2004",fechaultestado:"01/01/2020",estado:"ACTIVO"},
      {cuenta:"0999999991",tipoproducto:"PRESTAMO PERSONAL",fechaalta:"03/07/2001",fechaultestado:"11/03/2020",estado:"ACTIVO"},
      {cuenta:"0999999993",tipoproducto:'AHORROS SOLES',fechaalta:"16/05/2006",fechaultestado:"15/02/2020",estado:"BAJA"},
      {cuenta:"0999999994",tipoproducto:'AHORROS DOLARES',fechaalta:"31/08/2001",fechaultestado:"10/01/2020",estado:"ACTIVO"},
      {cuenta:"0999999995",tipoproducto:"CREDITO MYPE",fechaalta:"16/03/2013",fechaultestado:"20/01/2020",estado:"ACTIVO"},
      {cuenta:"0999999996",tipoproducto:"CUENTA MUJER",fechaalta:"17/04/2017",fechaultestado:"15/03/2020",estado:"BAJA"}
      ];  
  regSolicitud: FormGroup; 
  idsolicitud: number= 10;
  veraccion: boolean;
  loading: boolean;
  sortedData: Dessert[];
  sortedDatac: DessertC[];
  minDate: Date;
  maxDate: Date;
  minDateFin: Date;
  maxDateFin: Date;

  fechaInicioInput = new FormControl();
  fechaFinInput = new FormControl();
  tipodocumento = new FormControl();
  tiporequerimiento = new FormControl();
  nombresinput = new FormControl();
  apellidopaternoInput = new FormControl();
  apellidomaternoInput = new FormControl();
  estado = new FormControl();
  agencia = new FormControl();
  entidad = new FormControl();
  prioridad = new FormControl();
  existeimplicado: boolean;

  activa: string="false";
  dataSource = new MatTableDataSource(this.desserts);
  tipodocumentolista: string[] = ['DNI', 'PASAPORTE','CARNET DE EXTRANJERIA','LIBRETA MILITAR','OTROS'];
  tiporequerimientolista: string[] = ['INFORMACION', 'LSB','RETENCIONES','LEVANTAMIENTO DE RETENCIONES'];
  agencialista: string[] = ['Agencia Abancay',	'Agencia Aguaytia',	'Agencia Andahuaylas',	'Agencia Andrés Avelino Cáceres',	'Agencia Anta',	'Agencia Arequipa',	'Agencia Ate',	'Agencia Ayacucho',	'Agencia Bambamarca',	'Agencia Barranca',	'Agencia Cajabamba',	'Agencia Cajamarca',	'Agencia Camaná',	'Agencia Campo Verde',	'Agencia Chocope',	'Agencia Cañete',	'Agencia Carabayllo',	'Agencia Casma',	'Agencia Cayma',	'Agencia Centenario',	'Agencia Cerro de Pasco',	'Agencia Cerro colorado',	'Agencia Chachapoyas',	'Agencia Chepén',	'Agencia Chiclayo',	'Agencia Chilca',	'Agencia Chimbote',	'Agencia Chivay',	'Agencia Chorrillos',	'Agencia Chosica',	'Agencia Chota',	'Agencia Chulucanas',	'Agencia Chupaca',	'Agencia Chuquibamba',	'Agencia Ciudad Constitución',	'Agencia Cocachacra',	'Agencia Constitución',	'Agencia Corire',	'Agencia Cusco',	'Agencia El Porvenir',	'Agencia El Tambo',	'Agencia Huachipa',	'Agencia Huacho',	'Agencia Huamachuco',	'Agencia Huancavelica',	'Agencia Huancabamba',	'Agencia Huánuco',	'Agencia Huaraz',	'Agencia Huarmaca',	'Agencia Huaycán',	'Agencia Ica',	'Agencia Iquitos',	'Agencia Jaén',	'Agencia Jauja',	'Agencia Jicamarca',	'Agencia Juliaca',	'Agencia La Esperanza',	'Agencia La Unión',	'Agencia La Joya',	'Agencia La Merced',	'Agencia La Negrita',	'Agencia La Oroya',	'Agencia Los Olivos',	'Agencia Lurín',	'Agencia Manchay',	'Agencia Mollendo',	'Agencia Moquegua',	'Agencia Moyobamba',	'Agencia Olmos',	'Agencia Oxapampa',	'Agencia Paita',	'Agencia Perene',	'Agencia Pampa Inalámbrica',	'Agencia Pampas',	'Agencia Pedregal',	'Agencia Pichanaqui',	'Agencia Pisac',	'Agencia Piura',	'Agencia Pucallpa',	'Agencia Puerto Maldonado',	'Agencia Puno',	'Agencia San Juan de Lurigancho',	'Agencia San Juan de Próceres',	'Agencia San Marcos',	'Agencia San Martín de Pangoa',	'Agencia San Martín de Porres',	'Agencia Santa Anita',	'Agencia Santiago de Chuco',	'Agencia Satipo',	'Agencia Sechura',	'Agencia Sede Principal Tacna',	'Agencia Sullana',	'Agencia Tacna Cono Norte',	'Agencia Tacna Cono Sur',	'Agencia Tambo Grande',	'Agencia Tarapoto',	'Agencia Tarma',	'Agencia Tayabamba',	'Agencia Tingo María',	'Agencia Tumbes',	'Agencia Urcos',	'Agencia Ventanilla',	'Agencia Villa El Salvador',	'Agencia Villa María del Triunfo',	'Agencia Villa Rica',	'Agencia Virú',	'Agencia Trujillo',	'Agencia Abancay',	'Agencia Aguaytia',	'Agencia Andahuaylas',	'Agencia Andrés Avelino Cáceres',	'Agencia Anta',	'Agencia Arequipa',	'Agencia Ate',	'Agencia Ayacucho',	'Agencia Bambamarca',	'Agencia Barranca',	'Agencia Cajabamba',	'Agencia Cajamarca',	'Agencia Camaná',	'Agencia Campo Verde',	'Agencia Chocope',	'Agencia Cañete',	'Agencia Carabayllo',	'Agencia Casma',	'Agencia Cayma',	'Agencia Centenario',	'Agencia Cerro de Pasco',	'Agencia Cerro colorado',	'Agencia Chachapoyas',	'Agencia Chepén',	'Agencia Chiclayo',	'Agencia Chilca',	'Agencia Chimbote',	'Agencia Chivay',	'Agencia Chorrillos',	'Agencia Chosica',	'Agencia Chota',	'Agencia Chulucanas',	'Agencia Chupaca',	'Agencia Chuquibamba',	'Agencia Ciudad Constitución',	'Agencia Cocachacra',	'Agencia Constitución',	'Agencia Corire',	'Agencia Cusco',	'Agencia El Porvenir',	'Agencia El Tambo',	'Agencia Huachipa',	'Agencia Huacho',	'Agencia Huamachuco',	'Agencia Huancavelica',	'Agencia Huancabamba',	'Agencia Huánuco',	'Agencia Huaraz',	'Agencia Huarmaca',	'Agencia Huaycán',	'Agencia Ica',	'Agencia Iquitos',	'Agencia Jaén',	'Agencia Jauja',	'Agencia Jicamarca',	'Agencia Juliaca',	'Agencia La Esperanza',	'Agencia La Unión',	'Agencia La Joya',	'Agencia La Merced',	'Agencia La Negrita',	'Agencia La Oroya',	'Agencia Los Olivos',	'Agencia Lurín',	'Agencia Manchay',	'Agencia Mollendo',	'Agencia Moquegua',	'Agencia Moyobamba',	'Agencia Olmos',	'Agencia Oxapampa',	'Agencia Paita',	'Agencia Perene',	'Agencia Pampa Inalámbrica',	'Agencia Pampas',	'Agencia Pedregal',	'Agencia Pichanaqui',	'Agencia Pisac',	'Agencia Piura',	'Agencia Pucallpa',	'Agencia Puerto Maldonado',	'Agencia Puno',	'Agencia San Juan de Lurigancho',	'Agencia San Juan de Próceres',	'Agencia San Marcos',	'Agencia San Martín de Pangoa',	'Agencia San Martín de Porres',	'Agencia Santa Anita',	'Agencia Santiago de Chuco',	'Agencia Satipo',	'Agencia Sechura',	'Agencia Sede Principal Tacna',	'Agencia Sullana',	'Agencia Tacna Cono Norte',	'Agencia Tacna Cono Sur',	'Agencia Tambo Grande',	'Agencia Tarapoto',	'Agencia Tarma',	'Agencia Tayabamba',	'Agencia Tingo María',	'Agencia Tumbes',	'Agencia Urcos',	'Agencia Ventanilla',	'Agencia Villa El Salvador',	'Agencia Villa María del Triunfo',	'Agencia Villa Rica',	'Agencia Virú',	'Agencia Trujillo'];
  entidadlista: string[] = ['MINISTERIO PUBLICO', 'MINISTERIO DEL INTERIOR','TRIBUNAL CONSTITUCIONAL','POLICIA NACIONA DEL PERU','PROCUDARIA DEL PUBLICA','SBS','OTROS','PODER JUDICIAL'];        
  estadolista: string[] = ['REGISTRADO','ACEPTADO','DEVUELTO','RECHAZADO','CERRADO'];
  prioridadlista:string[] = ['ALTO','MEDIO','BAJO'];
  doughnutChartLabels: Label[] =  ['Registrado','Aceptado','Devuelto','Rechazado','Cerrado'];
  barChartPlugins = [pluginDataLabels];
  doughnutChartType: ChartType = 'doughnut';
  doughnutChartData: MultiDataSet = [[10,4,6,6,2]];

  public revisiontalentogerentes: boolean;
  public contratodesempenofuncionarios: boolean;
  public revisiontalentojefes: boolean;
  public contratodesempenogerentes: boolean;
  
  constructor(public dialogRef: MatDialogRef<DialogConsultaExistenciaComponent>, private matDialog: MatDialog) {
    this.sortedData = this.desserts.slice();
    this.sortedDatac = this.dessertsc.slice();}

  public chartOptions:any = { 
    responsive: true,
    size: "20",
    legend: { position: 'right'}
  };

  sortData(sort: Sort) {
    const data = this.desserts.slice();
    if (!sort.active || sort.direction === '') {
      this.sortedData = data;
      return;
    }
    
    this.sortedData = data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'pais': return compare(a.pais, b.pais, isAsc);
        case 'tipodocumento': return compare(a.tipodocumento, b.tipodocumento, isAsc);
        case 'numerodocumento': return compare(a.numerodocumento, b.numerodocumento, isAsc);
        case 'apellidosnombres': return compare(a.apellidosnombres, b.apellidosnombres, isAsc);
        case 'origenbusqueda': return compare(a.origenbusqueda, b.origenbusqueda, isAsc);
        default: return 0;
      }
    });

  }
  sortDatac(sort: Sort) {
    const data = this.dessertsc.slice();
    if (!sort.active || sort.direction === '') {
      this.sortedDatac = data;
      return;
    }
    
    this.sortedDatac = data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'cuenta': return compare(a.cuenta, b.cuenta, isAsc);
        case 'tipoproducto': return compare(a.tipoproducto, b.tipoproducto, isAsc);
        case 'fechaalta': return compare(a.fechaalta, b.fechaalta, isAsc);
        case 'fechaultestado': return compare(a.fechaultestado, b.fechaultestado, isAsc);
        case 'estado': return compare(a.estado, b.estado, isAsc);
        default: return 0;
      }
    });
  }
  ngOnInit() {
    this.veraccion = false;
    localStorage.setItem('indinicio',"false");
    this.loading = false;
  }

  applyFilter(event: Event) {
    alert((event.target as HTMLInputElement).value);
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  selecttiporeq(plan){
    alert(plan.value);
  }
  changeFech(type: string, event: MatDatepickerInputEvent<Date>) {
    let daySelect = event.value;
    if("change" == type){
      this.minDateFin  = new Date(daySelect.getFullYear(), daySelect.getMonth(), daySelect.getDate()+1);
    }
  }

  changeFechFin(type: string, event: MatDatepickerInputEvent<Date>) {

  }

  compareItems(obj1, obj2) {
    return obj1 && obj2 && obj1.codigo===obj2.codigo;
  }

  openDialogProductos(){

  }
  openDialogEditar(){

  }
}

function compare(a: number | string, b: number | string, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}
