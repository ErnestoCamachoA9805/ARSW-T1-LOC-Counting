package edu.escuelaing.app;

import java.io.*;
public class LOCcount{
    private static String flags[]= {"phy","loc"}; 
    public static void main(String[] args){
        String comando= args[0];
        File file= new File(args[1]);
        if(comando.equals(flags[0])){
            System.out.println("The amount of lines counted was: " + phyCount(file));     
        }else if(comando.equals(flags[1])){
            System.out.println("The amount of lines counted was: " + locCount(file));
        }
        else{
            System.out.println("Command not recognized");
        }
     }

     public static int phyCount(File inFile){
         /**
          * this Function returns the amout of lines int an archive, or archives in a directory and prints all lines
          * @param inFile : File -> the archive or diectory
          * @return int : counter -> the amount of lines in an archive  or archives in a directory
          */
          int counter= 0;
          if (inFile.isDirectory()){
              for(File fileEntry: inFile.listFiles()){
                counter+= phyCount(fileEntry);
              }   
          }
          System.out.println(inFile.getName());
          try{
            BufferedReader br= new BufferedReader(new FileReader (inFile));
            String currentString;
            while ((currentString= br.readLine()) != null){
                System.out.println(currentString);
                counter+=1;
            }
            br.close();
          }catch(IOException e){
              System.out.println("File not Found");
          }
          System.out.println();
          return counter;
     }

     public static int locCount(File inFile){
        /**
         * this Function returns the amout of lines int an archive, or archives in a directory and prints all lines 
         * @param inFile : File -> the archive or diectory
         * @return int : counter -> the amount of lines in an archive  or archives in a directory(ignores blank or comented lines)
         */
         int counter= 0;
         if (inFile.isDirectory()){
             for(File fileEntry: inFile.listFiles()){
               counter+= phyCount(fileEntry);
             }   
         }
         System.out.println(inFile.getName());
         try{
           BufferedReader br= new BufferedReader(new FileReader (inFile));
           String currentString;
           while ((currentString= br.readLine()) != null){
               currentString= currentString.replace(" ", "");
               if((currentString.length() != 0)){
                   if((currentString.charAt(0)!= '*') && (currentString.charAt(0)!= '/')){
                    System.out.println(currentString);
                    counter+=1;
                   }
               }
           }
           br.close();
         }catch(IOException e){
             System.out.println("File not Found");
         }
         System.out.println();
         return counter;
    }
}
