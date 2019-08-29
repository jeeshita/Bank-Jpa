package com.veri.security;

import com.veri.security.entity.User;
import com.veri.security.service.IUserDetailsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication(scanBasePackages = "com.veri")
@EnableTransactionManagement
public class MainApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MainApplication.class, args);
        IUserDetailsService userDetailsService=applicationContext.getBean(IUserDetailsService.class);
        User user=new User("scooby6367","1234");
        user=userDetailsService.createUser(user);

    }

    @Bean
    public ViewResolver getViewResolver() {
        System.out.println("inside view resolver");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate template=new JdbcTemplate();
        template.setDataSource(dataSource);
        return template;
    }

}


/*
        JdbcTemplate jdbcTemplate=applicationContext.getBean(JdbcTemplate.class);
       // jdbcTemplate.execute("insert into book(id,author,name,price)" +
        //        " values('b-99','bb','bb',789)");
       Book book= jdbcTemplate.queryForObject("select * from book where id='b1'", new RowMapper<Book>() {
           @Override
           public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
               Book create=new Book();
               String id=rs.getString("id");
               create.setId(id);
               String author=rs.getString("author");
               create.setAuthor(author);
               System.out.println("author="+author);
               return create;
           }
       });

       System.out.println("book details="+book.getAuthor()+" id="+book.getId());
       */