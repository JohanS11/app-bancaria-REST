package edu.eci.mcsw.model;

import java.util.ArrayList;
import java.util.Collection;


public class Usuario {

    private String nombre;
    private String apellido;
    private String correo;
    private String celular;

    private Collection<Cuenta> cuentas = new ArrayList<Cuenta>();

    private String cedula;

    private String usuarioid;

    private String pwd;

    public Usuario() {
    }

    public Usuario(String usuarioid, String nombre, String apellido, String correo, String pwd, String cedula, String celular) {
        this.usuarioid = usuarioid;
        this.nombre = nombre;
        this.celular = celular;
        this.apellido = apellido;
        this.correo = correo;
        this.pwd = pwd;
        this.cedula = cedula;
    }

    public String getCelular() {
        return celular;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(String usuarioid) {
        this.usuarioid = usuarioid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", cuentas=" + cuentas +
                ", cedula='" + cedula + '\'' +
                ", usuarioid='" + usuarioid + '\'' +
                '}';
    }

}
