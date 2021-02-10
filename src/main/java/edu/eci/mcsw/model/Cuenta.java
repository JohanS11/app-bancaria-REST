package edu.eci.mcsw.model;

import javax.persistence.*;

public class Cuenta {


    private String id;

    private String numerodecuenta;
    private float saldo;

    public Cuenta() {
    }

    public Cuenta(String numerodecuenta, float saldo) {
        this.numerodecuenta = numerodecuenta;
        this.saldo = saldo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getNumerodecuenta() {
        return numerodecuenta;
    }

    public void setNumerodecuenta(String numerodecuenta) {
        this.numerodecuenta = numerodecuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
