package br.com.crud.service;

import br.com.crud.domain.Cliente;
import br.com.crud.exception.GenericBadRequestException;
import br.com.crud.exception.GenericNotFoundException;
import br.com.crud.mapper.ClienteMapper;
import br.com.crud.repository.ClienteRepository;
import br.com.crud.service.dto.ClienteDTO;
import br.com.crud.util.PropertyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Transactional
    public ClienteDTO salvar(ClienteDTO clienteDTO) {
        Cliente cliente = unirClienteEndereco(clienteDTO);
        Cliente clienteSalvo = this.clienteRepository.save(cliente);
        return this.clienteMapper.toDTO(clienteSalvo);
    }

    public List<ClienteDTO> pesquisar() {
        List<Cliente> clientes = this.clienteRepository.findAll();
        return clientes.stream().map(clienteMapper::toDTO).toList();
    }

    public ClienteDTO buscarPorId(Long id) {
        Cliente cliente = this.clienteRepository.findById(id).orElseThrow(GenericNotFoundException::new);
        return this.clienteMapper.toDTO(cliente);
    }

    public ClienteDTO atualizar(Long id, ClienteDTO clienteDTO) {
        verificarIdsIsNull(clienteDTO);
        return this.clienteRepository.findById(id)
                .map(clienteSalvo -> {
                    Cliente cliente = unirClienteEndereco(clienteDTO);
                    PropertyUtils.copyNonNullProperties(cliente, clienteSalvo);
                    this.clienteRepository.save(clienteSalvo);
                    return this.clienteMapper.toDTO(clienteSalvo);
                })
                .orElseGet(() -> {
                    Cliente cliente = unirClienteEndereco(clienteDTO);
                    Cliente clienteSalvo = this.clienteRepository.save(cliente);
                    return this.clienteMapper.toDTO(clienteSalvo);
                });
    }

    public void remover(Long id) {
        this.clienteRepository.deleteById(id);
    }

    private Cliente unirClienteEndereco(ClienteDTO clienteDTO) {
        Cliente cliente = this.clienteMapper.toCliente(clienteDTO);
        cliente.getEndereco().setCliente(cliente);
        return cliente;
    }

    private void verificarIdsIsNull(ClienteDTO clienteDTO) {
        if (isNull(clienteDTO.getEndereco().getId()))
            throw new GenericBadRequestException("endereco.id é obrigatório");

        boolean telefoneIdIsNull = clienteDTO.getTelefones().stream().anyMatch(telefone -> isNull(telefone.getId()));
        if (telefoneIdIsNull)
            throw new GenericBadRequestException("telefone.id é obrigatório");

        boolean emailIdIsNull = clienteDTO.getEmails().stream().anyMatch(email -> isNull(email.getId()));
        if (emailIdIsNull)
            throw new GenericBadRequestException("telefone.id é obrigatório");
    }
}
