/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.scrittura_file;

/**
 *
 * @author Alessio
 */


    

import java.io.*;
public class Scrittura_file {
    
    public Scrittura_file(String filename) throws IOException{
        PrintWriter output = new PrintWriter(new FileWriter(filename)); 
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String linea = input.readLine(); 
            while (!linea.equals("")) {
                output.println(linea); linea = input.readLine();
            }
            input.close(); output.close();
            }
    public static void main(String[] args) {
        try {
            Scrittura_file cp = new Scrittura_file(args[0]);
        }
        catch(IOException ex) { 
            System.out.println("Errore di I/O.");
            System.exit(1);
        }
    }
}



