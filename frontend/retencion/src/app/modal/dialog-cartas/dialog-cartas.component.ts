import { Component, OnInit } from '@angular/core';
import {Sort} from '@angular/material/sort';
import { MatTableDataSource, MatDatepickerInputEvent, MatDialog, MatDialogRef } from '@angular/material';
import { FormControl, FormGroup } from '@angular/forms';
import { SingleLineLabel, MultiLineLabel, MultiDataSet } from 'ng2-charts';
export declare type Label = SingleLineLabel | MultiLineLabel;
import * as pluginDataLabels from 'chartjs-plugin-datalabels';
import { ChartType } from 'chart.js';
import { DialogCargaMasivaComponent } from '../dialog-carga-masiva/dialog-carga-masiva.component';
import { AngularEditorConfig } from '@kolkov/angular-editor';

export interface Dessert {
  id: string,
  columna: string,
  seleccion: string
}

export interface DessertP {
  id: string,
  plantilla: string,
  tipo: string,
  seleccion: string
}
@Component({
  selector: 'app-dialog-cartas',
  templateUrl: './dialog-cartas.component.html',
  styleUrls: ['./dialog-cartas.component.css']
})
export class DialogCartasComponent implements OnInit {
  activapdf: Boolean;
  editorConfig: AngularEditorConfig = {
    editable: true,
    spellcheck: true,
    height: '260px',
    minHeight: '0',
    maxHeight: 'auto',
    width: 'auto',
    minWidth: '0',
    translate: 'yes',
    enableToolbar: true,
    showToolbar: true,
    placeholder: 'Introducir texto aquí...',
    defaultParagraphSeparator: '',
    defaultFontName: '',
    defaultFontSize: '',
    fonts: [
      {class: 'arial', name: 'Arial'},
      {class: 'times-new-roman', name: 'Times New Roman'},
      {class: 'calibri', name: 'Calibri'},
      {class: 'comic-sans-ms', name: 'Comic Sans MS'}
    ],
    customClasses: [
    {
      name: 'quote',
      class: 'quote',
    },
    {
      name: 'redText',
      class: 'redText'
    },
    {
      name: 'titleText',
      class: 'titleText',
      tag: 'h1',
    },
  ],
  uploadUrl: 'assets/images',
  sanitize: false,
  outline: true,
  toolbarPosition: 'top',
  toolbarHiddenButtons: [
    ['insertImage', 'insertVideo']
  ]
};
headingCss = {
  'height': '390px'
};  

  desserts: Dessert[] = [
    {id:"1",columna:"Tipo de Documento",seleccion:"true"},
    {id:"2",columna:"Numero de Documento",seleccion:"true"},
    {id:"3",columna:"Operacon",seleccion:"true"},
    {id:"4",columna:"Moneda",seleccion:"true"},
    {id:"5",columna:"Importe",seleccion:"true"},
    {id:"6",columna:"Porcentaje",seleccion:"true"},
    {id:"7",columna:"Nombre y Apellidos",seleccion:"true"}
    ];

  dessertsp: DessertP[] = [
      {id:"1",plantilla:"CARTA RETENCION 1",tipo:"RETENCIO",seleccion:"true"},
      {id:"2",plantilla:"CARTA NO RETENCION",tipo:"NO RETENCION",seleccion:"true"},
      {id:"3",plantilla:"CARTA LEVANTAMIENTO DE INFORMACION",tipo:"LEVANTAMIENTO DE INFORMACION",seleccion:"true"},
      {id:"4",plantilla:"CARTA LIBERACION",tipo:"LIBERACION",seleccion:"true"},
      {id:"5",plantilla:"CARTA NO CLIENTE",tipo:"INFORMTIVO",seleccion:"true"}
      ];

  regCartas: FormGroup; 
  idsolicitud: number= 10;
  veraccion: boolean;
  loading: boolean;
  sortedData: Dessert[];
  sortedDatap: DessertP[];
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
  actSemanaAnterior = new FormControl();
  existeimplicado: boolean;


  activa: string="false";

  public revisiontalentogerentes: boolean;
  public contratodesempenofuncionarios: boolean;
  public revisiontalentojefes: boolean;
  public contratodesempenogerentes: boolean;
  
  constructor(public dialogRef: MatDialogRef<DialogCargaMasivaComponent>, private matDialog: MatDialog) {
    this.sortedData = this.desserts.slice();}


  public chartOptions:any = { 
    responsive: true,
    size: "20",
    legend: { position: 'right'}
  };
  openDialogEditar(){
    
  }
  onCheckboxChange(e: any, columna: string){
    if (e.target.checked)
    {
      alert(columna);
      //var checkbox = document.getElementById('editor1').innerHTML="{"+ columna +"}";
    }
  }  
  habilita(){
    this.editorConfig = {
      editable: true,
      spellcheck: true,
      height: 'auto',
      minHeight: '0',
      maxHeight: 'auto',
      width: 'auto',
      minWidth: '0',
      translate: 'yes',
      enableToolbar: true,
      showToolbar: true,
      placeholder: 'Introducir texto aquí...',
      defaultParagraphSeparator: '',
      defaultFontName: '',
      defaultFontSize: '',
      fonts: [
        {class: 'arial', name: 'Arial'},
        {class: 'times-new-roman', name: 'Times New Roman'},
        {class: 'calibri', name: 'Calibri'},
        {class: 'comic-sans-ms', name: 'Comic Sans MS'}
      ],
      customClasses: [
      {
        name: 'quote',
        class: 'quote',
      },
      {
        name: 'redText',
        class: 'redText'
      },
      {
        name: 'titleText',
        class: 'titleText',
        tag: 'h1',
      },
    ],
    uploadUrl: 'assets/images',
    sanitize: false,
    outline: true,
    toolbarPosition: 'top',
    toolbarHiddenButtons: [
      ['insertImage', 'insertVideo']
    ]
  };
}

  deshabilita(){
    this.activapdf = false;
    this.editorConfig = {
      editable: true,
      spellcheck: true,
      height: 'auto',
      minHeight: '0',
      maxHeight: 'auto',
      width: 'auto',
      minWidth: '0',
      translate: 'yes',
      enableToolbar: true,
      showToolbar: false,
      placeholder: 'Introducir texto aquí...',
      defaultParagraphSeparator: '',
      defaultFontName: '',
      defaultFontSize: '',
      fonts: [
        {class: 'arial', name: 'Arial'},
        {class: 'times-new-roman', name: 'Times New Roman'},
        {class: 'calibri', name: 'Calibri'},
        {class: 'comic-sans-ms', name: 'Comic Sans MS'}
      ],
      customClasses: [
      {
        name: 'quote',
        class: 'quote',
      },
      {
        name: 'redText',
        class: 'redText'
      },
      {
        name: 'titleText',
        class: 'titleText',
        tag: 'h1',
      },
    ],
    uploadUrl: 'assets/images',
    sanitize: false,
    outline: true,
    toolbarPosition: 'top',
    toolbarHiddenButtons: [
      ['insertImage', 'insertVideo']
    ]
  };
  this.activapdf = true;
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
        case 'columna': return compare(a.columna, b.columna, isAsc);
        case 'seleccion': return compare(a.seleccion, b.seleccion, isAsc);
        default: return 0;
      }
    });
  }

  sortDataP(sort: Sort) {
    const data = this.dessertsp.slice();
    if (!sort.active || sort.direction === '') {
      this.sortedDatap = data;
      return;
    }
    this.sortedDatap = data.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'id': return compare(a.id, b.id, isAsc);
        case 'plantilla': return compare(a.plantilla, b.plantilla, isAsc);
        case 'tipo': return compare(a.tipo, b.tipo, isAsc);
        case 'seleccion': return compare(a.seleccion, b.seleccion, isAsc);
        default: return 0;
      }
    });
  }

  ngOnInit() {
    this.veraccion = false;
    localStorage.setItem('indinicio',"false");
    this.loading = false;
  }

  changeFech(type: string, event: MatDatepickerInputEvent<Date>) {
    let daySelect = event.value;
    if("change" == type){
      this.minDateFin  = new Date(daySelect.getFullYear(), daySelect.getMonth(), daySelect.getDate()+1);
    }
  }

}

function compare(a: number | string, b: number | string, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}
