import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminProgrammazioneComponent } from './admin-programmazione.component';

describe('AdminProgrammazioneComponent', () => {
  let component: AdminProgrammazioneComponent;
  let fixture: ComponentFixture<AdminProgrammazioneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdminProgrammazioneComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminProgrammazioneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
