package io.academik.demoinfosec.controller;

import io.academik.demoinfosec.model.AdmPhrase;
import io.academik.demoinfosec.repository.AdmPhraseRepository;
import io.academik.demoinfosec.util.RolesEnum;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

@Path("/phrases")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdmPhraseController {

    @Inject
    AdmPhraseRepository admPhraseRepository;

    @GET
    @RolesAllowed({RolesEnum.Constants.WEB_VALUE})
    public List<AdmPhrase> findAll(@QueryParam("author") @DefaultValue("%") String author,
                                   @QueryParam("phrase") @DefaultValue("%") String phrase){
        return admPhraseRepository.listAll(author, phrase);
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @RolesAllowed({RolesEnum.Constants.MOBILE_VALUE, RolesEnum.Constants.WEB_VALUE})
    public AdmPhrase findById(@PathParam("id") Long id) {
        return admPhraseRepository.findById(id);
    }

    @POST
    @RolesAllowed({RolesEnum.Constants.WEB_VALUE})
    public Response create(AdmPhrase phrase) {
        admPhraseRepository.create(phrase);
        return Response.created(UriBuilder.fromResource(this.getClass())
                .path(phrase.getPhraseId().toString()).build()).build();
    }


    @PUT
    @Path("/{id:[0-9][0-9]*}")
    @RolesAllowed({RolesEnum.Constants.WEB_VALUE})
    public Response update(@PathParam("id") Long id, AdmPhrase phrase) {
        if(id != phrase.getPhraseId())
            return Response.status(Response.Status.NOT_FOUND).build();

        phrase = admPhraseRepository.update(phrase);

        return Response.ok(phrase).build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    @RolesAllowed({RolesEnum.Constants.WEB_VALUE})
    public Response delete(@PathParam("id") Long id) {
        var updatedEntity = admPhraseRepository.findById(id);

        if(updatedEntity == null)
            return Response.status(Response.Status.NOT_FOUND).build();

        admPhraseRepository.delete(updatedEntity);
        return Response.ok().build();
    }

}
