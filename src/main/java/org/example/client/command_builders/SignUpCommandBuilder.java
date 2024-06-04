package org.example.client.command_builders;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.client.utils.ClientAppContainer;
import org.example.contract.command.Command;
import org.example.contract.command.SignInCommand;
import org.example.contract.command.SignUpCommand;
import org.example.contract.exceptions.ExtraArgumentException;
import org.example.contract.model.User;

@NoArgsConstructor
public class SignUpCommandBuilder implements CommandBuilder{
    @Override
    public Command build(String[] str) {
        if(str.length == 2) throw new ExtraArgumentException();
        System.out.println("Введите логин:");
        String login = ClientAppContainer.getInstance().getBufferedLineReader().nextLine();
        System.out.println("Введите пароль:");
        String pass = ClientAppContainer.getInstance().getBufferedLineReader().nextLine();
        return new SignUpCommand(new User(login, pass));
    }
}
