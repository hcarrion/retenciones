import { Component, OnInit, ElementRef, ViewChild, Directive } from '@angular/core';
import { Sort } from '@angular/material';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

export interface Dessert {
  id: string,
  archivocarga: string,
  solicitud: string,
  usuario:string,
  fechacarga:string,
  estado:string
}


@Component({
  selector: 'app-dialog-carga-masiva',
  templateUrl: './dialog-carga-masiva.component.html',
  styleUrls: ['./dialog-carga-masiva.component.css']
})

export class DialogCargaMasivaComponent implements OnInit {  
  regSolicitud: FormGroup;
  loading: boolean;
  sortedData: Dessert[];
  desserts: Dessert[] = [
    {id:"1",archivocarga:"listajudicilal1.xlsx",solicitud:"1",usuario:"SUAREZ SALAZAR, JOSE",fechacarga:"01/04/2020 21:30:00 22:30:00",estado:"PROCESADO"},
    {id:"2",archivocarga:"listajudicilal2.xlsx",solicitud:"4",usuario:"RUIZ DIAS, JUAN",fechacarga:"01/04/2020 21:30:00",estado:"PROCESADO"},
    {id:"3",archivocarga:"listajudicilal3.xlsx",solicitud:"7",usuario:"BARRANCA BALTAZA, LUIS",fechacarga:"01/04/2020 21:30:00",estado:"PROCESADO"},
    {id:"4",archivocarga:"listajudicilal4.xlsx",solicitud:"10",usuario:"QUISPE SANCHES, JOSE",fechacarga:"01/04/2020 21:30:00",estado:"PROCESADO"},
    {id:"5",archivocarga:"listajudicilal5.xlsx",solicitud:"12",usuario:"SALASAR JUAREZ, PETER",fechacarga:"01/04/2020 21:30:00",estado:"PROCESADO"},
    {id:"6",archivocarga:"listajudicilal6.xlsx",solicitud:"14",usuario:"CARRION QUISPE, ANDERSOn",fechacarga:"01/04/2020 21:30:00",estado:"PROCESADO"},
    {id:"7",archivocarga:"listajudicilal7.xlsx",solicitud:"20",usuario:"PORTUGUEZ BAZALAr, ALBERTO",fechacarga:"01/04/2020 21:30:00",estado:"PROCESADO"},
    {id:"8",archivocarga:"listajudicilal8.xlsx",solicitud:"24",usuario:"SUAREZ SALASA, JOSE",fechacarga:"01/04/2020 21:30:00",estado:"PROCESADO"}
    ];
    myFiles:string [] = [];
    
    myForm = new FormGroup({
      name: new FormControl('', [Validators.required, Validators.minLength(3)]),
      file: new FormControl('', [Validators.required])
    });

  constructor(private http: HttpClient, private el: ElementRef) {
    
    this.sortedData = this.desserts.slice();
    if (!el.nativeElement['focus']) {
      throw new Error('el elemento no acepta el enfoque.');
    }
  }

  openDialogEditar(e: any){

  }
  ngOnInit() {
    const input: HTMLInputElement = this.el.nativeElement as HTMLInputElement;
    input.focus();
    input.select();
    }

  public chartOptions:any = { 
    responsive: true,
    size: "20",
    legend: { position: 'right'}
  };
  get f(){
    return this.myForm.controls;
  }
  onFileChange(event) {
    for (var i = 0; i < event.target.files.length; i++) { 
        this.myFiles.push(event.target.files[i]);
    } 
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
        case 'archivocarga': return compare(a.archivocarga, b.archivocarga, isAsc);
        case 'solicitud': return compare(a.solicitud, b.solicitud, isAsc);
        case 'usuario': return compare(a.usuario, b.usuario, isAsc);
        case 'fechacarga': return compare(a.fechacarga, b.fechacarga, isAsc);
        case 'estado': return compare(a.estado, b.estado, isAsc);
        default: return 0;
      }
    });

  }
submit(){
    const formData = new FormData();
    for (var i = 0; i < this.myFiles.length; i++) { 
      formData.append("file[]", this.myFiles[i]);
    }

    this.http.post('http://localhost:8001/upload.php', formData)
      .subscribe(res => {
        console.log(res);
        alert('Uploaded Successfully.');
      })

  }
}
function compare(a: number | string, b: number | string, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}
