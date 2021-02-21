package edu.eci.mcsw.services;

import com.google.gson.Gson;
import edu.eci.mcsw.model.Cuenta;
import edu.eci.mcsw.model.Transaccion;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class TransaccionServices {

    public static void registrarTransaccion(Connection con, Transaccion transaccion) throws SQLException {

        con.setAutoCommit(true);
        PreparedStatement insertTransaccion = null;

        String insertStatment = "INSERT INTO TRANSACCION VALUES (?,?,?,?,?,?,?,?)";

        insertTransaccion = con.prepareStatement(insertStatment);
        insertTransaccion.setString(1, transaccion.getIdentificador());
        insertTransaccion.setString(2, transaccion.getOrigen());
        insertTransaccion.setString(3, transaccion.getDestinatario());
        insertTransaccion.setFloat(4, transaccion.getSaldoatransferir());
        insertTransaccion.setTimestamp(5, java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
        insertTransaccion.setString(6,  transaccion.getDetalle());
        insertTransaccion.setBoolean(7, transaccion.isAprobacion());
        insertTransaccion.setBoolean(8, transaccion.isIntrabancaria());

        insertTransaccion.execute();
        con.setAutoCommit(false);
        con.commit();

        if (transaccion.isIntrabancaria()){
            CuentaServices.actualizarSaldo(con,transaccion.getOrigen(),transaccion.getSaldoatransferir()*-1);
            CuentaServices.actualizarSaldo(con,transaccion.getDestinatario(),transaccion.getSaldoatransferir());
        }else{
            CuentaServices.actualizarSaldo(con,transaccion.getOrigen(),transaccion.getSaldoatransferir()*-1);
        }

    }

    public static Transaccion getTransaccionByid(Connection con , String id) throws SQLException {

        List<String> np=new LinkedList<>();

        PreparedStatement selectTransaccion = null;
        System.out.println("IDDD");
        System.out.println(id);

        String selectStatment = "SELECT * FROM TRANSACCION WHERE numerodecuenta='"+id+"'";
        selectTransaccion = con.prepareStatement(selectStatment);

        ResultSet resultado = selectTransaccion.executeQuery();

        while(resultado.next()){

            np.add(resultado.getString("identificador"));
            np.add(resultado.getString("numerodecuenta"));
            np.add(resultado.getString("saldoatransferir"));
            np.add(resultado.getString("aprobacion"));
            np.add(resultado.getString("fecha"));
            np.add(resultado.getString("detalle"));

        }
        System.out.println("NP");
        System.out.println(np);
        Gson gson = new Gson();
        String json = gson.toJson(np);

        Transaccion transaccion =  new Gson().fromJson(json, Transaccion.class);
        return transaccion;



    }


}
