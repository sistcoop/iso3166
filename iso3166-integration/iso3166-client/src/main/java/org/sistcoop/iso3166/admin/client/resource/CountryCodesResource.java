package org.sistcoop.iso3166.admin.client.resource;

import java.util.List;

import javax.ejb.EJBException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.sistcoop.iso3166.representations.idm.CountryCodeRepresentation;
import org.sistcoop.iso3166.representations.idm.search.SearchResultsRepresentation;

@Path("countryCodes")
@Consumes(MediaType.APPLICATION_JSON)
public interface CountryCodesResource {

    /**
     * @param countryCode
     *            Id del CountryCode.
     */
    @Path("{countryCode}")
    public CountryCodeResource countryCode(@PathParam("countryCode") String countryCode);

    /**
     * Crea un CountryCode segun los datos enviados
     * 
     * @summary Crea un CountryCode
     * @param representation
     *            El detalle del objeto a enviar.
     * @statuscode 201 Si el objeto fue creado satisfactoriamente.
     * @return CountryCode creado.
     * @throws EJBException
     *             datos validos pero ocurrio un error interno
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(CountryCodeRepresentation rep);

    /**
     * Listar todos los country codes.
     * 
     * @summary Listar todos los Country Codes
     * @statuscode 200 Si la busqueda fue exitosa.
     * @return SearchResultsRepresentation resultado de busqueda.
     * @throws EJBException
     *             datos validos pero ocurrio un error interno
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CountryCodeRepresentation> getAll();

    /**
     * Buscar CountryCode segun los parametros enviados.
     * 
     * @summary Buscar uno o varios CountryCode
     * @param filterText
     *            Palabra filtro.
     * @param page
     *            Numero de pagina.
     * @param pageSize
     *            Tamano de pagina.
     * @statuscode 200 Si la busqueda fue exitosa.
     * @return SearchResultsRepresentation resultado de busqueda.
     * @throws EJBException
     *             datos validos pero ocurrio un error interno
     */

    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public SearchResultsRepresentation<CountryCodeRepresentation> search(
            @QueryParam("filterText") String filterText, @QueryParam("page") int page,
            @QueryParam("pageSize") int pageSize);

}