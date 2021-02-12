package edu.eci.mcsw.services;

import edu.eci.mcsw.model.Cuenta;
import edu.eci.mcsw.model.Transaccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CuentaServices {

    public static List<String> verCuenta(Connection con , edu.eci.mcsw.model.Cuenta cuenta, String cedula) throws SQLException {

        List<String> np=new LinkedList<>();

        PreparedStatement getcuenta = null;
        String consultarcuenta = "SELECT * FROM cuenta where usuario="+cedula;
        getcuenta = con.prepareStatement(consultarcuenta);
        ResultSet resultado = getcuenta.executeQuery();
        while(resultado.next()) {
            np.add(resultado.getString("numerodecuenta"));
            np.add(resultado.getString("saldo"));
            np.add(resultado.getString("tipodecuenta"));
        }

        return np;
    }

    public static void registrarCuenta(Connection con , Cuenta cuenta) throws SQLException {

        PreparedStatement insertCuenta = null;
        //Toca generalizar la sentencia con ?

        String insertStatment = "INSERT INTO CUENTA VALUES (?,?,?,?,?)";

        insertCuenta = con.prepareStatement(insertStatment);

        System.out.println(cuenta.getUsuario());

        insertCuenta.setString(1, cuenta.getId());
        insertCuenta.setString(2, cuenta.getNumerodecuenta());
        insertCuenta.setFloat(3, cuenta.getSaldo());
        insertCuenta.setString(4, cuenta.getTipodecuenta());
        insertCuenta.setString(5,cuenta.getUsuario());

        insertCuenta.execute();
        con.commit();
    }

    public static List<String> verUltimosMov(Connection con, String cuenta) throws SQLException {

        List<String> np=new LinkedList<>();

        PreparedStatement getmovs = null;
        String consultarmov = "SELECT detalle,fecha,saldoatransferir,aprobado FROM TRANSACCION where numerocuenta="+cuenta+"order by fecha DESC";
        getmovs = con.prepareStatement(consultarmov);
        ResultSet resultado = getmovs.executeQuery();
        while(resultado.next()) {
            np.add(resultado.getString("detalle"));
            np.add(resultado.getString("fecha"));
            np.add(resultado.getString("saldoatransferir"));
            np.add(resultado.getString("aprobado"));

        }
        return np;
    }

}
