import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ICliente} from "./cliente.model";

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(protected http: HttpClient) { }

  buscarTodos(): Observable<ICliente[]> {
    return this.http.get<ICliente[]>(`http://localhost:8080/api/cliente`);
  }
}
