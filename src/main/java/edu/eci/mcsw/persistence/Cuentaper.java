package edu.eci.mcsw.persistence;

import edu.eci.mcsw.model.Cuenta;
import edu.eci.mcsw.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cuentaper {

    public static void registrarusuario(Connection con , Cuenta cuenta) throws SQLException {

        PreparedStatement insertCuenta = null;
        //Toca generalizar la sentencia con ?

        String insertStatment = "INSERT INTO USUARIO VALUES (?,?,?,?,?,?,?)";

        insertCuenta = con.prepareStatement(insertStatment);

        insertCuenta.setString(1, cuenta.getId());
        insertCuenta.setString(2, cuenta.getNumerodecuenta());
        insertCuenta.setFloat(3, cuenta.getSaldo());
        insertCuenta.setString(4, cuenta.getTipodecuenta());
        insertCuenta.setObject(5,cuenta.getUsuario());


        insertCuenta.execute();

        con.commit();
    }
}
