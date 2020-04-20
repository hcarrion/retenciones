import { Component, OnInit } from '@angular/core';
import {Sort} from '@angular/material/sort';
import { MatTableDataSource, MatDatepickerInputEvent, MatDialog, MatDialogRef } from '@angular/material';
import { FormControl, FormGroup } from '@angular/forms';
import { SingleLineLabel, MultiLineLabel, MultiDataSet } from 'ng2-charts';
export declare type Label = SingleLineLabel | MultiLineLabel;
import * as pluginDataLabels from 'chartjs-plugin-datalabels';
import { ChartType } from 'chart.js';
import { DialogCartasComponent } from '../dialog-cartas/dialog-cartas.component';

export interface Dessert {
  id: string,
  tipodocumento: string,
  numerodocumento: string,
  archivo:string,
  fechacarga:string
}


@Component({
  selector: 'app-dialog-consulta-documentos',
  templateUrl: './dialog-consulta-documentos.component.html',
  styleUrls: ['./dialog-consulta-documentos.component.css']
})
export class DialogConsultaDocumentosComponent implements OnInit {
  desserts: Dessert[] = [
    {id:"1",tipodocumento:"OFICIO",numerodocumento:"40292320",archivo:"archivo.pdf",fechacarga:"31/03/2020"},
    {id:"2",tipodocumento:"CARTA",numerodocumento:"10766098",archivo:"archivo.pdf",fechacarga:"31/03/2020"},
    {id:"3",tipodocumento:'CARTA',numerodocumento:"10302030",archivo:"archivo.pdf",fechacarga:"31/03/2020"},
    {id:"4",tipodocumento:'OFICIO',numerodocumento:"08765432",archivo:"archivo.pdf",fechacarga:"31/03/2020"},
    {id:"5",tipodocumento:"CARTA",numerodocumento:"06789090",archivo:"archivo.pdf",fechacarga:"31/03/2020"},
    {id:"6",tipodocumento:"CARTA",numerodocumento:"06345678",archivo:"archivo.pdf",fechacarga:"31/03/2020"},
    {id:"7",tipodocumento:"CARTA",numerodocumento:"03403546",archivo:"archivo.pdf",fechacarga:"31/03/2020"},
    {id:"8",tipodocumento:"CARTA",numerodocumento:"14567890",archivo:"archivo.pdf",fechacarga:"31/03/2020"},
    {id:"9",tipodocumento:"CARTA",numerodocumento:"70789887",archivo:"archivo.pdf",fechacarga:"31/03/2020"},
    {id:"10",tipodocumento:"CARTA",numerodocumento:"34567890",archivo:"archivo.pdf",fechacarga:"31/03/2020"}
    ];

  regSolicitud: FormGroup; 
  idsolicitud: number= 10;
  veraccion: boolean;
  loading: boolean;
  sortedData: Dessert[];
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
  
  constructor(public dialogRef: MatDialogRef<DialogConsultaDocumentosComponent>, private matDialog: MatDialog) {
    this.sortedData = this.desserts.slice();}

  public chartOptions:any = { 
    responsive: true,
    size: "20",
    legend: { position: 'right'}
  };
  
  openDialogPlantilla(): void {
    let idIniciativa: string="";
    const dialogRef = this.matDialog.open(DialogCartasComponent, /*dialogConfig,*/
      { width: '1400px',
        height: '600px',
        data: idIniciativa
      }
    );
    } 
    openverdoc(){
      let objectUrl = "https://drive.google.com/file/d/1I0zV6qdH9ypGLtZ28lysy-4AkpnvmX-L/view?usp=sharing_eil&ts=5e94d078"
      var newWindow = window.open(objectUrl); 
    }
  sortData(sort: Sort) {
    const data = this.desserts.slice();
    if (!sort.active || sort.direction === '') {
      this.sortedData = data;
      return;
    }
    
    this.sortedData = data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'id': return compare(a.id, b.id, isAsc);
        case 'tipodocumento': return compare(a.tipodocumento, b.tipodocumento, isAsc);
        case 'numerodocumento': return compare(a.numerodocumento, b.numerodocumento, isAsc);
        case 'archivo': return compare(a.archivo, b.archivo, isAsc);
        case 'fechacarga': return compare(a.fechacarga, b.fechacarga, isAsc);
        default: return 0;
      }
    });

  }
  openDialogProductos(){


  }
  openDialogEditar(){

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
}

function compare(a: number | string, b: number | string, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}
