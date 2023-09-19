package org.acme;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.net.URI;
import java.util.List;

@Path("/hello")
@ApplicationScoped
public class GreetingResource {
    @RestClient
    CepService cepService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Address> addresses = cepService
                .getByParameters("RS",
                "Porto Alegre",
                "Domingos José",
                "json");
        return objectMapper.writeValueAsString(addresses);
    }
}
