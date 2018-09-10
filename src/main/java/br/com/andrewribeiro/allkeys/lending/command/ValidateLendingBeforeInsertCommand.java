package br.com.andrewribeiro.allkeys.lending.command;

import br.com.andrewribeiro.allkeys.models.Lending;
import br.com.andrewribeiro.allkeys.utils.Utils;
import br.com.andrewribeiro.ribrest.exceptions.RibrestDefaultException;
import br.com.andrewribeiro.ribrest.services.command.AbstractCommand;

/**
 *
 * @author Andrew Ribeiro
 */
public class ValidateLendingBeforeInsertCommand extends AbstractCommand{

    @Override
    public void execute() throws RibrestDefaultException, Exception {
        
        Lending lending = (Lending) flowContainer.getModel();
        lending.setDateReg(Utils.getCurrentTime());
        
        if(lending.getStatus() == null || lending.getStatus().isEmpty()){
            lending.setStatus("Ativo");
        }
    }
    
}
