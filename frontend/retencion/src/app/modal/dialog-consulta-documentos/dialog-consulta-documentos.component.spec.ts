import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogConsultaDocumentosComponent } from './dialog-consulta-documentos.component';

describe('DialogConsultaDocumentosComponent', () => {
  let component: DialogConsultaDocumentosComponent;
  let fixture: ComponentFixture<DialogConsultaDocumentosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogConsultaDocumentosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogConsultaDocumentosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
