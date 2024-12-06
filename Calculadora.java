import java.util.Scanner;

public class Calculadora {

    //Se definen las opciones del menu como constantes para facilitar el manejo de la info
    //Se evita tambien el uso de numeros falsos, en este caso no hay forma de variar las opciones del menu.
    //Una vez determinadas como constantes.
    private static final int Suma = 1;
    private static final int Resta = 2;
    private static final int Multiplicacion = 3;
    private static final int Division = 4;
    private static final int Salir = 5;

    //Se determinan las variables que almacenan valores
    //Se determina tambien el valor booleano continuar.
    private float valor1, valor2, resultado;
    private int opc;
    private boolean continuar = true;

    //Se define el objeto Scanner en una sola linea para todo el codigo.
    private Scanner leer = new Scanner(System.in);

    //Se define la funcion del metodo para cargar datos.
    public void cargardatos() {

        //Mostrar menu.
        System.out.println("*****Menu*****\n1. Suma \n2. Resta \n3. Multiplicación \n4. División \n5. Salir");
        System.out.println("\nDigite una opción: ");
        opc = leer.nextInt();


        //Si el usuario no desea salir, se piden los valores
        if (opc != Salir) {
            
            System.out.println("Digite el valor 1: ");
            valor1 = leer.nextFloat();

            System.out.println("Digite el valor 2: ");
            valor2 = leer.nextFloat();

        }

    }


    //Se determinan las funciones de los metodos para cada operacion.
    
}