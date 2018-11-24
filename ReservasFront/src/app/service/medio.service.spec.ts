import { TestBed } from '@angular/core/testing';

import { MedioService } from './medio.service';

describe('MedioService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MedioService = TestBed.get(MedioService);
    expect(service).toBeTruthy();
  });
});
