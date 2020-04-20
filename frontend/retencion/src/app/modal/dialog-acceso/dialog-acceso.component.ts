import { Component, OnInit, Inject } from '@angular/core';
import { formatDate } from '@angular/common';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MatTableDataSource, MAT_DIALOG_DATA } from '@angular/material';


@Component({
  selector: 'app-dialog-acceso',
  templateUrl: './dialog-acceso.component.html',
  styleUrls: ['./dialog-acceso.component.css']
})
export class DialogAccesoComponent implements OnInit {
  public usuario: string;
  public mensaje: string;
  public perfil: string;
  loading: boolean;
  password: string;
  registerForm: FormGroup;
  
  constructor(private dialogRef: MatDialogRef<DialogAccesoComponent>, private formBuilder: FormBuilder){}
    
  get f() { return this.registerForm.controls; }
  
  ngOnInit() {
    localStorage.setItem("usuario","");
    localStorage.setItem("nomusu","");
    localStorage.setItem("cargousu","");
    localStorage.setItem("perfil","");
    this.registerForm = this.formBuilder.group({
      usuario: ['', [Validators.required, Validators.minLength(10)]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }
  openacceso(usu: string, pwd: string){

    this.loading = true;
  
    if(usu.length==0&&pwd.length==0){
       this.mensaje="Error: los datos del usuario son obligatorios, verifique y vuelva a ingresar"; 
       this.loading = false;
       return;
    }
    else{
      this.usuario= usu;
      this.password= pwd;
      this.mensaje="";
      localStorage.setItem("usuario","THCAL001");
      localStorage.setItem("nomusu","HARRY CARRION LEON");
      localStorage.setItem("cargousu","ANALISTA DE SISTEMAS");
      localStorage.setItem("perfil","ADMINISTRADOR");
      this.dialogRef.close();
    }
  } 
}
