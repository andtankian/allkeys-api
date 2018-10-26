package br.com.andrewribeiro.allkeys.models;

import br.com.andrewribeiro.ribrest.core.model.AbstractModel;
import java.sql.Timestamp;
import javax.persistence.Entity;

/**
 *
 * @author Andrew Ribeiro
 */
@Entity
public abstract class GenericModel extends AbstractModel{
    
    private Timestamp dateReg;

    public Timestamp getDateReg() {
        return dateReg;
    }

    public void setDateReg(Timestamp dateReg) {
        this.dateReg = dateReg;
    }
}
