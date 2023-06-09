/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package impuestoVehicular;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Andres
 */
public class Ordenamiento {

    int num;
    //arreglo para guardar los numeros de motor
    int motores[] = new int[num];
    ArrayList vehiculos = new ArrayList();
    Scanner in = new Scanner(System.in);

    void registrarVehiculo() {

        Vehiculo obj = new Vehiculo();
        System.out.println("DATOS DEL VEHICULO A REGISTRAR");
        System.out.print("Placa: ");
        obj.setPlaca(in.next());
        System.out.print("Numero de motor: ");
        obj.setNumeroMotor(in.nextInt());
        System.out.print("Valor a pagar: ");
        obj.setValorPagar(in.nextInt());
        System.out.print("Nombre del propietario: ");
        obj.setPropietario(in.next());
        System.out.print("Modelo: ");
        obj.setModelo(in.next());

        vehiculos.add(obj);

        motores = new int[vehiculos.size()];
        num = vehiculos.size();

        for (int i = 0; i < motores.length; i++) {
            Vehiculo get = (Vehiculo) vehiculos.get(i);
            motores[i] = get.getNumeroMotor();
        }
        System.out.println("Vehiculo registrado!!");
        System.out.println("--------------------------------------------------");

    }

    void listarMotor() {
        System.out.println("Numeros de motor");
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo get = (Vehiculo) vehiculos.get(i);
            System.out.print(motores[i] + " - ");

        }
        System.out.println("");
        System.out.println("-------------------------------------------------");
    }

    void ordenarporBurbuja(int arreglo[]) {
        int n = arreglo.length;
        //variable usada pa
        int aux = 0;

        for (int i = 0; i < n - 1; i++) {
            /*Este ciclo se encraga de llevar el mayor al final del arreglo
			 * Va desde 0 hasta se haya ido ornando el mayor
			 * */
            for (int j = 0; j < n - i - 1; j++) {
                //en caso de que se cumpla la condicion se intercambia la posicion
                if (arreglo[j] > arreglo[j + 1]) {
                    aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                }
            }

        }

        //Listar el arreglo ordenado
        System.out.println("\n---Arreglo ordenado por metodo Burbuja----");
        for (int i : arreglo) {
            System.out.print(i + " - ");
        }
        System.out.println("");
        System.out.println("-------------------------------------------------");
    }

    void ordenarBurbuja() {
        ordenarporBurbuja(motores);
    }

    public void ordenarPorInserccion() {
        int insercion; // variable temporal para contener el elemento a insertar

        // itera a trav�s de datos.length - 1 elementos
        for (int siguiente = 1; siguiente < motores.length; siguiente++) {
            // almacena el valor en el elemento actual
            insercion = motores[siguiente];

            // inicializa ubicaci�n para colocar el elemento
            int moverElemento = siguiente;

            // busca un lugar para colocar el elemento actual
            while (moverElemento > 0 && motores[moverElemento - 1] > insercion) {
                // desplaza el elemento una posici�n a la derecha
                motores[moverElemento] = motores[moverElemento - 1];
                moverElemento--;
            } // fin de while

            motores[moverElemento] = insercion; // coloca el elemento insertado
            //imprimirPasada( siguiente, moverElemento ); // imprime la pasada del algoritmo
        }
        System.out.println("\n---Arreglo ordenado por metodo Inserccion----");

        for (int i = 0; i < motores.length; i++) {
            System.out.print(motores[i] + " - ");
        }
        System.out.println("");
        System.out.println("--------------------------------------------------");
    }

    void buscarPlaca() {
        System.out.print("Ingrese el numero de placa a buscar: ");
        String placaB = in.next();
        boolean bandera = false;
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo obj1 = (Vehiculo) vehiculos.get(i);
            if (placaB.equalsIgnoreCase(obj1.getPlaca())) {

                System.out.println("Placa: " + obj1.getPlaca());
                System.out.println("Numero del motor: " + motores[i]);
                System.out.println("Valor a pagar: $" + obj1.getValorPagar());
                System.out.println("Nombre propietario: " + obj1.getPropietario());
                System.out.println("Modelo: " + obj1.getModelo());
                bandera = true;
            }
        }
        if (bandera == false) {
            System.out.println("Vehiculo no encontrado");
        }
        System.out.println("");
        System.out.println("-------------------------------------------------");
    }

    void buscarModelo() {
        boolean bandera = false;
        System.out.print("Digite el modelo del vehiculo: ");
        String busqueda = in.next();

        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo obj2 = (Vehiculo) vehiculos.get(i);
            if (busqueda.equalsIgnoreCase(obj2.getModelo())) {

                System.out.println("Placa: " + obj2.getPlaca());
                System.out.println("Numero del motor: " + motores[i]);
                System.out.println("Valor a pagar: $" + obj2.getValorPagar());
                System.out.println("Nombre propietario: " + obj2.getPropietario());
                System.out.println("Modelo: " + obj2.getModelo());
                bandera = true;
            }
        }
        if (bandera == false) {
            System.out.println("No hay vehiculos con ese modelo.");
        }
        System.out.println("--------------------------------------------------");
    }

    void busquedaBinaria() {
        System.out.println("Buscando...");
        System.out.print("Digite el numero de motor a buscar: ");
        double numBuscado = in.nextDouble();

        //llamo al metodo del algortimo de busqueda binaria
        double datoRet = this.busquedaBinaria(numBuscado);

        if (datoRet == -1) {
            System.out.println("Numero de motor no encontrado!!");
        } else {
            System.out.println("Numero de motor Encontrado. Posicion = " + datoRet);
            System.out.println("");
        }

        System.out.println("--------------------------------------------------");
    }

    public double busquedaBinaria(double elementoBusqueda) {
        int inferior = 0; // extremo inferior del �rea de b�squeda
        int superior = motores.length - 1; // extremo superior del �rea de b�squeda
        int medio = (inferior + superior + 1) / 2; // elemento medio
        int ubicacion = -1; // devuelve el valor; -1 si no lo encontr�

        do {
            if (elementoBusqueda == motores[medio]) {
                ubicacion = medio; // la ubicaci�n es el elemento medio actual
            } // el elemento medio es demasiado alto
            else if (elementoBusqueda < motores[medio]) {
                superior = medio - 1; // elimina la mitad superior
            } else // el elemento medio es demasiado bajo
            {
                inferior = medio + 1; // elimina la mitad inferior
            }
            medio = (inferior + superior + 1) / 2; // recalcula el elemento medio
        } while ((inferior <= superior) && (ubicacion == -1));

        return ubicacion; // devuelve 
    }
}
