import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogRegistraSolicitudComponent } from './dialog-registra-solicitud.component';

describe('DialogRegistraSolicitudComponent', () => {
  let component: DialogRegistraSolicitudComponent;
  let fixture: ComponentFixture<DialogRegistraSolicitudComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogRegistraSolicitudComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogRegistraSolicitudComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
