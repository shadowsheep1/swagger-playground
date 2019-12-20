import io.swagger.v3.oas.annotations.Operation;

import javax.ws.rs.GET;

public class DefaultApi {

    @GET
    @Operation(summary = "Get users",
            description = "Get list of users")
    public FooBar getUsers() {
        return FooBar.WINNIE_THE_POO;
    }

}
