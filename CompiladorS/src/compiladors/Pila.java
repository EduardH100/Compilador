package compiladors;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class Pila{ 
        
    List<Integer> pila = new ArrayList<Integer>();
    
    public void push(int x){
        pila.add(0, x);
    }
    
    public int top(){
        return pila.get(0);
    }
    
    public int pop(){
        return pila.remove(0);
    }
    
    public  void muestra(){
        System.out.println("Pila: ");
        for(int i = 0; i < pila.size(); i++){
            System.out.println(pila.get(i));
        }
    }
    
}
