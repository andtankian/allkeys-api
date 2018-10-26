package br.com.andrewribeiro.allkeys.generics;

import br.com.andrewribeiro.ribrest.core.exceptions.RibrestDefaultException;
import br.com.andrewribeiro.ribrest.services.command.AbstractCommand;

/**
 *
 * @author Andrew Ribeiro
 */
public abstract class GenericCommand extends AbstractCommand{
    
    protected RibrestDefaultException exception(String cause){
        return new RibrestDefaultException(cause);
    }
    
}
