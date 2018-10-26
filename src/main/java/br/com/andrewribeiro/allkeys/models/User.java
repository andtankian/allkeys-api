package br.com.andrewribeiro.allkeys.models;


import br.com.andrewribeiro.allkeys.user.commands.BuildProfilePictureCommand;
import br.com.andrewribeiro.allkeys.user.commands.FillUserWithQueries;
import br.com.andrewribeiro.allkeys.user.dao.UsersBySecureCodeDAO;
import br.com.andrewribeiro.allkeys.user.commands.ValidateUserBeforeInsertCommand;
import br.com.andrewribeiro.ribrest.core.annotations.RibrestEndpointConfigurator;
import br.com.andrewribeiro.ribrest.core.annotations.RibrestModel;
import br.com.andrewribeiro.ribrest.services.command.GetPersistentModelCommand;
import br.com.andrewribeiro.ribrest.services.command.MergeModelToPersistedModelCommand;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Andrew Ribeiro
 */
@RibrestModel(defaultEndpointsConfigurators = {
    @RibrestEndpointConfigurator(
            method = "POST",
            beforeCommands = {
                ValidateUserBeforeInsertCommand.class,
                BuildProfilePictureCommand.class
            }
    ),
    @RibrestEndpointConfigurator,
    @RibrestEndpointConfigurator(
            method = "PUT",
            path = "{id}",
            beforeCommands = {
                BuildProfilePictureCommand.class,
                GetPersistentModelCommand.class,
                MergeModelToPersistedModelCommand.class
            }
    )
}, endpointsConfigurators = {
    @RibrestEndpointConfigurator(
            method = "GET",
            path = "{id}"
    ),
    @RibrestEndpointConfigurator(
            method = "GET",
            path = "bysecurecode",
            beforeCommands = FillUserWithQueries.class,
            dao = UsersBySecureCodeDAO.class
    )
})
@Entity(name = "Uzer")
public class User extends GenericModel{

    private String fullName;
    private String email;
    private String secureCode;
    private String type;

    @Column(length = 1000)
    private String pictureLink;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecureCode() {
        return secureCode;
    }

    public void setSecureCode(String secureCode) {
        this.secureCode = secureCode;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public String getType(){
      return this.type;
    }

    public void setType(String type){
      this.type = type;
    }
}
