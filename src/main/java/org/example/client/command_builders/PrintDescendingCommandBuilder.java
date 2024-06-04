package org.example.client.command_builders;

import lombok.NoArgsConstructor;
import org.example.client.utils.ConsoleManager;
import org.example.contract.command.Command;
import org.example.contract.command.InfoCommand;
import org.example.contract.command.PrintDescendingCommand;
import org.example.contract.exceptions.ExtraArgumentException;

@NoArgsConstructor
public class PrintDescendingCommandBuilder implements CommandBuilder{
    @Override
    public Command build(String[] str) {
        if(str.length == 2) throw new ExtraArgumentException();
        return new PrintDescendingCommand(ConsoleManager.getUser());
    }
}
