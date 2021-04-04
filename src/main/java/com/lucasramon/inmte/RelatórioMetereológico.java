/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucasramon.inmte;
import javax.swing.JOptionPane;

import java.util.Arrays;

/**
 *
 * @author Lucas
 */
public class RelatórioMetereológico {
    //Atributos da classe Relatório Metereológico
   
    private int nMes;
    private int nAno;
    private int tamMes;
    private double temperaturas[];
    private double tempMin;
    private double tempMax;
    private double tempMed;
  // Construtor vazio 
    
 public RelatórioMetereológico() {
     
    }
 // Construtor com todos os atributos
 
    public RelatórioMetereológico(int nMes, int nAno, int tamMes, double[] temperaturas, double tempMin, double tempMax, double tempMed) {
        this.nMes = nMes;
        this.nAno = nAno;
        this.tamMes = tamMes;
        this.temperaturas = temperaturas;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.tempMed = tempMed;
    }
//Começo dos getters e setters
    
    public int getnMes() {
        return nMes;
    }

    public void setnMes(int nMes) {
        this.nMes = nMes;
    }

    public int getnAno() {
        return nAno;
    }

    public void setnAno(int nAno) {
        this.nAno = nAno;
    }

    public int getTamMes() {
        return tamMes;
    }

    public void setTamMes(int tamMes) {
        this.tamMes = tamMes;
    }

    public double[] getTemperaturas() {
        return temperaturas;
    }

    public void setTemperaturas(double[] temperaturas) {
        this.temperaturas = temperaturas;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public double getTempMed() {
        return tempMed;
    }

    public void setTempMed(double tempMed) {
        this.tempMed = tempMed;
    }
// Fim dos getters e setters 
    
// Função que  verifica se o ano bissexto,será muito útil para a função obter tamanho do mês
    public boolean verificaBissexto() {
                                //atribui a variável local ano da função verificaBissexto o valor do ano
                                
		int ano = getnAno();
                
		//Condicional simples pautada na verificação do intervalo de 2011 a 2020
                
		if(ano == 2012 || ano == 2016 || ano == 2020) {
			return true;
		}else {
			return false;
		}
	}
    // Função que obtem o tamanho do mes settando no atributo
    
    public int obtemTamanhoMes() {
		//pegar o numero do mês e se ele é bissexto atribuindo o tamanho dele
		int mes = getnMes();
		boolean bissexto = verificaBissexto();
		
		if (bissexto && mes == 2) {
			setTamMes(29);
			return 29;
		}else if(!bissexto && mes == 2){
			setTamMes(28);
			return 28;
		}else if ( mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12 ){
			setTamMes(31);
			return 31;
		}else{
			setTamMes(30);
			return 30;
		}
	}
    // Função que recebe como parametro o tamanho do mês determinando o tamanho do vetor temperatura
    
    public void calculaTemps(int tamMes){
        // Passando o valor do atributo tamanho do mes ao parâmetro
        tamMes=this.tamMes;
        
        //settar o tamanho do mês no vetor temperatura
         double[]tempProvisorio=new double[tamMes];
         
         // ler valores do Array e criando variavel da soma das temperaturas
         double soma=0;
         for(int i=0;i<tempProvisorio.length;i++){
             //Pegando o input do usuário
             String strTempDia= JOptionPane.showInputDialog("Entre com a temperatura do dia "+(i+1)+" com a escala Celsius ");
             
             //Convertendo o string para double para dps settar certinho no array =-)
             double TempDia=Double.parseDouble(strTempDia);
             soma+=TempDia;
             tempProvisorio[i]=TempDia;
             
         }
         //Criando uma variavel media para o set da temperatura média não ficar confuso hsjhsjhsj
         double media=soma/tamMes;
        
         
         //A função sort ordena os valores do array em ordem crescente
         Arrays.sort(tempProvisorio);
         
         //Settar o array temporário que criamos no array atributo
         setTemperaturas(tempProvisorio);
         
         //Já que o Array tá ordenadinho e já calculamos a média,é só settar as temperaturas mínima,média e máxima
         setTempMin(tempProvisorio[0]);
         setTempMax(tempProvisorio.length-1);
         setTempMed(media); 
    }
   
    
    
    
    
    
}
