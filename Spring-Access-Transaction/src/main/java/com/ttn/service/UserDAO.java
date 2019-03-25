package com.ttn.service;

import com.ttn.UserMapper;
import com.ttn.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UserDAO {
    @Autowired
    @Qualifier("driverManagerDataSource")
    DataSource dataSource;

    @Autowired
    @Qualifier("singleConnectionDataSource")
    DataSource dataSource1;

    @Autowired
    @Qualifier("dbcp2.BasicDataSource")
    DataSource dataSource2;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    SessionFactory sessionFactoryBean;

    public void printUserNames() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
    }

    public void printUserNamesBySingleDatasource() throws SQLException {
        Connection connection = dataSource1.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
    }

    public void printUserNamesBydbcp2() throws SQLException {
        Connection connection = dataSource2.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
    }

    public void userCount() {
        String sql = "SELECT COUNT(*) FROM user";
        System.out.println(jdbcTemplate.queryForObject(sql, Integer.class));
    }

    public String getUserName() {
        String sql = "SELECT name FROM user WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{"spring1"}, String.class);
    }

    public void insertUser(User user) {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{
                user.getUsername(), user.getPassword(), user.getName(), user.getAge(), user.getDob()
        });
    }

    public void queryForMapDemo() {
        String sql = "SELECT * FROM user WHERE username = ?";
        System.out.println(jdbcTemplate.queryForMap(sql, new Object[]{"spring2"}));
    }

    public void queryForListDemo() {
        String sql = "SELECT * FROM user";
        System.out.println(jdbcTemplate.queryForList(sql));
    }

    public User getUser() {
        String sql = "SELECT * FROM user WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{"spring1"}, new UserMapper());
    }

    public void sessionFactoryDemo() {
        String sql = "SELECT COUNT(*) FROM com.ttn.entity.User";
        Query query = sessionFactoryBean.openSession().createQuery(sql);
        System.out.println(query.uniqueResult());
    }
}





