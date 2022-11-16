package com.beyzagobel;

import com.beyzagobel.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = SpringPostgresqlApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@RequiredArgsConstructor
public class EmployeeControllerTest {
    private final TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl(){
        return "http:localhost:" + port;
    }

    @Test
    public void testGetAllEmployees(){

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        HttpEntity<String> response = restTemplate.exchange(getRootUrl() + "/employees",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());

    }

    @Test
    public void testGetEmployeesById(){
        Employee employee = restTemplate.getForObject(getRootUrl() + "/employees/1", Employee.class);
        System.out.println(employee.getName());
        assertNotNull(employee);
    }

}
