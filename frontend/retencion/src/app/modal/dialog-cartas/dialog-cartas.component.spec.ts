import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogCartasComponent } from './dialog-cartas.component';

describe('DialogCartasComponent', () => {
  let component: DialogCartasComponent;
  let fixture: ComponentFixture<DialogCartasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DialogCartasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DialogCartasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
