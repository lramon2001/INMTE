/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasramon.inmte;

import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    //Atributos da classe Principal
    private static Cadastros cadastros;
    
    public static void main(String[] args) {
       cadastros=new Cadastros();
       menu();
    }
    public static void menu(){
        int x;
        do{
            
            String menu="1-Entrar com dados"+"\n"+
                                 "2-Exibir as temperaturas médias registradas"+"\n"+
                                 "3-Exibir as temperaturas mínimas registradas "+"\n"+
                                 "4-Exibir as temperaturas máximas registradas"+"\n"+
                                 "5-Emitir relatórios metereológicos"+"\n"+
                                 "0- para sair do programa";
            String strx=JOptionPane.showInputDialog(null, menu);
            x=Integer.parseInt(strx);
            switch(x){
                case 1:
                    cadastros.cadastrar();
                    break;
                case 2:
                    cadastros.imprimirTempsMed();
                    break;
                case 3:
                    cadastros.imprimirTempsMin();
                    break;
                case 4:
                    cadastros.imprimirTempsMax();
                    break;     
                case 5:
                    cadastros.imprimirRelatorios();
                    break; 
                case 0:
                    JOptionPane.showMessageDialog(null, "Obrigado por usar nosso software \n \n\nMIT License © Maicon Rodrigues \nMIT License © Lucas Ramon");
                    x=0;
                    break;                
            }
            
        }
        while(x!=0);
        
    }
}
