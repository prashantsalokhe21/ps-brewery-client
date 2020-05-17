package com.prashant21tube.psbreweryclient.web.client;

import com.prashant21tube.psbreweryclient.web.model.BeerDto;
import com.prashant21tube.psbreweryclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.PropertySources;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Project: ps-brewery-client
 * Package: com.prashant21tube.psbreweryclient.web.client
 * <p>
 * User: lenovo
 * Date: 5/17/2020
 * Time: 9:03 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@Component
@ConfigurationProperties(value = "ps.brewery", ignoreInvalidFields = false)
public class CustomerClient {

    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";

    private String apiHost;
    private final RestTemplateBuilder restTemplateBuilder;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public ResponseEntity<CustomerDto> getCustomerById(UUID uuid) {
        return restTemplateBuilder.build().getForEntity(apiHost + CUSTOMER_PATH_V1 + uuid, CustomerDto.class);
    }

    public ResponseEntity saveCustomer(CustomerDto customerDto) {
        return restTemplateBuilder.build().postForEntity(apiHost + CUSTOMER_PATH_V1, customerDto, CustomerDto.class);
    }

    public void updateCustomer(UUID uuid, CustomerDto customerDto) {
        restTemplateBuilder.build().put(apiHost + CUSTOMER_PATH_V1 + uuid,customerDto);
    }

    public void deleteCustomer(UUID uuid) {
        restTemplateBuilder.build().delete(apiHost + CUSTOMER_PATH_V1 + uuid);
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }
}
