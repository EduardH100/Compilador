package compiladors;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.text.html.HTMLEditorKit;
//import java.util.regex.*;

public class SintacticoS {

    LexicoS lexico = new LexicoS("int x;");
    Pila pila = new Pila();
    int[][] tablaLR = new int[94][45];
    String fileName = "LR1.txt"; 
    String cadF = "";
    

    SintacticoS() throws IOException {
        analiza();
        //Ejercicio2();
    }

    private void comprueba(String simbolo){
        if (lexico.simbolo.equals(simbolo)) {
            lexico.sigSimbolo();
        } else {
            lexico.error();
        }
    }

    private void analiza() throws IOException{
        //lexico.sigSimbolo();
        //comprueba("$");
        //System.out.println("Cadena valida...");
        proyecto();
        System.exit(0);

        //( ([a-d|A-Z])+ \d* = ([a-d|A-Z]\d)+ (-|+)* ([a-d|A-Z]\d)+ ; )? 
    }
    
    private void error(){
        System.out.println("Error Sintactico...");
        System.exit(0);
    }
    
    /*private void Ejercicio2() {
        
        boolean aceptacion = false;
        int fila, columna, accion = 0, i = 0;
        int[][] tablaLR = {{2,0,0,1},
                           {0,0,-1,0},
                           {0,3,-3,0},
                           {2,0,0,4},
                           {0,0,-2,0}
        };

        pila.push(TipoSimbolo.PESOS); //2 == $
        pila.push(0);
        lexico.sigSimbolo();    //id    
        

        while (!aceptacion) {
            
            fila = pila.top();      //0
            columna = lexico.tipo;  //0
            accion = tablaLR[fila][columna];   //2

            pila.muestra();
            System.out.println("Entrada 1:" + lexico.simbolo); //id
            System.out.println("Accion:" + accion);  

            if (accion > 0) {
                pila.push(lexico.tipo);
                pila.push(accion);
                lexico.sigSimbolo();    
            } 
            else if (accion < 0) {
                
                if(accion == -2) {
                    for(i = 0; i < (LonReglas[0]); i++){
                        pila.pop();
                        pila.pop();
                    }                
                    fila = pila.top();      
                    columna = idReglas[0];  
                    accion = tablaLR[fila][columna]; 
                    
                    pila.push(idReglas[0]); //E
                    pila.push(accion); 
                }
                else if (accion == -3) {
                    for(i = 0; i < LonReglas[1]; i++){
                        pila.pop();
                        pila.pop();
                    }                
                    fila = pila.top();      
                    columna = idReglas[1];  
                    accion = tablaLR[fila][columna]; 
                    
                    pila.push(idReglas[1]); 
                    pila.push(accion); 
                } 
                else break; //accion = -1
                
            } else {
                error();
                System.exit(0);
            }

        }

        aceptacion = accion == -1;
        if (aceptacion) {
            System.out.println("Aceptación");
        } else {
            System.out.println("No aceptación");
        }
    }*/

    private void proyecto() throws IOException{
        
        boolean aceptacion = false;
        int i = 0;
        ReadLRTable();
        
        int fila, columna, accion = 0;
        
        ElementoPilaS eleAux = new ElementoPilaS();
        
        Estado estAux = new Estado(0);
        Terminal terAux = new Terminal("$");

        pila.push(terAux);  //$
        pila.push(estAux);  //0
        lexico.sigSimbolo();    //id    
        

        while (!aceptacion) {
            
            fila = pila.top().tipo;      //0 
            columna = lexico.tipo;  //23
            accion = tablaLR[fila][columna];   //2

            pila.muestra();
            System.out.println("Entrada: " + lexico.simbolo); //id
            System.out.println("Accion: " + accion);  

            if (accion > 0) {
                
                pila.push(new Terminal(columna));
                pila.push(new Estado(accion));
                lexico.sigSimbolo();    
            } 
            else if (accion < 0) {
                    
                Nodo nodo = new Nodo();
                accion = getRule(accion);
                
                switch(accion){
                    case 0: aceptacion = true; break;
                    case 1: nodo = new Programa(pila, accion); break;
                    case 2: nodo = new Definiciones(pila, accion); break;
                    case 3: nodo = new Definiciones(pila, accion); break;
                    case 4: nodo = new Definicion(pila, accion); break;
                    case 5: nodo = new Definicion(pila, accion); break;
                    case 6: nodo = new DefVar(pila, accion); break;
                    case 7: nodo = new ListaVar(pila, accion); break;
                    case 8: nodo = new ListaVar(pila, accion); break;
                    case 9: nodo = new DefFunc(pila, accion); break;
                    case 10: nodo = new Parametros(pila, accion); break;
                    case 11: nodo = new Parametros(pila, accion); break;
                    case 12: nodo = new ListaParam(pila, accion); break;
                    case 13: nodo = new ListaParam(pila, accion); break;
                    case 14: nodo = new BloqFunc(pila, accion); break;
                    case 15: nodo = new DefLocales(pila, accion); break;
                    case 16: nodo = new DefLocales(pila, accion); break;
                    case 17: nodo = new DefLocal(pila, accion); break;
                    case 18: nodo = new DefLocal(pila, accion); break;
                    case 19: nodo = new Sentencias(pila, accion); break;
                    case 20: nodo = new Sentencias(pila, accion); break;
                    case 21: nodo = new Sentencia(pila, accion); break;
                    case 22: nodo = new Sentencia(pila, accion); break;
                    case 23: nodo = new Sentencia(pila, accion); break;
                    case 24: nodo = new Sentencia(pila, accion); break;
                    case 25: nodo = new Sentencia(pila, accion); break;
                    case 26: nodo = new Otro(pila, accion); break;
                    case 27: nodo = new Otro(pila, accion); break;
                    case 28: nodo = new Bloque(pila, accion); break;
                    case 29: nodo = new ValorRegresa(pila, accion); break;
                    case 30: nodo = new ValorRegresa(pila, accion); break;
                    case 31: nodo = new Argumentos(pila, accion); break;
                    case 32: nodo = new Argumentos(pila, accion); break;
                    case 33: nodo = new ListaArgumentos(pila, accion); break;
                    case 34: nodo = new ListaArgumentos(pila, accion); break;
                    case 35: nodo = new Termino(pila, accion); break;
                    case 36: nodo = new Termino(pila, accion); break;
                    case 37: nodo = new Termino(pila, accion); break;
                    case 38: nodo = new Termino(pila, accion); break;
                    case 39: nodo = new Termino(pila, accion); break;
                    case 40: nodo = new LlamadaFunc(pila, accion); break;
                    case 41: nodo = new SentenciaBloque(pila, accion); break;
                    case 42: nodo = new SentenciaBloque(pila, accion); break;
                    case 43: nodo = new Expresion(pila, accion); break;
                    case 44: nodo = new Expresion(pila, accion); break;
                    case 45: nodo = new Expresion(pila, accion); break;
                    case 46: nodo = new Expresion(pila, accion); break;
                    case 47: nodo = new Expresion(pila, accion); break;
                    case 48: nodo = new Expresion(pila, accion); break;
                    case 49: nodo = new Expresion(pila, accion); break;
                    case 50: nodo = new Expresion(pila, accion); break;
                    case 51: nodo = new Expresion(pila, accion); break;
                    case 52: nodo = new Expresion(pila, accion); break;
                    
                    
                }
                
                NoTerminal noT = new NoTerminal(accion);
                noT.nodo = nodo;
                
                fila = pila.top().tipo;
                columna = Reglas.idReglas[accion];
                accion = tablaLR[fila][columna];
                       
                pila.push(noT);
                pila.push(new Estado(accion));
                
            } else {
                error();
                System.exit(0);
            }

        }

        //aceptacion = accion == -1;
        if (aceptacion) {
            System.out.println("Aceptación");
        } else {
            System.out.println("No aceptación");
        }
    
    }   
    
    int getRule(int n){
        n = n*(-1);
        n--;
        return n; 
    }
    
    void ReadLRTable() throws FileNotFoundException, IOException{
        
        String[] auxS;
        String aux;
        int j = 0, k = 0, n = 0;
        
        FileReader f = new FileReader(fileName);
        BufferedReader br = new BufferedReader(f);
        while((aux = br.readLine())!=null){
            cadF += aux;
        }
        
        auxS = cadF.split("\t");
        
        for(j = 0; j < 94; j++){     
            for(k = 0; k < 45; k++){
                tablaLR[j][k] = Integer.parseInt(auxS[n]); 
                n++;
            }
        }
        
        for(j = 0; j < 93; j++){     
            for(k = 0; k < 45; k++){
                //tablaLR[j][k] = Integer.parseInt(auxS[k]);
                System.out.print(tablaLR[j][k] + " | ");
                
            }
            System.out.println();
        }
            
    }
}




 


