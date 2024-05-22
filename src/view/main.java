/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


/**
 *
 * @author LENOVO
 */
public class main {
    
    public static void main(String[] args){
        
        MainView v = new MainView();
        v.setVisible(true);
        v.setLocationRelativeTo(null);
        v.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    

}
