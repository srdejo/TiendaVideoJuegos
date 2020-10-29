import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ClienteService } from 'src/app/cliente.service';


@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.page.html',
  styleUrls: ['./cliente.page.scss'],
})
export class ClientePage implements OnInit {

  registroForm = this._fb.group({
    documento: ["", Validators.required],
    nombre: ["", Validators.required],
    telefono: ["", [Validators.required, Validators.pattern("[0-9]{10}")]],
    fechaNacimiento: ["", Validators.required]
  });

  isCargando: boolean;

  clientes: {};

  constructor(
    private _fb: FormBuilder,
    private _clienteService: ClienteService) {

    this.isCargando = false;
  }  

  ngOnInit() {
    this.todos();
  }

  onSubmit() {
    this.isCargando = true;
    this._clienteService.crearCliente(this.registroForm.value)
      .subscribe(
        response => {
          this.isCargando = false;
          this._clienteService.presentToast('Cliente creado exitosamente');
          this.registroForm.reset();
          this.todos();
        },
        error => {
          console.log(<any>error)
          this.isCargando = false;
          this._clienteService.presentToast('Error al crear el cliente')
        }
      );
  }

  eliminar(id){
    this._clienteService.eliminarCliente(id)
    .subscribe(
      response => {
        this._clienteService.presentToast('Cliente eliminado exitosamente');
        this.todos();
      },
      error => {
        console.log(<any>error)
        this.isCargando = false;
        this._clienteService.presentToast('Error al eliminar el cliente')
      }
    );
  }

  todos(){
    this._clienteService.listarClientes().subscribe(
      response => {
        this.clientes = response;
      },
      error => {
        console.log(<any>error);
      }
    )
  }
}
