package com.prashant21tube.psbreweryclient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Project: ps-brewery-client
 * Package: com.prashant21tube.psbreweryclient.web.model
 * <p>
 * User: lenovo
 * Date: 5/17/2020
 * Time: 5:28 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    private UUID id;
    private String name;
}
