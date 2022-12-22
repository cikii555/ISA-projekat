import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchBloodCenterComponent } from './search-blood-center.component';

describe('SearchBloodCenterComponent', () => {
  let component: SearchBloodCenterComponent;
  let fixture: ComponentFixture<SearchBloodCenterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchBloodCenterComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchBloodCenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
