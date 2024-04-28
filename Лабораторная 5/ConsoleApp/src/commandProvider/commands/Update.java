package commandProvider.commands;

import commandProvider.CompareSpaceMarine;
import spaceMarines.SpaceMarine;

import java.util.LinkedList;

import static commandProvider.commands.Add.AddCommand;
import static commandProvider.commands.Remove.RemoveCommand;

/**
 * Обновляет элемент по id
 */
public class Update {
    public static LinkedList<SpaceMarine> UpdateCommand(LinkedList<SpaceMarine> collection, String[] commandToWords){
        CompareSpaceMarine CSM = new CompareSpaceMarine();
        int count = 0;
        SpaceMarine sp;

            try {
                boolean isId = true;
                int cmId = Integer.parseInt(commandToWords[2]);
                for (SpaceMarine obj : collection){
                    if (cmId == obj.getId()){
                        long previousId = obj.getId();
                        collection.remove(obj);
                        AddCommand(collection,CSM);
                        sp = collection.get(count);
                        sp.setId(previousId);
                        collection.remove(count);
                        collection.add(sp);
                        System.out.println("Объект обновлен! Новое значение: " + sp.getName() + " " + String.valueOf(sp.getId()));
                        isId = false;
                        break;

                    }
                    count+=1;
                }
                if (isId == true){
                    System.out.println("Значения с таким id нет");
                }
            }catch (NumberFormatException e){
                System.out.println("Ошибка ввода id");
            }
        return collection;
    }
}
