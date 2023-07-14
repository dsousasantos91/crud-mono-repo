import {Component, OnInit} from '@angular/core';
import {ICliente} from "../cliente.model";
import {ClienteService} from "../cliente.service";
import {map} from "rxjs";

@Component({
  selector: 'app-cliente-lista',
  templateUrl: './cliente-lista.component.html',
  styleUrls: ['./cliente-lista.component.css']
})
export class ClienteListaComponent implements OnInit {
  colunas: string[] = ['id', 'nome', 'cpf', 'telefones', 'emails', 'endereco', 'acoes'];
  clientes : ICliente[] = [];

  constructor(protected clienteService: ClienteService) {
  }

  ngOnInit(): void {
    this.clienteService.buscarTodos().subscribe(res => {
      this.clientes = res;
      console.log(res);
    })
  }
}
