package br.com.casadocodigo.loja.service;

import br.com.casadocodigo.loja.models.Pagamento;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

public class PagamentoGateway implements Serializable {

    public static final long serialVersionUID = 1L;

    public String pagar(BigDecimal total) {
        Pagamento pagamento = new Pagamento(total);
        String target = "http://book-payment.herokuapp.com/payment";
        Client client = ClientBuilder.newClient();
        Entity<Pagamento> json = Entity.json(pagamento);
        return client.target(target).request()
                .post(json, String.class);
    }
}
