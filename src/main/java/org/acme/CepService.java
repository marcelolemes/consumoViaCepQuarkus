package org.acme;

import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/ws/{uf}/{localidade}/{logradouro}/{formato}")
@RegisterRestClient(configKey="extensions-api")
public interface CepService {
    @GET
    List<Address> getByParameters(@PathParam("uf") String uf,
                                  @PathParam("localidade") String localidade,
                                  @PathParam("logradouro") String logradouro,
                                  @PathParam("formato") @DefaultValue("json") String formato);
}

