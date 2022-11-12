import { TestBed } from '@angular/core/testing';

import { TransfusionCenterServiceService } from './transfusion-center-service.service';

describe('TransfusionCenterServiceService', () => {
  let service: TransfusionCenterServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TransfusionCenterServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
