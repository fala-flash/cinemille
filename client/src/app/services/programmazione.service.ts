import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Film {
  id: number;
  titolo: string;
  dataUscita: string;
  durata: number;
}

export interface Sala {
  id: number;
  numero: number;
  capienza: number;
  tecnologia: string;
}

export interface Programmazione {
  id: number;
  dataInizio: string;
  dataFine: string;
  film: Film;
  sala: Sala;
}

@Injectable({
  providedIn: 'root'
})
export class ProgrammazioneService {
  private baseUrl = 'http://localhost:8080/api/programmazioni';

  constructor(private http: HttpClient) { }

  /**
   * Recupera le programmazioni.
   * Se vengono passati username e password, l’API restituisce tutta la programmazione per admin.
   * altrimenti verranno applicati i filtri per la vista pubblica.
   */
  getProgrammazioni(dataInizio?: string, dataFine?: string, username?: string, password?: string): Observable<Programmazione[]> {
    let params = new HttpParams();
    if (dataInizio) {
      params = params.set('dataInizio', dataInizio);
    }
    if (dataFine) {
      params = params.set('dataFine', dataFine);
    }
    if (username) {
      params = params.set('username', username);
    }
    if (password) {
      params = params.set('password', password);
    }
    return this.http.get<Programmazione[]>(this.baseUrl, { params });
  }
}
