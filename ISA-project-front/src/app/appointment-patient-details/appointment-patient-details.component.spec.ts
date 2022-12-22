import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppointmentPatientDetailsComponent } from './appointment-patient-details.component';

describe('AppointmentPatientDetailsComponent', () => {
  let component: AppointmentPatientDetailsComponent;
  let fixture: ComponentFixture<AppointmentPatientDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AppointmentPatientDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AppointmentPatientDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
