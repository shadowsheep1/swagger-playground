package it.shadowsheep.swagger.playground.foo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/foobar")
@Produces({"application/json"})
public class DefaultApi {

    @POST
    @Operation(summary = "Get FooBar",
            description = "Get FooBar whatever thing it is")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = FooBar.class)
                    )
            )})
    public Response getYourFooBar(
                    FooBar f
    ) {
        return Response.ok(FooBar.TEDDY_BEAR).build();
    }

}
