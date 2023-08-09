import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDividendComponent } from './add-dividend.component';

describe('AddDividendComponent', () => {
  let component: AddDividendComponent;
  let fixture: ComponentFixture<AddDividendComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddDividendComponent]
    });
    fixture = TestBed.createComponent(AddDividendComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
