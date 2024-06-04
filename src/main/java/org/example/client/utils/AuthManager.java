package org.example.client.utils;

import org.example.client.command_builders.CommandBuilder;
import org.example.client.command_builders.SignInCommandBuilder;
import org.example.client.command_builders.SignUpCommandBuilder;
import org.example.contract.command.Command;

import java.util.HashMap;

public class AuthManager {
    public HashMap<String, CommandBuilder> parser = new HashMap<>();
    public AuthManager(){
        parser.put("sign_in", new SignInCommandBuilder());
        parser.put("sign_up", new SignUpCommandBuilder());
    }
    public Command auth(String[] str){
        return parser.get(str[0]).build(str);
    }

}
