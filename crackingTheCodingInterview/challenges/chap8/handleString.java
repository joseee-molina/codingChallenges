package chap8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class handleString {
    public handleString() throws IOException {
    }

    public String deleteStringLineJumps(String s){
        String res = "";
        for(int i = 0 ; i<s.length();i++){
            if(s.charAt(i)== '\n'){
                res+="-";
                continue;
            }
            res+=s.charAt(i);
        }
        return res;
    }

    public static void states(){
        String states = "Aguascalientes\n" +
                "Baja California\n" +
                "Baja California Sur\n" +
                "Campeche\n" +
                "Chiapas\n" +
                "Chihuahua\n" +
                "Coahuila de Zaragoza\n" +
                "Colima\n" +
                "Durango\n" +
                "Estado de México\n" +
                "Guanajuato\n" +
                "Guerrero\n" +
                "Hidalgo\n" +
                "Jalisco\n" +
                "Michoacán de Ocampo\n" +
                "Morelos\n" +
                "Nayarit\n" +
                "Nuevo León\n" +
                "Oaxaca\n" +
                "Puebla\n" +
                "Querétaro\n" +
                "Quintana Roo\n" +
                "San Luis Potosí\n" +
                "Sinaloa\n" +
                "Sonora\n" +
                "Tabasco\n" +
                "Tamaulipas\n" +
                "Tlaxcala\n" +
                "Veracruz de Ignacio de la Llave\n" +
                "Yucatán\n" +
                "Zacatecas";
        List<String> items = Arrays.asList(states.split("\n"));
        System.out.print("[");
        for(String s : items){
            System.out.print("'"+s+"',");
        }
        System.out.print("]");

    }


    public static void readingFile() throws IOException {
        File file = new File("/Users/joseoctavio/Documents/jose octavio molina nava - about me - sobre mi/INTERNSHIPS DOCS/codingPrep/crackingTheCodingInterview/challenges/chap8/ladas.txt");
        Scanner sc = new Scanner(file);
        //System.out.print('{');
        while (sc.hasNextLine()) {
            String currLine = sc.nextLine();
            List<String> items = Arrays.asList(currLine.split(" "));
            //System.out.println(items);
            try {
                String lada = items.get(items.size() -1);
                String state =items.get(items.size()-4).substring(0,items.get(items.size()-4).length()-1);
                if(state.equals("Roo")){
                    state = "Quintana Roo";
                }
                if(state.equals("México")){
                    if(items.get(items.size()-6).equals("Estado")) {
                        state = "Estado de México";
                    }
                }
                if(state.equals("México)")){
                    state="Ciudad de México";
                }
                if(state.equals("California")){
                    state="Baja California";
                }
                if(state.equals("Sur")){
                    state="Baja California Sur";
                }
                if(state.equals("Camp")){
                    state="Campeche";
                }
                if(state.equals("León")){
                    state="Nuevo León";
                }
                if(state.equals("Potosí")){
                    state="San Luis Potosí";
                }

                System.out.print( lada+":'"+state+"',");
            }
            catch (IndexOutOfBoundsException e){
                continue;
            }

        }
        //System.out.println("}");
    }

    public static void main(String[] args) throws IOException {
        readingFile();
        //states();
    }

}
