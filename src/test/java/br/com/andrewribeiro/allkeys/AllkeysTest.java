package br.com.andrewribeiro.allkeys;

import br.com.andrewribeiro.allkeys.app.AllkeysApp;
import br.com.andrewribeiro.ribrest.core.exceptions.RibrestDefaultException;
import br.com.andrewribeiro.ribrest.utils.RibrestUtils;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.BeforeClass;

/**
 *
 * @author Andrew Ribeiro
 */
public class AllkeysTest {

    protected final Client client = ClientBuilder.newClient();

    @BeforeClass
    public static void start() {
        AllkeysApp.main(null);
    }
    
    public Response get(Class resource) {
        WebTarget webTarget = buildWebTarget(resource,null);
        return webTarget.request(MediaType.APPLICATION_JSON).get();
    }
    
    public Response get(Class resource, String queries){
        WebTarget webTarget = buildWebTarget(resource, queries);
        return webTarget.request(MediaType.APPLICATION_JSON).get();
    }
    
    public Response post(Class resource, Form form) {
        WebTarget wt = buildWebTarget(resource, null);
        return wt.request(MediaType.APPLICATION_JSON).post(Entity.form(form));
    }
    
    private WebTarget buildWebTarget(Class sub, String queries) {
        WebTarget wt = null;
        try {
            wt = client.target("http://localhost:2007/allkeys/" + RibrestUtils.getResourceName(sub) + queries);
        } catch (RibrestDefaultException e) {
            if (e instanceof RibrestDefaultException) {
                throw new RuntimeException(((RibrestDefaultException) e).getError());
            }
        }
        return wt;
    }

}
