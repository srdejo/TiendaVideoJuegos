import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { environment } from './../environments/environment';
import { ToastController } from '@ionic/angular';

const httpOptions = {
  headers: new HttpHeaders({
    "Content-Type": "application/json"
  })
};

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  url: string;

  constructor(private _http: HttpClient, public toastController: ToastController) { 
    this.url = environment.apiUrl+"/cliente";
  }
  
  async presentToast(mensaje) {
    const toast = await this.toastController.create({
      message: mensaje,
      duration: 2000
    });
    toast.present();
  }

  crearCliente(data: any): Observable<any>{
    let json = JSON.stringify(data);
    return this._http.post(this.url, json, httpOptions);
  }

  listarClientes(){
    return this._http.get(this.url, httpOptions);
  }

  eliminarCliente(id: any): Observable<any>{
    return this._http.delete(this.url+"/"+id, httpOptions);
  }
}
