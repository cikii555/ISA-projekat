import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BloodDonationAppointmentComponent } from './blood-donation-appointment.component';

describe('BloodDonationAppointmentComponent', () => {
  let component: BloodDonationAppointmentComponent;
  let fixture: ComponentFixture<BloodDonationAppointmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BloodDonationAppointmentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BloodDonationAppointmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
