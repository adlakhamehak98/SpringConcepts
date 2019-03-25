package com.ttn;

import com.ttn.entity.User;
import com.ttn.repository.UserRepo;
import com.ttn.service.UserDAO;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        UserDAO userDAO = applicationContext.getBean(UserDAO.class);

        // Use datasource with DriverManagerDataSource, dbcp2.BasicDataSource and
        //SingleConnectionDataSource to print the records of user tables
        System.out.println("By DriverManagerDataSource:");
        userDAO.printUserNames();
        System.out.println();

        System.out.println("By SingleConnectionDataSource:");
        userDAO.printUserNamesBySingleDatasource();
        System.out.println();

        System.out.println("By dbcp2.BasicDataSource:");
        userDAO.printUserNamesBydbcp2();
        System.out.println();

        //Use JdbcTemplate to get the count of users
        System.out.println("Count by jdbcTemplate:");
        userDAO.userCount();
        System.out.println();

        // Get name of the user by providing username to the parametrized query
        System.out.println("Username query with parameter:");
        System.out.println(userDAO.getUserName());
        System.out.println();

        //Insert one record using JdbcTemplate
        System.out.println("Insertion using jdbcTemplate:");
        userDAO.insertUser(new User("spring4", "spring4", "Sidharth", 22, "1990-01-16"));
        userDAO.printUserNamesBydbcp2();
        System.out.println();

        // Use QueryForMap to fetch the user details of the  user
        System.out.println("Query for map:");
        userDAO.queryForMapDemo();
        System.out.println();

        //Use QueryForList to fetch records of all users
        System.out.println("Query for list:");
        userDAO.queryForListDemo();
        System.out.println();

        //Use a rowmapper to get the User object when you query for a user
        System.out.println("Row Mapper:");
        System.out.println(userDAO.getUser());
        System.out.println();

        //Integrate Hibernate with Spring and use hql query to count the number of records in user table.
        System.out.println("Spring ORM:");
        userDAO.sessionFactoryDemo();
        System.out.println();

        //Use @Transactional to save to save 2 records using jdbc template with the following prapogation options
        //REQUIRED
        //REQUIRES_NEW
        //NESTED
        //MANDATORY
        //NEVER
        //NOT_SUPPORTED
        //SUPPORTS
        UserRepo userRepo = applicationContext.getBean(UserRepo.class);
        System.out.print("Adding 2 user : ");
        userRepo.insert();
        System.out.println();

        //Demonstrate the use of following options of @Transactional annotation
        //read-only
        //timeout
        //rollback-for
        //no-rollback-for
        System.out.print("Demonstrating read-only," +
                "timeout," +
                "rollback-for," +
                "no-rollback-for.");
        //ReadOnly
        userRepo.insert2();
        //Timeout
        userRepo.insert3();
        //RollbackFor
        userRepo.insert4();
        //NoRollbackFor
        userRepo.insert5();
    }
}
