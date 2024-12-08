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
    public void suma() {
        resultado = valor1 + valor2;
        System.out.println("\nEl resultado de la suma es: " + resultado + "\n");
    }

    public void resta() {

        resultado = valor1 - valor2;
        System.out.println("\nEl resultado de la resta es: " + resultado + "\n");

    }

    public void multiplicacion() {
        resultado = valor1 * valor2;
        System.out.println("\nEl resultado de la multiplicación es: " + resultado + "\n");
    }

    public void division() {

        //Se usa if para evaluar si se puede o no realizar la division ya que no podemos hacerla entre 0.
        if (valor2 == 0) {

            System.out.println("\nError: División por cero no permitida.\n");
        
        } else {

            resultado = valor1 / valor2;
            System.out.println("\nEl resultado de la división es: " + resultado + "\n");
        
        }
    }

    public void salir() {

        continuar = false;
        System.out.println("\nGracias por usar la Calculadora Cuenta Pollos. ¡Hasta luego!");

    }

    public void menu() {

        while (continuar) {
            
            cargardatos();

            switch (opc) {
                case Suma:
                    suma();
                    break;
                
                case Resta:
                    resta();
                    break;
                    
                case Multiplicacion:
                    multiplicacion();
                    break;
                    
                case Division:
                    division();
                    break;
                    
                case Salir:
                    salir();
                    break;
            
            default:

                System.out.println("\n" + "Opción no válida. Por favor, intente nuevamente.\n");

                break;

            }
        }
    }

    
    //Se determina el metodo principal
    public static void main(String[] args) {
        
        //Se crea un objeto llamado calculadora a partir de la clase principal calculadora.
        
       
        Calculadora calculadora = new Calculadora();
        calculadora.menu();

         /*
        Al los metodos y variables ser private no static no se puede llamar directamente a ellas 
        ya que no son compartidas entre todas las instancias por lo tanto debemos crear un objeto (calculadora)
        para poder acceder a ellas.
        */

    }

}