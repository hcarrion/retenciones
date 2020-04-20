import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogListaImplicadosComponent } from './dialog-lista-implicados.component';

describe('DialogListaImplicadosComponent', () => {
  let component: DialogListaImplicadosComponent;
  let fixture: ComponentFixture<DialogListaImplicadosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogListaImplicadosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogListaImplicadosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
