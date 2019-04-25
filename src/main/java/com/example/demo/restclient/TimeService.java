package com.example.demo.restclient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/time")
@ApplicationScoped
public class TimeService {
    @Inject
    @RestClient
    WorldClockApi clockApi;

    @GET
    @Path("/now")
    @Produces(MediaType.APPLICATION_JSON)
    public Now utc() {
        return clockApi.utc();
    }
}
