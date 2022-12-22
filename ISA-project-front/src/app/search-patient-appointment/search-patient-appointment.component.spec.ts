import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchPatientAppointmentComponent } from './search-patient-appointment.component';

describe('SearchPatientAppointmentComponent', () => {
  let component: SearchPatientAppointmentComponent;
  let fixture: ComponentFixture<SearchPatientAppointmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchPatientAppointmentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchPatientAppointmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
