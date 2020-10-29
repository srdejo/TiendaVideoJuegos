import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { JuegoService } from 'src/app/service/juego.service';
import { TecnologiaService } from 'src/app/service/tecnologia.service';

@Component({
  selector: 'app-juego',
  templateUrl: './juego.page.html',
  styleUrls: ['./juego.page.scss'],
})
export class JuegoPage implements OnInit {

  registroForm = this._fb.group({
    nombreJue: ["", Validators.required],
    directorJue: ["", Validators.required],
    protagonistaJue: ["", [Validators.required]],
    productorJue: ["", Validators.required],
    marcaJue: ["", Validators.required],
    precioJue: ["", [Validators.required]],
    idTecnologia: ["", [Validators.required]],
  });

  isCargando: boolean;
  
  isEdit: boolean;
  idJuego: number;
  titulo: string;

  juegos: {};
  tecnologias: {};

  constructor(
    private _fb: FormBuilder,
    private _juegoService: JuegoService,
    private _tecnologiaService: TecnologiaService) {
      this.isCargando = false;
      this.isEdit = false;
      this.titulo = "Agregar" }

  ngOnInit() {
    this.todos();
    this.listarTecnologias();
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
    this._juegoService.eliminarJuego(id)
    .subscribe(
      response => {
        this._juegoService.presentToast('juego eliminado exitosamente');
        this.todos();
      },
      error => {
        console.log(<any>error)
        this.isCargando = false;
        this._juegoService.presentToast('Error al eliminar el juego')
      }
    );
  }

  todos(){
    this._juegoService.listarJuegos().subscribe(
      response => {
        this.juegos = response;
      },
      error => {
        console.log(<any>error);
      }
    )
  }

  listarTecnologias(){
    this._tecnologiaService.listar().subscribe(
      response => {
        this.tecnologias = response;
      },
      error => {
        console.log(<any>error);
        this._tecnologiaService.presentToast('Error al cargar tecnologias')
      }
    )
  }

  guardar(){    
    this._juegoService.crearJuego(this.registroForm.value)
      .subscribe(
        response => {
          this.isCargando = false;
          this._juegoService.presentToast('juego creado exitosamente');
          this.registroForm.reset();
          this.todos();
        },
        error => {
          console.log(<any>error)
          this.isCargando = false;
          this._juegoService.presentToast('Error al crear el juego')
        }
      );
  }

  editar(id){
    this.isEdit = true
    this.idJuego = id;
    this.titulo = "Editar"
    this._juegoService.listarJuego(this.idJuego)
    .subscribe(
      response => {
        console.log(response.documentoCli)
        this.registroForm.patchValue({
          documento: response.documentoCli,
          nombre: response.nombreCli,
          telefono: response.telefonoCli,
          fechaNacimiento: response.fechaNacimientoCli
        });
      },
      error => {
        console.log(<any>error)
        this._juegoService.presentToast('Error al cargar el juego')
      }
    )
  }

  actualizar(){    
    console.log(this.idJuego)
    this._juegoService.actualizarJuego(this.idJuego, this.registroForm.value)
      .subscribe(
        response => {
          this.isCargando = false;
          this._juegoService.presentToast('juego actualizado exitosamente');
          this.registroForm.reset();
          this.todos();
          this.isEdit = false;
        },
        error => {
          console.log(<any>error)
          this.isCargando = false;
          this._juegoService.presentToast('Error al actualizar el juego')
        }
      );
  }
}
