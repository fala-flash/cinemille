import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicProgrammazioneComponent } from './public-programmazione.component';

describe('PublicProgrammazioneComponent', () => {
  let component: PublicProgrammazioneComponent;
  let fixture: ComponentFixture<PublicProgrammazioneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PublicProgrammazioneComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PublicProgrammazioneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
