package br.com.andrewribeiro.allkeys.lending.command;

import br.com.andrewribeiro.allkeys.models.Lending;
import br.com.andrewribeiro.allkeys.utils.Utils;
import br.com.andrewribeiro.ribrest.core.exceptions.RibrestDefaultException;
import br.com.andrewribeiro.ribrest.core.model.Model;
import br.com.andrewribeiro.ribrest.services.command.AbstractCommand;

/**
 *
 * @author Andrew Ribeiro
 */
public class DevolveLendingCommand extends AbstractCommand{

    @Override
    public void execute() throws RibrestDefaultException, Exception {
        
        Lending lending = (Lending) flowContainer.getExtraObject(Model.PERSISTED_MODEL_KEY);
        lending.setDevolutionTime(Utils.getCurrentTime());
        lending.getItem().setCurrentStatus("Ok");
        lending.setStatus("Devolvido");
        flowContainer.setModel(lending);
    }
    
}
