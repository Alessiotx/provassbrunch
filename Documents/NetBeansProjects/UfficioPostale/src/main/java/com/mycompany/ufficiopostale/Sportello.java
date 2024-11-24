/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ufficiopostale;

/**
 *
 * @author Alessio
 */
public class Sportello implements Runnable{
    private ListaClienti listaClienti;
    private final int minTempoServizio=2000;
    private final int maxTempoServizio=8000;
    private int numeroSportello;
    public Sportello(ListaClienti listaClienti,int numeroSportello){
        this.listaClienti=listaClienti;
        this.numeroSportello=numeroSportello;
        
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                Integer clienteServito=listaClienti.rimuoviCliente();
                System.out.println("Chiamato Cliente NUmero \t "+ clienteServito+ " dallo sportello numero "+ numeroSportello);
                int tempoServizio=(int) (Math.random()*(maxTempoServizio - minTempoServizio+1)+ minTempoServizio);
                Thread.sleep(tempoServizio);
                System.out.println("Servizio Cliente Numero \t "+ clienteServito);
            }
        } catch (InterruptedException e){
            System.out.println("Thread interrotto durante lo sleep");
    }finally{
            System.out.println("sportello Chiuso");
        }
    }
    
}
