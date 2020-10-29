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
export class TecnologiaService {

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

  
  listar(){
    return this._http.get(`${this.url}tecnologia/`, httpOptions);
  }
}
