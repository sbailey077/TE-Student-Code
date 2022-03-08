package com.techelevator.timesheet.services;

import com.techelevator.timesheet.model.AuthenticatedUser;
import com.techelevator.timesheet.model.Department;
import com.techelevator.timesheet.model.EmployeeDetail;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

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



}
