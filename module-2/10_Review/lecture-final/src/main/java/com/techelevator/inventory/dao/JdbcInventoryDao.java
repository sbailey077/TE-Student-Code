package com.techelevator.inventory.dao;

import com.techelevator.inventory.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class JdbcInventoryDao implements InventoryDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcInventoryDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Map<String, Item> getAllItems() {
        Map<String, Item> inventoryItems = new HashMap<String, Item>();

        String sql = "SELECT item.item_id, item.type_code, item_types.name AS type_name, item.sku, item.name, item.description, " +
                "item.price, item.is_perishable, pet.weight, pet.pet_name FROM item " +
                "JOIN item_types ON item.type_code = item_types.code " +
                "LEFT JOIN pet ON item.item_id = pet.item_id";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);

        while (rows.next()) {
            Item item = mapItemFromRow(rows);
            inventoryItems.put(item.getSku(), item);
        }

        return inventoryItems;
    }

    @Override
    public Long add(Item item) {
        String sql = "INSERT INTO item( " +
                "item_id, type_code, sku, name, description, price, is_perishable) " +
                "VALUES (DEFAULT, ?, ?, ?, ?, ?, ?) RETURNING item_id";
        Long item_id = jdbcTemplate.queryForObject(sql, Long.class, item.getTypeCode(), item.getSku(), item.getName(),
                item.getDescription(), item.getPrice(), item.isPerishable());

        if (item.getTypeCode().equalsIgnoreCase("P")) {
            insertPetForItem((Pet) item, item_id);
        }
        return item_id;
    }

    private void insertPetForItem(Pet pet, Long itemId) {
        String sql = "INSERT INTO pet(" +
                "pet_id, item_id, weight, pet_name) " +
                "VALUES (DEFAULT, ?, ?, ?)";
        jdbcTemplate.update(sql, itemId, pet.getWeight(), pet.getPetName());

    }

    private Item mapItemFromRow(SqlRowSet row) {
        Item item = null;

        String sku = row.getString("sku");
        String name = row.getString("name");
        String description = row.getString("description");
        Boolean perishable = row.getBoolean("is_perishable");
        Double price = row.getDouble("price");
        String type = row.getString("type_code");

        if (type.equalsIgnoreCase("F")) {
            item = new Food(sku, name);
        } else if (type.equalsIgnoreCase("C")) {
            item = new Clothing(sku, name);
        } else if (type.equalsIgnoreCase("B")) {
            item = new Book(sku, name);
        } else if (type.equalsIgnoreCase("P")) {
            Integer weight = row.getInt("weight");
            String petName = row.getString("pet_name");
            item = new Pet(sku, name, petName, weight);
        }


        item.setDescription(description);
        item.setPerishable( perishable );
        item.setPrice(price);
        return item;
    }

}
