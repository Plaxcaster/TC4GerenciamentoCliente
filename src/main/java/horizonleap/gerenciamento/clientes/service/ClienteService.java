package horizonleap.gerenciamento.clientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import horizonleap.gerenciamento.clientes.model.ClienteModel;
import horizonleap.gerenciamento.clientes.repository.ClienteRepository;
import horizonleap.gerenciamento.clientes.repository.DadosClienteDTO;


@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteModel save(String nome, String endereco, String infoContato) {
        var cliente = new ClienteModel(nome, endereco, infoContato);

        return clienteRepository.save(cliente);
    }

    public ClienteModel busca(int id_cliente) {
        return clienteRepository.findById(id_cliente).get();
    }

    public DadosClienteDTO consultarDadosCliente(Integer id_cliente) {
        ClienteModel cliente = clienteRepository.findById(id_cliente).get();

        return new DadosClienteDTO(cliente.getId(), cliente.getNome(), cliente.getEndereco(),
                cliente.getInfoContato());

    }

    public ClienteModel updateEndereco(Integer idCliente) {
        var cliente = clienteRepository.findById(idCliente).get();
        return clienteRepository.save(cliente);
    }

}
