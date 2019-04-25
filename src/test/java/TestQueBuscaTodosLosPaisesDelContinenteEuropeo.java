import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Assert;
import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;

public class TestQueBuscaTodosLosPaisesDelContinenteEuropeo {

	public SessionFactory buildSessionFactory() {
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().
                configure("hibernateContext.xml").build();

        Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().
                build();

        SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder();

        SessionFactory sessionFactory = sessionFactoryBuilder.build();
		
        return sessionFactory;
	}
	
	@Test
	public void testQueBuscaTodosLosPaisesDelContinenteEuropeo() {
		
		Continente continente = new Continente();
		continente.setNombre("Europa");
		
		Pais pais = new Pais();
		pais.setContinente(continente);
		
		Session session = buildSessionFactory().getCurrentSession();
		session.save(pais);
		
		Query q = session.createSQLQuery("SELECT *"
										+ "FROM Pais"
										+ "WHERE Continente = 'Europa'");
		List<Pais> paisesEuropeos = (List<Pais>)q.list();
		for( Pais element : paisesEuropeos ) {
			Assert.assertEquals(element.getContinente().getNombre(), "Europa");
		}
	}

}
