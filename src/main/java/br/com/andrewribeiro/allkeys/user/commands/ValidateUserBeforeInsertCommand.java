package br.com.andrewribeiro.allkeys.user.commands;

import br.com.andrewribeiro.allkeys.generics.GenericCommand;
import br.com.andrewribeiro.allkeys.models.User;
import br.com.andrewribeiro.allkeys.utils.Constants;
import br.com.andrewribeiro.allkeys.utils.Utils;
import br.com.andrewribeiro.ribrest.exceptions.RibrestDefaultException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

/**
 *
 * @author Andrew Ribeiro
 */
public class ValidateUserBeforeInsertCommand extends GenericCommand {

    @Override
    public void execute() throws RibrestDefaultException, Exception {

        User user = (User) flowContainer.getModel();

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw exception("empty email");
        } else if (!new EmailValidator().validateEmail(user.getEmail())) {
            throw exception("invalid email");
        }

        if (user.getFullName() == null || user.getFullName().isEmpty()) {
            throw exception("empty name");
        } else if (user.getFullName().length() < 3) {
            throw exception("short name");
        }

        if (user.getSecureCode() != null && user.getSecureCode().length() < 6) {
            throw exception("short secure code");
        } else if (user.getSecureCode() == null) {
            user.setSecureCode(Utils.generateNewSecureCode());
        }

    }

}