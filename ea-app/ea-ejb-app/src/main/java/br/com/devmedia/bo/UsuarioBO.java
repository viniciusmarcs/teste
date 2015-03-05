package br.com.devmedia.bo;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.devmedia.dao.UsuarioDAO;
import br.com.devmedia.entity.Usuario;

/**
 * @author codigosfontes.com.br
 */
@Stateless
public class UsuarioBO extends GenericBO<Usuario>{

    @Inject
    private UsuarioDAO usuarioDAO;
    
    @Override
    @PostConstruct
    protected void inicializar() {
        this.genericDAO = usuarioDAO;
    }
}