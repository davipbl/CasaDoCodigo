package br.com.casadocodigo.loja.security;

import br.com.casadocodigo.loja.daos.SecurityDao;
import br.com.casadocodigo.loja.models.SystemUser;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Model
public class CurrentUser {

    @Inject
    private HttpServletRequest request;

    @Inject
    private SecurityDao securityDao;

    private SystemUser systemUser;

    public SystemUser get() {
        return systemUser;
    }

    public boolean hasRole(String role) {
        return request.isUserInRole(role);
    }

    public String logout() {
        request.getSession().invalidate();
        return "/admin/livros/lista.xhtml?faces-redirect=true";
    }

    @PostConstruct
    public void loadSystemUser() {
        Principal principal = request.getUserPrincipal();
        if (principal != null) {
            String login = request.getUserPrincipal().getName();
            systemUser = securityDao.findByEmail(login);
        }
    }

}
