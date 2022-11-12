import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCenterDashboardComponent } from './admin-center-dashboard.component';

describe('AdminCenterDashboardComponent', () => {
  let component: AdminCenterDashboardComponent;
  let fixture: ComponentFixture<AdminCenterDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminCenterDashboardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminCenterDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
