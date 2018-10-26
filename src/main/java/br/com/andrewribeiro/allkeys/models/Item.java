package br.com.andrewribeiro.allkeys.models;

import br.com.andrewribeiro.allkeys.item.command.BuildItemPictureCommand;
import br.com.andrewribeiro.allkeys.lending.daos.ItemsNotLendedDAO;
import br.com.andrewribeiro.allkeys.item.command.ValidateItemBeforeInsertCommand;
import br.com.andrewribeiro.ribrest.core.annotations.RibrestEndpointConfigurator;
import br.com.andrewribeiro.ribrest.core.annotations.RibrestModel;
import br.com.andrewribeiro.ribrest.services.command.GetPersistentModelCommand;
import br.com.andrewribeiro.ribrest.services.command.MergeModelToPersistedModelCommand;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author Andrew Ribeiro
 */
@RibrestModel(defaultEndpointsConfigurators = {
    @RibrestEndpointConfigurator(
            method = "POST",
            beforeCommands = {
                ValidateItemBeforeInsertCommand.class,
                BuildItemPictureCommand.class,
            }
    ),
    @RibrestEndpointConfigurator,
    @RibrestEndpointConfigurator(
            method="PUT",
            path="{id}",
            beforeCommands = {
                BuildItemPictureCommand.class,
                GetPersistentModelCommand.class,
                MergeModelToPersistedModelCommand.class
            }
    )
}, endpointsConfigurators = {
    @RibrestEndpointConfigurator(
            path = "{id}"
    ),
    @RibrestEndpointConfigurator(
            path = "available",
            dao = ItemsNotLendedDAO.class            
    )
})
@Entity
public class Item extends GenericModel {

    private String name;
    private String type;
    private String pictureLink;
    private String currentStatus;
    
    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
    private Set<Lending> lendings;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Lending> getLendings() {
        return lendings;
    }

    public void setLending(Set<Lending> lendings) {
        this.lendings = lendings;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }
}
