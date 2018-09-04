package br.com.andrewribeiro.allkeys.item.command;

import br.com.andrewribeiro.allkeys.generics.GenericCommand;
import br.com.andrewribeiro.allkeys.models.Item;
import br.com.andrewribeiro.allkeys.utils.Utils;
import br.com.andrewribeiro.ribrest.exceptions.RibrestDefaultException;
import java.util.Base64;

/**
 *
 * @author Andrew Ribeiro
 */
public class ValidateItemBeforeInsertCommand extends GenericCommand {

    @Override
    public void execute() throws RibrestDefaultException, Exception {

        Item item = (Item) flowContainer.getModel();

        if (item.getName() == null || item.getName().isEmpty()) {
            throw exception("invalid name");
        }

        if (item.getName().length() < 4) {
            throw exception("item name is too short");
        }

        if (item.getType() == null || item.getType().isEmpty()) {
            throw exception("invalid type");
        }

        if (item.getPictureLink() != null && !item.getPictureLink().isEmpty()) {
            try {
                item.setPictureLink(Utils.saveFileAndGenerateLink(item.getPictureLink()));
            } catch (Exception e) {
                throw exception("error while processing item image");
            }

        }
    }

}
