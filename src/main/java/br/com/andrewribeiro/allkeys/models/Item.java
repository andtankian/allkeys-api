package br.com.andrewribeiro.allkeys.models;


import br.com.andrewribeiro.ribrest.annotations.RibrestModel;
import javax.persistence.Entity;


/**
 *
 * @author Andrew Ribeiro
 */
@RibrestModel
@Entity
public class Item extends GenericModel{
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
