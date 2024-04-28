import commandProvider.CommandManager;
import spaceMarines.SpaceMarine;

import java.util.LinkedList;

import static commandProvider.CommandManager.idSolve;
import static commandProvider.commands.Help.HelpCommand;
import static data.ObjectReader.BackParseToJson;
import static spaceMarines.MyScanner.Scan;

//todo Валидация id, аргумент командной, валидация id с add, remove_lower)
// todo дописать в commandManager успешно добавлен, remove_lover, execute_update id, надо сплитануть массив как CommandToWords и все гуд

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String fileName = "";
        try {
            fileName = args[0];
            LinkedList<SpaceMarine> newcollection = BackParseToJson(fileName);
            System.out.println("Загруженный файл: " + fileName);
            CommandManager server = new CommandManager();
            idSolve(newcollection);
            server.setCollection(newcollection);
            HelpCommand();
            while (true) {
                server.CommandChecker(Scan());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Кажется, вы забыли передать имя файла");
        }
    }

}