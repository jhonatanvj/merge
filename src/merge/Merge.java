/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package merge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author jhona
 */
public class Merge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de números aleatorios a generar: ");
        int n = scanner.nextInt();

        System.out.print("Ingrese el rango máximo de números aleatorios: ");
        int max = scanner.nextInt();

        if (n > max) {
            System.out.println("Error: n no puede ser mayor que el rango máximo.");
            return;
        }

        ArrayList<Integer> listaNumeros = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            listaNumeros.add(i);
        }

        Collections.shuffle(listaNumeros);

        ArrayList<Integer> seleccionados = new ArrayList<>(listaNumeros.subList(0, n));

        System.out.println("Lista original: " + seleccionados.toString().replaceAll("[\\[\\] ]", ""));
        Merge.separar(seleccionados);
        System.out.println("Lista ordenada: " + seleccionados.toString().replaceAll("[\\[\\] ]", ""));
        scanner.close();
    }

    static void separar(ArrayList<Integer> acomienzo) {
        int tamaño = acomienzo.size();

        if (tamaño < 2) {
            return;
        }

        int mitad = tamaño / 2;
        ArrayList<Integer> izquierdo = new ArrayList<>();
        ArrayList<Integer> derecho = new ArrayList<>();

        for (int i = 0; i < mitad; i++) {
            izquierdo.add(acomienzo.get(i));
        }

        for (int i = mitad; i < tamaño; i++) {
            derecho.add(acomienzo.get(i));
        }

        separar(izquierdo);
        separar(derecho);

        comparar(acomienzo, izquierdo, derecho);
    }

    static void comparar(ArrayList<Integer> acomienzo, ArrayList<Integer> izquierdo, ArrayList<Integer> derecho) {
        int i = 0, j = 0, k = 0;
        int tamañoI = izquierdo.size();
        int tamañoD = derecho.size();

        acomienzo.clear();

        while (i < tamañoI && j < tamañoD) {
            if (izquierdo.get(i) <= derecho.get(j)) {
                acomienzo.add(izquierdo.get(i));
                i++;
            } else {
                acomienzo.add(derecho.get(j));
                j++;
            }
        }

        while (i < tamañoI) {
            acomienzo.add(izquierdo.get(i));
            i++;
        }

        while (j < tamañoD) {
            acomienzo.add(derecho.get(j));
            j++;
        }
    }

}
