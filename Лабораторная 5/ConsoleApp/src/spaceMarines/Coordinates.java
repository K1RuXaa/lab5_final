package spaceMarines;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import static spaceMarines.MyScanner.Scan;

public class Coordinates implements Serializable {
        /**
         * Класс для координат
         */
        @JsonProperty("x")
        private Double x; //Значение поля должно быть больше -194, Поле не может быть null
        @JsonProperty("y")
        private double y; //Максимальное значение поля: 937



        public Coordinates(){

        }
        public Double getX() {
                return x;
        }

        public double getY() {
                return y;
        }
        public void setX(Double x) {
                if (x <= -194 || x == null ){
                        this.x = 1.0;
                }else {
                        this.x = x;
                }
        }

        public void setY(double y) {
                if (y > 937){
                        this.y = 1.0;
                }else {
                        this.y = y;
                }
        }
        public void makeCoordinates(){
                while (true){
                        try {
                                String sc;
                                System.out.println("Введите х >= -194");
                                sc = Scan();
                                sc.replaceAll(" ","");
                                if (sc == ""){
                                        System.out.println("Поле не может быть null!");
                                } else if (( x = Double.parseDouble(sc)) < -194) {
                                        System.out.println("х должен превышать -194");
                                }else {
                                        System.out.println("Координате х присвоилось значение: "+ x);
                                        setX(x);
                                        break;
                                }
                        }catch (NumberFormatException e){
                                System.out.println("Нужно ввести Double!");
                        }
                }
                while (true){
                        try {
                                System.out.println("Введите значение double(y) <= 937");
                                y = Double.parseDouble(Scan());
                                if (y <= 937){
                                        System.out.println("Координате y присвоилось значение: "+ y);
                                        setY(y);
                                        break;
                                }else{
                                        System.out.println("Число превышает заданный диапозон!");
                                }

                        }catch (NumberFormatException e){
                                System.out.println("Нужно ввести double!");

                        }
                }
        }
        @Override
        public String toString(){
                return ("x: "+String.valueOf(x)+", y: "+String.valueOf(y));
        }
}



