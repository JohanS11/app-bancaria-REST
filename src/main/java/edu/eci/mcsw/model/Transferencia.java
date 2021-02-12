package edu.eci.mcsw.model;

public class Transferencia {

    private String identificador;
    private String tipodecuenta;
    private float saldoatransferir;
    private boolean aprobacion;
    private String retiro;
    private String deposito;

    public Transferencia() {

    }

    public Transferencia(String identificador, String tipodecuenta, float saldoatransferir, boolean aprobacion, String retiro, String deposito) {
        this.identificador = identificador;
        this.tipodecuenta = tipodecuenta;
        this.saldoatransferir = saldoatransferir;
        this.aprobacion = aprobacion;
        this.retiro = retiro;
        this.deposito = deposito;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTipodecuenta() {
        return tipodecuenta;
    }

    public void setTipodecuenta(String tipodecuenta) {
        this.tipodecuenta = tipodecuenta;
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

    public String getRetiro() {
        return retiro;
    }

    public void setRetiro(String retiro) {
        this.retiro = retiro;
    }

    public String getDeposito() {
        return deposito;
    }

    public void setDeposito(String deposito) {
        this.deposito = deposito;
    }

    @Override
    public String toString() {
        return "Transferencia{" +
                "identificador='" + identificador + '\'' +
                ", tipodecuenta='" + tipodecuenta + '\'' +
                ", saldoatransferir=" + saldoatransferir +
                ", aprobacion=" + aprobacion +
                ", retiro=" + retiro +
                ", deposito=" + deposito +
                '}';
    }
}
