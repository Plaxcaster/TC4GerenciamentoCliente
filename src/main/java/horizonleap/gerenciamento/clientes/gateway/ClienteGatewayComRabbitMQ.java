package horizonleap.gerenciamento.clientes.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import horizonleap.gerenciamento.clientes.config.StreamProperties;
import horizonleap.gerenciamento.clientes.model.ClienteModel;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClienteGatewayComRabbitMQ implements ClienteEventGateway{

    @Autowired
    private final StreamBridge bridge;
    @Autowired
    private final StreamProperties properties;

    @Override
    public void clienteCriado(ClienteModel cliente) {
        bridge.send(properties.getClienteCriadoChanel(), cliente);
    }
    @Override
    public void clienteAlterado(ClienteModel cliente) {
        bridge.send(properties.getClienteAlteradoChanel(), cliente);
    }
}
