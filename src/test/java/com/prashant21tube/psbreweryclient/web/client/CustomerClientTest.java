package com.prashant21tube.psbreweryclient.web.client;

import com.prashant21tube.psbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project: ps-brewery-client
 * Package: com.prashant21tube.psbreweryclient.web.client
 * <p>
 * User: lenovo
 * Date: 5/17/2020
 * Time: 9:31 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient client;


    @Test
    void getCustomerById() {
        ResponseEntity<CustomerDto> customerEntity = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerEntity.getBody());
        System.out.println("Customer ID: " +customerEntity.getBody().getId());
        System.out.println("Customer Name : " +customerEntity.getBody().getName());
    }

    @Test
    void testSaveCustomer() {
        //given
        CustomerDto dto = CustomerDto.builder().name("Ojas Salokhe").build();

        ResponseEntity entity = client.saveCustomer(dto);
        HttpHeaders headers = entity.getHeaders();
        System.out.println(headers.get("Location"));
    }

    @Test
    void testUpdateCustomer() {
        //given
        CustomerDto dto = CustomerDto.builder().name("Ojas Salokhe").build();
        client.updateCustomer(UUID.randomUUID(), dto);
    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}