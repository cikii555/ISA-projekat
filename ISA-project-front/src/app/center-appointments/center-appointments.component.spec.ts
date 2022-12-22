import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CenterAppointmentsComponent } from './center-appointments.component';

describe('CenterAppointmentsComponent', () => {
  let component: CenterAppointmentsComponent;
  let fixture: ComponentFixture<CenterAppointmentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CenterAppointmentsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CenterAppointmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
