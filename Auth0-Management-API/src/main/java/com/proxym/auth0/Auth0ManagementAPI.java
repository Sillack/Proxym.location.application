package com.proxym.auth0;

/**
 * @author Anis OURAJINI
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class Auth0ManagementAPI {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Auth0ManagementAPI.class, args);
    }
}
