import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { environment } from './../../environments/environment';
import { ToastController } from '@ionic/angular';

const httpOptions = {
  headers: new HttpHeaders({
    "Content-Type": "application/json"
  })
};

@Injectable({
  providedIn: 'root'
})
export class JuegoService {

  url: string;

  constructor(private _http: HttpClient, public toastController: ToastController) { 
    this.url = environment.apiUrl;
  }

  async presentToast(mensaje) {
    const toast = await this.toastController.create({
      message: mensaje,
      duration: 2000
    });
    toast.present();
  }

  crearJuego(data: any): Observable<any>{
    let json = JSON.stringify(data);
    return this._http.post(this.url+"juego", json, httpOptions);
  }

  actualizarJuego(id: number , data: any): Observable<any>{
    let json = JSON.stringify(data);
    console.log(json)
    return this._http.put(`${this.url}juego/${id}`, json, httpOptions);
  }

  listarJuegos(){
    return this._http.get(`${this.url}juego/`, httpOptions);
  }

  eliminarJuego(id: number): Observable<any>{
    return this._http.delete(`${this.url}/juego/${id}`, httpOptions);
  }

  listarJuego(id: number): Observable<any>{
    return this._http.get(`${this.url}/juego/${id}`, httpOptions);
  }


}
