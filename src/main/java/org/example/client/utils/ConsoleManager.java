package org.example.client.utils;

import lombok.Getter;
import lombok.Setter;
import org.example.contract.exceptions.ExtraArgumentException;
import org.example.contract.exceptions.NoArgumentException;
import org.example.contract.model.User;
import org.example.contract.utils.BufferedLineReader;

import java.io.IOException;

public class ConsoleManager {
    private final Sender sender;
    @Getter
    @Setter
    private static boolean isAuth = false;
    @Getter
    @Setter
    private static User user;


    public ConsoleManager(Sender sender) {
        this.sender = sender;
    }

    public void run() {
        ClientAppContainer app = ClientAppContainer.getInstance();
        BufferedLineReader bufferedLineReader = app.getBufferedLineReader();
        ResponseHandler responseHandler = new ResponseHandler();
        AuthManager authManager = new AuthManager();
        System.out.println("Программа запущена, для регистрации введите 'sign_up', для входа введите 'sign_in'");
        System.out.print('>');
        while (!isAuth) {
            while (!isAuth && bufferedLineReader.hasNextLine()) {
                String aLine = bufferedLineReader.nextLine().trim();
                String[] prompt = aLine.trim().split("\\s+");
                while (prompt.length != 1) {
                    System.out.println("Пройдите процесс аутентификации!");
                    System.out.print('>');
                    aLine = bufferedLineReader.nextLine().trim();
                    prompt = aLine.trim().split("\\s+");
                }
                try {
                    System.out.println(responseHandler.handleResponse(sender.sendRequest(authManager.auth(prompt))));
                    System.out.print('>');
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (NullPointerException e) {
                    System.out.println("Пройдите процесс аутентификации!");
                    System.out.print('>');
                }


            }
        }
        System.out.println("Для получения списка команд введите 'help'");
        System.out.print('>');
        while (bufferedLineReader.hasNextLine()) {
            String line = bufferedLineReader.nextLine().trim();
            String[] prompt = line.trim().split("\\s+");
            while (prompt.length == 0 || prompt.length > 2) {
                System.out.println("Неверный формат ввода команды!");
                System.out.print('>');
                line = bufferedLineReader.nextLine().trim();
                prompt = line.trim().split("\\s+");
            }
            try {
                System.out.println(responseHandler.handleResponse(sender.sendRequest(CommandParser.getDTO(prompt))));
                System.out.print('>');
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NullPointerException e) {
                System.out.println("Команды " + prompt[0] + " не существует!");
                System.out.print('>');
            } catch (NoArgumentException e) {
                System.out.println("У команды должен быть аргумент!");
                System.out.print('>');
            } catch (ExtraArgumentException e) {
                System.out.println("У команды не должно быть аргумента!");
                System.out.print('>');
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат аргумента!");
                System.out.print('>');
            }

        }

    }
}
