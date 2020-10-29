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
export class ClienteService {

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

  crearCliente(data: any): Observable<any>{
    let json = JSON.stringify(data);
    return this._http.post(this.url+"/cliente", json, httpOptions);
  }

  actualizarCliente(id: number , data: any): Observable<any>{
    let json = JSON.stringify(data);
    console.log(json)
    return this._http.put(`${this.url}cliente/${id}`, json, httpOptions);
  }

  listarClientes(){
    return this._http.get(`${this.url}/cliente/`, httpOptions);
  }

  eliminarCliente(id: number): Observable<any>{
    return this._http.delete(`${this.url}/cliente/${id}`, httpOptions);
  }

  listarCliente(id: number): Observable<any>{
    return this._http.get(`${this.url}/cliente/${id}`, httpOptions);
  }
}
