import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewDividendsComponent } from './view-dividends.component';

describe('ViewDividendsComponent', () => {
  let component: ViewDividendsComponent;
  let fixture: ComponentFixture<ViewDividendsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewDividendsComponent]
    });
    fixture = TestBed.createComponent(ViewDividendsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
