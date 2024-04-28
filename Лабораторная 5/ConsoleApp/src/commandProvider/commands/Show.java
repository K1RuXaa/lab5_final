package commandProvider.commands;

import java.util.LinkedList;


public class Show {
    /**
     * Показывает коллекцию
     * @param collection
     */
    public static void ShowCommand(LinkedList collection){
        for (Object o : collection) {
            System.out.println(o);
            System.out.println();
        }
    }
}
