import java.io.Serializable;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author oscar Anotaciones sirven para comunicar con el xhtml
 */
@ManagedBean(name = "login")
@RequestScoped// me sirve para comunicarme mientras el navegador esta abierto
public class login implements Serializable {

    private String usuario;
    private String contrasena;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void ingresar() {
        FacesContext context = FacesContext.getCurrentInstance();
        if ("admin".equals(usuario) && "1234".equals(contrasena)) {
            System.out.println("ingreso");
            
            context.addMessage(null, new FacesMessage("Successful", "Your message: " + "Datos Ingresados correctamente"));
        } else {
            System.out.println("no ingreso");
            context.addMessage(null, new FacesMessage("Invalid", "Your message: " + "Datos Ingresados erronesos"));
        }
    }

}