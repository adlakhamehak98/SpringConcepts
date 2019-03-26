package entity;

import javax.persistence.*;
import java.util.*;

//Question 1:Create a class Author with instance variables firstName, lastName and age.

@Entity
public class Author {

    //  Question 9: Generate Id for Author Using IDENTITY and TABLE strategy.
    //  @GeneratedValue(strategy = GenerationType.TABLE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    //Question 6: Rename all the fields using column annotation.
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    //  Question 7: Mark lastName as @Transient.
    @Transient
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    //  Question 8: Use @Temporal for date of birth of Author.
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    //  Question 11: Create instance variable of Address class inside Author class and save it as embedded object.
    @Embedded
    private Address address;

    //   Question 12: Introduce a List of subjects for author.
    @ElementCollection
    private Set<String> subjects = new HashSet<>();

//    Question 14: Create an Entity book with an instance variable bookName.
//    public Author(String firstName, String lastName, int age, Date dateOfBirth, Book book) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
//        this.dateOfBirth = dateOfBirth;
//        this.book = book;
//    }
//
//    public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }

//    Question 15: Implement One to One mapping between Author and Book.
//    @OneToOne
//    @JoinColumn(name = "book_id")
//    private Book book;

//    //    Question 16: Implement One to Many Mapping between Author and Book(Unidirectional, BiDirectional and without additional table ) and implement cascade save.
//    @JoinTable
//    @OneToMany(cascade = CascadeType.PERSIST)

//    //  Question 16.3
//    @OneToMany(mappedBy = "authors")

    //    Question 17: Implement Many to Many Mapping between Author and Book.
    @ManyToMany
    private Collection<Book> books;

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    public Author(String firstName, String lastName, int age, Date dateOfBirth, Collection<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.books = (List<Book>) books;
    }


    public Set<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<String> subjects) {
        this.subjects = subjects;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", dateOfBirth=" + dateOfBirth +
                ", address=" + address +
                ", subjects=" + subjects +
                '}';
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Author(String firstName, String lastName, int age, Date dateOfBirth, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public Author(String firstName, String lastName, int age, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }

    public Author() {
    }
}
