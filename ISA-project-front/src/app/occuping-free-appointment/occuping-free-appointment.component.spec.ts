import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OccupingFreeAppointmentComponent } from './occuping-free-appointment.component';

describe('OccupingFreeAppointmentComponent', () => {
  let component: OccupingFreeAppointmentComponent;
  let fixture: ComponentFixture<OccupingFreeAppointmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OccupingFreeAppointmentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OccupingFreeAppointmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
