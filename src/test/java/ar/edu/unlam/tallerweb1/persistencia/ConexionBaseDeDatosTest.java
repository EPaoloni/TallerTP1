package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import static org.junit.Assert.assertTrue;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

// Clase que prueba la conexion a la base de datos. Hereda de SpringTest por lo que corre dentro del contexto
// de spring
public class ConexionBaseDeDatosTest extends SpringTest{

    @Test
    @Transactional @Rollback(true)
    public void pruebaConexion(){
        assertThat(getSession().isConnected()).isTrue();
    }
    
    @Test
    @Transactional @Rollback(true)
    public void creaUnUsuarioNuevo() {
    	Usuario nuevoUsuario = new Usuario();
    	nuevoUsuario.setEmail("pepe@hotmail.com");
    	nuevoUsuario.setPassword("1234");
    	nuevoUsuario.setRol("Warlock");;
    	
    	Session session = getSession();
    	
    	session.save(nuevoUsuario);
    	
    	Usuario usuarioGuardado = session.get(Usuario.class, nuevoUsuario.getId());
    	assertThat(usuarioGuardado).isNotNull();
    }
}
