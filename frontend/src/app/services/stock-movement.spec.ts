import { TestBed } from '@angular/core/testing';

import { StockMovement } from './stock-movement';

describe('StockMovement', () => {
  let service: StockMovement;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StockMovement);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
