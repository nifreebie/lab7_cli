package org.example.client.command_builders;

import lombok.NoArgsConstructor;
import org.example.client.Client;
import org.example.client.utils.ClientAppContainer;
import org.example.contract.command.Command;
import org.example.contract.command.SignInCommand;
import org.example.contract.exceptions.ExtraArgumentException;
import org.example.contract.model.User;

import java.sql.SQLOutput;
@NoArgsConstructor
public class SignInCommandBuilder implements CommandBuilder {
    @Override
    public Command build(String[] str) {
        if(str.length == 2) throw new ExtraArgumentException();
        System.out.println("Введите логин:");
        String login = ClientAppContainer.getInstance().getBufferedLineReader().nextLine();
        System.out.println("Введите пароль:");
        String pass = ClientAppContainer.getInstance().getBufferedLineReader().nextLine();
        return new SignInCommand(new User(login, pass));
    }
}
