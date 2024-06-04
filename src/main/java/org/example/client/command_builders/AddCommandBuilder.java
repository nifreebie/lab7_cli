package org.example.client.command_builders;

import lombok.NoArgsConstructor;
import org.example.client.utils.ConsoleManager;
import org.example.client.utils.ProductCreator;
import org.example.contract.command.AddCommand;
import org.example.contract.command.Command;
import org.example.contract.exceptions.ExtraArgumentException;
import org.example.contract.model.ProductDTO;
import org.example.contract.model.User;

import java.io.Console;

@NoArgsConstructor
public class AddCommandBuilder implements CommandBuilder {
    @Override
    public Command build(String[] str) {
        if(str.length == 2) throw new ExtraArgumentException();
        ProductCreator productCreator = new ProductCreator();
        ProductDTO productDTO = productCreator.createNewProduct();
        User user = ConsoleManager.getUser();
        return new AddCommand(productDTO, user);
    }
}
