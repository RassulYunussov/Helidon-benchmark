package io.helidon.examples.quickstart.mp;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;


import java.net.URI;
import java.util.List;

@Path("/performance-helidon")
public class PerformanceHelidon {

    @RegisterRestClient(baseUri = "http://localhost:8084")
    public interface ProuductClient {
        @GET
        @Path("/product")
        List<Product.ProductItem> getProducts(@QueryParam("delay") long delay);
    }

    @Inject
    @RestClient
    ProuductClient client;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product.ProductItem> get(@QueryParam("delay") long delay) {
        return client.getProducts(delay);
    }
}
