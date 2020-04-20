import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Label, MultiDataSet } from 'ng2-charts';
import * as pluginDataLabels from 'chartjs-plugin-datalabels';
import { ChartType } from 'chart.js';
import { MatDialog, Sort, MatDatepickerInputEvent } from '@angular/material';
import { DialogConsultaDocumentosComponent } from '../modal/dialog-consulta-documentos/dialog-consulta-documentos.component';
import { DialogListaImplicadosComponent } from '../modal/dialog-lista-implicados/dialog-lista-implicados.component';
import { DialogRegistraSolicitudComponent } from '../modal/dialog-registra-solicitud/dialog-registra-solicitud.component';
import { DialogCargaMasivaComponent } from '../modal/dialog-carga-masiva/dialog-carga-masiva.component';
import { ActivatedRoute } from '@angular/router';
import { BuscarListaComando } from '../shared/models/buscar-lista-comando';
import { ParametroRetencion } from '../shared/models/parametro-retencion';
import { TraedatabaseService } from '../shared/services/traedatabase-service';
import { IfStmt } from '@angular/compiler';
import { getMatScrollStrategyAlreadyAttachedError } from '@angular/cdk/overlay/typings/scroll/scroll-strategy';

export interface Dessert {
  id: number,
  ruta: string,
  solicitudes: number,
  implicados: number,
  fecharegistro: string,
  horaproceso:string,
  horatermino:string,
  estado:string,
  usuario: string;
}

@Component({
  selector: 'app-maestrocargas',
  templateUrl: './maestrocargas.component.html',
  styleUrls: ['./maestrocargas.component.css']
})
export class MaestrocargasComponent implements OnInit {
  ruta:string = this.routeparametro.snapshot.paramMap.get('retenciones');
  desserts: Dessert[] = [
    {id:1,ruta:'solicitud1345.xls',solicitudes:5, implicados:20, fecharegistro:"20/04/2020 10:46:00",horaproceso:"10:49:00",horatermino:"10:49:00",usuario:"THCAL002 - JORGE MENDEZ",estado:"REGISTRADO"},
    {id:2,ruta:'solicitud1345.xls',solicitudes:6, implicados:30, fecharegistro:"20/04/2020 10:46:00",horaproceso:"10:49:00",horatermino:"10:49:00",usuario:"TQCAL004 - JULIO QUISPE",estado:"EN PROCESO"},
    {id:3,ruta:'solicitud1345.xls',solicitudes:2, implicados:15, fecharegistro:"20/04/2020 10:46:00",horaproceso:"10:49:00",horatermino:"10:49:00",usuario:"TQCAL004 - JULIO QUISPE",estado:"PROCESADO"},
    {id:4,ruta:'solicitud1345.xls',solicitudes:6, implicados:50, fecharegistro:"20/04/2020 10:46:00",horaproceso:"10:49:00",horatermino:"10:49:00",usuario:"TQCAL004 - JULIO QUISPE",estado:"OBSERVADO"},
    {id:5,ruta:'solicitud1345.xls',solicitudes:2, implicados:10, fecharegistro:"20/04/2020 10:46:00",horaproceso:"10:49:00",horatermino:"10:49:00",usuario:"TQCAL004 - JULIO QUISPE",estado:"ANULADO"},
    {id:6,ruta:'solicitud1345.xls',solicitudes:3, implicados:30, fecharegistro:"20/04/2020 10:46:00",horaproceso:"10:49:00",horatermino:"10:49:00",usuario:"TQCAL004 - JULIO QUISPE",estado:"PROCESAO"}
    ];
  oculta: boolean =true;
  tipoflecha: string ="keyboard_arrow_up";
  listSolicitud: FormGroup;  
  veraccion: boolean;
  loading: boolean;
  sortedData: Dessert[];
  minDate: Date;
  maxDate: Date;
  minDateFin: Date;
  maxDateFin: Date;
  Parametro =  new ParametroRetencion();
  agenciaFilterCtrl: FormControl = new FormControl();
  idSolicitud = new FormControl();
  fechaInicioInput = new FormControl();
  fechaFinInput = new FormControl();
  tipodocumento = new FormControl();
  tiporequerimiento = new FormControl();
  tiporequerimientodta = new ParametroRetencion();
  estado = new FormControl();
  agencia = new FormControl();
  entidad = new FormControl();
  tipodocumentolista: string[];
  tiporequerimientolista: string[];
  agencialista: string[] = ['Agencia Abancay',	'Agencia Aguaytia',	'Agencia Andahuaylas',	'Agencia Andrés Avelino Cáceres',	'Agencia Anta',	'Agencia Arequipa',	'Agencia Ate',	'Agencia Ayacucho',	'Agencia Bambamarca',	'Agencia Barranca',	'Agencia Cajabamba',	'Agencia Cajamarca',	'Agencia Camaná',	'Agencia Campo Verde',	'Agencia Chocope',	'Agencia Cañete',	'Agencia Carabayllo',	'Agencia Casma',	'Agencia Cayma',	'Agencia Centenario',	'Agencia Cerro de Pasco',	'Agencia Cerro colorado',	'Agencia Chachapoyas',	'Agencia Chepén',	'Agencia Chiclayo',	'Agencia Chilca',	'Agencia Chimbote',	'Agencia Chivay',	'Agencia Chorrillos',	'Agencia Chosica',	'Agencia Chota',	'Agencia Chulucanas',	'Agencia Chupaca',	'Agencia Chuquibamba',	'Agencia Ciudad Constitución',	'Agencia Cocachacra',	'Agencia Constitución',	'Agencia Corire',	'Agencia Cusco',	'Agencia El Porvenir',	'Agencia El Tambo',	'Agencia Huachipa',	'Agencia Huacho',	'Agencia Huamachuco',	'Agencia Huancavelica',	'Agencia Huancabamba',	'Agencia Huánuco',	'Agencia Huaraz',	'Agencia Huarmaca',	'Agencia Huaycán',	'Agencia Ica',	'Agencia Iquitos',	'Agencia Jaén',	'Agencia Jauja',	'Agencia Jicamarca',	'Agencia Juliaca',	'Agencia La Esperanza',	'Agencia La Unión',	'Agencia La Joya',	'Agencia La Merced',	'Agencia La Negrita',	'Agencia La Oroya',	'Agencia Los Olivos',	'Agencia Lurín',	'Agencia Manchay',	'Agencia Mollendo',	'Agencia Moquegua',	'Agencia Moyobamba',	'Agencia Olmos',	'Agencia Oxapampa',	'Agencia Paita',	'Agencia Perene',	'Agencia Pampa Inalámbrica',	'Agencia Pampas',	'Agencia Pedregal',	'Agencia Pichanaqui',	'Agencia Pisac',	'Agencia Piura',	'Agencia Pucallpa',	'Agencia Puerto Maldonado',	'Agencia Puno',	'Agencia San Juan de Lurigancho',	'Agencia San Juan de Próceres',	'Agencia San Marcos',	'Agencia San Martín de Pangoa',	'Agencia San Martín de Porres',	'Agencia Santa Anita',	'Agencia Santiago de Chuco',	'Agencia Satipo',	'Agencia Sechura',	'Agencia Sede Principal Tacna',	'Agencia Sullana',	'Agencia Tacna Cono Norte',	'Agencia Tacna Cono Sur',	'Agencia Tambo Grande',	'Agencia Tarapoto',	'Agencia Tarma',	'Agencia Tayabamba',	'Agencia Tingo María',	'Agencia Tumbes',	'Agencia Urcos',	'Agencia Ventanilla',	'Agencia Villa El Salvador',	'Agencia Villa María del Triunfo',	'Agencia Villa Rica',	'Agencia Virú',	'Agencia Trujillo',	'Agencia Abancay',	'Agencia Aguaytia',	'Agencia Andahuaylas',	'Agencia Andrés Avelino Cáceres',	'Agencia Anta',	'Agencia Arequipa',	'Agencia Ate',	'Agencia Ayacucho',	'Agencia Bambamarca',	'Agencia Barranca',	'Agencia Cajabamba',	'Agencia Cajamarca',	'Agencia Camaná',	'Agencia Campo Verde',	'Agencia Chocope',	'Agencia Cañete',	'Agencia Carabayllo',	'Agencia Casma',	'Agencia Cayma',	'Agencia Centenario',	'Agencia Cerro de Pasco',	'Agencia Cerro colorado',	'Agencia Chachapoyas',	'Agencia Chepén',	'Agencia Chiclayo',	'Agencia Chilca',	'Agencia Chimbote',	'Agencia Chivay',	'Agencia Chorrillos',	'Agencia Chosica',	'Agencia Chota',	'Agencia Chulucanas',	'Agencia Chupaca',	'Agencia Chuquibamba',	'Agencia Ciudad Constitución',	'Agencia Cocachacra',	'Agencia Constitución',	'Agencia Corire',	'Agencia Cusco',	'Agencia El Porvenir',	'Agencia El Tambo',	'Agencia Huachipa',	'Agencia Huacho',	'Agencia Huamachuco',	'Agencia Huancavelica',	'Agencia Huancabamba',	'Agencia Huánuco',	'Agencia Huaraz',	'Agencia Huarmaca',	'Agencia Huaycán',	'Agencia Ica',	'Agencia Iquitos',	'Agencia Jaén',	'Agencia Jauja',	'Agencia Jicamarca',	'Agencia Juliaca',	'Agencia La Esperanza',	'Agencia La Unión',	'Agencia La Joya',	'Agencia La Merced',	'Agencia La Negrita',	'Agencia La Oroya',	'Agencia Los Olivos',	'Agencia Lurín',	'Agencia Manchay',	'Agencia Mollendo',	'Agencia Moquegua',	'Agencia Moyobamba',	'Agencia Olmos',	'Agencia Oxapampa',	'Agencia Paita',	'Agencia Perene',	'Agencia Pampa Inalámbrica',	'Agencia Pampas',	'Agencia Pedregal',	'Agencia Pichanaqui',	'Agencia Pisac',	'Agencia Piura',	'Agencia Pucallpa',	'Agencia Puerto Maldonado',	'Agencia Puno',	'Agencia San Juan de Lurigancho',	'Agencia San Juan de Próceres',	'Agencia San Marcos',	'Agencia San Martín de Pangoa',	'Agencia San Martín de Porres',	'Agencia Santa Anita',	'Agencia Santiago de Chuco',	'Agencia Satipo',	'Agencia Sechura',	'Agencia Sede Principal Tacna',	'Agencia Sullana',	'Agencia Tacna Cono Norte',	'Agencia Tacna Cono Sur',	'Agencia Tambo Grande',	'Agencia Tarapoto',	'Agencia Tarma',	'Agencia Tayabamba',	'Agencia Tingo María',	'Agencia Tumbes',	'Agencia Urcos',	'Agencia Ventanilla',	'Agencia Villa El Salvador',	'Agencia Villa María del Triunfo',	'Agencia Villa Rica',	'Agencia Virú',	'Agencia Trujillo'];
  entidadlista: string[] ;
  estadolista: string[];
  doughnutChartLabels: Label[] =  ['Registrados','En Proceso','Procesados','Observados','Anulados'];
  barChartPlugins = [pluginDataLabels];
  doughnutChartType: ChartType = 'doughnut';
  doughnutChartData: MultiDataSet = [[10,4,6,6,2]];
  public BuscarListaParametro = new BuscarListaComando;
  cadena: string ="";

  constructor(private matDialog: MatDialog,
             private routeparametro: ActivatedRoute,
             private baseDatoService:TraedatabaseService) {this.sortedData = this.desserts.slice();}

  public chartOptions:any = { 
    responsive: true,
    size: "20",
    legend: { position: 'right'}
  };

  openDialogDocumentos(){
    this.matDialog.open(DialogConsultaDocumentosComponent,
      /*dialogConfig,*/
        { width: '800px',
        height: '380px',
        data: 0});
  }
  openDialogCargaMasiva(){
    this.matDialog.open(DialogCargaMasivaComponent,
      /*dialogConfig,*/
        { width: '800px',
        height: '380px',
        data: 0});
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
        case 'ruta': return compare(a.ruta, b.ruta, isAsc);
        case 'solicitudes': return compare(a.solicitudes, b.solicitudes, isAsc);
        case 'implicados': return compare(a.implicados, b.implicados, isAsc);
        case 'fecharegistro': return compare(a.fecharegistro, b.fecharegistro, isAsc);
        case 'horaproceso': return compare(a.horaproceso, b.horaproceso, isAsc);
        case 'horatermin': return compare(a.horatermino, b.horatermino, isAsc);
        case 'usuario': return compare(a.usuario, b.usuario, isAsc);
        case 'estado': return compare(a.estado, b.estado, isAsc);
        default: return 0;
      }
    });
  }
  ngOnInit() {
    this.listSolicitud = new FormGroup({
      idSolicitud: new FormControl(),
      expdediente: new FormControl(),
      tipodocumento: new FormControl(),
      tiporequerimiento: new FormControl(),
      entidad: new FormControl(),
      agencia: new FormControl(),
      fechainicio: new FormControl(),
      fechafin: new FormControl(),
      estado: new FormControl()
    }); 
    this.loading = true;
    this.buildForm();
    this.veraccion = false;
    localStorage.setItem('indinicio',"false");
    this.llenado_combo_box();
    this.loading = false;
  }
  ocultar(){
      this.oculta= !this.oculta;   
      if (this.oculta) {
        this.tipoflecha = "keyboard_arrow_up";}
      else{
        this.tipoflecha = "keyboard_arrow_down"};
  }
  llenado_combo_box(){
    try {
      let cont: number = 0; 
      let cadena: string="";
      // estableciendo llenado de combo segun segun objeto
      let cad: any;
      let url = this.Parametro.llave.replace(":codigo","0").replace(":correlativo","0"); 
      this.BuscarListaParametro.opcionListarQuerys = url;
      this.baseDatoService.queryOptionDateBase(this.BuscarListaParametro).subscribe(paramsLibro => {        
        paramsLibro.forEach(elem=>{
          elem.codigo = +elem.columnas[0];        
          elem.correlativo = +elem.columnas[1];
          elem.descripcion = elem.columnas[2].toUpperCase();
          elem.importe= +elem.columnas[3];
          elem.numero= +elem.columnas[4];
          let valcomp: string = "¬" + elem.codigo + "¬";
          if(elem.correlativo>=0) {
            if(this.cadena.indexOf(valcomp)>-1){
              this.cadena += elem.correlativo + ' - ' + elem.descripcion + '|';
              cadena += elem.correlativo + ' - ' + elem.descripcion + ' - ' + elem.importe + ' - ' + elem.numero + '|';
            } else{
              this.cadena += "¬" + elem.codigo + "¬" + elem.correlativo + ' - ' + elem.descripcion + '|';
              cadena += "¬" + elem.codigo + "¬" + elem.correlativo + ' - ' + elem.descripcion + ' -  ' + elem.importe + ' - ' + elem.numero + '|';
            }
          }
          localStorage.setItem("parametros",this.cadena);
          localStorage.setItem("parametrost",cadena);
          // Lenando lo valores         
          let arrtabla = this.cadena.split("¬" + elem.codigo + "¬"); // Obteniendo los datos del Tipo de requerimiento 
          if (arrtabla.length>0){
            let arrdatos = (arrtabla[1] + '--- SELECCIONAR TODO ---').split("|"); // Obteniendo los elementos
            switch(elem.codigo){
              case 1:
                this.tipodocumentolista = arrdatos;
                break;
              case 2:
                this.tiporequerimientolista = arrdatos;
                break;
              case 6:
                this.estadolista = arrdatos;
            }          
          }        
        });
        
      });
    }catch(ex){
      alert(ex);
    } 
  }

  private buildForm(){
    
  }

  compareItems(obj1, obj2) {
    return obj1 && obj2 && obj1.codigo===obj2.codigo;
  }

  agregarTablaRecursos(agencia: any){
    if(undefined == this.agencialista){
      this.agencialista = [];
      this.agencialista.push(agencia);
    }else{
      let isExists = this.agencialista.filter(agencias => agencias == agencia).length > 0;
      if(!isExists){
        this.agencialista.push(agencia);
      }   
    }
  }

  applyFilter(event: Event) {
    alert((event.target as HTMLInputElement).value);
    const filterValue = (event.target as HTMLInputElement).value;
  }

  selecttiporeq(plan: any){
    try{
      if (plan==""){
        this.entidadlista = "--- No Existe Datos ---".split(',');
      }else {
        let p 
        if ((' ' + plan).indexOf("---")>-1){
          p = "1 - A,2 - A,3 - A,4 - A,5 - A,6 - A, 7 - A".split(',');
        }else{   
          p = (' '+plan).split(',');
        }
        let cbotxt: string="";
        p.forEach(l=>{ 
          let a = (' '+l).split(' - ');
          let arrtabla = this.cadena.split("¬3¬"); // Obteniendo los datos del Tipo de requerimiento 
          if (arrtabla.length>0){
            let vali: number = +(a[0]+'0');
            let valf: number = +(a[0]+'9');
            let cadtxt = arrtabla[1].split('|')
            for(let i=0;i<=cadtxt.length-1;i++){
                let cadtxt1 = cadtxt[i].split(' - ');
                if (valf>=+cadtxt1[0] && vali<=+cadtxt1[0]){
                  cbotxt += cadtxt[i] + '|';
                }
            }        
            let arrdatos = (cbotxt + '--- SELECCIONAR TODO ---').split("|"); // Obteniendo los elementos        
            this.entidadlista = arrdatos;
          }
        });
      }
    }catch(ex){
      alert(ex);
    }
  }

  changeFech(type: string, event: MatDatepickerInputEvent<Date>) {
    let daySelect = event.value;
    if("change" == type){
      this.minDateFin  = new Date(daySelect.getFullYear(), daySelect.getMonth(), daySelect.getDate()+1);
    }
  }

  changeFechFin(type: string, event: MatDatepickerInputEvent<Date>) {

  }
  openDialogImplicados(): void {
    let idIniciativa: string="";
    const dialogRef = this.matDialog.open(DialogListaImplicadosComponent, /*dialogConfig,*/
      { width: '800px',
        height: '235px',
        data: idIniciativa
      }
    );
    }
  openDialogRecursos(): void {
    let idIniciativa: string="";
    const dialogRef = this.matDialog.open(DialogRegistraSolicitudComponent, /*dialogConfig,*/
      { width: '800px',
        height: '400px',
        data: idIniciativa
      }
    );
    }
    select1(e: any){

    } 
    chartHovered(e: any){

    }
    chartClicked(e: any){

    }
    buscarDatos(datos: string){

    }

}

function compare(a: number | string, b: number | string, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}

