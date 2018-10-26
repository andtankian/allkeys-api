package br.com.andrewribeiro.allkeys.item.command;

import br.com.andrewribeiro.allkeys.models.Item;
import br.com.andrewribeiro.allkeys.utils.Utils;
import br.com.andrewribeiro.ribrest.core.exceptions.RibrestDefaultException;
import br.com.andrewribeiro.ribrest.services.command.AbstractCommand;

/**
 *
 * @author Andrew Ribeiro
 */
public class BuildItemPictureCommand extends AbstractCommand{

    @Override
    public void execute() throws RibrestDefaultException, Exception {
        
        Item item = (Item) flowContainer.getModel();
        
        if(item.getPictureLink() != null && !item.getPictureLink().isEmpty()){
            item.setPictureLink(Utils.saveFileAndGenerateLink(item.getPictureLink()));
        }
    }

}
