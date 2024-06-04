package org.example.client.command_builders;

import org.example.client.utils.ConsoleManager;
import org.example.contract.command.Command;
import org.example.contract.command.ShowCommand;
import org.example.contract.exceptions.ExtraArgumentException;

public class ShowCommandBuilder implements CommandBuilder{
    @Override
    public Command build(String[] str) {
        if(str.length == 2) throw new ExtraArgumentException();
        return new ShowCommand(ConsoleManager.getUser());
    }
}
