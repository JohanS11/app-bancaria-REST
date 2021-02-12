package edu.eci.mcsw.services;

import edu.eci.mcsw.model.Transaccion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransaccionServices {

    public static void registrarTransaccion(Connection con, Transaccion transaccion) throws SQLException {

        PreparedStatement insertTransaccion = null;
        PreparedStatement updateTransaccion = null;
        //Toca generalizar la sentencia con ?

        String insertStatment = "INSERT INTO TRANSACCION VALUES (?,?,?,?,?,?)";
        String updateStatement = "UPDATE CUENTA SET saldo=saldo+? where id=?";

        System.out.println("Gonorrreeeweaaa");
        System.out.println(transaccion.getNumerocuenta());

        System.out.println("joder");
        System.out.println(transaccion.getSaldoatransferir());
        updateTransaccion = con.prepareStatement(updateStatement);

        updateTransaccion.setFloat(1,transaccion.getSaldoatransferir());
        updateTransaccion.setString(2,transaccion.getNumerocuenta());

        insertTransaccion = con.prepareStatement(insertStatment);

        insertTransaccion.setString(1, transaccion.getIdentificador());
        insertTransaccion.setString(2, transaccion.getNumerocuenta());
        insertTransaccion.setFloat(3, transaccion.getSaldoatransferir());
        insertTransaccion.setBoolean(4, transaccion.isAprobacion());
        insertTransaccion.setDate(5, transaccion.getFecha());
        insertTransaccion.setString(6,  transaccion.getDetalle());

        insertTransaccion.execute();

        updateTransaccion.execute();

        con.commit();
    }


}
