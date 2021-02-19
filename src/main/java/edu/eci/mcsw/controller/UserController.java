package edu.eci.mcsw.controller;

import edu.eci.mcsw.model.Credentials;
import edu.eci.mcsw.model.Usuario;
import edu.eci.mcsw.persistence.JDBC;
import edu.eci.mcsw.services.ServicesException;
import edu.eci.mcsw.services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UserController {

    JDBC cliente = new JDBC();
    Connection dbcon = cliente.con;

    @PostMapping("ingreso")
    public ResponseEntity<?> login(@RequestBody Credentials credentials){

        try {
            boolean login = UserServices.dologin(dbcon,credentials);
            if (login) {
                return new ResponseEntity<>("login success", HttpStatus.ACCEPTED);
            }
            throw new ServicesException(ServicesException.USUARIO_NO_REGISTRADO_EN_SISTEMA);

        } catch (SQLException | ServicesException e) {
            return new ResponseEntity<>("login failed", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("registro-sistema")
    public ResponseEntity<?> registrarUsuarioEnSistema(@RequestBody Usuario usuario){

        try {
            UserServices.registrarUsuarioSistema(dbcon,usuario);
            return new ResponseEntity<>("registro success", HttpStatus.ACCEPTED);
        } catch (SQLException e) {
            return new ResponseEntity<>("registro failed", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("registro-app")
    public ResponseEntity<?> registrarUsuarioApp(@RequestBody Usuario usuario){

        System.out.println(usuario);
        try {
            UserServices.registrarUsuarioApp(dbcon,usuario);
            return new ResponseEntity<>("Registro exitoso", HttpStatus.ACCEPTED);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Este usuario ya se ha registrado o ha ocurrido un error", HttpStatus.BAD_REQUEST);
        } catch (ServicesException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("Y3Jpc3RpYW4gZXMgZ2F5")
    public ResponseEntity<?> ingresocritico(@RequestBody Credentials usuario){

        try {
            UserServices.dologincritico(dbcon,usuario);
            return new ResponseEntity<>("login success", HttpStatus.ACCEPTED);
        } catch (SQLException e) {
            return new ResponseEntity<>("login failed", HttpStatus.BAD_REQUEST);
        }
    }

}
