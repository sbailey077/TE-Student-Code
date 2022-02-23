package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1L, 1L, 1L, 
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2L, 1L, 1L,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3L, 2L, 1L,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4L, 2L, 2L,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao sut;
    private Timesheet testTimesheet;

    @Before
    public void setup() {
        sut = new JdbcTimesheetDao(dataSource);
        testTimesheet = new Timesheet(99L, 2L, 2L, LocalDate.now(), 3.0, false, "Timesheet 99");
    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {
        Timesheet timesheet = sut.getTimesheet(1L);
        assertTimesheetsMatch(TIMESHEET_1, timesheet);
        assertTimesheetsMatch(TIMESHEET_3, sut.getTimesheet(3L));
    }

    @Test
    public void getTimesheet_returns_null_when_id_not_found() {
      Timesheet timesheet = sut.getTimesheet(5L);
      Assert.assertNull(timesheet);
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        List<Timesheet> timesheets = sut.getTimesheetsByEmployeeId(1L);
        Assert.assertEquals(2, timesheets.size());
        assertTimesheetsMatch(TIMESHEET_1, timesheets.get(0));
        assertTimesheetsMatch(TIMESHEET_2, timesheets.get(1));
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> timesheets = sut.getTimesheetsByProjectId(1L);
        Assert.assertEquals(3, timesheets.size());

        assertTimesheetsMatch(TIMESHEET_1, timesheets.get(0));
        assertTimesheetsMatch(TIMESHEET_2, timesheets.get(1));
        assertTimesheetsMatch(TIMESHEET_3, timesheets.get(2));
    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {
        Timesheet createdTimesheet = sut.createTimesheet(testTimesheet);

        long newId = createdTimesheet.getTimesheetId();
        Assert.assertTrue(newId > 0);

        testTimesheet.setTimesheetId(newId);
        assertTimesheetsMatch(testTimesheet, createdTimesheet);
    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Timesheet createdTimesheet = sut.createTimesheet(testTimesheet);

        long newId = createdTimesheet.getTimesheetId();
        Timesheet retrievedTimesheet = sut.getTimesheet(newId);

        assertTimesheetsMatch(createdTimesheet, retrievedTimesheet);
    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        Timesheet timesheetToUpdate = sut.getTimesheet(1L);

        timesheetToUpdate.setEmployeeId(2L);
        timesheetToUpdate.setProjectId(2L);
        timesheetToUpdate.setDateWorked(LocalDate.now());
        timesheetToUpdate.setHoursWorked(4.0);
        timesheetToUpdate.setBillable(false);
        timesheetToUpdate.setDescription("Timesheet Updated");

        sut.updateTimesheet(timesheetToUpdate);

        Timesheet retrievedTimesheetPostUpdate = sut.getTimesheet(1L);
        assertTimesheetsMatch(timesheetToUpdate, retrievedTimesheetPostUpdate);
    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {
        sut.deleteTimesheet(1L);

        Timesheet retrievedTimesheet = sut.getTimesheet(1L);
        Assert.assertNull(retrievedTimesheet);

        List<Timesheet> timesheets = sut.getTimesheetsByProjectId(1L);
        Assert.assertEquals(2, timesheets.size());
        assertTimesheetsMatch(TIMESHEET_2, timesheets.get(0));
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        double billableHours1_1 = sut.getBillableHours(1L, 1L);
        Assert.assertEquals(2.5, billableHours1_1, 0.1);

        double billableHours2_1 = sut.getBillableHours(2L, 1L);
        Assert.assertEquals(0.25, billableHours2_1, 0.1);

        double billableHours2_2 = sut.getBillableHours(2L, 2L);
        Assert.assertEquals(0, billableHours2_2, 0.1);
    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
