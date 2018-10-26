package br.com.andrewribeiro.allkeys.user.commands;

import br.com.andrewribeiro.allkeys.models.User;
import br.com.andrewribeiro.ribrest.core.exceptions.RibrestDefaultException;
import br.com.andrewribeiro.ribrest.services.command.AbstractCommand;

/**
 *
 * @author Andrew Ribeiro
 */
public class FillUserWithQueries extends AbstractCommand{

    @Override
    public void execute() throws RibrestDefaultException, Exception {
        
        User user = (User)flowContainer.getModel();
        
        user.setSecureCode(flowContainer.getRequestMaps().getQueryMap().getFirst("secureCode"));
    }

}
