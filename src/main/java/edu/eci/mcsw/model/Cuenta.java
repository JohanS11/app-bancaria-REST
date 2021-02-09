package edu.eci.mcsw.model;

import javax.persistence.*;

@Entity
@Table( name = "CUENTA")
public class Cuenta {

    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "cuentaid" )
    private String id;

    private String numerodecuenta;
    private float saldo;

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }
}
