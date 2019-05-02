package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;

public class TestTPPaises extends SpringTest{
	
	@Test
	@Transactional @Rollback(true)
	public void testQueBuscaTodosLosPaisesDeHablaInglesa() {
		Continente europa = new Continente();
		europa.setNombre("Europa");
		
		Continente america = new Continente();
		america.setNombre("America");
		
		Ciudad londres = new Ciudad();
		londres.setUbicacionGeografica(new Ubicacion());
		
		Ciudad washington = new Ciudad();
		washington.setUbicacionGeografica(new Ubicacion());
		
		Ciudad buenosAires = new Ciudad();
		buenosAires.setUbicacionGeografica(new Ubicacion());
		
		Pais inglaterra = new Pais();
		inglaterra.setIdioma("ingles");
		inglaterra.setContinente(europa);
		inglaterra.setCapital(londres);
		
		Pais usa = new Pais();
		usa.setIdioma("ingles");
		usa.setContinente(america);
		usa.setCapital(washington);
		
		Pais argentina = new Pais();
		argentina.setIdioma("español");
		argentina.setContinente(america);
		argentina.setCapital(buenosAires);
		
		Session session = getSession();
		session.save(inglaterra);
		session.save(usa);
		session.save(argentina);
		
		List paisesDeHablaInglesa = session.createCriteria(Pais.class)
									.add(Restrictions.eq("idioma", "ingles"))
									.list();
		
		assertThat(paisesDeHablaInglesa).containsExactly(inglaterra, usa);
	}
	
	@Test
	@Transactional @Rollback(true)
	public void testQueBuscaTodosLosPaisesDelContinenteEuropeo() {
		Continente europa = new Continente();
		europa.setNombre("Europa");
		
		Continente america = new Continente();
		america.setNombre("America");
		
		Ciudad londres = new Ciudad();
		londres.setUbicacionGeografica(new Ubicacion());
		
		Ciudad washington = new Ciudad();
		washington.setUbicacionGeografica(new Ubicacion());
		
		Ciudad buenosAires = new Ciudad();
		buenosAires.setUbicacionGeografica(new Ubicacion());
		
		Pais inglaterra = new Pais();
		inglaterra.setIdioma("ingles");
		inglaterra.setContinente(europa);
		inglaterra.setCapital(londres);
		
		Pais usa = new Pais();
		usa.setIdioma("ingles");
		usa.setContinente(america);
		usa.setCapital(washington);
		
		Pais argentina = new Pais();
		argentina.setIdioma("español");
		argentina.setContinente(america);
		argentina.setCapital(buenosAires);
		
		Session session = getSession();
		session.save(inglaterra);
		session.save(usa);
		session.save(argentina);
		
		List paisesEuropeos = session.createCriteria(Pais.class)
									.createAlias("continente","c")
									.add(Restrictions.eq("c.nombre", "Europa"))
									.list();
		
		assertThat(paisesEuropeos).containsExactly(inglaterra);
	}
	
	@Test
	@Transactional @Rollback(true)
	public void testQueBuscaTodosLosPaisesCuyaCapitalEstanAlNorteDelTropicoDeCancer(){
		Double latitudTropicoDeCancer = 23.2614;
		
		// Pais: Argentina.
		// Cuidad: Buenos Aires.
		Ubicacion ubicacionBuenosAires = new Ubicacion();
		ubicacionBuenosAires.setLatitud(-34.61315);		
		Ciudad buenosAires = new Ciudad();
		buenosAires.setUbicacionGeografica( ubicacionBuenosAires );
		Pais argentina = new Pais();
		argentina.setCapital( buenosAires );

		// Pais: Suecia.
		// Cuidad: Stockholm.
		Ubicacion ubicacionStockholm = new Ubicacion();
		ubicacionStockholm.setLatitud(59.3325);
		Ciudad stockholm = new Ciudad();
		stockholm.setUbicacionGeografica( ubicacionStockholm );
		Pais suecia = new Pais();
		suecia.setCapital( stockholm );

		List paisesConCapitalAlNorteDelTropicoDeCancer = getSession().createCriteria(Pais.class)
														 .createAlias("capital","cap")
														 .createAlias("cap.ubicacionGeografica", "ubic")
														 .add(Restrictions.gt("ubic.latitud",latitudTropicoDeCancer))
														 .list();

		assertThat(paisesConCapitalAlNorteDelTropicoDeCancer).containsExactly(suecia);
	} 
	
}
