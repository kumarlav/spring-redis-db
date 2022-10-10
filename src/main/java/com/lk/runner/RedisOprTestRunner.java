package com.lk.runner;

import com.lk.model.Person;
import com.lk.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * The type Redis opr test runner.
 *
 * @author LavKumar
 */
@Component
public class RedisOprTestRunner implements CommandLineRunner {

	private final PersonService personService;

	/**
	 * Instantiates a new Redis opr test runner.
	 *
	 * @param personService the person service
	 */
	public RedisOprTestRunner(PersonService personService) {
		this.personService = personService;
	}

	@Override
	public void run(String... args) throws Exception {
		personService.addPerson(new Person(10,"A",52));
		personService.addPerson(new Person(11,"B",48));
		personService.modifyPerson(new Person(12,"C",91));

		personService.removePerson(11);
		personService.getAllPersons().forEach((k,v)->System.out.println(k+"-"+v));
		System.out.println(personService.getPerson(10));
	}
}