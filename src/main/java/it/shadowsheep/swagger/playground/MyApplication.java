package it.shadowsheep.swagger.playground;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/sample")
public class MyApplication extends ResourceConfig {}