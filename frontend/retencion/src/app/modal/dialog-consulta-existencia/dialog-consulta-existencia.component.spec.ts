import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogConsultaExistenciaComponent } from './dialog-consulta-existencia.component';

describe('DialogConsultaExistenciaComponent', () => {
  let component: DialogConsultaExistenciaComponent;
  let fixture: ComponentFixture<DialogConsultaExistenciaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogConsultaExistenciaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogConsultaExistenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
