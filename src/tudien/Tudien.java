/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tudien;

/**
 *
 * @author SâuBéNhỏ
 */
public class Tudien {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataManagement.loadData();
        Search srch = new Search();
        srch.setVisible(true);
        srch.pack();

    }

}
