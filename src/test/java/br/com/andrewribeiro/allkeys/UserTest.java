package br.com.andrewribeiro.allkeys;

import br.com.andrewribeiro.allkeys.models.User;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Andrew Ribeiro
 */
public class UserTest extends AllkeysTest {

    private Response response;

    @Test
    @Ignore
    public void missingEmailCreatingNewUser() {
        postNewUser(new Form());
        checkPreconditionFailed();
        checkErrorCause("empty email");
    }
    
    @Test
    public void invalidEmailCreatingNewUser(){
        MultivaluedMap mvm = new MultivaluedHashMap();
        mvm.add("email", "ribrest");
        postNewUser(new Form(mvm));
        checkPreconditionFailed();
        checkErrorCause("invalid email");
        mvm.putSingle("email", "ribrest@ribrest");
        postNewUser(new Form(mvm));
        checkPreconditionFailed();
        checkErrorCause("invalid email");
        mvm.putSingle("email", "r@ribrest.c");
        postNewUser(new Form(mvm));
        checkPreconditionFailed();
        checkErrorCause("invalid email");
    }

    @Test
    public void missingNameCreatingNewUser() {
        MultivaluedMap mvm = new MultivaluedHashMap();
        mvm.add("email", "andrew.ribeiro@etec.sp.gov.br");
        postNewUser(new Form(mvm));
        checkPreconditionFailed();
        checkErrorCause("empty name");

    }
    
    @Test
    public void shortNameCreatingNewUser(){
        MultivaluedHashMap mvm = new MultivaluedHashMap();
        mvm.add("email", "andrew.ribeiro@etec.sp.gov.br");
        mvm.add("fullName", "An");
        postNewUser(new Form(mvm));
        checkPreconditionFailed();
        checkErrorCause("short name");
    }
    
    @Test
    public void shortSecureCode(){
        MultivaluedHashMap mvm = new MultivaluedHashMap();
        mvm.add("email", "andrew.ribeiro@etec.sp.gov.br");
        mvm.add("fullName", "Andrew Ribeiro");
        mvm.add("secureCode", "1234"); //short
        postNewUser(new Form(mvm));
        checkPreconditionFailed();
        checkErrorCause("short secure code");
    }
    
    @Test
    public void validUser(){
        MultivaluedHashMap mvm = new MultivaluedHashMap();
        mvm.add("email", "andrew.ribeiro@etec.sp.gov.br");
        mvm.add("fullName", "Andrew Ribeiro");
        mvm.add("secureCode", "12092017");
        postNewUser(new Form(mvm));
        checkCreated();
    }

    private void postNewUser(Form form) {
        response = post(User.class, form);
    }

    private void checkPreconditionFailed() {
        Assert.assertEquals(Response.Status.PRECONDITION_FAILED.getStatusCode(), response.getStatus());
    }
    
    private void checkCreated(){
        Assert.assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }
    
    void checkErrorCause(String cause){
        Assert.assertEquals(cause, getErrorMessage());
    }
    
    private String getErrorMessage(){
        JSONObject jsonObject = getJsonObject();
        return jsonObject.getString("cause");
    }
    
    private JSONObject getJsonObject(){
        return new JSONObject(response.readEntity(String.class));
    }
    
    

}
