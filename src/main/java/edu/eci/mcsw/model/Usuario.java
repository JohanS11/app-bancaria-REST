package edu.eci.mcsw.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table( name = "USUARIO")
public class Usuario {

    private String nombre;
    private String apellido;
    private String correo;

    @OneToMany
    @JoinTable( name = "USUARIO_CUENTA", joinColumns = @JoinColumn( name = "cuenta" ), inverseJoinColumns = @JoinColumn( name = "cuentaid" ))
    private Collection<Cuenta> cuentas = new ArrayList<Cuenta>();

    private String cedula;

    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "usuarioid" )
    private String usuarioid;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String correo, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.cedula = cedula;
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
                ", cedula='" + cedula + '\'' +
                '}';
    }

    public void setId(String id) {
        this.usuarioid = id;
    }

    @Id
    public String getId() {
        return usuarioid;
    }
}
