import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewStocksComponent } from './view-stocks.component';

describe('ViewStocksComponent', () => {
  let component: ViewStocksComponent;
  let fixture: ComponentFixture<ViewStocksComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewStocksComponent]
    });
    fixture = TestBed.createComponent(ViewStocksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
