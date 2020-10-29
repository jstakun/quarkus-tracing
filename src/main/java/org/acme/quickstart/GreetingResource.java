package org.acme.quickstart;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

@Path("/")
public class GreetingResource {

    private static final Logger LOG = Logger.getLogger(GreetingResource.class);

    @Inject
    public ConversationService conversationService;
    
    @ConfigProperty(name = "hello.suffix", defaultValue="from the Cloud") 
    String MSG;

    private static final String PREFIX = "Hello ";
    
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
    	final String message = PREFIX + MSG;
        LOG.info(message);
        return message;
    }

    @GET
    @Path("/bonjour")
    @Produces(MediaType.TEXT_PLAIN)
    public String bonjour() {
    	return "Bonjour";
    }

    @GET
    @Path("/conversation")
    @Produces(MediaType.TEXT_PLAIN)
    public String conversation() {
        return conversationService.talk();
    }

    @GET
    @Path("/foo")
    @Produces(MediaType.TEXT_PLAIN)
    public String foo() {
        return "foo";
    }
}
