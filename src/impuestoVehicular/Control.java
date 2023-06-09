/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impuestoVehicular;

import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class Control {

    Scanner in = new Scanner(System.in);

    //MEDU DE OPCIONES
    void menu() {
        int opcion;
        Ordenamiento objMetodo = new Ordenamiento();

        do {
            System.out.println("MENU IMPUESTO VEICULAR");
            System.out.println("1. Registrar un vehiculo");
            System.out.println("2. Buscar un vehiculo por placa (busqueda lineal)");
            System.out.println("3. Buscar un Vehiculo por modelo ");
            System.out.println("4. Listar numeros de los motores");
            System.out.println("5. Ordenar numero de motor por burbujas");
            System.out.println("6. Ordenar numero de motor por insercion");
            System.out.println("7. Buscar un numero de motor (busqueda binaria)");
            System.out.println("8. Salir");
            System.out.print("INGRESA TU OPCION: ");
            opcion = in.nextInt();
            System.out.println("");
            switch (opcion) {
                case 1 ->
                    objMetodo.registrarVehiculo();
                case 2 ->
                    objMetodo.buscarPlaca();
                case 3 ->
                    objMetodo.buscarModelo();
                case 4 ->
                    objMetodo.listarMotor();
                case 5 ->
                    objMetodo.ordenarBurbuja();
                case 6 ->
                    objMetodo.ordenarPorInserccion();
                case 7 ->
                    objMetodo.busquedaBinaria();
            }
        } while (opcion > 0 && opcion < 8);
    }

}
