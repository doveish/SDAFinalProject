import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewTradesComponent } from './view-trades.component';

describe('ViewTradesComponent', () => {
  let component: ViewTradesComponent;
  let fixture: ComponentFixture<ViewTradesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewTradesComponent]
    });
    fixture = TestBed.createComponent(ViewTradesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
