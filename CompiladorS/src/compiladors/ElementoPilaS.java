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
    
     static int[] idReglas = {24,25,25,26,26,27,28,28,29,30,
                              30,31,31,32,33,33,34,34,35,35,
                              36,36,36,36,36,37,37,38,39,39,
                              40,40,41,41,42,42,42,42,42,43,
                              44,44,45,45,45,45,45,45,45,45,
                              45,45};
}

class Nodo{
    Nodo sig;
    
    Nodo(){
       this.sig = null;
    }
}

class NoTerminal extends ElementoPilaS{
    String simboloR;

    public NoTerminal(int s) {
        this.simboloR = "R" + String.valueOf(s);
        this.tipo = s;
    }
}

class Terminal extends ElementoPilaS{
    String simbolo = "";

    public Terminal(String s) {
        this.simbolo = s;
        this.tipo = -1;  
    }
    
    public Terminal(int n) {
        this.simbolo = "";
        this.tipo = n; 
    }
    
}

class Estado extends ElementoPilaS{
    String simbolo;
    
    public Estado(int s) {
        this.simbolo = String.valueOf(s);
        this.tipo = s;
    }
}

class Programa extends Nodo{

    ElementoPilaS definiciones;
    
    public Programa(Pila pila, int n) {
        
        for(int i = 0; i < (Reglas.lonReglas[n-1]); i++){
            
            pila.pop(); 
            definiciones = pila.pop();
        }
    }
    
}

class Definiciones extends Nodo{

    ElementoPilaS definicion, definiciones;
    
    public Definiciones(Pila pila, int n) {
        
        int i;
        
        if(n == 2){}
        else if(n == 3){
            
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();
            
                switch(i){
                
                    case 0: definiciones = pila.pop(); break;
                    case 1: definicion = pila.pop(); break;
                    default: break;
                }
            }
        }
    }
    
}

class Definicion extends Nodo{

    ElementoPilaS defvar, defFunc; 
    
    public Definicion(Pila pila, int n) {
         if(n == 4){
             
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();
                defvar = pila.pop();
            }
            
        }
        else if(n == 5){
            
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                defFunc = pila.pop();
            }
        }
    }
    
}

class DefVar extends Nodo{
    
    int tipo, i;
    String id;
    ElementoPilaS listaVar;
    
    public DefVar(Pila pila, int n) {
        
        for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
            
                pila.pop();
                
            switch (i) {
                case 0:
                    pila.pop();
                    break;
                case 1:
                    listaVar = pila.pop();
                    break;
                case 2:
                    id = String.valueOf(pila.pop().tipo);
                    break;
                case 3:
                    tipo = pila.pop().tipo;
                    break;
                default:
                    break;
            }
        }
        
    }
    
}

class ListaVar extends Nodo{
    
    String id;
    ElementoPilaS listaVar;
    
    public ListaVar(Pila pila, int n) {
        
        int i;
        
        if(n == 7){}
        else if(n == 8){
            
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                
                switch (i) {
                    case 0:
                        listaVar = pila.pop();
                        break;
                    case 1:
                        id = String.valueOf(pila.pop().tipo);
                        break;
                    case 2:
                        pila.pop();
                        break;
                    default:
                        break;
                }
            }
            
        }
    }
    
}

class DefFunc extends Nodo{

    int i, tipo;
    String id;
    ElementoPilaS param, blocF;
    
    public DefFunc(Pila pila, int n) {
        
        for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
            
                pila.pop();       
                
            switch (i) {
                case 0:
                    blocF = pila.pop();
                    break;
                case 1:
                    param = pila.pop();
                    break;
                case 2:
                    id = String.valueOf(pila.pop().tipo);
                    break;
                case 3:
                    tipo = pila.pop().tipo;
                    break;
                default:
                    break;
            }
                
        }
        
    }
    
}

class Parametros extends Nodo{

    int tipo, i;
    String id;
    ElementoPilaS listaParam;
    
    public Parametros(Pila pila, int n) {
        
        if(n == 10){}
        else if(n == 11){
            
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                
                switch(i){
                    
                    case 0: listaParam = pila.pop(); break;
                    case 1: id = String.valueOf(pila.pop().tipo); break;
                    case 2: tipo = pila.pop().tipo; break;
                    default: break;
                }
            }
        
        }
    }
}

class ListaParam extends Nodo{

    int tipo, i;
    String id;
    ElementoPilaS listaParam;
    
    public ListaParam(Pila pila, int n) {
        
        if(n == 12){}
        else if(n == 13){
            
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){

                pila.pop();       

                switch(i){

                    case 0: listaParam = pila.pop(); break;
                    case 1: id = String.valueOf(pila.pop().tipo); break;
                    case 2: tipo = pila.pop().tipo; break;
                    default: break;
                }
            }
            
        }
    
    }
}

class BlocFunc extends Nodo{

    int i;
    ElementoPilaS defLocales;  
    
    public BlocFunc(Pila pila, int n) {
        
        for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
            
                pila.pop();  
                
                if(i == 1)
                    defLocales = pila.pop();
                else
                    pila.pop();
                    
        }
    }
    
}

class DefLocales extends Nodo{

    int i;
    ElementoPilaS defLocal, defLocales;
    
    public DefLocales(Pila pila, int n) {
        
        if(n == 15){}
        else if(n == 16){
            
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                
                if(i == 0)
                    defLocales = pila.pop();
                else
                    defLocal = pila.pop();
                
            }
            
        }
    }
    
}

class DefLocal extends Nodo{

    ElementoPilaS defVar, Sentencia;
    
    public DefLocal(Pila pila, int n) {
        
        if(n == 17){
            
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop(); 
                defVar = pila.pop();      
                
            }
            
        }
        else if(n == 18){
            
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                Sentencia = pila.pop();
                
            }
            
        }
    }
    
}

class Sentencias extends Nodo{

    int i;
    ElementoPilaS Sentencia, Sentencias;
    
    public Sentencias(Pila pila, int n) {
        
        if(n == 19){}
        else if(n == 20){
            
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();
                
                if(i == 0){
                    Sentencia = pila.pop();
                }
                else
                    Sentencias = pila.pop();
                
            }
            
        }
    }
    
}

class Sentencia extends Nodo{

    String id;
    int i; 
    ElementoPilaS expresion, sentBloq, bloq, otro, valorReg, llamadaFuc;
    
    public Sentencia(Pila pila, int n) {
        
        if(n == 21){
            
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                
                switch(i){
                    case 0: pila.pop(); break;
                    case 1: expresion = pila.pop(); break;
                    case 2: pila.pop(); break;
                    case 3: id = String.valueOf(pila.pop().tipo); break;
                    default: break;
                }
                        
            }
            
        }
        else if(n == 22){
            
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                
                switch(i){
                    case 0: otro = pila.pop(); break;
                    case 1: sentBloq = pila.pop(); break;
                    case 2: pila.pop(); break;
                    case 3: expresion = pila.pop(); break;
                    case 4: pila.pop(); break;
                    case 5: pila.pop(); break;
                    default: break;
                }
            }
            
        }
        else if(n == 23){
            
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop(); 
                
                switch(i){
                    case 0: bloq = pila.pop(); break;
                    case 1: pila.pop(); break;
                    case 2: expresion = pila.pop(); break;
                    case 3: pila.pop(); break;
                    case 4: pila.pop(); break;
                    default: break;
                }
            }
            
        }
        else if(n == 24){
            
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                
                switch(i){
                    case 0: pila.pop(); break;
                    case 1: valorReg = pila.pop(); break;
                    case 2: pila.pop(); break;
                    default: break;
                }
            }
            
        }
        else if(n == 25){
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                
                switch(i){
                    case 0: pila.pop(); break;
                    case 1: llamadaFuc = pila.pop(); break;
                    default: break;
                }
            }
            
        }
    }
    
}

class Otro extends Nodo{

    int i;
    ElementoPilaS sentBloq;
    
    public Otro(Pila pila, int n) {
        
         if(n == 26){}
        else if(n == 27){
            
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                
                if(i == 0)
                    sentBloq = pila.pop();
                else
                    pila.pop();
            }
            
        }
    }
}

class Bloque extends Nodo{

    int i;
    ElementoPilaS sentencias;
    
    public Bloque(Pila pila, int n) {
        
        for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
            
                pila.pop(); 
                
                switch(i){
                    case 0: pila.pop(); break;
                    case 1: sentencias = pila.pop(); break;
                    case 2: pila.pop(); break;
                    default: break;
                }
        }
    }
    
}

class ValorRegresa extends Nodo{

    ElementoPilaS exprecion;
    
    public ValorRegresa(Pila pila, int n) {
        
        if(n == 29){}
        else if(n == 30){
            
            for(int i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                exprecion = pila.pop();
                
            }
            
        }
    }
    
}

class Argumentos extends Nodo{

    int i;
    ElementoPilaS exprecion, listaArgum;
    
    public Argumentos(Pila pila, int n) {
        
        if(n == 31){}
        else if(n == 32){
            
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                
                if(i == 0)
                    listaArgum = pila.pop();
                else
                    exprecion = pila.pop();
                
            }
            
        }
    }
    
}

class ListaArgumentos extends Nodo{

    int i;
    ElementoPilaS exprecion, listaArgum;
    
    public ListaArgumentos(Pila pila, int n) {
        
        if(n == 33){}
        else if(n == 34){
            
           for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                
                if(i == 0)
                    listaArgum = pila.pop();
                else if(i == 1)
                    exprecion = pila.pop();
                else
                    pila.pop();
            }     
            
        }
    }
    
}

class Termino extends Nodo{

    String id = "", entero = "", real = "", cadena = "";
    ElementoPilaS llamadaF;
    
    public Termino(Pila pila, int n) {
        if(n == 35){
            
                pila.pop();  
                llamadaF = pila.pop();
            
        }
        else if(n == 36){
            
                pila.pop();
                id = String.valueOf(pila.pop().tipo);
            
        }
        else if(n == 37){
           
                pila.pop();       
                entero = String.valueOf(pila.pop().tipo);
               
            
        }
        else if(n == 38){
           
                pila.pop();       
                real = String.valueOf(pila.pop().tipo);
                
        }
        else if(n == 39){
            
                pila.pop();       
                cadena = String.valueOf(pila.pop().tipo);
            
        }
    }
    
}

class LlamadaFunc extends Nodo{

    int i;
    String id;
    ElementoPilaS argum;
    
    public LlamadaFunc(Pila pila, int n){ 
            
        for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
            
                pila.pop();   
                
                switch(i){
                    case 0: pila.pop(); break;
                    case 1: argum = pila.pop(); break;
                    case 2: pila.pop(); break;
                    case 3: id = String.valueOf(pila.pop().tipo); break;
                    default: break;
                }
        }
    }
    
}

class SentenciaBloque extends Nodo{

    ElementoPilaS sentencia, bloq;
    
    public SentenciaBloque(Pila pila, int n) {
        
        if(n == 41){
                pila.pop();       
                sentencia = pila.pop();
            
        }
        else if(n == 42){
            pila.pop();
            bloq = pila.pop();     
            
        }
    }
    
}

class Expresion extends Nodo{

    int i;
    String operacion;
    ElementoPilaS expresion, termino;
    
    public Expresion(Pila pila, int n) {
        
        if(n == 43){
            
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                if(i == 1)
                    expresion = pila.pop();
                else
                    pila.pop();             // ( y )
            }
                
        }
        else if(n == 44){
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                if(i == 0)
                    expresion = pila.pop();
                else
                    pila.pop(); //opSuma
                    
                    
            }
            
        }
        else if(n == 45){
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                if(i == 0)
                    expresion = pila.pop();
                else
                    pila.pop(); //opNot
            }
                    
            
        }
        else if(n == 46){
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                if(i == 0)
                    expresion = pila.pop();
                else if(i == 1)
                    pila.pop(); //opMul
                else
                    expresion = pila.pop();
            }
                    
            
        }
        else if(n == 47){
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                if(i == 0)
                    expresion = pila.pop();
                else if(i == 1)
                    pila.pop(); //opSuma
                else
                    expresion = pila.pop();
            }
                    
            
        }
        else if(n == 48){
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                if(i == 0)
                    expresion = pila.pop();
                else if(i == 1)
                    pila.pop(); //opRelac
                else
                    expresion = pila.pop();
            }
                
            
        }
        else if(n == 49){
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                if(i == 0)
                    expresion = pila.pop();
                else if(i == 1)
                    pila.pop(); //opIgualdad
                else
                    expresion = pila.pop();
            }
                
            
        }
        else if(n == 50){
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                if(i == 0)
                    expresion = pila.pop();
                else if(i == 1)
                    pila.pop(); //AND
                else
                    expresion = pila.pop();
            }
                
            
        }
        else if(n == 51){
            for(i = 0; i < (Reglas.lonReglas[n-1]); i++){
                
                pila.pop();       
                switch (i) {
                    case 0:
                        expresion = pila.pop();
                        break;
                    case 1:
                        pila.pop(); //oR
                        break;
                    case 2:
                        expresion = pila.pop();
                        break;
                    default: break;
                }
            }
                     
            
        }
        else if(n == 52){
            
                pila.pop();       
                termino = pila.pop();
            
        }
    }
}


/*
en cada reducion mandar llamar a una funcion 
de la clase que corresponda la regla y pasarle 
por parametro la pila y resolver la reduccion 
en dicha funcion

*/






