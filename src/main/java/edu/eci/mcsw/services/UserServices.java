package edu.eci.mcsw.services;

import edu.eci.mcsw.model.Credentials;
import edu.eci.mcsw.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserServices {


    public static void registrarUsuarioSistema(Connection con , Usuario usuario) throws SQLException {

        con.setAutoCommit(true);
        PreparedStatement insertUsuario = null;

        //Toca generalizar la sentencia con ?


        String insertStatment = "INSERT INTO USUARIO_SISTEMA VALUES (?,?,?,?,?,?,?,?)";

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
        con.setAutoCommit(false);

        con.commit();

    }

    public static boolean dologin(Connection con, Credentials credentials) throws SQLException {

        List<String> np=new LinkedList<>();

        PreparedStatement getuser = null;
        String consultaUsuarios = "SELECT correo FROM USUARIO where correo="+"'"+credentials.getEmail()+"'"+"and pwd="+"'"+credentials.getPassword()+"'";
        getuser = con.prepareStatement(consultaUsuarios);
        ResultSet resultado = getuser.executeQuery();
        while(resultado.next()) {
            np.add(resultado.getString("correo"));
        }
        System.out.println(np);

        return np.size()==0?false:true;

    }

    public static boolean dologincritico(Connection con, Credentials credentials) throws SQLException {

        List<String> np=new LinkedList<>();

        PreparedStatement getuser = null;
        String consultaUsuarios = "SELECT correo FROM USUARIO_ADMIN where correo="+"'"+credentials.getEmail()+"'"+"and pwd="+"'"+credentials.getPassword()+"'";
        getuser = con.prepareStatement(consultaUsuarios);
        ResultSet resultado = getuser.executeQuery();
        while(resultado.next()) {
            np.add(resultado.getString("correo"));
        }
        System.out.println(np);

        return np.size()==0?false:true;

    }

    public static void registrarUsuarioApp(Connection con , Usuario usuario) throws SQLException, ServicesException {

        con.setAutoCommit(true);

        PreparedStatement insertUsuario = null;

        PreparedStatement selectUsuario = null;

        String selectStatment = "SELECT cedula FROM USUARIO_SISTEMA WHERE cedula=?";

        selectUsuario = con.prepareStatement(selectStatment);
        selectUsuario.setString(1,usuario.getCedula());
        ResultSet resultado = selectUsuario.executeQuery();
        con.setAutoCommit(false);

        if (resultado.next()){
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
        } else{
            throw new ServicesException(ServicesException.USUARIO_NO_REGISTRADO_EN_SISTEMA);
        }



        con.commit();

    }




}

