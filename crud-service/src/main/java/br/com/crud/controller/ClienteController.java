package br.com.crud.controller;

import br.com.crud.domain.Cliente;
import br.com.crud.event.RecursoCriadoEvent;
import br.com.crud.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Api(value = "API REST - Entidade Pessoa")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	private final ClienteService pessoaService;
	private final ApplicationEventPublisher publish;

	@ApiOperation(value = "Listagem de clientes.")
	@GetMapping
	public ResponseEntity<List<Cliente>> pesquisar() {
		List<Cliente> clientes = pessoaService.pesquisar();
		return ResponseEntity.ok(clientes);
	}

	@ApiOperation(value = "Informações sobre um cliente específico.")
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Cliente> buscaoPorId(@PathVariable Long id) {
		Cliente cliente = pessoaService.buscarPorId(id);
		return ResponseEntity.ok(cliente);
	}

	@ApiOperation(value = "Cadastro de cliente.")
	@PostMapping(produces = "application/json")
	public ResponseEntity<Cliente> salvar(@Valid @RequestBody Cliente cliente, HttpServletResponse response) {
		Cliente clienteSalva = this.pessoaService.salvar(cliente);
		publish.publishEvent(new RecursoCriadoEvent(this, response, cliente.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalva);
	}

	@ApiOperation(value = "Atualização de pessoa.")
	@PutMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
		Cliente clienteSalva = this.pessoaService.atualizar(id, cliente);
		return ResponseEntity.ok(clienteSalva);
	}

	@ApiOperation(value = "Remoção de pessoa e seus endereços.")
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		this.pessoaService.remover(id);
	}

}
