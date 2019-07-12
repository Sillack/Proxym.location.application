package com.proxym.user.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Anis OURAJINI
 */
@FeignClient(name = "Location-Management-Microservice", url = "http://localhost:9092")

public interface UserManagementFeignClient {
    @RequestMapping(value = "/location/all/byuser")
    String getLocationsByUser(@RequestParam("id_user") Integer user_id);

}
