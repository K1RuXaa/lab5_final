package spaceMarines;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import java.io.Serializable;
import java.time.LocalDateTime;


import static spaceMarines.MyScanner.Scan;

public class SpaceMarine implements Serializable {
    /**
     * Главный класс объекта
     */

        private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
        private String name; //Поле не может быть null, Строка не может быть пустой
        private Coordinates coordinates = new Coordinates(); //Поле не может быть null
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm-ss")
        private LocalDateTime creationDate = LocalDateTime.now(); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        private long health; //Значение поля должно быть больше 0
        private boolean loyal;
        private Weapon weaponType; //Поле может быть null
        private MeleeWeapon meleeWeapon; //Поле может быть null
        private Chapter chapter; //Поле может быть null

        public SpaceMarine(){
                setId();

        }


        public void setName(String name) {
                this.name = name;
        }

        public void setCoordinates(Coordinates coordinates) {
                this.coordinates = coordinates;
        }

        public void setCreationDate(LocalDateTime creationDate) {
                this.creationDate = creationDate;
        }

        public void setHealth(long health) {
            if (health > 0){
                this.health = health;
            }else {
                this.health = 1;
            }

        }

        public void setLoyal(boolean loyal) {

            this.loyal = loyal;

        }

        public void setWeaponType(Weapon weaponType) {
                this.weaponType = weaponType;
        }

        public void setMeleeWeapon(MeleeWeapon meleeWeapon) {
                this.meleeWeapon = meleeWeapon;
        }

        public void setChapter(Chapter chapter) {
                this.chapter = chapter;
        }

        public long getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public Coordinates getCoordinates() {
                return coordinates;
        }

       public LocalDateTime getCreationDate() {
            return creationDate;
        }

        public long getHealth() {
                return health;
        }

        public boolean isLoyal() {
                return loyal;
        }

        public Weapon getWeaponType() {
                return weaponType;
        }

        public MeleeWeapon getMeleeWeapon() {
                return meleeWeapon;
        }

        public Chapter getChapter() {
                return chapter;
        }
        public void setId(long id){
            this.id = id;
        }





        public void setId(){
                this.id = (int) (Math.random() * 1000000)+1; //только целая часть + 1 тк > 0
        }
        //пришлость сделать паблик тк взял за значение и его надо менять (для команды)

        @Override
        public String toString(){
                return ("Name: "+name+ "\nid: "+ id + "\nКоординаты: "+ coordinates+"\nhealth: "+ health+
                        "\nweaponType: "+ weaponType + "\nmeleeWeapon: "+meleeWeapon+"\nChapter: "+ chapter +"\nloyal: " + loyal+ "\nДата: " + creationDate);
        }





}
