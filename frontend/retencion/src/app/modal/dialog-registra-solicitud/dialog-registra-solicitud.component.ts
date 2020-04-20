import { Component, OnInit, Inject } from '@angular/core';
import { formatDate } from '@angular/common';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { MatDialogRef, MatTableDataSource, MAT_DIALOG_DATA, MatDatepickerInputEvent, MatDialog } from '@angular/material';
import { IniciativaMainFire } from 'src/app/shared/models/iniciativa-main-fire';
import { ColaboradorDetalleFire } from 'src/app/shared/models/colaborador-detalle-fire';
import { FirebaseColaboradorService } from 'src/app/shared/services/firebase-colaborador.service';
import { FirebaseIniciativaMainService } from 'src/app/shared/services/firebase-iniciativa-main.service';
import { ColaboradorFire } from 'src/app/shared/models/colaborador-fire';
import { DialogListaImplicadosComponent } from '../dialog-lista-implicados/dialog-lista-implicados.component';
import { SolicitudService } from 'src/app/shared/services/solicitud-service';
import { ActivatedRoute } from '@angular/router';
import { TraedatabaseService } from 'src/app/shared/services/traedatabase-service';
import { BuscarListaComando } from 'src/app/shared/models/buscar-lista-comando';

@Component({
  selector: 'app-dialog-registra-solicitud',
  templateUrl: './dialog-registra-solicitud.component.html',
  styleUrls: ['./dialog-registra-solicitud.component.css']
})
export class DialogRegistraSolicitudComponent implements OnInit {
  public BuscarListaParametro = new BuscarListaComando;
  veraccion: boolean;
  loading: boolean;
  minDate: Date;
  maxDate: Date;
  minDateFin: Date;
  maxDateFin: Date;
  regSolicitud: FormGroup;
  fecharegistro = new FormControl();
  fecharecepcion = new FormControl();
  tipodocumento = new FormControl();
  tiporequerimiento = new FormControl();
  prioridad = new FormControl();
  tiempolimite = new FormControl();
  Solicitud =  new SolicitudService();
  estado = new FormControl();
  agencia: string;
  entidad = new FormControl();
  totalhojas = new FormControl();
  expediente = new FormControl();
  personal = new FormControl();
  cadena: string;
  tipodocumentolista: string[];
  tiporequerimientolista: string[];
  agencialista: string[] = ['--- No Seleccionado ---','101 - Agencia Abancay',	'102 - Agencia Aguaytia',	'103 - Agencia Andahuaylas',	'104 - Agencia Andrés Avelino Cáceres',	'105 - Agencia Anta',	'106 - Agencia Arequipa',	'107 - Agencia Ate',	'108 - Agencia Ayacucho',	'109 - Agencia Bambamarca',	'110 - Agencia Barranca',	'111 - Agencia Cajabamba',	'112 - Agencia Cajamarca'];
  entidadlista: string[];        
  estadolista: string[];
  prioridadlista: string[];
  tipo: string="";
  tiempodiaslista: string[];
  constructor(private dialogRef: MatDialogRef<DialogRegistraSolicitudComponent>,private matDialog: MatDialog, private formBuilder: FormBuilder,
              private routeparametro: ActivatedRoute,
              private baseDatoService:TraedatabaseService, private firebaseColaboradores: FirebaseColaboradorService){}
    
  get f() { return this.regSolicitud.controls; }
  
  ngOnInit() {
    this.regSolicitud = new FormGroup({
      idSolicitud: new FormControl() ,
      tipodocumento: new FormControl(),
      agencia: new FormControl(),
      personal: new FormControl(),
      tiporequerimiento: new FormControl(),
      entidad: new FormControl(),
      prioridad: new FormControl(),
      fecharegistro: new FormControl(),
      fecharecepcion: new FormControl(),
      expediente: new FormControl(),
      tiempolimite: new FormControl(),
      totalhojas: new FormControl(),
      estado: new FormControl()
    });
    this.resetFields();
    this.IniciaValores();
  }

  IniciaValores(){
    this.cadena = localStorage.getItem("parametros");
    let cadena = localStorage.getItem("parametrost");
    // Lenando lo valores
    let arrtabla = this.cadena.split("¬1¬");
    
    let arrdatos = arrtabla[1].substr(0,arrtabla[1].indexOf("¬")-1).split("|");
    this.tipodocumentolista = arrdatos;

    arrtabla = this.cadena.split("¬2¬");
    arrdatos = arrtabla[1].substr(0,arrtabla[1].indexOf("¬")-1).split("|");
    this.tiporequerimientolista = arrdatos;

    arrtabla = this.cadena.split("¬6¬");
    arrdatos = arrtabla[1].substr(0,arrtabla[1].indexOf("¬")-1).split("|");
    this.estadolista = arrdatos;

    arrtabla = this.cadena.split("¬7¬");
    if(arrtabla[1].indexOf("¬")>-1)
    arrdatos = arrtabla[1].substr(0,arrtabla[1].indexOf("¬")-1).split("|");
    else
    arrdatos = arrtabla[1].substr(0,arrtabla[1].length-1).split("|");
    
    this.prioridadlista = arrdatos;
    
    arrtabla = cadena.split("¬8¬");
    if(arrtabla[1].indexOf("¬")>-1)
    arrdatos = arrtabla[1].substr(0,arrtabla[1].indexOf("¬")-1).split("|");
    else
    arrdatos = arrtabla[1].substr(0,arrtabla[1].length-1).split("|");
    
    let DiasInicial: number = +arrdatos[1].split(" - ")[3];
    let DiasFinal: number = +arrdatos[2].split(" - ")[3];

    let cadstr ="";
    for(let i=0; i<=DiasFinal; i++){
      cadstr += i +','; 
    }
    cadstr = cadstr.substr(0,cadstr.length-1);
    this.tiempodiaslista = cadstr.split(",");

  }

  openacceso(usu: string, pwd: string){
  
  }
  compareItems(obj1, obj2) {
    return obj1 && obj2 && obj1.codigo===obj2.codigo;
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

  changeFech(type: string, event: MatDatepickerInputEvent<Date>) {
    let daySelect = event.value;
    if("change" == type){
      this.minDateFin  = new Date(daySelect.getFullYear(), daySelect.getMonth(), daySelect.getDate()+1);
    }
  }

  changeFechFin(type: string, event: MatDatepickerInputEvent<Date>) {

  }

  saveIniciativa(datos: string){
      let url = this.Solicitud.inserta;  
      

      if (this.regSolicitud.get('agencia').value!=undefined)
      url = url.replace(":COD_AGEN_RECEP",(this.regSolicitud.get('agencia').value).split(" -")[0]);
      
      if (this.regSolicitud.get('totalhojas').value!=undefined)      
      url = url.replace(":CANTIDAD_HOJAS",''+this.regSolicitud.get('totalhojas').value);
      
      this.Solicitud.COD_AGEN_REGIS = 100;
      url = url.replace(":COD_AGEN_REGIS","100");
      
      if (this.regSolicitud.get('tipodocumento').value!=undefined)
      url = url.replace(":COD_DCTO_INGRESADO",(''+this.regSolicitud.get('tipodocumento').value).split(" -")[0]);
            
      if (this.regSolicitud.get('entidad').value!=undefined)      
      url = url.replace(":COD_ENTIDAD",(''+this.regSolicitud.get('entidad').value).split(" -")[0]);
      
      if (this.regSolicitud.get('prioridad').value!=undefined)
      url = url.replace(":COD_PRIORIDAD",(''+this.regSolicitud.get('prioridad').value).split(" -")[0]);
     
      if (this.regSolicitud.get('tiporequerimiento').value!=undefined)
      url = url.replace(":COD_REQUERIMIENTO",(''+this.regSolicitud.get('tiporequerimiento').value).split(" -")[0]);
      
      if (this.regSolicitud.get('tiempolimite').value!=undefined)
      url = url.replace(":DIAS_MAX_RPTA",(''+this.regSolicitud.get('tiempolimite').value));

      if (this.regSolicitud.get('fecharecepcion').value!=undefined)
      url = url.replace(":FECHA_RECEP",(''+this.regSolicitud.get('fecharecepcion').value));
    
      if (this.regSolicitud.get('fecharegistro').value!=undefined)
      url = url.replace(":FECHA_REGISTRO",(''+this.regSolicitud.get('fecharegistro').value));
    
      url = url.replace(":HORA_REGISTRO",'16:18:00');
      url = url.replace(":ID_SECUENCIA_EVENTO_ULTI",'1');

      if (this.regSolicitud.get('entidad').value!=undefined)
      url = url.replace(":NUM_DOC_INGRESADO","1");
      
      url = url.replace(":TEXTO_RESPUESTA"," ");
      url = url.replace(":USER_REGISTRO","THCAL001");
      url = url.replace(":ID_CARTA","0");
  
      this.BuscarListaParametro.opcionListarQuerys = url;    
      this.baseDatoService.queryOptionDateBase(this.BuscarListaParametro).subscribe(paramssolicitud => {

      });
  }
  Iniciavalores(){
    this.tiempolimite.setValue("0");
    this.tipodocumento.setValue("1");
    this.tiporequerimiento.setValue("");
    this.entidad.setValue(""); 
    this.prioridad.setValue("")
  } 
  resetFields(){
     // Inicia los campos de los campos a guardar
      this.Solicitud.COD_AGEN_RECEP = 0;
      this.Solicitud.CANTIDAD_HOJAS= 0;
      this.Solicitud.COD_AGEN_REGIS = 0;
      this.Solicitud.COD_DCTO_INGRESADO= 0;
      this.Solicitud.COD_ENTIDAD=  0;
      this.Solicitud.COD_PRIORIDAD=  0;
      this.Solicitud.COD_REQUERIMIENTO=  0;
      this.Solicitud.DIAS_MAX_RPTA=  0;
      this.Solicitud.FECHA_RECEP=  null;
      this.Solicitud.FECHA_REGISTRO= null;
      this.Solicitud.HORA_REGISTRO=  null;
      this.Solicitud.ID_SECUENCIA_EVENTO_ULTI=0;
      this.Solicitud.NUM_DOC_INGRESADO= ' ';
      this.Solicitud.TEXTO_RESPUESTA=' ';
      this.Solicitud.USER_REGISTRO= localStorage.getItem("usuario");
      this.Solicitud.ID_CARTA=0;
      // inicia los datos
  } 
  close(){

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
            let arrdatos = (cbotxt.substr(0,cbotxt.length-1)).split("|"); // Obteniendo los elementos        
            this.entidadlista = arrdatos;
          }
        });
      }
    }catch(ex){
      alert(ex);
    }
  }

}

