package it.shadowsheep.swagger.playground.foo;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/foobar")
@Api(tags = {"foobar"})
@Produces({"application/json", "application/xml"})
public class DefaultApi {

    @GET
    @Operation(summary = "Get users",
            description = "Get list of users")
    public FooBar getUsers() {
        return FooBar.WINNIE_THE_POO;
    }

}
