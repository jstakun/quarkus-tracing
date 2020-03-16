package org.acme.quickstart;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 * @author Pavol Loffay
 */
@Traced
@ApplicationScoped
public class ConversationService {

    @Inject
    @RestClient
    private GreetingService greetingService;

    @Counted(name = "performedTalk", description = "How many talks have been performed.")
    @Timed(name = "checksTalkTimer", description = "A measure of how long it takes to perform the talk.", unit = MetricUnits.MILLISECONDS)
    public String talk() {
        return greetingService.hello() + " -> " + greetingService.bonjour();
    }
}
