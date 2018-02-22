package compiladors;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import static java.lang.Character.isSpaceChar;
import static java.lang.Character.isLetterOrDigit;

public class LexicoS {
    
     public String Fname = "File.txt";
     public boolean continua;
     public String cadena;
     public String simbolo;
     public int tipo;
     public int estado;
     public int ind;
     public char c;
     
     LexicoS(String cad){
         this.c = ' ';
         this.cadena = cad + '$';
         this.continua = true;
         this.estado = 0;
         this.ind = -1;
         this.simbolo = "";
         this.tipo = -1;
     }
     
     LexicoS() throws IOException{
         this.c = ' ';
         this.cadena = "";
         this.continua = true;
         this.estado = 0;
         this.ind = -1;
         this.simbolo = "";
         this.tipo = -1;
         leerArchivo(Fname);
     }
     
     public void sigEstado(int e){
         simbolo += c;
         estado = e;
     }
     
     public void sigSimbolo() throws StringIndexOutOfBoundsException{
         continua = true;
         estado = 0;
         simbolo = "";
         try{
             while(continua && ind <= cadena.length()){

                 c = sigChar();

                 switch(estado){
                     case 0: 
                         if(isSpaceChar(c)) sigEstado(0);
                         else if(isLetter(c)) sigEstado(1);
                         else if(isDigit(c)) sigEstado(2); 
                         else if(isOpRelac(c)) sigEstado(4); 
                         else if(isOpIgualdad(c)) sigEstado(5); 
                         else if(isOpAsig(c)) valido(6); 
                         else if(isOpAdic(c)) valido(7); 
                         else if(isOpMul(c)) valido(8); 
                         else if(isParent(c)) valido(9); 
                         else if(isPyC(c)) valido(10); 
                         else if(isLlave(c)) valido(11); 
                         else if(isOpAND(c)) valido(12); 
                         else if(isOpOR(c)){
                             simbolo += c; //los demas lo necesitan
                             valido(13);
                         } 
                         else if(c == '"') sigEstado(6);
                         else if(c == '$') Finalizar();
                         else error();
                         break;

                     case 1:
                         if(isSentencia(simbolo) || isTipoD(simbolo)){
                             if(!isLetterOrDigit(c)) valido(14);
                             else sigEstado(1);
                         } 
                         else if(isLetterOrDigit(c)) sigEstado(1);
                         else valido(estado);
                         break;

                     case 2:
                         if(isDigit(c)) sigEstado(2);
                         else if(c == '.') sigEstado(3);
                         else valido(estado);
                         break;

                     case 3:
                         if(isDigit(c)) sigEstado(3);
                         else if(!isDigit(c) && cadena.charAt(ind - 1) == '.') error();
                         else valido(estado);
                         break;

                     case 4:   
                         if(c == '=') sigEstado(4);
                         else valido(estado);
                         break;   
                         
                     case 5:
                         if(c == '='){
                             simbolo += c;
                             valido(8);
                         }
                         else valido(6);
                         break;   
                         
                     case 6:
                         if(c != '"') sigEstado(6);
                         else valido(5);
                         break;

                 }

             }
             
         }catch(StringIndexOutOfBoundsException e){
             System.out.println("Se ha producido en error de desbordamiento...");
         }
         catch(Exception e){
             System.out.println("Se ha producido en error...");
         }     
         
     }
     
    public void leerArchivo(String name) throws FileNotFoundException, IOException{
        String aux;
        FileReader f = new FileReader(name);
        BufferedReader br = new BufferedReader(f);
        while((aux = br.readLine())!=null){
            cadena += aux;
        }
    }
    
    public char sigChar(){
        ind = ind + 1;
        return cadena.charAt(ind);
    }
    
    public boolean isOpAsig(char x){
        return x == '=';
    }
    
    public boolean isOpAdic(char x){
        return (x == '+' || x == '-');
    }
    
    public boolean isOpMul(char x){
        return (x == '*' || x == '/');
    }
    
    public boolean isParent(char x){
        return (x == '(' || x == ')');
    }
    
    public boolean isPyC(char x){
        return (x == ';' || x == ',');
    }
     
    public boolean isOpRelac(char x){
        return (x == '>' || x == '<');
    }
    
    public boolean isOpAND(char x){
        return x == '&';
    }
    
    public boolean isOpOR(char x){
        return x == '|';
    }
    
    public boolean isLlave(char x){
        return (x == '{' || x == '}');  
    }
    
    public boolean isOpIgualdad(char x){
        return (x == '=' || x == '!' );
    }
    
    public boolean isSentencia(String x){
        return("while".equals(x) || "if".equals(x) || "else".equals(x) || "switch".equals(x) || "return".equals(x));
    }
    
     public boolean isTipoD(String x){
        return("int".equals(x) || "void".equals(x) || "char".equals(x) || "float".equals(x));
    }
    
    
    public void error(){
        System.out.println("Cadena invalida. Caracter: " + c);
        System.exit(0);
    }
    
    public void valido(int t){
        
        //TipoSimbolo ts = new TipoSimbolo();
        switch(t){
                 case 1: tipo = TipoSimbolo.IDENTIFICADOR; break;
                 case 2: tipo = TipoSimbolo.ENTERO; break;
                 case 3: tipo = TipoSimbolo.REAL; break;
                 case 4: tipo = TipoSimbolo.RELACIONAL; break; 
                 case 5: tipo = TipoSimbolo.CADENA; break; 
                 case 6: tipo = TipoSimbolo.ADICION; break; //////////////
                 case 7: tipo = TipoSimbolo.ADICION; break;
                 case 8: tipo = TipoSimbolo.MULTIPLICACION; break;
                 case 9: tipo = TipoSimbolo.ASIGNACION; ind -= 1; break; //podria ponerlo en otro case
                 case 19: tipo = TipoSimbolo.PARENTECISI; break;//
                 case 10: tipo = TipoSimbolo.PARENTECISD; break;//
                 case 11: tipo = TipoSimbolo.PC; break;
                 case 12: tipo = TipoSimbolo.COMA; break;
                 case 13: tipo = TipoSimbolo.LLAVEI; break;//
                 case 14: tipo = TipoSimbolo.LLAVED; break;//
                 case 15: tipo = TipoSimbolo.AND; break;
                 case 16: tipo = TipoSimbolo.OR; break;
                 case 17: 
                     if(isSentencia(simbolo)){
                         if("if".equals(simbolo)) tipo = TipoSimbolo.IF; 
                         else if("while".equals(simbolo)) tipo = TipoSimbolo.WHILE; 
                         else if("return".equals(simbolo)) tipo = TipoSimbolo.RETURN; 
                         else if("else".equals(simbolo)) tipo = TipoSimbolo.ELSE; 
                     }
                     else if(isTipoD(simbolo)){
                         tipo = TipoSimbolo.TIPODATO;        
                     }
                 break;
                 case 18: tipo = TipoSimbolo.IGUALDAD; break;
                     
                 default: tipo = TipoSimbolo.ERROR;
                                           
             }
        System.out.println(simbolo + " -> " + tipo); 
        
        if(t != 6)
            ind = ind - 1;
        if(t == 5 || t == 8)
            ind = ind + 1;
        continua = false;
    }
    
    public void Finalizar(){
        System.out.println("Cadena Valida...");
        tipo = TipoSimbolo.PESOS;
        //System.exit(0);
    }
     
}
