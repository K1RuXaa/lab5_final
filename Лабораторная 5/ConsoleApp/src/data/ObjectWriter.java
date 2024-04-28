package data;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;

import spaceMarines.SpaceMarine;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class ObjectWriter {
    /**
     * Преобразуем коллекцию в JSON и записываем в файл
     *
     * @param collection
     * @param fileName
     */

    public static void parseToJson(LinkedList<SpaceMarine> collection,String fileName){
        ObjectMapper mapper = new ObjectMapper();

        try {

            mapper.writeValue(new File(fileName), collection);

            System.out.println("Объект успешно записан в файл " + fileName);
        } catch (IOException e) {
            // Обработка исключения, если что-то пошло не так при записи
            System.out.println(e.getMessage());
        }
    }
}
