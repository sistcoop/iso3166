package org.sistcoop.iso3166.admin.client.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/countryNames")
@Consumes(MediaType.APPLICATION_JSON)
public interface CountryNamesResource {

}