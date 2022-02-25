package com.techelevator.inventory.dao;

import com.techelevator.dao.BaseDaoTests;
import com.techelevator.inventory.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class JdbcInventoryDaoTests extends BaseDaoTests {
//price, String name, String description, String sku, boolean isPerishable
    private final static Item ITEM_CLOTHING_C01 = new Clothing(7.00, "ClothingOne", "Clothing One Description", "C01", false);
    private final static Item ITEM_FOOD_100 = new Food(10, "FoodOne", "FoodOneDescription", "100", true);
    private final static Item ITEM_BOOK_BOOK01 = new Book(18.75, "BookOne", "Book One Description", "Book01", false);
    private final static Item ITEM_PET_P1 = new Pet(12,"PetOne","PetOne Description", "P1",true,"PetOne Name",10);

    private JdbcInventoryDao target;

    @Before
    public void setup() {
        target = new JdbcInventoryDao(dataSource);
    }

    @Test
    public void get_all_items() {
        Map<String, Item> returnedInventory = target.getAllItems();

        Assert.assertEquals(8, returnedInventory.size());
        Assert.assertEquals(ITEM_CLOTHING_C01, returnedInventory.get(ITEM_CLOTHING_C01.getSku()));
        Assert.assertEquals(ITEM_FOOD_100, returnedInventory.get(ITEM_FOOD_100.getSku()));
        Assert.assertEquals(ITEM_BOOK_BOOK01, returnedInventory.get(ITEM_BOOK_BOOK01.getSku()));
        Assert.assertEquals(ITEM_PET_P1, returnedInventory.get(ITEM_PET_P1.getSku()));
    }

    @Test
    public void insert_non_pet_item() {
        Item itemToInsert = new Food(15, "InsertedFood", "InsertedFoodDescription", "INS1", true);

        Long itemId = target.add(itemToInsert);

        Assert.assertTrue(itemId > 0);

    }

}
