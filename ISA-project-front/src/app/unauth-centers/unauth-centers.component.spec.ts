import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnauthCentersComponent } from './unauth-centers.component';

describe('UnauthCentersComponent', () => {
  let component: UnauthCentersComponent;
  let fixture: ComponentFixture<UnauthCentersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UnauthCentersComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UnauthCentersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
