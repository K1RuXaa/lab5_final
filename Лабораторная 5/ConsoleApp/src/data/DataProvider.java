package data;

import spaceMarines.SpaceMarine;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class DataProvider {
    /**
     * Класс, который работает с файлами для загрузки и сохраниния
     * @param collection
     * @param fileName
     */
    public void Save(LinkedList<SpaceMarine> collection,String fileName){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            outputStream.writeObject(collection);

        }catch (Exception e){
            System.out.println("Нет доступа к файлу или мб неправильное название from dp");
        }
    }
    public LinkedList<SpaceMarine> Load(String fileName){
        System.out.println(fileName);
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName));
            LinkedList<SpaceMarine> loadList = (LinkedList<SpaceMarine>) inputStream.readObject();
            System.out.println("<=<=<=<=<=<=<=<=<=<=<=<=<=<=<=<=<=<=<=<=");
            System.out.println("Успешно загружено");
            return loadList;
        }catch (Exception e){
            System.out.println("Файл не найден или то что вы хотите загрузить не является коллекцией");
            return new LinkedList<SpaceMarine>();
        }
    }
    public ArrayList<String> LoadScript(String fileName){ // парсим команды в LinkedList

        ArrayList<String> lines = new ArrayList<String>();
        try{
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();//убираем пробелы
                lines.add(line);}
        }catch (FileNotFoundException e){
            System.out.println("К файлу нету доступа или он отсутствует!");
        }
        return lines;
    }
}
