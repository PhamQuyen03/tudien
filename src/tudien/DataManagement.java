/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tudien;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SâuBéNhỏ
 */
public class DataManagement {
    
    private static Map<String, String> listWord = new HashMap<>();
    
    public static void add(String word, String mean) {
        listWord.put(word.toLowerCase(), mean.toLowerCase());
    }
    public static void saveData() {
        
        try {
            FileOutputStream fileOutput = new FileOutputStream("inOut.txt");
            ObjectOutputStream objOutputStream = new ObjectOutputStream(fileOutput);
            objOutputStream.writeObject(listWord);
            objOutputStream.flush();
            objOutputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void loadData() {
        try {
            File file = new File("inOut.txt");
            if (!file.exists()) {
                file.createNewFile();
                return;
            }
            FileInputStream fileInput = new FileInputStream("inOut.txt");
            ObjectInputStream objInputStream = new ObjectInputStream(fileInput);
            listWord = (HashMap<String, String>) objInputStream.readObject();
            objInputStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataManagement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getMean(String key) {
        return listWord.get(key);
    }
}
