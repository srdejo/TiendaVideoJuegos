import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ClienteService } from 'src/app/service/cliente.service';


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
  
  isEdit: boolean;
  idCliente: number;
  titulo: string;

  clientes: {};

  constructor(
    private _fb: FormBuilder,
    private _clienteService: ClienteService) {

    this.isCargando = false;
    this.isEdit = false;
    this.titulo = "Agregar"
  }  

  ngOnInit() {
    this.todos();
  }

  onSubmit() {
    this.isCargando = true;
    if (this.isEdit){
      this.actualizar()
    }else{
      this.guardar();
    }
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

  guardar(){    
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

  editar(id){
    this.isEdit = true
    this.idCliente = id;
    this.titulo = "Editar"
    this._clienteService.listarCliente(this.idCliente)
    .subscribe(
      response => {
        console.log(response.documentoCli)
        this.registroForm.patchValue({
          documento: response.documentoCli,
          nombre: response.nombreCli,
          telefono: response.telefonoCli,
          fechaNacimiento: response.fechaNacimientoCli,
          idTecnologia: response.idTecnologia
        });
      },
      error => {
        console.log(<any>error)
        this._clienteService.presentToast('Error al cargar el cliente')
      }
    )
  }

  actualizar(){    
    console.log(this.idCliente)
    this._clienteService.actualizarCliente(this.idCliente, this.registroForm.value)
      .subscribe(
        response => {
          this.isCargando = false;
          this._clienteService.presentToast('Cliente actualizado exitosamente');
          this.registroForm.reset();
          this.todos();
          this.isEdit = false;
        },
        error => {
          console.log(<any>error)
          this.isCargando = false;
          this._clienteService.presentToast('Error al actualizar el cliente')
        }
      );
  }
}
