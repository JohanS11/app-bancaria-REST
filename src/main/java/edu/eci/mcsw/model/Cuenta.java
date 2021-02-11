package edu.eci.mcsw.model;

import javax.persistence.*;

public class Cuenta {


    private String id;

    private String numerodecuenta;
    private String tipodecuenta;
    private float saldo;
    private Usuario usuario;

    public Cuenta() {

    }

    public Cuenta(String id, String numerodecuenta, String tipodecuenta, float saldo) {
        this.id = id;
        this.numerodecuenta = numerodecuenta;
        this.tipodecuenta = tipodecuenta;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
