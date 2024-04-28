package commandProvider.commands;

import commandProvider.CompareSpaceMarine;
import spaceMarines.*;

import java.util.Collections;
import java.util.LinkedList;

import static spaceMarines.MyScanner.Scan;

/**
 * add a new element to the collection
 *
 * @param collection collection where we store SpaceMarine objects
 * @param CSM Comparator to sort
 * */
public class Add {
    public static void AddCommand(LinkedList collection, CompareSpaceMarine CSM){
        SpaceMarine sp = new SpaceMarine();
        while (true) {
            System.out.print("Введите имя: ");
            String name = Scan();
            if (name.replaceAll(" ", "").equals("")) {
                System.out.println("Вы ввели пустую строчку! Имя не может быть пустой строчкой.");
            }else {
                sp.setName(name);
                break;
            }
        }
        while (true){
            boolean loyal = true;
            System.out.println("Будет ли десантник верным? (Да/Нет)");
            String isLoyal = Scan();
            isLoyal.replaceAll(" ", "");
            if (isLoyal.equals("Да")){
                sp.setLoyal(loyal);
                break;
            } else if (isLoyal.equals("Нет")) {
                loyal = false;
                sp.setLoyal(loyal);
                break;
            }else {
                System.out.println("Введите Да или Нет");
            }
        }
        Coordinates coordinates = new Coordinates();
        coordinates.makeCoordinates();
        sp.setCoordinates(coordinates);
        while(true){
            System.out.print("Введите значение больше 0 (long)health: ");
            try{
                String sHealth = Scan();
                long health = Long.parseLong(sHealth);
                if (health<=0){
                    System.out.println("Значение health должно быть больше 0!");
                }else{
                    sp.setHealth(health);
                    break;
                }
            }catch(NumberFormatException e){
                System.out.println("Надо ввести long!");
            }
        }

        try {
            while (true){
                Weapon weaponType;
                System.out.println("Хотите ли вы выдать оружие? (1 - Да или 0 - Нет)");
                int weaponDecide = Integer.parseInt(Scan());
                if (weaponDecide == 0){
                    weaponType = null;
                    sp.setWeaponType(weaponType);
                    break;
                }else{
                    System.out.println("Выберите оружие (BOLTGUN/BOLT_RIFLE/COMBI_PLASMA_GUN/FLAMER/INFERNO_PISTOL)");
                    String weaponChoice = Scan();
                    weaponChoice.replaceAll(" ","");
                    if (weaponChoice.equals("BOLTGUN") || weaponChoice.equals("BOLT_RIFLE") || weaponChoice.equals("COMBI_PLASMA_GUN") || weaponChoice.equals("FLAMER") || weaponChoice.equals("INFERNO_PISTOL")){
                        switch (weaponChoice){
                            case "BOLTGUN":
                                weaponType = Weapon.BOLTGUN;
                                sp.setWeaponType(weaponType);
                                break;
                            case "BOLT_RIFLE":
                                weaponType = Weapon.BOLT_RIFLE;
                                sp.setWeaponType(weaponType);
                                break;
                            case "COMBI_PLASMA_GUN":
                                weaponType = Weapon.COMBI_PLASMA_GUN;
                                sp.setWeaponType(weaponType);
                                break;
                            case "FLAMER":
                                weaponType = Weapon.FLAMER;
                                sp.setWeaponType(weaponType);
                                break;
                            case "INFERNO_PISTOL":
                                weaponType = Weapon.INFERNO_PISTOL;
                                sp.setWeaponType(weaponType);
                                break;
                        }
                        break;
                    }else {
                        System.out.println("Выберите один из предложенный вариантов");
                    }
                }
            }
        }catch (NumberFormatException e){
            System.out.println("Введите 1 или 0");
        }
        while (true) {
            try {
                System.out.println("Хотите ли вы дать оружие ближнего боя? Да - 1, Нет - 0");
                int weaponDecide;
                MeleeWeapon meleeWeapon;
                weaponDecide = Integer.parseInt(Scan());
                if (weaponDecide == 0){
                    meleeWeapon = null;
                    sp.setMeleeWeapon(meleeWeapon);
                    break;
                }else {
                    System.out.println("Введите оружие ближнего боя (CHAIN_SWORD,CHAIN_AXE,MANREAPER,POWER_BLADE,POWER_FIST)");
                    String meleeWeaponChoice;
                    meleeWeaponChoice = Scan();
                    meleeWeaponChoice.replaceAll(" ", "");
                    if (meleeWeaponChoice.equals("CHAIN_SWORD") || meleeWeaponChoice.equals("CHAIN_AXE") | meleeWeaponChoice.equals("MANREAPER") || meleeWeaponChoice.equals("POWER_BLADE") || meleeWeaponChoice.equals("POWER_FIST")) {
                        switch (meleeWeaponChoice) {
                            case "CHAIN_SWORD":
                                meleeWeapon = MeleeWeapon.CHAIN_SWORD;
                                sp.setMeleeWeapon(meleeWeapon);
                                break;
                            case "CHAIN_AXE":
                                meleeWeapon = MeleeWeapon.CHAIN_AXE;
                                sp.setMeleeWeapon(meleeWeapon);
                                break;
                            case "MANREAPER":
                                meleeWeapon = MeleeWeapon.MANREAPER;
                                sp.setMeleeWeapon(meleeWeapon);
                                break;
                            case "POWER_FIST":
                                meleeWeapon = MeleeWeapon.POWER_FIST;
                                sp.setMeleeWeapon(meleeWeapon);
                                break;
                            case "POWER_BLADE":
                                meleeWeapon = MeleeWeapon.POWER_BLADE;
                                sp.setMeleeWeapon(meleeWeapon);
                                break;
                        }
                        break;
                    } else {
                        System.out.println("Введите одно из доступных оружий!");
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("Введите 1 или 0!");
            }



        }
        int chapterChoice;
        while (true) {
            try {
                System.out.println("Хотите добавить chapter? Для ответа \"Да\" введите 1 иначе введите 0");
                chapterChoice = Integer.parseInt(Scan());
                if (chapterChoice != 1 && chapterChoice != 0) {
                    System.out.println("Введите 1 или 0!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Надо ввести число! (int)");
            }
        }
        Chapter chapter = new Chapter();
        switch (chapterChoice){

            case 1:

                chapter.makeChapter();
                sp.setChapter(chapter);
                break;
            case 0:
                sp.setChapter(chapter);
                break;
        }
        collection.add(sp);
        Collections.sort(collection, CSM);
    }
}
