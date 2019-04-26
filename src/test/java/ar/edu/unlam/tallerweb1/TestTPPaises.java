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

public class TestTPPaises extends SpringTest{
	
	@Test
	@Transactional @Rollback(true)
	public void testQueBuscaTodosLosPaisesDeHablaInglesa() {
		
		Pais inglaterra = new Pais();
		inglaterra.setIdioma("ingles");
		
		Pais usa = new Pais();
		usa.setIdioma("ingles");
		
		Pais argentina = new Pais();
		argentina.setIdioma("espa�ol");
		
		Session session = getSession();
		session.save(inglaterra);
		session.save(usa);
		session.save(argentina);
		
		List paisesDeHablaInglesa = session.createCriteria(Pais.class)
				.add(Restrictions.eq("idioma", "ingles"))
				.list();
		
		assertThat(paisesDeHablaInglesa).containsExactly(usa, inglaterra);
	}
	
	@Test
	@Transactional @Rollback(true)
	public void testQueBuscaTodosLosPaisesDelContinenteEuropeo() {
		
		Continente europa = new Continente();
		europa.setNombre("Europa");
	
		Continente oceania = new Continente();
		oceania.setNombre("Oceania");
		
		Pais inglaterra = new Pais();
		inglaterra.setContinente(europa);
		
		Pais italia= new Pais();
		italia.setContinente(europa);
		
		Pais australia = new Pais();
		australia.setContinente(oceania);

		Session session = getSession();
		session.save(inglaterra);
		session.save(australia);
		session.save(italia);
		
		List paisesEuropeos = session.createCriteria(Pais.class)
				.add(Restrictions.eq("continente", "Europa"))
				.list();
		
		assertThat(paisesEuropeos).containsExactly(inglaterra, italia);
	}
	
}
