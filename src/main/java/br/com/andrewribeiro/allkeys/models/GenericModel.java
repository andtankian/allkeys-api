/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.andrewribeiro.allkeys.models;

import br.com.andrewribeiro.ribrest.model.abstracts.AbstractModel;
import java.security.Timestamp;
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
