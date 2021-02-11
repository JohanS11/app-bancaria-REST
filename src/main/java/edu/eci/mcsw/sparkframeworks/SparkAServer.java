package edu.eci.mcsw.sparkframeworks;

import com.google.gson.Gson;
import edu.eci.mcsw.model.Usuario;
import edu.eci.mcsw.persistence.JDBC;
import edu.eci.mcsw.servers.HTTPServer;
import edu.eci.mcsw.services.UserServices;


import java.nio.charset.Charset;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.Random;


/**
 * The type Spark a server.
 */
public class SparkAServer {

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        HTTPServer server =  new HTTPServer();
        server.setPort(getPort());
        server.start();
        JDBC cliente = new JDBC();
        Random rand = new Random();
        int upperbound = 1000;
        int int_random = rand.nextInt(upperbound);

        byte[] array = new byte[8]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        //Usuario usuario = new Usuario("ABC123" + int_random,"pepito"+generatedString,"perez"+generatedString,"test"+int_random+"@gmail.com",generatedString,"1010"+int_random,"3227897777");
        Connection dbcon = cliente.con;
        SparkA.post("/register",(request, response) -> {

            System.out.println(request.getBody());

            try {
                Usuario newuser = new Gson().fromJson(request.getBody(),Usuario.class);
                UserServices.registrarusuario(dbcon,newuser);
            } catch (Exception e) {
                response.setStatus("400");
                return "Registro fallido";
            }
            response.setStatus("200");
            return "Usuario registrado exitosamente";

        });

        SparkA.get("/lol",(request, response) -> "Hola");

    }

    /**
     * Gets port.
     *
     * @return the port
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 36000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

}
