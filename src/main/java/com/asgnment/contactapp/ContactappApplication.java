package com.asgnment.contactapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.asgnment.contactapp.model.Contact;
import com.asgnment.contactapp.repository.ContactRepository;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContactappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactappApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ContactRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11)
					.mapToObj(i -> new Contact(i, "firstName" + i,"lastName" + i ,"email" + i+ "@email.com", "(111) 111-111"+i,"Active"))
					.map(v -> repository.save(v))
					.forEach(System.out::println);
			
		};
	
	}
}
