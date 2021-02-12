package edu.eci.mcsw.model;

import javax.persistence.*;

public class Cuenta {


    private String id;

    private String numerodecuenta;
    private String tipodecuenta;
    private float saldo;
    private String usuario;

    public Cuenta() {

    }

    public Cuenta(String id, String numerodecuenta, String tipodecuenta, float saldo, String usuario) {
        this.id = id;
        this.numerodecuenta = numerodecuenta;
        this.tipodecuenta = tipodecuenta;
        this.saldo = saldo;
        this.usuario = usuario;
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

    public String getTipodecuenta() {
        return tipodecuenta;
    }

    public void setTipodecuenta(String tipodecuenta) {
        this.tipodecuenta = tipodecuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
