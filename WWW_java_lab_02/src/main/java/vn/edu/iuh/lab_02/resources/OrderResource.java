package vn.edu.iuh.lab_02.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.lab_02.models.Order;
import vn.edu.iuh.lab_02.requests.OrderRequest;
import vn.edu.iuh.lab_02.services.OrderService;

import java.util.List;

@Path("/orders")
public class OrderResource {
    private OrderService orderService;

    public OrderResource() {
        this.orderService = new OrderService();
    }

    @POST
    @Path("/")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addOrder(OrderRequest orderRequest){
        boolean result = orderService.addOrder(orderRequest);
        if(!result){
            return Response.ok().entity("{\"message\": \"Data not found\"}").build();
        }
        return Response.ok().entity("{\"message\": \"Create order successfully\"}").build();
    }

    @GET
    @Path("/")
    @Produces("application/json")
    public Response getAll(@QueryParam("date") String date, @QueryParam("from_date") String fromDate, @QueryParam("to_date") String toDate){
        List<Order> orders = orderService.getAll(date, fromDate, toDate);
        return Response.ok(orders).build();
    }
}