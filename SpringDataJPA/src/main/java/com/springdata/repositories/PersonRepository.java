package com.springdata.repositories;

import com.springdata.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Question 2: Implement CrudRepository for it.

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    //Question 4: For class Person find person declare methods in repository to find person by firstname, lastname and Id.
    List<Person> findByFirstName(String firstName);

    List<Person> findByLastName(String lastName);

    Person findById(Integer id);

    //Question 6: Use @Query to fetch firstname of the Person whose age is 25.
    @Query("select firstName from Person where age=25")
    List<Person> findByAgeViaQuery();

    //Question 7: Use @Query to fetch firstname and lastname of the Person whose age is 25.
    @Query("select CONCAT(p.firstName, ' ', p.lastName) as fullname from Person p where age=25")
    List<String> findFullNameWithAge25ViaQuery();

    //Question 8: Get complete information of the Employee whose age is 25 using @Query.
    @Query("from Person where age=25")
    List<Person> findPersonWithAgeViaQuery();

    //Question 9: Count Person where name is "Peter" using @Query.
    @Query("select count(p) from Person p where firstName='Peter'")
    Integer findPersonWithNamePeterViaQuery();

    // Question 10: mplement following methods for Person repository:
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
    Integer countAllByAge(Integer age);

    List<Person> getDistinctByFirstNameOrAge(String fName, Integer age);

    List<Person> getAllByFirstNameAndAge(String fName, Integer age);

    List<Person> getByAgeBetween(Integer after, Integer before);

    List<Person> getBySalaryLessThan(Integer salary);

    List<Person> getBySalaryGreaterThan(Integer salary);

    List<Person> getByFirstNameLike(String firstName);

    List<Person> getByFirstNameNot(String firstName);

    List<Person> getByFirstNameIn(List<String> firstNames);

    List<Person> getByFirstNameIgnoreCase(String firstName);

    //Question 11: Get the persons greater than age 25 and sort them in descending order according to id by method query.
    List<Person> findByAgeGreaterThanOrderByIdDesc(Integer age);

    //Question 12: Do the question above using the Sort class.
    List<Person> findByAgeGreaterThan(Integer age, Sort sort);

    //Question 13: Apply Pagination on Person entities.
    Page<Person> findAll(Pageable pageable);
}
