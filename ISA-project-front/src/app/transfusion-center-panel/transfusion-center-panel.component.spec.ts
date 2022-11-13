import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransfusionCenterPanelComponent } from './transfusion-center-panel.component';

describe('TransfusionCenterPanelComponent', () => {
  let component: TransfusionCenterPanelComponent;
  let fixture: ComponentFixture<TransfusionCenterPanelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TransfusionCenterPanelComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransfusionCenterPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
