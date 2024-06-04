package org.example.contract.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.contract.model.User;

@AllArgsConstructor
@Getter
public class PrintDescendingCommand implements Command{
    private User user;
}
