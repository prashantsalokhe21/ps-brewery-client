package com.prashant21tube.psbreweryclient.web.client;

import com.prashant21tube.psbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project: ps-brewery-client
 * Package: com.prashant21tube.psbreweryclient.web.client
 * <p>
 * User: lenovo
 * Date: 5/17/2020
 * Time: 6:16 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest
class BreweryClientTest {
    @Autowired
    BreweryClient breweryClient;

    @Test
    void testGetBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        System.out.println("Beer ID : "+beerDto.getId());
        System.out.println("Beer Name : "+beerDto.getBeerName());
        System.out.println("Beer Style : "+beerDto.getBeerStyle());
        assertNotNull(beerDto);
    }

    @Test
    void testNewSaveBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();

        URI uri = breweryClient.saveNewBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri);
    }


}