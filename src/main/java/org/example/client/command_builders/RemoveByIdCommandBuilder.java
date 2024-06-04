package org.example.client.command_builders;

import lombok.NoArgsConstructor;
import org.example.client.utils.CommandWithIdArgument;
import org.example.client.utils.ConsoleManager;
import org.example.contract.command.Command;
import org.example.contract.command.RemoveByIdCommand;
import org.example.contract.exceptions.NoArgumentException;

import java.io.Console;

@NoArgsConstructor
public class RemoveByIdCommandBuilder implements CommandBuilder, CommandWithIdArgument {
    @Override
    public Command build(String[] str) {
        if (str.length == 1) throw new NoArgumentException();
        if (checkArgForId(str[1])) {
            if (Long.parseLong(str[1]) <= 0) throw new NumberFormatException();
            return new RemoveByIdCommand(Long.parseLong(str[1]), ConsoleManager.getUser());

        } else {
            throw new NumberFormatException();
        }
    }
}
