/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import model.Text;


public class Nomalize {
    
    public static void readAndWrite(){
        BufferedReader br = null;
        try {
            int countLine = Text.countLine();
            int count = 1;
            br = new BufferedReader(new FileReader(new File("input.txt")));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.txt", true)));
            String line;
            while ((line = br.readLine()) != null) {
                if (Text.isLineEmpty(line)) {
                    continue;
                }
                line = Text.formatOneSpace(line);
                line = Text.formatSpecialCharacters(line);
                line = Text.afterDotUpperCase(line);
                line = Text.noSpaceQuotes(line);
                line = Text.firstUpercase(line);
                line = Text.lastAddDot(line);
                pw.print(line);
                if (count < countLine) {
                    pw.print(System.getProperty("line.separator"));
                }
                count++;
            }
            br.close();
            pw.close();
            System.out.println("Normalize successful.");
        } catch (FileNotFoundException ex) {
            System.err.println("Can't not found");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    
}
