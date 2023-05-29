import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Libreria recoger input
        File file = new File("C:\\Users\\Jesus\\Desktop\\countdown.txt"); //Archivo de countdown

        if(!file.exists()){
            try {
                file.createNewFile();
            }catch(Exception ex){
                System.out.println("Ha ocurrido un error");
            }
        }

        //Minutos del contador
        int time = 5;
        //Convertir los minutos a segundos
        int counter = time * 60;

        do {
            try {
                //Abrir la escritura al archivo
                FileWriter fw = new FileWriter(file);
                //Abrir el buffer de lectura al archivo
                BufferedWriter bfw = new BufferedWriter(fw);
                int hours = (counter / 3600); //Calcular las horas
                int minutes = (counter % 3600) / 60; // Calcular los minutos
                int seconds = counter % 60; //Calcular los segundos

                //formatear el timer
                String textToWrite = padLeftZeros(minutes + "", 2) + ":" + padLeftZeros(seconds + "", 2);

                bfw.write(textToWrite); //Escribir el tiempo en el archivo
                bfw.close(); //Cerrar buffer de lectura
                counter--; //Restar un segundo
                Thread.sleep(1000); //Esperar un segundo
            }catch (Exception ex) {
                System.out.println("Ha ocurrido un error, Por favor contacta con el soporte");
            }
        }while(counter>0);
        System.exit(0); //Cuando el contador llega a cero mata el programa
    }

    //Metodo la rellenar con ceros el temporizador (00:00:00)
    public static String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }
}
