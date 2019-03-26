package com.springdata;

import com.springdata.entity.Person;
import com.springdata.repositories.PersonRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceContext.class);
        PersonRepository personRepository = (PersonRepository) applicationContext.getBean("personRepository");

        //Question 3: Perform all the methods inside CrudRepository for Person Class.
//      Using save(S entity)
        System.out.println("=====================Single Record Added=====================");
        System.out.println(personRepository
                .save(new Person("Mehak", "Adlakha", 21, 450000)));

//      Using save(Iterable<S> entities)
        List<Person> people = Arrays.asList(
                new Person("Mehak", "Adlakha", 26, 450000),
                new Person("yatin", "ajmani", 25, 430000),
                new Person("Sagar", "Malhotra", 25, 420000),
                new Person("Peter", "Bhatia", 24, 420000),
                new Person("Harshit", "Raheja", 26, 410000));
        System.out.println("=====================Multiple Records Added=====================");
        personRepository.save(people).forEach(System.out::println);

//      Using findOne(ID id)
        System.out.println("=====================Find one with id 1=====================");
        System.out.println(personRepository.findOne(1));

//      Using exists(ID id)
        System.out.println("=====================Exists with id 1=====================");
        System.out.println(personRepository.exists(1));

//      Using findAll()
        System.out.println("=====================Find All Records=====================");
        personRepository.findAll().forEach(System.out::println);

//      Using findAll(Iterable<ID> ids)
        System.out.println("=====================Find All Records having ids 2,3,4=====================");
        personRepository.findAll(people.stream().map(Person::getId).collect(Collectors.toList()))
                .forEach(System.out::println);

//      Using count()
        System.out.println("No. of Persons : " + personRepository.count());

//      Using delete(ID id)
        System.out.println("=====================Delete with id 4=====================");
        personRepository.delete(4);
        personRepository.findAll().forEach(System.out::println);

//      Using delete(T entity)
        System.out.println("=====================Delete with id 1=====================");
        personRepository.delete(personRepository.findById(1));
        personRepository.findAll().forEach(System.out::println);

//      Using delete(Iterable<? extends T> entities)
        System.out.println("=====================Delete using iterable with id 2,3=====================");
        personRepository.delete(Arrays.asList(people.get(0), people.get(1)));
        personRepository.findAll().forEach(System.out::println);

//      Using deleteAll()
        System.out.println("=====================Delete All=====================");
        personRepository.deleteAll();
        personRepository.findAll().forEach(System.out::println);
        System.out.println();

        personRepository.save(people);

        //Question 5: Use the methods declared above to fetch the person.
        System.out.println("Person with Id 6 : " + personRepository.findById(6));
        System.out.println("Persons with FirstName Harshit : " + personRepository.findByFirstName("Harshit"));
        System.out.println("Persons with lastName Raheja : " + personRepository.findByLastName("Raheja"));
        System.out.println();

        //Question 6: Use @Query to fetch firstname of the Person whose age is 25.
        System.out.println("Persons with age = 25 : " + personRepository.findByAgeViaQuery());
        System.out.println();

        //Question 7: Use @Query to fetch firstname and lastname of the Person whose age is 25.
        System.out.println("Persons full Name with age = 25 : ");
        personRepository.findFullNameWithAge25ViaQuery().forEach(System.out::println);

        //Question 8: Get complete information of the Employee whose age is 25 using @Query.
        System.out.println("Persons with age = 25 : ");
        personRepository.findPersonWithAgeViaQuery().forEach(System.out::println);
        System.out.println();

        //Question 9: Count Person where name is "Peter" using @Query.
        System.out.println("Persons with first Name = Peter : " + personRepository.findPersonWithNamePeterViaQuery());
        System.out.println();

        //Question 10: Implement following methods for Person repository:
        //count
        //distinct
        //or
        //and
        //between
        //LessThan
        //GreaterThan
        //Like
        //Not
        //In
        //IgnoreCase
        System.out.println("Persons with age = 25, Using count : " + personRepository.countAllByAge(25));

        System.out.println("Persons with age = 26 or firstName = yatin, Using distinct : " + personRepository
                .getDistinctByFirstNameOrAge("Mehak", 26));

        System.out.println("Persons with age = 25 and firstName = yatin, Using distinct : " + personRepository
                .getAllByFirstNameAndAge("yatin", 25));

        System.out.println("Persons age between 25 and 28= yatin, Using distinct : " + personRepository
                .getByAgeBetween(25, 28));

        System.out.println("Persons salary less than 420000 : " + personRepository
                .getBySalaryLessThan(420000));

        System.out.println("Persons salary greater than 420000 : " + personRepository
                .getBySalaryGreaterThan(420000));

        System.out.println("Persons with name like mehak : " + personRepository
                .getByFirstNameLike("Mehak"));

        System.out.println("Persons with name not like mehak : " + personRepository
                .getByFirstNameNot("Mehak"));

        System.out.println("Persons with name not like mehak : " + personRepository
                .getByFirstNameIn(Arrays.asList("Mehak", "Harshit")));

        System.out.println("Persons with name MEHAK ignoring case : " + personRepository
                .getByFirstNameIgnoreCase("MEHAK"));
        System.out.println();

        //Question 11: Get the persons greater than age 25 and sort them in descending order according to id by method query.
        System.out.println("Persons with age greater than 25 sorted by descending order by id : " + personRepository
                .findByAgeGreaterThanOrderByIdDesc(25));
        System.out.println();

        //Question 12: Do the question above using the Sort class.
        System.out.println("Persons with age greater than 25 sorted by descending order by id using sort class : "
                + personRepository.findByAgeGreaterThan(25, new Sort(Sort.Direction.DESC, "id")));
        System.out.println();

        //Question 13: Apply Pagination on Person entities.
        Page<Person> personPage = personRepository.findAll((new PageRequest(0, 2)));
        System.out.println("Paginated Persons : " + personPage);
        System.out.println(personPage.getContent());
    }
}
