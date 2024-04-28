package commandProvider.commands;

import data.DataProvider;
import spaceMarines.SpaceMarine;

import java.util.LinkedList;


import static spaceMarines.MyScanner.Scan;
/**
 * display information
 * <p>
 * display information about the collection to standard output
 *
 * @param collection collection where we store SpaceMarine objects
 * */


public class Load { // реализация в DataProvider
    /**
     * \
     * @param dp
     * @return
     */
    public static LinkedList<SpaceMarine> LoadCommand(DataProvider dp){
        System.out.print("Введите имя файл, который хотите загрузить ");
        return dp.Load(Scan());
    }
}
