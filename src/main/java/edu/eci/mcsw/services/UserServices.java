package edu.eci.mcsw.services;

import edu.eci.mcsw.model.Cuenta;
import edu.eci.mcsw.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserServices {


    public static void registrarusuario(Connection con , Usuario usuario) throws SQLException {

        PreparedStatement insertUsuario = null;
        //Toca generalizar la sentencia con ?

        String selectcedula  = "SELECT * from cedulas where cedula="+usuario.getCedula();

        if (selectcedula != null) {

            String insertStatment = "INSERT INTO USUARIO VALUES (?,?,?,?,?,?,?,?)";

            insertUsuario = con.prepareStatement(insertStatment);

            insertUsuario.setString(1, usuario.getApellido());
            insertUsuario.setString(2, usuario.getNombre());
            insertUsuario.setString(3, usuario.getCelular());
            insertUsuario.setString(4, usuario.getCorreo());
            insertUsuario.setString(5, usuario.getCedula());
            insertUsuario.setString(6, usuario.getUsuarioid());
            insertUsuario.setString(7, usuario.getPwd());
            insertUsuario.setString(8, usuario.getRol().name());
            insertUsuario.execute();

            con.commit();
        } else { System.out.println("no se pudo registrar"); }

    }

    public static boolean dologin(Connection con, String correo, String pwd) throws SQLException {

        List<String> np=new LinkedList<>();

        PreparedStatement getuser = null;
        String consultaUsuarios = "SELECT correo FROM USUARIO where correo="+correo+"and pwd="+pwd;
        getuser = con.prepareStatement(consultaUsuarios);
        ResultSet resultado = getuser.executeQuery();
        while(resultado.next()) {
            np.add(resultado.getString("correo"));
        }

        return np.size()==0?false:true;

    }


}

