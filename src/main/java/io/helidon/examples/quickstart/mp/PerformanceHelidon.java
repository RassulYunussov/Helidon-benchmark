package io.helidon.examples.quickstart.mp;

import io.helidon.webclient.api.WebClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/performance-helidon")
public class PerformanceHelidon {
    private final WebClient webClient = WebClient.builder()
            .baseUri("http://localhost:8084")
            .build();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@QueryParam("delay") long delay) {
        final var response = webClient.get()
                .path("/product")
                .queryParam("delay", String.format("%d", delay))
                .request(String.class);
        return response.entity();
    }

}
