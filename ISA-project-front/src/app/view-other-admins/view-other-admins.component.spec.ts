import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewOtherAdminsComponent } from './view-other-admins.component';

describe('ViewOtherAdminsComponent', () => {
  let component: ViewOtherAdminsComponent;
  let fixture: ComponentFixture<ViewOtherAdminsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewOtherAdminsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewOtherAdminsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
