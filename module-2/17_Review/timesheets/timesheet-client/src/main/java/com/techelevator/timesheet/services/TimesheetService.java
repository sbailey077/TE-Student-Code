package com.techelevator.timesheet.services;

import com.techelevator.timesheet.model.*;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimesheetService {

    private RestTemplate restTemplate = new RestTemplate();

    private String baseUrl = "";
    private AuthenticatedUser user;

    public TimesheetService(String baseUrl) {
        this.baseUrl = baseUrl;

    }

    public void setUser(AuthenticatedUser user) {
        this.user = user;
    }


    public List<Department> getAllDepartments() {
        Department[] departments =  restTemplate.getForObject(baseUrl +"departments", Department[].class);
        return Arrays.asList(departments);
    }

    public EmployeeDetail getEmployeeDetailsForCurrentUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(user.getToken());
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(baseUrl + "employees", HttpMethod.GET, entity, EmployeeDetail.class).getBody();
    }

    public Timesheet addTimesheetRecord(Timesheet record) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(user.getToken());
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Timesheet> entity = new HttpEntity<Timesheet>(record, headers);

        Timesheet response = restTemplate.exchange(baseUrl + "timesheets", HttpMethod.POST, entity, Timesheet.class).getBody();
        return response;
    }

    public List<Employee> departmentEmployeeView() {
        Employee[] employeeDetail = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth((user.getToken()));
            HttpEntity<Void> entity = new HttpEntity<>(headers);

            employeeDetail = restTemplate.exchange(baseUrl + "/departments/" + user.getUser().getId() +
                    "/employees", HttpMethod.GET, entity, Employee[].class).getBody();
            if (employeeDetail != null) {
                return Arrays.asList(employeeDetail);
            }
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return null;
    }

}
