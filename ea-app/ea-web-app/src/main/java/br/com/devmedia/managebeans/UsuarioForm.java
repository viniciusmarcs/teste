package br.com.devmedia.managebeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.devmedia.bo.UsuarioBO;

/**
 * @author codigosfontes.com.br
 */
@ManagedBean
@ViewScoped
public class UsuarioForm implements Serializable{
    
    @EJB
    private UsuarioBO usuarioBO;
    
    private String teste;
    
    @PostConstruct
    public void inicializar () {
        usuarioBO.buscarTodos();
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }
}
