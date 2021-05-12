package br.com.casadocodigo.loja.websockets;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UsuariosSession {

    private List<Session> sessions = new ArrayList<>();

    public void add(Session session) {
        sessions.add(session);
    }

    public List<Session> getUsuarios() {
        return sessions;
    }

    public void remove(Session session) {
        sessions.remove(session);
    }
}
