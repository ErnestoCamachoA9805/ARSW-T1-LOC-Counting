package edu.escuelaing.app;

import java.io.*;

public class LOCcount{
    private static String flags[]= {"phy","loc"}; 
    public static void main(String[] args){
        String comando= args[0];
        if(comando.equals(flags[0])){
            String path= args[1];
            phyMethot(path);

        }
        else if(comando.equals(flags[1])){
            String path= args[1];
            locMethot(path);
        }
    }

    public static void phyMethot (String path){
        File inFile= new File(path);
        try{
            BufferedReader br= new BufferedReader(new FileReader(inFile));
            int counter= 0;
            String currentString;
            while ((currentString= br.readLine()) != null){
                System.out.println(currentString);
                counter+=1;
            }
            System.out.println("");
            System.out.println("El total de lineas contadas fueron: " + counter);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void locMethot (String path){
        File inFile= new File(path);
        try{
            BufferedReader br= new BufferedReader(new FileReader(inFile));
            int counter= 0;
            String currentString;
            while ((currentString= br.readLine()) != null){
                if(currentString.length() != 0){
                    System.out.println(currentString);
                    counter+=1;
                }
            }
            System.out.println("");
            System.out.println("El total de lineas contadas fueron: " + counter);
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
