package br.com.crud.service;

import br.com.crud.domain.Cliente;
import br.com.crud.exception.GenericNotFoundException;
import br.com.crud.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    public List<Cliente> pesquisar() {
        return this.clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return this.clienteRepository.findById(id).orElseThrow(GenericNotFoundException::new);
    }

    public Cliente atualizar(Long id, Cliente cliente) {

        Cliente clienteSalvo = this.buscarPorId(id);

        if (clienteSalvo == null) {
            throw new EmptyResultDataAccessException(1);
        }

        BeanUtils.copyProperties(cliente, clienteSalvo, "id");
        this.clienteRepository.save(cliente);

        return clienteSalvo;
    }

    public void remover(Long id) {
        this.clienteRepository.deleteById(id);
    }
}
