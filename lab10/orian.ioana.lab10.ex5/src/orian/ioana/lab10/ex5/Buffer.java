/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orian.ioana.lab10.ex5;

import java.util.*;

/**
 *
 * @author Alexandra
 */
class Buffer
{
      /*
       * Vector folosit pentru a inmagazina obiecte de tip Double.
       */
      ArrayList content = new ArrayList();
 
      /**
       * Prin intermediul acestei metode sunt adaugate elemente in containerul content.
       * Se observa ca aceasta metoda este sincronizata. Metoda fa fi apelata de firele
       * de executie de tip Producer.
       *
       * Dupa adaugarea unui element in container se apeleaza metoda notify() aceasta asigura
       * trezirea unui fir de executie ce a fost blocat prin apelul functiei wait().
       * @param d
       */
       void push(double d)
      {
            
            synchronized(content){
            content.add(new Double(d));
            content.notify();
            }
      }
 
      /**
       * Aceasta metoda este folosita pentru a extrage elemente din cadrul containerului
       * content. Se observa ca aceasta metoda este sincronizata.
       * Daca containerul este  gol se apeleaza metoda wait(). Aceasta va bloca firul
       * de executie apelant pana in momentul in care un fir de executie producator
       * va adauga in container un element si va apela metoda notify() (vezi metoda put(...))
       *
       * @return
       */
       double get()
      {
            double d=-1;
            synchronized(content){
            try
            {
                  while(content.size()==0) content.wait();
                  d = (((Double)content.get(0))).doubleValue();
                  content.remove(0);
            }catch(Exception e){e.printStackTrace();}
            return d;
      }
      }
}