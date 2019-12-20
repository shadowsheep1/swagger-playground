/**
 *  Copyright 2016 SmartBear Software
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package it.shadowsheep.swagger.playground.resource;

import io.swagger.annotations.*;
import it.shadowsheep.swagger.playground.data.StoreData;
import it.shadowsheep.swagger.playground.model.AuthenticationInfo;
import it.shadowsheep.swagger.playground.model.Order;
import it.shadowsheep.swagger.playground.exception.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/store")
@Api(value="/store" , description = "Operations about store")
@Produces({"application/json", "application/xml"})
public class PetStoreResource {
  static StoreData storeData = new StoreData();

  @GET
  @Path("/order/{orderId}")
  @ApiOperation(value = "Find purchase order by ID",
    notes = "For valid response try integer IDs with value >= 1 and <= 10. Other values will generated exceptions",
    response = Order.class)
  @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid ID supplied"),
      @ApiResponse(code = 404, message = "Order not found") })
  public Response getOrderById(
      @BeanParam AuthenticationInfo info,
      @ApiParam(value = "ID of order to fetch") @PathParam("orderId") Long orderId)
      throws NotFoundException {
    Order order = storeData.findOrderById(orderId);
    if (null != order) {
      return Response.ok().entity(order).build();
    } else {
      throw new NotFoundException(404, "Order not found");
    }
  }

  @POST
  @Path("/order")
  @ApiOperation(value = "Place an order for a pet",
    response = Order.class)
  @ApiResponses({ @ApiResponse(code = 400, message = "Invalid Order") })
  public Response placeOrder(
      @BeanParam AuthenticationInfo info,
      @ApiParam(value = "order placed for purchasing the pet", required = true) Order order) {
    storeData.placeOrder(order);
    return Response.ok().entity("").build();
  }

  @DELETE
  @Path("/order/{orderId}")
  @ApiOperation(value = "Delete purchase order by ID")
  @ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid ID supplied"),
    @ApiResponse(code = 404, message = "Order not found") })
  public Response deleteOrder(
      @BeanParam AuthenticationInfo info,
      @ApiParam(value = "ID of order to delete") @PathParam("orderId") Long orderId) {
    if (storeData.deleteOrder(orderId)) {
      return Response.ok().entity("").build();
    } else {
      return Response.status(Response.Status.NOT_FOUND).entity("Order not found").build();
    }
  }
}
