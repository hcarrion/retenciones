import { BrowserModule } from '@angular/platform-browser';
import { NgModule,NgZone, ViewChild } from '@angular/core';
import { MatSliderModule } from '@angular/material/slider';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MenuComponent } from './menu/menu.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatDialogModule } from '@angular/material/dialog';
import { MatDatepickerModule} from '@angular/material/datepicker';
import { MatFormFieldModule, MatNativeDateModule, MatInputModule,MatSelectModule, MatProgressSpinnerModule} from '@angular/material';
//import { MbscModule } from '@mobiscroll/angular';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
// Modulos Para Firebase
import { AngularFireModule } from '@angular/fire';
import { AngularFireDatabaseModule } from '@angular/fire/database';
import { environment } from '../environments/environment';
import { AngularFireStorageModule } from '@angular/fire/storage';
import { AngularFirestore } from 'angularfire2/firestore';
import { FirebaseParametroService } from './shared/services/firebase-parametro.service';
import { MaterialModule } from './material-module';
import { NgxMatSelectSearchModule } from 'ngx-mat-select-search';
import { SelectDropDownModule } from 'ngx-select-dropdown';
import { ChartsModule } from 'ng2-charts';
import { HttpClientModule} from '@angular/common/http';
import { AngularEditorModule } from '@kolkov/angular-editor';
import { CommonModule, DatePipe } from '@angular/common';
import { DialogAccesoComponent } from './modal/dialog-acceso/dialog-acceso.component';
import { EmailFireService } from './shared/services/email-fire.service';
import { SolicitudComponent } from './solicitud/solicitud.component';
import { DialogRegistraSolicitudComponent } from './modal/dialog-registra-solicitud/dialog-registra-solicitud.component';
import { DialogListaImplicadosComponent } from './modal/dialog-lista-implicados/dialog-lista-implicados.component';
import { DialogConsultaExistenciaComponent } from './modal/dialog-consulta-existencia/dialog-consulta-existencia.component';
import { DialogConsultaDocumentosComponent } from './modal/dialog-consulta-documentos/dialog-consulta-documentos.component';
import { DialogCargaMasivaComponent } from './modal/dialog-carga-masiva/dialog-carga-masiva.component';
import { DialogCartasComponent } from './modal/dialog-cartas/dialog-cartas.component';
import { MaestrocargasComponent } from './maestrocargas/maestrocargas.component';


@NgModule({
  declarations: 
  [
    AppComponent,
    MenuComponent,
    DialogAccesoComponent,
    SolicitudComponent,
    DialogRegistraSolicitudComponent,
    DialogListaImplicadosComponent,
    DialogConsultaExistenciaComponent,
    DialogConsultaDocumentosComponent,
    DialogCargaMasivaComponent,
    DialogCartasComponent,
    MaestrocargasComponent
  ],
  imports: 
  [
    BrowserModule,    
    ChartsModule,
    AppRoutingModule,
    MatSliderModule,
    BrowserAnimationsModule,
    LayoutModule,
    MaterialModule,
    ReactiveFormsModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    AngularFireDatabaseModule,
    MatProgressSpinnerModule,
    NgxMatSelectSearchModule,
    HttpClientModule, 
    AngularEditorModule,
    SelectDropDownModule,
    CommonModule,
    FormsModule
  ],
  providers: [AngularFireStorageModule,AngularFirestore, FirebaseParametroService, CommonModule, DatePipe, EmailFireService, ],
  entryComponents: [DialogAccesoComponent, DialogRegistraSolicitudComponent, DialogListaImplicadosComponent, DialogConsultaExistenciaComponent,DialogConsultaDocumentosComponent,
                    DialogCargaMasivaComponent, DialogCartasComponent],
  bootstrap: [AppComponent]
})
export class AppModule {   
}
