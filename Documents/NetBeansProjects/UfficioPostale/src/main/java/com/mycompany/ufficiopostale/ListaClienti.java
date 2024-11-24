/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ufficiopostale;
import java.util.ArrayList;
/**
 *
 * @author Alessio
 */
public class ListaClienti {
    private ArrayList<Integer> listaNumeri;
    private int ultimoArrivo;
    private int ultimoServito;
    private final int numeroMassimo =100;
        public ListaClienti(){
            listaNumeri= new ArrayList<Integer>();
            ultimoArrivo=0;
            ultimoServito=0;
        }
        
    public synchronized Integer rimuoviCliente() throws InterruptedException{
        while(ultimoServito>=ultimoArrivo)
            wait();
        ultimoServito++;
        return ultimoServito;
    }
    
    public synchronized Integer addCliente() throws InterruptedException{
        if(ultimoArrivo>=numeroMassimo){
            ultimoArrivo++;
            listaNumeri.add(ultimoArrivo); 
            notifyAll();
            return ultimoArrivo;
        }
    return null;
    }
}
