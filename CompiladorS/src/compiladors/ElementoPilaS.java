package compiladors;

public class ElementoPilaS extends Nodo{
    Nodo nodo;
    int tipo;

    public ElementoPilaS(){
        this.nodo = null;
        this.tipo = -1;
    }
    
}

class Reglas{
    //static int[] idReglas = {3,3}; 
    static int[] lonReglas = {1,0,2,1,1,4,0,3,6,0,
                              3,0,4,3,0,2,1,1,0,2,
                              4,6,5,3,2,0,2,3,0,1,
                              0,2,0,3,1,1,1,1,1,4,
                              1,1,3,2,2,3,3,3,3,3,
                              3,1};
}

class Nodo{
    String simbolo;
    Nodo sig;
    
    Nodo(){
       this.simbolo = "";
       this.sig = null;
    }
}

class NoTerminal extends ElementoPilaS{
    //int estado;

    public NoTerminal(int s) {
       // this.estado = s;
        this.tipo = s;
    }
}

class Terminal extends ElementoPilaS{
    String simbolo;
    //int estado;

    public Terminal(String s) {
        this.simbolo = s;
        //this.estado = 0;  
    }
    
    public Terminal(int n) {
        this.simbolo = "";
        this.tipo = n; 
    }
    
}

class Estado extends ElementoPilaS{
    //int estado;
    
    public Estado(int s) {
        //this.estado = s;
        this.tipo = s;
    }
}

class Programa extends Nodo{

    Definiciones definiciones;
    
    public Programa(Pila pila, int n) {
        for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
            pila.pop(); 
    }
    
}

class Definiciones extends Nodo{

    public Definiciones(Pila pila, int n) {
        
        if(n == 2){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 3){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
       
    }
    
}

class Definicion extends Nodo{

    public Definicion(Pila pila, int n) {
         if(n == 4){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 5){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
    }
    
}

class DefVar extends Nodo{

    public DefVar(Pila pila, int n) {
        for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
        
    }
    
}

class ListaVar extends Nodo{

    public ListaVar(Pila pila, int n) {
        if(n == 7){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 8){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
    }
    
}

class DefFunc extends Nodo{

    public DefFunc(Pila pila, int n) {
        for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
        
    }
    
}

class Parametros extends Nodo{

    public Parametros(Pila pila, int n) {
        if(n == 10){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 11){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
    }
    
}

class ListaParam extends Nodo{

    public ListaParam(Pila pila, int n) {
        if(n == 12){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 13){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
    }
    
}

class BlocFunc extends Nodo{

    public BlocFunc(Pila pila, int n) {
        for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();  
    }
    
}

class DefLocales extends Nodo{

    public DefLocales(Pila pila, int n) {
        if(n == 15){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 16){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
    }
    
}

class DefLocal extends Nodo{

    public DefLocal(Pila pila, int n) {
        if(n == 17){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 18){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
    }
    
}

class Sentencias extends Nodo{

    public Sentencias(Pila pila, int n) {
        if(n == 19){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 20){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
    }
    
}

class Sentencia extends Nodo{

    public Sentencia(Pila pila, int n) {
        if(n == 21){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 22){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 23){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 24){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 25){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
    }
    
}

class Otro extends Nodo{

    public Otro(Pila pila, int n) {
         if(n == 26){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 27){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
    }
}

class Bloque extends Nodo{

    public Bloque(Pila pila, int n) {
        for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop(); 
    }
    
}

class ValorRegresa extends Nodo{

    public ValorRegresa(Pila pila, int n) {
        if(n == 29){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 30){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
    }
    
}

class Argumentos extends Nodo{

    public Argumentos(Pila pila, int n) {
        if(n == 31){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 32){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
    }
    
}

class ListaArgumentos extends Nodo{

    public ListaArgumentos(Pila pila, int n) {
        if(n == 33){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 34){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
    }
    
}

class Termino extends Nodo{

    public Termino(Pila pila, int n) {
        if(n == 35){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 36){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 37){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 38){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 39){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
    }
    
}

class LlamadaFunc extends Nodo{

    public LlamadaFunc(Pila pila, int n) {
        for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();   
    }
    
}

class SentenciaBloque extends Nodo{

    public SentenciaBloque(Pila pila, int n) {
        if(n == 41){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 42){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
    }
    
}

class Expresion extends Nodo{

    public Expresion(Pila pila, int n) {
        if(n == 43){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 44){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 45){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 46){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 47){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 48){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 49){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 50){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 51){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
        else if(n == 52){
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++)
                pila.pop();       
            
        }
    }
}


/*
en cada reducion mandar llamar a una funcion 
de la clase que corresponda la regla y pasarle 
por parametro la pila y resolver la reduccion 
en dicha funcion

*/






