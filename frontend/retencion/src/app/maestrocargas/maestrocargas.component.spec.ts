import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MaestrocargasComponent } from './maestrocargas.component';

describe('MaestrocargasComponent', () => {
  let component: MaestrocargasComponent;
  let fixture: ComponentFixture<MaestrocargasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MaestrocargasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MaestrocargasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
