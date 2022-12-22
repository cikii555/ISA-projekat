import { TestBed } from '@angular/core/testing';

import { BloodDonationAppointmentService } from './blood-donation-appointment.service';

describe('BloodDonationAppointmentService', () => {
  let service: BloodDonationAppointmentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BloodDonationAppointmentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
