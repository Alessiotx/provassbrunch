/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ufficiopostale;

import java.util.ArrayList;

/**
 *
 * @author Alessio
 */
public class UfficioPostale {
    public static final int NumeroSportelli = 3;
    public static void main(String[] args) {
        
        ListaClienti listaClienti=new ListaClienti();
        Thread arriviThread =new Thread(new Arrivi (listaClienti));
        ArrayList<Thread> sportelloThreadList= new ArrayList<Thread>();
        
        arriviThread.start();
        for(int i=0;i<NumeroSportelli;i++){
            Thread sportelloThread = new Thread(new Sportello(listaClienti,i+1));
            sportelloThreadList.add(sportelloThread);
            sportelloThread.start();
        }
        
    }
}
