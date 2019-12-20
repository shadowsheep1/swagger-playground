package it.shadowsheep.swagger.playground.foo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;

@Path("/v1")
@Produces({"application/json"})
public class DefaultApi {

    @POST
    @Path("/foobar")
    @Operation(summary = "Get FooBar",
            description = "Get FooBar whatever thing it is",
            responses = {
                    @ApiResponse(responseCode = "200",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = FooBar.class)
                            )
                    )})
    public Response getYourFooBar(
            @Parameter(schema = @Schema(implementation = FooBar.class))
                    FooBar f
    ) {
        return Response.ok(FooBar.TEDDY_BEAR).build();
    }

    @POST
    @Path("/foobar2")
    @Operation(summary = "Get FooBar2",
            description = "Get FooBar2 whatever thing it is",
            responses = {
                    @ApiResponse(responseCode = "200",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = FooBar.class)
                            )
                    )})
    public Response getYourFooBar2(
            @Parameter(schema = @Schema(implementation = FooBar2.class))
                    FooBar2 f
    ) {
        return Response.ok(FooBar.TEDDY_BEAR).build();
    }

    public class FooBar2 {
        public Long userId;
        public int myInt;
    }
}
