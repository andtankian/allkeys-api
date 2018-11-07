package br.com.andrewribeiro.allkeys.user.commands;

import br.com.andrewribeiro.allkeys.models.User;
import br.com.andrewribeiro.allkeys.utils.Utils;
import br.com.andrewribeiro.ribrest.core.exceptions.RibrestDefaultException;
import br.com.andrewribeiro.ribrest.services.command.AbstractCommand;

/**
 *
 * @author Andrew Ribeiro
 */
public class BuildProfilePictureCommand extends AbstractCommand{

    @Override
    public void execute() throws RibrestDefaultException, Exception {
        
        User user = (User) flowContainer.getModel();
        
        if(user.getPictureLink() != null && !user.getPictureLink().isEmpty() && !user.getPictureLink().startsWith("http")){
            user.setPictureLink(Utils.saveFileAndGenerateLink(user.getPictureLink()));
        }
    }

}
