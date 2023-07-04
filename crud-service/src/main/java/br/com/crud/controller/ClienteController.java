package br.com.crud.controller;

import br.com.crud.event.RecursoCriadoEvent;
import br.com.crud.service.ClienteService;
import br.com.crud.service.dto.ClienteDTO;
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
	public ResponseEntity<List<ClienteDTO>> pesquisar() {
		List<ClienteDTO> response = pessoaService.pesquisar();
		return ResponseEntity.ok(response);
	}

	@ApiOperation(value = "Informações sobre um cliente específico.")
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<ClienteDTO> buscaoPorId(@PathVariable Long id) {
		ClienteDTO response = pessoaService.buscarPorId(id);
		return ResponseEntity.ok(response);
	}

	@ApiOperation(value = "Cadastro de cliente.")
	@PostMapping(produces = "application/json")
	public ResponseEntity<ClienteDTO> salvar(@Valid @RequestBody ClienteDTO clienteDTO, HttpServletResponse servletResponse) {
		ClienteDTO dtoResponse = this.pessoaService.salvar(clienteDTO);
		publish.publishEvent(new RecursoCriadoEvent(this, servletResponse, dtoResponse.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(dtoResponse);
	}

	@ApiOperation(value = "Atualização de cliente.")
	@PutMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<ClienteDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ClienteDTO clienteDTO) {
		ClienteDTO dtoResponse = this.pessoaService.atualizar(id, clienteDTO);
		return ResponseEntity.ok(dtoResponse);
	}

	@ApiOperation(value = "Remoção de cliente e seus endereços.")
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		this.pessoaService.remover(id);
	}

}
