package edu.eci.mcsw.model;

public class Transferencia {

    private String identificador;
    private String tipodecuenta;
    private float saldoatransferir;
    private boolean aprobacion;
    private Transaccion retiro;
    private Transaccion deposito;

    public Transferencia() {

    }

    public Transferencia(String identificador, String tipodecuenta, float saldoatransferir, boolean aprobacion, Transaccion retiro, Transaccion deposito) {
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

    public Transaccion getRetiro() {
        return retiro;
    }

    public void setRetiro(Transaccion retiro) {
        this.retiro = retiro;
    }

    public Transaccion getDeposito() {
        return deposito;
    }

    public void setDeposito(Transaccion deposito) {
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
