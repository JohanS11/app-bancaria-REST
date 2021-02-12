package edu.eci.mcsw.model;

import java.sql.Date;

public class Transaccion {

    private String identificador;
    private String numerodecuenta;
    private float saldoatransferir;
    private boolean aprobacion;
    private Date fecha;
    private String detalle;

    public Transaccion() {

    }

    public Transaccion(String identificador, String numeroprimeracuenta, String numerosegundacuenta, float saldoatransferir, boolean aprobacion, Date fecha, String detalle) {
        this.identificador = identificador;
        this.numerodecuenta = numeroprimeracuenta;
        this.saldoatransferir = saldoatransferir;
        this.aprobacion = aprobacion;
        this.fecha = fecha;
        this.detalle = detalle;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNumerocuenta() {
        return numerodecuenta;
    }

    public void setNumerocuenta(String numerocuenta) {
        this.numerodecuenta = numerocuenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public float getSaldoatransferir() {
        return saldoatransferir;
    }

    public void setSaldoatransferir(float saldoatransferir) {
        this.saldoatransferir = saldoatransferir;
    }

    public boolean isAprobacion() {
        return aprobacion;
    }

    public void setAprobacion(boolean aprobacion) {
        this.aprobacion = aprobacion;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "identificador='" + identificador + '\'' +
                ", idprimeracuenta='" + numerodecuenta + '\'' +
                ", saldoatransferir=" + saldoatransferir +
                ", aprobacion=" + aprobacion +
                '}';
    }
}
