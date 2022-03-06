package com.techelevator.store.controller;

import com.techelevator.store.dao.JdbcInventoryDao;
import com.techelevator.store.model.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.junit.*;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.util.List;

public class InventoryControllerTest {

    private JdbcTemplate jdbcTemplate;
    private JdbcInventoryDao dao;

    @Before
    public void setup() {
        SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/JavaBlueMart");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        jdbcTemplate = new JdbcTemplate(dataSource);

        dao = new JdbcInventoryDao(jdbcTemplate);
    }

    @Test
    public void get_all_items() {
        List<Item> items = dao.getAllItems();
        Assert.assertNotNull(items);
        Assert.assertTrue(items.size() > 0);
    }


}
