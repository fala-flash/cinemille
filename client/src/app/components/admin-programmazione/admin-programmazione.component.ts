import { Component, OnInit } from '@angular/core';
import { Programmazione, ProgrammazioneService } from '../../services/programmazione.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-admin-programmazione',
  imports: [FormsModule, CommonModule],
  templateUrl: './admin-programmazione.component.html',
  styleUrl: './admin-programmazione.component.css'
})
export class AdminProgrammazioneComponent implements OnInit {
  programmazioni: Programmazione[] = [];
  dataInizio: string = '';
  dataFine: string = '';
  username: string = '';
  password: string = '';
  message: string = '';

  constructor(private programmazioneService: ProgrammazioneService) { }

  ngOnInit(): void {
    const today = new Date();
    this.dataInizio = this.formatDate(today);
    const threeWeeksLater = new Date();
    threeWeeksLater.setDate(today.getDate() + 21);
    this.dataFine = this.formatDate(threeWeeksLater);
  }

  getProgrammazioni(): void {
    if (this.username && this.password) {
      this.programmazioneService.getProgrammazioni(this.dataInizio, this.dataFine, this.username, this.password).subscribe(
        data => {
          this.programmazioni = data;
          this.message = '';
        },
        error => {
          console.error(error);
          this.message = 'Errore: autenticazione fallita o problema nel recupero dei dati.';
          this.programmazioni = [];
        }
      );
    } else {
      this.message = 'Inserisci le credenziali admin per visualizzare i dati.';
      this.programmazioni = [];
    }
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
