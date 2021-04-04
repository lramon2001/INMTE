/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasramon.inmte;
import javax.swing.JOptionPane;
import com.lucasramon.inmte.RelatórioMetereológico;
/**
 *
 * @author Lucas
 */
public class Cadastros {
    // Atributos da classe cadastros 
    private RelatórioMetereológico[] relatorios;
    
    //Construtores da classe cadastros
    
    public Cadastros(){
        this.relatorios=new RelatórioMetereológico[0];
        
    }

    public Cadastros(RelatórioMetereológico[] relatorios) {
        this.relatorios = relatorios;
    }

    //Começo dos getters e setters
    public RelatórioMetereológico[] getRelatorios() {
        return relatorios;
    }

    public void setRelatorios(RelatórioMetereológico[] relatorios) {
        this.relatorios = relatorios;
    }
    
    // Fim dos getters and setters 
    
    //Função que coloca um novo relatorio no array
    public void cadastrar() {
         //Criando o objeto relatório 
        RelatórioMetereológico relatório = new RelatórioMetereológico();
        //Buscando do usuário informações sobre o relatório e Fazendo validação do mes ano
        boolean valido=false;
        int nMes;
        int nAno;
        for(int i=0;valido!=true;i++){
             String strnMes=JOptionPane.showInputDialog("Entre com o número do mês:\n\n\n"
                + "ex:Declare janeiro como 1."
                );
                 
        String strnAno=JOptionPane.showInputDialog("Entre com o número do ano:\n\n\n "+
                "Ano deve pertencer ao intervalo fechado de 2011 e 2020.");
        
         //Convertendo para int os inputs vindos do JOptionPane
          nMes=Integer.parseInt(strnMes);
          nAno=Integer.parseInt(strnAno);        
          
            if( (nAno < 2011 || nAno > 2020) || (nMes < 1 || nMes > 12) ) {
                
			valido= false;
                        JOptionPane.showMessageDialog(null, "Digite um mês e/ou ano válidos ");
		}else {
                 //Settando os inputs no objeto para rodar as funções necessárias para de fato cadastras a temperaturas (obtemTamMes e CalculaTemps)
                                                relatório.setnMes(nMes);
                                                relatório.setnAno(nAno);
			valido= true;
		}
        }
        
        //Rodando as funções mega importantes da classe Relatório Metereológico  para cadastro.Covém ler a implementação delas, meu chapa
        relatório.obtemTamanhoMes();
        relatório.calculaTemps(relatório.getTamMes());
        
        /*
        1-Criar um array temporário tempRelatorios com uma posição a mais que relatorios;
        2-Copiar o vetor relatórios pro TempRelatorios;
        3-Alocar relatório em TempRelatorios;
        4-Atualizar a referência de relatórios.     
        */
        //1
        RelatórioMetereológico[] tempRelatorios=new RelatórioMetereológico[relatorios.length+1];
        
        //2
        for(int i=0;i<relatorios.length;i++){
            tempRelatorios[i]=relatorios[i];
        }
        
        //3
        tempRelatorios[tempRelatorios.length-1]=relatório;
        
        //4
        setRelatorios(tempRelatorios);
              
    }
    
    //Imprime todas as temp média dos meses cadastrados
    public void imprimirTempsMin(){
        
        //Juntando todas as temp min com referencia de ano de mês;
        String resposta="";
        for(int i=0;i<relatorios.length;i++){
                    resposta+= relatorios[i].getnMes()+ "/ "+relatorios[i].getnAno()+"\n"+
                    "Temperatura mínima: "+relatorios[i].getTempMin()+" °C"+"\n"
                    ;     
        }
        JOptionPane.showMessageDialog(null, resposta);
    }
    
    //Imprime todas as temp máxima dos meses cadastrados
    public void imprimirTempsMax(){
        //Juntando todas as temp max com referencia de ano de mês;
        String resposta="";
        for(int i=0;i<relatorios.length;i++){
                    resposta+= relatorios[i].getnMes()+ "/"+relatorios[i].getnAno()+"\n"+
                    "Temperatura máxima: "+relatorios[i].getTempMax()+" °C"+"\n"
                    ;
           
            
        }
         JOptionPane.showMessageDialog(null, resposta);
    }
    
    //imprime todas as temperaturas médias dos meses cadastrados
     public void imprimirTempsMed(){
        //Juntando todas as temp min com referencia de ano de mês;
        String resposta="";
        for(int i=0;i<relatorios.length;i++){
                    resposta+= relatorios[i].getnMes()+ "/"+relatorios[i].getnAno()+"\n"+
                    "Temperatura média: "+relatorios[i].getTempMed()+" °C"+"\n"
                    ;
          
            
        }
          JOptionPane.showMessageDialog(null, resposta);
    }
     
     //imprime todos os relátorios dos meses cadatrados
     public void imprimirRelatorios(){
        //Juntando todas as temp min com referencia de ano de mês;
        String resposta="";
        for(int i=0;i<relatorios.length;i++){
                    resposta+= relatorios[i].getnMes()+ "/"+relatorios[i].getnAno()+"\n"+
                    "Temperatura mínima: "+relatorios[i].getTempMin()+" °C"+"\n"+
                    "Temperatura máxima: "+ relatorios[i].getTempMax()+" °C"+"\n"+
                    "Temperatura média: "+ relatorios[i].getTempMed()+" °C"+"\n"
                    
                    ;
         
            
        }
           JOptionPane.showMessageDialog(null, resposta);
    }
    
}
