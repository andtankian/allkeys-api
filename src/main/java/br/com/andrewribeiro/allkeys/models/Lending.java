package br.com.andrewribeiro.allkeys.models;

import br.com.andrewribeiro.allkeys.lending.command.DevolveLendingCommand;
import br.com.andrewribeiro.allkeys.lending.command.ValidateLendingBeforeInsertCommand;
import br.com.andrewribeiro.ribrest.core.annotations.RibrestEndpointConfigurator;
import br.com.andrewribeiro.ribrest.core.annotations.RibrestModel;
import br.com.andrewribeiro.ribrest.services.command.GetPersistentChildrenModelCommand;
import br.com.andrewribeiro.ribrest.services.command.GetPersistentModelCommand;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 *
 * @author Andrew Ribeiro
 */
@RibrestModel(defaultEndpointsConfigurators = {
    @RibrestEndpointConfigurator(
            method = "POST",
            beforeCommands = {
                ValidateLendingBeforeInsertCommand.class,
                GetPersistentChildrenModelCommand.class
            }
    )
    ,
    @RibrestEndpointConfigurator
}, endpointsConfigurators = {
    @RibrestEndpointConfigurator(
            path = "{id}",
            beforeCommands = {
                GetPersistentModelCommand.class
            }
    )
    ,
    @RibrestEndpointConfigurator(
            path = "{id}/devolve",
            method = "PUT",
            beforeCommands = {
                GetPersistentModelCommand.class,
                DevolveLendingCommand.class,
            }
    )
})
@Entity
public class Lending extends GenericModel {

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Item item;

    @Column
    private Timestamp devolutionTime;

    @Column
    private String status;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Timestamp getDevolutionTime() {
        return devolutionTime;
    }

    public void setDevolutionTime(Timestamp devolutionTime) {
        this.devolutionTime = devolutionTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
