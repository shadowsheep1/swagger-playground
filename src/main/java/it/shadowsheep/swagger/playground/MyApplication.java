package it.shadowsheep.swagger.playground;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/*
    - https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Integration-and-Configuration

 */

@ApplicationPath("/sample")
public class MyApplication extends ResourceConfig {}