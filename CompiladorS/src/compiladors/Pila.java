package compiladors;

import java.util.List;
import java.util.ArrayList;

public class Pila{ 
        
    List<ElementoPilaS> pila = new ArrayList<ElementoPilaS>(); 
    ElementoPilaS Ep = new ElementoPilaS();
    
    public void push(ElementoPilaS ep){
        pila.add(0, ep);
    }
    
    public ElementoPilaS top(){
        return pila.get(0);
    }
    
    public ElementoPilaS pop(){
        return pila.remove(0);
    }
    
    public  void muestra(){
        System.out.println("Pila: ");
        for(int i = 0; i < pila.size(); i++){
            System.out.println(pila.get(i).simbolo); 
        }
        
    }
    
}
