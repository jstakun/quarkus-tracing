package org.acme.quickstart;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * @author Pavol Loffay
 */
@Path("/")
@RegisterRestClient
public interface GreetingService {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    @Counted(name = "performedHello", description = "How many hello greetings have been performed.")
    @Timed(name = "checksHelloTimer", description = "A measure of how long it takes to perform the hello greeting.", unit = MetricUnits.MILLISECONDS)
    String hello();

    @GET
    @Path("/bonjour")
    @Produces(MediaType.TEXT_PLAIN)
    @Counted(name = "performedBonjour", description = "How many bonjour greetings have been performed.")
    @Timed(name = "checksBonjourTimer", description = "A measure of how long it takes to perform the bonjour greeting.", unit = MetricUnits.MILLISECONDS)
    String bonjour();
}
