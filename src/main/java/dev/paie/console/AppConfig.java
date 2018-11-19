package dev.paie.console;

import java.util.Scanner;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
// option => je définie exactement ce qu'il y aura dans la console
@ComponentScan({ "dev.paie.ihm", "dev.paie.service" })
//permet d'utiliser @Transactional
@EnableTransactionManagement
@EnableJpaRepositories("dev.paie.repository")
public class AppConfig {
	
	private Scanner scanner;
	
	@Bean
	public Scanner scanner() {
		Scanner scanner =  new Scanner(System.in);
		return scanner;
	}
	
	   @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("org.postgresql.Driver");
	        dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/sirh-paie");
	        dataSource.setUsername("postgres");
	        dataSource.setPassword("Caline32=!");
	        return dataSource;
	    }

	   @Bean
	      public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
	        JpaTransactionManager txManager = new JpaTransactionManager();
	        txManager.setEntityManagerFactory(emf);
	        return txManager;
	      }

	    @Bean
	    // Cette configuration nécessite une source de données configurée.
	    // Elle s'utilise donc en association avec un autre fichier de configuration définissant un bean DataSource.
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {

	        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        vendorAdapter.setGenerateDdl(true);
	        // activer les logs SQL
	        vendorAdapter.setShowSql(true);

	        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	        factory.setJpaVendorAdapter(vendorAdapter);
	        // alternative au persistence.xml
	        factory.setPackagesToScan("dev.paie.domain");
	        factory.setDataSource(dataSource);
	        factory.afterPropertiesSet();

	        return factory;
	    }
	@PreDestroy
	public void onDestroy() {
		System.out.println("On détruit");
		scanner.close();
		
	}
}
