import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BloodDonationReportComponent } from './blood-donation-report.component';

describe('BloodDonationReportComponent', () => {
  let component: BloodDonationReportComponent;
  let fixture: ComponentFixture<BloodDonationReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BloodDonationReportComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BloodDonationReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
