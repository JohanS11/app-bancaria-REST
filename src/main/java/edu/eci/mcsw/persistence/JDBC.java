package edu.eci.mcsw.persistence;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import edu.eci.mcsw.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBC {

    private String url;
    private String driver;
    private String user;
    private String pwd;
    public static Connection con;

    public JDBC() {
        this.url = "jdbc:postgresql://ec2-34-230-167-186.compute-1.amazonaws.com:5432/dthu6mr9vmpe3";
        this.driver = "org.postgresql.Driver";
        this.user = "gzprgpblrcqtow";
        this.pwd = "0bb8adf0ea3958d13c74315589052c907a23e45a5efe605f14beb9dfc52e9e8b";

        try {
            Class.forName(driver);
            this.con= DriverManager.getConnection(url,user,pwd);
            con.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void registrarusuario(Connection con , Usuario usuario) throws SQLException {

        PreparedStatement insertUsuario = null;
        //Toca generalizar la sentencia con ?

        String insertStatment = "INSERT INTO USUARIO VALUES (?,?,?,?,?,?,?)";

        insertUsuario = con.prepareStatement(insertStatment);

        insertUsuario.setString(1, usuario.getApellido());
        insertUsuario.setString(2, usuario.getNombre());
        insertUsuario.setString(3, usuario.getCelular());
        insertUsuario.setString(4, usuario.getCorreo());
        insertUsuario.setString(5, usuario.getCedula());
        insertUsuario.setString(6, usuario.getUsuarioid());
        insertUsuario.setString(7,usuario.getPwd());

        insertUsuario.execute();

        con.commit();
    }


    public static List<String> seleccionarUsuarios(Connection con) throws SQLException{

        List<String> np=new LinkedList<>();

        //Crear prepared statement
        //asignar parámetros
        //usar executeQuery
        //Sacar resultados del ResultSet
        //Llenar la lista y retornarla
        PreparedStatement listarUsuarios = null;
        String consultaUsuarios = "SELECT * FROM USUARIO";
        listarUsuarios = con.prepareStatement(consultaUsuarios);
        ResultSet resultado = listarUsuarios.executeQuery();
        while(resultado.next()) {
            np.add(resultado.getString("nombre"));
            np.add(resultado.getString("apellido"));
        }
        con.commit();

        return np;
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
