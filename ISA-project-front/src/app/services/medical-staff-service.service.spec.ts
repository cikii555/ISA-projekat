import { TestBed } from '@angular/core/testing';

import { MedicalStaffServiceService } from './medical-staff-service.service';

describe('MedicalStaffServiceService', () => {
  let service: MedicalStaffServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MedicalStaffServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
