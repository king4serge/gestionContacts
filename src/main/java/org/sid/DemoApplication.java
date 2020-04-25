package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	@Autowired
	ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contactRepository.save(new Contact("AGBO", "Tinin", df.parse("20/11/1989"), "king4serge@gmail.com", 91179773, "tinin.png"));
		contactRepository.save(new Contact("AGBO", "Abiola", df.parse("02/05/2017"), "king4serge@gmail.com", 91179773, "abiola.png"));
		contactRepository.save(new Contact("SOUROU-SABI", "Tinola", df.parse("07/02/1991"), "pelagie.tinola@gmail.com", 92109946, "tinola.png"));
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});
	}

}
