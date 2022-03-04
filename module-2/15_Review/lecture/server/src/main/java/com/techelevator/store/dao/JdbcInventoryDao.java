package com.techelevator.store.dao;

import com.techelevator.store.model.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInventoryDao implements InventoryDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcInventoryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Item> getAllItems() {

        List<Item> items = new ArrayList<Item>();

        String sql = "SELECT item.item_id, item_types.code, item_types.name AS type_name, " +
                "item.sku, item.name, item.description, item.price, item.is_perishable " +
                "FROM item " +
                "JOIN item_types ON item.type_code = item_types.code";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);

        while (rows.next()) {
            items.add(mapRowToItem(rows));
        }


        return items;
    }

    public Item add(Item item) {
        String sql = "INSERT INTO public.item(" +
                "item_id, type_code, sku, name, description, price, is_perishable) " +
                "VALUES (DEFAULT, ?, ?, ?, ?, ?, ?) RETURNING item_id";
        Long itemId = jdbcTemplate.queryForObject(sql, Long.class, item.getTypeCode(),
                item.getSku(), item.getName(), item.getDescription(), item.getPrice(), item.isPerishable());
        item.setId(itemId);
        return item;
    }

    private Item mapRowToItem(SqlRowSet rows) {
        Item item = new Item();

        item.setId( rows.getLong("item_id") );
        item.setTypeCode( rows.getString("code") );
        item.setTypeName( rows.getString("type_name") );
        item.setSku( rows.getString("sku") );
        item.setName( rows.getString("name") );
        item.setDescription( rows.getString("description") );
        item.setPrice( rows.getDouble("price") );
        item.setPerishable( rows.getBoolean("is_perishable") );

        return item;
    }

}
