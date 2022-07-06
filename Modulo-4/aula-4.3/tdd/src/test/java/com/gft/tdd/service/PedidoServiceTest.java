package com.gft.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.gft.tdd.email.NotificadorEmail;
import com.gft.tdd.model.Pedido;
import com.gft.tdd.model.builder.PedidoBuilder;
import com.gft.tdd.repository.Pedidos;
import com.gft.tdd.sms.NotificadorSms;

public class PedidoServiceTest {
    
    private PedidoService pedidoService;
    private Pedido pedido;
    
    @Mock
    private Pedidos pedidos;

    @Mock
    private NotificadorEmail email;

    @Mock
    private NotificadorSms sms;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        pedidoService = new PedidoService(pedidos, email, sms);
        pedido = new PedidoBuilder()
                        .comValor(100.0)
                        .para("Josao", "josao@email.com", "9494-0303")
                        .construir();
    }

    @Test
    public void deveCalcularOImposto() throws Exception {
        
        double imposto = pedidoService.lancar(pedido);
        assertEquals(10.0, imposto, 0.0001);
    }
    
    @Test
    public void deveSalvarPedidoNoBancoDeDados() throws Exception{
        
        pedidoService.lancar(pedido);
        Mockito.verify(pedidos).guardar(pedido);
    }

    @Test
    public void deveNotificarPorEmail() throws Exception {

        pedidoService.lancar(pedido);
        Mockito.verify(email).enviar(pedido);
    }
    
    @Test
    public void deveNotificarPorSms() throws Exception {

        pedidoService.lancar(pedido);
        Mockito.verify(sms).notificar(pedido);
    }


}
