package compiladors;

import java.io.IOException;
//import java.util.regex.*;

public class SintacticoS {

    LexicoS lexico = new LexicoS("a+b");
    Pila pila = new Pila();

    int[] idReglas = new int[2];
    int[] LioReglas = new int[2];

    SintacticoS() throws IOException {
        //analiza();
        Ejercicio1();
    }

    private void comprueba(String simbolo) throws IOException {
        if (lexico.simbolo.equals(simbolo)) {
            lexico.sigSimbolo();
        } else {
            lexico.error();
        }
    }

    private void analiza() throws IOException {
        lexico.sigSimbolo();
        comprueba("$");
        System.out.println("Cadena valida...");
        System.exit(0);

        //( ([a-d|A-Z])+ \d* = ([a-d|A-Z]\d)+ (-|+)* ([a-d|A-Z]\d)+ ; )? 
    }

    private void ejemplo1() {
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        pila.muestra();
        System.out.println(pila.top());
        System.out.println(pila.top());
        System.out.println(pila.pop());
        System.out.println(pila.pop());
    }

    private void ejemplo2() {
        lexico.sigSimbolo();
        while (lexico.simbolo != "$") {
            lexico.sigSimbolo();
            System.out.println(lexico.simbolo);
        }
    }

    private void ejemplo3() {

        boolean aceptacion = false;
        int fila, columna, accion;
        int[][] tablaLR = new int[3][3];

        tablaLR[0][0] = 2;
        tablaLR[0][1] = 0;
        tablaLR[0][2] = 1;

        tablaLR[1][0] = 0;
        tablaLR[1][1] = -1;
        tablaLR[1][2] = 0;

        tablaLR[2][0] = 0;
        tablaLR[2][1] = -2;
        tablaLR[2][2] = 0;

        pila.push(1); //1 == $
        pila.push(0);
        lexico.sigSimbolo();

        fila = pila.top();
        columna = lexico.tipo;
        accion = tablaLR[fila][columna];

        pila.muestra();
        System.out.println("Entrada:" + lexico.simbolo);
        System.out.println("Accion:" + accion);

        pila.push(lexico.tipo);
        pila.push(accion);
        lexico.sigSimbolo();

        fila = pila.top();
        columna = lexico.tipo;
        accion = tablaLR[fila][columna];

        pila.muestra();
        System.out.println("Entrada:" + lexico.simbolo);
        System.out.println("Accion:" + accion);

        pila.pop();
        pila.pop();

        fila = pila.top();
        columna = lexico.tipo;
        accion = tablaLR[fila][columna];

        pila.muestra();
        System.out.println("Entrada:" + lexico.simbolo);
        System.out.println("Accion:" + accion);

        fila = pila.top();
        columna = 2; //No terminal E
        accion = tablaLR[fila][columna]; // = 1

        //Transicion
        pila.push(2); //E
        pila.push(accion);

        pila.muestra();
        System.out.println("Entrada:" + lexico.simbolo);
        System.out.println("Accion:" + accion);

        fila = pila.top();
        columna = lexico.tipo;
        accion = tablaLR[fila][columna];

        pila.muestra();
        System.out.println("Entrada:" + lexico.simbolo);
        System.out.println("Accion:" + accion);

        aceptacion = accion == -1;
        if (aceptacion) {
            System.out.println("Aceptación");
        } else {
            System.out.println("No aceptación");
        }

    }

    private void Ejercicio1() {
        boolean aceptacion = false;
        int fila, columna, accion;
        int[][] tablaLR = new int[5][4];

        tablaLR[0][0] = 2;
        tablaLR[0][1] = 0;
        tablaLR[0][2] = 0;
        tablaLR[0][3] = 1;

        tablaLR[1][0] = 0;
        tablaLR[1][1] = 0;
        tablaLR[1][2] = -1;
        tablaLR[1][3] = 0;

        tablaLR[2][0] = 0;
        tablaLR[2][1] = 3;
        tablaLR[2][2] = 0;
        tablaLR[2][3] = 0;

        tablaLR[3][0] = 4;
        tablaLR[3][1] = 0;
        tablaLR[3][2] = 0;
        tablaLR[3][3] = 0;

        tablaLR[4][0] = 0;
        tablaLR[4][1] = 0;
        tablaLR[4][2] = -2;
        tablaLR[4][3] = 0;

        pila.push(2); //2 == $
        pila.push(0);
        lexico.sigSimbolo();

        fila = pila.top();
        columna = lexico.tipo;
        accion = tablaLR[fila][columna];

        pila.muestra();
        System.out.println("Entrada:" + lexico.simbolo); //a
        System.out.println("Accion:" + accion); //2

        pila.push(lexico.tipo);
        pila.push(accion);
        lexico.sigSimbolo();

        fila = pila.top();
        columna = lexico.tipo;
        accion = tablaLR[fila][columna];

        pila.muestra();
        System.out.println("Entrada:" + lexico.simbolo); //1
        System.out.println("Accion:" + accion); //3

        pila.push(lexico.tipo);
        pila.push(accion);
        lexico.sigSimbolo();

        fila = pila.top();
        columna = lexico.tipo;
        accion = tablaLR[fila][columna];

        pila.muestra();
        System.out.println("Entrada:" + lexico.simbolo); //0
        System.out.println("Accion:" + accion); //4

        pila.push(lexico.tipo);
        pila.push(accion);
        lexico.sigSimbolo();

        fila = pila.top();
        columna = lexico.tipo;
        accion = tablaLR[fila][columna];

        pila.muestra();
        System.out.println("Entrada:" + lexico.simbolo); //2
        System.out.println("Accion:" + accion); //r1

        pila.pop();
        pila.pop();

        fila = pila.top();
        columna = 3; //No terminal E
        accion = tablaLR[fila][columna];

        //Transicion
        pila.push(3); //E
        pila.push(1); //1?

        pila.muestra();
        System.out.println("Entrada:" + lexico.simbolo); // 2
        System.out.println("Accion:" + accion); //r0

        fila = pila.top(); //1
        columna = lexico.tipo; //2
        accion = tablaLR[fila][columna];

        pila.muestra();
        System.out.println("Entrada:" + lexico.simbolo);
        System.out.println("Accion:" + accion);

        aceptacion = accion == -1;
        if (aceptacion) {
            System.out.println("Aceptación");
        } else {
            System.out.println("No aceptación");
        }
    }

    private void Ejercicio2() {
        boolean aceptacion = false;
        int fila, columna, accion = 0;
        int[][] tablaLR = new int[5][4];

        tablaLR[0][0] = 2;
        tablaLR[0][1] = 0;
        tablaLR[0][2] = 0;
        tablaLR[0][3] = 1;

        tablaLR[1][0] = 0;
        tablaLR[1][1] = 0;
        tablaLR[1][2] = -1;
        tablaLR[1][3] = 0;

        tablaLR[2][0] = 0;
        tablaLR[2][1] = 3;
        tablaLR[2][2] = -3;
        tablaLR[2][3] = 0;

        tablaLR[3][0] = 2;
        tablaLR[3][1] = 0;
        tablaLR[3][2] = 0;
        tablaLR[3][3] = 4;

        tablaLR[4][0] = 0;
        tablaLR[4][1] = 0;
        tablaLR[4][2] = -2;
        tablaLR[4][3] = 0;

        idReglas[0] = 3;
        idReglas[1] = 3;
        LioReglas[0] = 3;
        LioReglas[1] = 1;

        pila.push(2); //2 == $
        pila.push(0);
        lexico.sigSimbolo();

        fila = pila.top();
        columna = lexico.tipo;
        accion = tablaLR[fila][columna];

        pila.muestra();
        System.out.println("Entrada:" + lexico.simbolo); //a
        System.out.println("Accion:" + accion); //2

        while (!aceptacion) {
            if (accion > 0) {
                pila.push(lexico.tipo);
                pila.push(accion);
                lexico.sigSimbolo();
            } else if (accion < 0) {
                pila.pop();
                pila.pop();
                pila.pop();
                if (accion == -3) {
                    pila.push(2);
                } else {
                    pila.push(1);
                }
            } else {
                break;
            }

            fila = pila.top();
            columna = lexico.tipo;
            accion = tablaLR[fila][columna];

            pila.muestra();
            System.out.println("Entrada:" + lexico.simbolo); //a
            System.out.println("Accion:" + accion); //2

        }

        fila = pila.top(); // debe ser 0, para aceptar
        System.out.println("fla:" + fila);
        columna = 3; //No terminal E
        accion = tablaLR[fila][columna];

        //Transicion
        pila.push(3); //E
        pila.push(accion); //accion = 1?  por esto simpre acepta

        pila.muestra();
        System.out.println("Entrada:" + lexico.simbolo); // 2
        System.out.println("Accion:" + accion); //0

        fila = pila.top(); //1
        columna = lexico.tipo; //2
        accion = tablaLR[fila][columna];//r0

        pila.muestra();
        System.out.println("Entrada:" + lexico.simbolo);
        System.out.println("Accion:" + accion);

        aceptacion = accion == -1;
        if (aceptacion) {
            System.out.println("Aceptación");
        } else {
            System.out.println("No aceptación");
        }
    }

}
