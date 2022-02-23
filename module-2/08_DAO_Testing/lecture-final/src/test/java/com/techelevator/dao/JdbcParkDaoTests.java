package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private JdbcParkDao target;
    private Park testPark;

    @Before
    public void setup() {
        target = new JdbcParkDao(dataSource);
        testPark = new Park(0, "Test Park", LocalDate.now(), 900, true);
    }

    @Test
    public void getPark_returns_correct_park_for_id() {
        Park park = target.getPark(1);
        assertParksMatch("Park 1 did not match", PARK_1, park);

        assertParksMatch("Park 3 did not match", PARK_3, target.getPark(3) );
    }

    @Test
    public void getPark_returns_null_when_id_not_found() {
        Park park = target.getPark(99);
        Assert.assertNull(park);
    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {
        List<Park> parks = target.getParksByState("AA");
        Assert.assertEquals(2, parks.size());
        assertParksMatch("Park 1 not in list for AA", PARK_1, parks.get(0));
        assertParksMatch("Park 3 not in list for AA", PARK_3, parks.get(1));

        parks = target.getParksByState("BB");
        Assert.assertEquals(1, parks.size());
        assertParksMatch("Park 2 not in list for BB", PARK_2, parks.get(0));

    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {
        List<Park> parks = target.getParksByState("XX");
        Assert.assertEquals(0, parks.size());
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        /*
            1. call createPark with our test park
            2. get the returned id and verify it is > 0
            3. Make sure our test park (with the new id) equals the park returned from createPark
         */
        Park createdPark = target.createPark(testPark);

        long newId = createdPark.getParkId();
        Assert.assertTrue(newId > 0);

        testPark.setParkId(newId);
        assertParksMatch("Parks did not match", testPark, createdPark);
    }

    @Test
    public void created_park_has_expected_values_when_retrieved() {
          /*
            1. call createPark with our test park
            2. get the returned id use it to get the park from the database using getPark
            3. compare the returned park is the same as the created park
         */
        Park createdPark = target.createPark(testPark);

        long newId = createdPark.getParkId();
        Park retrievedPark = target.getPark(newId);

        assertParksMatch("Retrieved park not same as created", createdPark, retrievedPark);
    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {
        /*
            1. Get a park with getPark
            2. Make changes to the park
            3. update it with updatePark
            4. Get the park again with getPark
            5. Assert that the park returned after the update has the updated information
         */
        Park parkToUpdate = target.getPark(1);

        parkToUpdate.setParkName("Updated");
        parkToUpdate.setDateEstablished(LocalDate.now());
        parkToUpdate.setHasCamping(false);
        parkToUpdate.setArea(999);

        target.updatePark(parkToUpdate);

        Park retrievedParkAfterUpdate = target.getPark(1);
        assertParksMatch("Park not updated", parkToUpdate, retrievedParkAfterUpdate);

    }

    @Test
    public void deleted_park_cant_be_retrieved() {
        target.deletePark(1);

        Park retrievedPark = target.getPark(1);
        Assert.assertNull(retrievedPark);

        List<Park> parks = target.getParksByState("AA");
        Assert.assertEquals(1, parks.size());
        assertParksMatch("Park 3 not returned", PARK_3, parks.get(0));
    }

    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {
       /*
        add a park to a state
        use getParksByState to get the list of parks for that state
        verify it is the correct list with the new park added
        */
        target.addParkToState(3, "BB");
        List<Park> parks = target.getParksByState("BB");
        Assert.assertEquals(2, parks.size());

    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {
        target.removeParkFromState(1, "AA");
        List<Park> parks = target.getParksByState("AA");
        Assert.assertEquals(1, parks.size());

    }

    private void assertParksMatch(String message, Park expected, Park actual) {
        Assert.assertEquals(message, expected.getParkId(), actual.getParkId());
        Assert.assertEquals(message, expected.getParkName(), actual.getParkName());
        Assert.assertEquals(message, expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(message, expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(message, expected.getHasCamping(), actual.getHasCamping());
    }

}
