import { Component, OnInit } from '@angular/core';
import { Programmazione, ProgrammazioneService } from '../../services/programmazione.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-public-programmazione',
  imports: [CommonModule, FormsModule],
  templateUrl: './public-programmazione.component.html',
  styleUrl: './public-programmazione.component.css'
})

export class PublicProgrammazioneComponent implements OnInit {
  programmazioni: Programmazione[] = [];
  dataInizio: string = '';
  dataFine: string = '';

  constructor(private programmazioneService: ProgrammazioneService) { }

  ngOnInit(): void {
    const today = new Date();
    this.dataInizio = this.formatDate(today);
    const threeWeeksLater = new Date();
    threeWeeksLater.setDate(today.getDate() + 21);
    this.dataFine = this.formatDate(threeWeeksLater);
    this.getProgrammazioni();
  }

  getProgrammazioni(): void {
    // Vista pubblica: chiamata senza credenziali
    this.programmazioneService.getProgrammazioni(this.dataInizio, this.dataFine).subscribe(
      data => this.programmazioni = data,
      error => console.error(error)
    );
  }

  private formatDate(date: Date): string {
    const year = date.getFullYear();
    let month: string | number = date.getMonth() + 1;
    let day: string | number = date.getDate();
    if (month < 10) {
      month = '0' + month;
    }
    if (day < 10) {
      day = '0' + day;
    }
    return `${year}-${month}-${day}`;
  }
}
