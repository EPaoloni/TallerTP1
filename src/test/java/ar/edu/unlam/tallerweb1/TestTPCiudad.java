package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*; 

import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;

public class TestTPCiudad extends SpringTest{
	
	@Test
	@Transactional @Rollback(true)
	public void testQueBuscaLasCiudadesDelHemisferioSur(){
		
		Ubicacion ubicacionBuenosAires = new Ubicacion();
		ubicacionBuenosAires.setLatitud( -34.61315 );
		Ciudad buenosAires = new Ciudad();
		buenosAires.setUbicacionGeografica(ubicacionBuenosAires);

		Ubicacion ubicacionStockholm = new Ubicacion();
		ubicacionStockholm.setLatitud( 59.33258 );
		Ciudad stockholm = new Ciudad();
		stockholm.setUbicacionGeografica( ubicacionStockholm );
		
		getSession().save(buenosAires);
		getSession().save(stockholm);
		

		List cuidadesDelHemisferioSur = getSession().createCriteria(Ciudad.class)
										.createAlias( "ubicacionGeografica", "ubic" )
										.add(Restrictions.lt("ubic.latitud", 0.00))
										.list();

		assertThat(cuidadesDelHemisferioSur).containsExactly( buenosAires );
	}
}
