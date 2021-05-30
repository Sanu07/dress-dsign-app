import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddOrderModalComponent } from './add-order-modal.component';

describe('AddOrderModalComponent', () => {
  let component: AddOrderModalComponent;
  let fixture: ComponentFixture<AddOrderModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddOrderModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddOrderModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
