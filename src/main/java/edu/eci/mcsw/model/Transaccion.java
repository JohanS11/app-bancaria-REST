package edu.eci.mcsw.model;

public class Transaccion {

    private String identificador;
    private String numerocuenta;
    private String tipodecuenta;
    private float saldoatransferir;
    private boolean aprobacion;

    public Transaccion() {

    }

    public Transaccion(String identificador, String numeroprimeracuenta, String numerosegundacuenta, String tipodecuenta, float saldoatransferir, boolean aprobacion) {
        this.identificador = identificador;
        this.numerocuenta = numeroprimeracuenta;
        this.tipodecuenta = tipodecuenta;
        this.saldoatransferir = saldoatransferir;
        this.aprobacion = aprobacion;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getIdprimeracuenta() {
        return numerocuenta;
    }

    public void setIdprimeracuenta(String idprimeracuenta) {
        this.numerocuenta = idprimeracuenta;
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
                ", idprimeracuenta='" + numerocuenta + '\'' +
                ", saldoatransferir=" + saldoatransferir +
                ", aprobacion=" + aprobacion +
                '}';
    }
}
