package commandProvider.commands;

import Exceptions.RecursionException;
import commandProvider.CommandManager;
import data.DataProvider;
import spaceMarines.*;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import static commandProvider.commands.Add.AddCommand;

/**
 * execute script
 * <p>
 * read and execute the script from the specified file. The script contains commands in the same form in which the user enters them interactively.
 *  */
//todo Поменять marine на collection.get(index) = marine ; сплитануть array по пробелу если встречается двусоставная команда смотрим на некст элемент и юзаем командчекер или просто команду с параметром команды
    //todo ошибка в том что создает 2 hashset а надо 1/ половину сделал надо сетнуть хэшСет)
public class ExecuteScriptCommand{
    static HashSet<String> fileSet = new HashSet<>();
    public static LinkedList<SpaceMarine> ExecuteScript(String fileName, DataProvider dp,LinkedList<SpaceMarine> collection) throws RecursionException {
        ArrayList<String> lines = dp.LoadScript(fileName);
        String[] array = lines.toArray(new String[0]);
        String[] commandToWords;
        CommandManager cm = new CommandManager();
        HashSet<String> commandSet = new HashSet<>();
        cm.setCollection(collection);
        commandSet.addAll(lines);
        if (fileSet.contains(fileName)) {
            throw new RecursionException("Кажется, вы пытаетесь запустить скрипт в скрипте");

        }
        fileSet.add(fileName);


        int i = 0;
        try {
            while (i < array.length) {
                commandToWords = array[i].split(" ");
                String command = commandToWords[0];
                if (array[i].equals("add")) {
                    SpaceMarine marine = new SpaceMarine();
                    Chapter chap = new Chapter();
                    Coordinates cor = new Coordinates();
                    marine.setName(array[i + 1]);
                    if (array[i + 2].equals("Да")) {
                        marine.setLoyal(true);
                    } else {
                        marine.setLoyal(false);
                    }
                    cor.setX(Double.valueOf(array[i + 3]));
                    cor.setY(Double.parseDouble(array[i + 4]));
                    marine.setCoordinates(cor);
                    marine.setHealth(Long.parseLong(array[i + 5]));
                    if (array[i + 6].equals("1")) { // мб тут как в прошлом варианте сделать if-else
                        marine.setWeaponType(Weapon.valueOf(array[i + 7]));
                        if (array[i + 8].equals("1")) {
                            marine.setMeleeWeapon(MeleeWeapon.valueOf(array[i + 9]));
                            if (array[i + 10].equals("1")) {
                                chap.setName(array[i + 11]);
                                chap.setParentLegion(array[i + 12]);
                                marine.setChapter(chap);
                                collection.add(marine);
                                i = i + 13;
                            }
                        } else {
                            if (array[i + 9].equals("1")) {
                                chap.setName(array[i + 10]);
                                chap.setParentLegion(array[i + 11]);
                                marine.setChapter(chap);
                                collection.add(marine);
                                i = i + 12;
                            }
                        }

                    } else {
                        if (array[i + 7].equals("1")) {
                            marine.setMeleeWeapon(MeleeWeapon.valueOf(array[i + 8]));
                            if (array[i + 9].equals("1")) {
                                chap.setName(array[i + 10]);
                                chap.setParentLegion(array[i + 11]);
                                marine.setChapter(chap);
                                collection.add(marine);
                                i = i + 12;
                            }
                        } else {
                            if (array[i + 8].equals("1")) {
                                chap.setName(array[i + 9]);
                                chap.setParentLegion(array[i + 10]);
                                marine.setChapter(chap);
                                collection.add(marine);
                                i = i + 11;
                            }
                        }
                        i = i + 9;
                        collection.add(marine);
                    }


                } else if (command.equals("update") && commandToWords.length == 3) {
                    int count = 0;


                    try {
                        boolean isId = true;
                        int cmId = Integer.parseInt(commandToWords[2]);
                        for (SpaceMarine obj : collection) {
                            if (cmId == obj.getId()) {
                                long previousId = obj.getId();
                                collection.remove(obj);
                                SpaceMarine marine = new SpaceMarine();
                                Chapter chap = new Chapter();
                                Coordinates cor = new Coordinates();
                                marine.setName(array[i + 1]);
                                if (array[i + 2].equals("Да")) {
                                    marine.setLoyal(true);
                                } else {
                                    marine.setLoyal(false);
                                }
                                cor.setX(Double.valueOf(array[i + 3]));
                                cor.setY(Double.parseDouble(array[i + 4]));
                                marine.setCoordinates(cor);
                                marine.setHealth(Long.parseLong(array[i + 5]));
                                if (array[i + 6].equals("1")) { // мб тут как в прошлом варианте сделать if-else
                                    marine.setWeaponType(Weapon.valueOf(array[i + 7]));
                                    if (array[i + 8].equals("1")) {
                                        marine.setMeleeWeapon(MeleeWeapon.valueOf(array[i + 9]));
                                        if (array[i + 10].equals("1")) {
                                            chap.setName(array[i + 11]);
                                            chap.setParentLegion(array[i + 12]);
                                            marine.setChapter(chap);
                                            collection.add(marine);
                                            i = i + 13;
                                        }
                                    } else {
                                        if (array[i + 9].equals("1")) {
                                            chap.setName(array[i + 10]);
                                            chap.setParentLegion(array[i + 11]);
                                            marine.setChapter(chap);
                                            collection.add(marine);
                                            i = i + 12;
                                        }
                                    }

                                } else {
                                    if (array[i + 7].equals("1")) {
                                        marine.setMeleeWeapon(MeleeWeapon.valueOf(array[i + 8]));
                                        if (array[i + 9].equals("1")) {
                                            chap.setName(array[i + 10]);
                                            chap.setParentLegion(array[i + 11]);
                                            marine.setChapter(chap);
                                            collection.add(marine);
                                            i = i + 12;
                                        }
                                    } else {
                                        if (array[i + 8].equals("1")) {
                                            chap.setName(array[i + 9]);
                                            chap.setParentLegion(array[i + 10]);
                                            marine.setChapter(chap);
                                            collection.add(marine);
                                            i = i + 11;
                                        }
                                    }
                                    i = i + 9;
                                    collection.add(marine);
                                }
                                marine = collection.get(count);
                                marine.setId(previousId);
                                collection.remove(count);
                                collection.add(marine);
                                System.out.println("Значение по id " + cmId + " обновлено");
                                isId = false;
                                break;
                            }
                            count += 1;
                        }
                        if (isId == true) {
                            System.out.println("Значения с таким id нет");
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка ввода id");
                    }
                } else {
                    cm.CommandChecker(array[i]);
                    i++;
                }

            }
        }catch (NumberFormatException e){
            System.out.println("Ошибка ввода данных");
        }
        fileSet.remove(fileName);
        return collection;
    }
}
