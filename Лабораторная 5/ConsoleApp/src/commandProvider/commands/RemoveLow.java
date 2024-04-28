package commandProvider.commands;

import spaceMarines.SpaceMarine;

import java.util.ArrayList;
import java.util.LinkedList;

public class RemoveLow {
    public static void RemoveLower(LinkedList<SpaceMarine> collection,String[] ComandToWords){
        int count = 0;
        ArrayList<Integer> array = new ArrayList<>();
        int id = Integer.parseInt(ComandToWords[1]);
        for (SpaceMarine sp : collection){
            if (sp.getId() < id){
                array.add(count);

            }
            count++;
        }
        int count2 = 0;
        for (int i = 0; i < array.size();i++){
            int index = array.get(i) - count2;
            collection.remove(index);
            count2+=1;



        }
        System.out.println("Удаление произведено");
    }
}
