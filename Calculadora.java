import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;



public class Calculadora extends JFrame{
 /* Creacion de Objetos */
 JButton[] botones;
 JTextField tfPantalla;
 /* // Almacena el número en curso */
 private StringBuilder entradaActual = new StringBuilder();
 private float numeroAnterior = 0, resultado;
 private String operacionActual = "";
 private float numeroActual = 0f; /* Float.parseFloat(entradaActual.toString()); */

 /* creacion de fuente */
 final private Font maiFont = new Font("Arial", Font.BOLD, 16);
 final private Font maiFont1 = new Font("Arial", Font.BOLD, 40);

 public void iniciar() {

     /*-------------------------- Panel de Calcu ---------------------------- */

     /* Aparicion de los botones num en pantalla */
     tfPantalla = new JTextField();
     /* se le pone fuente */
     tfPantalla.setFont(maiFont1);
     /* Acomoda el texto automaticamente a la derecha */
     tfPantalla.setHorizontalAlignment(SwingConstants.RIGHT);
     /* Parametro para que el user no pueda editar */
     tfPantalla.setEditable(false);
     tfPantalla.setPreferredSize(new Dimension(600, 100));

     /*
      * --------------------------- Panel de Boton --------------------------------
      */

     JPanel CalcuPanel = new JPanel();
     /* Espacios del panel: filas, columnas y espaciado */
     CalcuPanel.setLayout(new GridLayout(5, 4, 2, 2));

     /* Inicializacion de los Botones */
     String[] nombreBotones = {

             "C", "", "", "←",
             "7", "8", "9", "/",
             "4", "5", "6", "*",
             "1", "2", "3", "-",
             ".", "0", "=", "+",
     };

     JButton[] botones = new JButton[nombreBotones.length];

     /* iterar para agregar los botones */
     for (int i = 0; i < nombreBotones.length; i++) {

         if (nombreBotones[i].isEmpty()) { // Espacios vacíos
             CalcuPanel.add(new JLabel());
             continue;
         }
         botones[i] = new JButton(nombreBotones[i]);
         botones[i].setFont(maiFont);

         /*
          * Agregar cada boton al panel
          * CalcuPanel.add(botones[i]);
          */
         botones[i].addActionListener((ActionEvent e) -> {
             String contenidoBoton = e.getActionCommand();

             if ("0123456789".contains(contenidoBoton)) {
                 /* Concatena los numeros en la pantalla */
                 entradaActual.append(contenidoBoton);
                 /* Muestra en la pantalla */
                 tfPantalla.setText(entradaActual.toString());
             } else if ("+-*/".contains(contenidoBoton)) {
                 if (entradaActual.length() > 0) {
                     numeroActual = Float.parseFloat(entradaActual.toString());
                 }
                 /* Para guardar el numero anterior mente digitado y el operador */
                 operacionActual = contenidoBoton;
                 /* convierte el StringBuilder a float */
                 numeroAnterior = Float.parseFloat(entradaActual.toString());
                 /* limpia la entrada actual */
                 entradaActual.setLength(0);

             } else if ("C".equals(contenidoBoton)) {
                 /* Limpiar pantalla y reiniciar */
                 entradaActual.setLength(0);
                 tfPantalla.setText("");
                 numeroAnterior = 0;
                 operacionActual = "";

             } else if ("=".equals(contenidoBoton)) {
                 if (entradaActual.length() > 0) {
                     numeroActual = Float.parseFloat(entradaActual.toString());
                 }
                 resultado = 0;

                 switch (operacionActual) {

                     case "+":
                         resultado = numeroAnterior + numeroActual;
                         break;

                     case "-":
                         resultado = numeroAnterior - numeroActual;
                         break;

                     case "*":
                         resultado = numeroAnterior * numeroActual;
                         break;

                     case "/":

                         if (numeroActual != 0) {
                             resultado = numeroAnterior / numeroActual;
                         } else {
                             tfPantalla.setText("Resultado indefinido");
                             entradaActual.setLength(0);
                             return;
                         }
                         break;
                 }

                 tfPantalla.setText(String.valueOf(resultado));
                 entradaActual.setLength(0);
                 /* // Permitir usar el resultado para operaciones futuras */
                 entradaActual.append(resultado);

             } else if ("←".equals(contenidoBoton)) {

                 if (entradaActual.length() > 0) {

                     /* Elmminina el ultimo caracter digitado */
                     entradaActual.deleteCharAt(entradaActual.length() - 1);
                     /* Actualizar el visor */
                     tfPantalla.setText(entradaActual.toString());
                 }

             } else if(".".equals(contenidoBoton)){

                 /* Verifica si el numero actial ya contiene un punto */
                 if (!entradaActual.toString().contains(".")) {
                     /* se agrega el punto si no esta presente */
                     entradaActual.append(contenidoBoton);
                     tfPantalla.setText(entradaActual.toString());
                 }
             }

         });

         /* Agregar cada boton al panel */
         CalcuPanel.add(botones[i]);
     }

     /*
      * -------------------------------PANEL PRINCIPAL ----------------------------
      */

     /* panel principal */
     JPanel mainPanel = new JPanel(new BorderLayout());
     /* se le asigna un color al fondo */
     mainPanel.setBackground(new Color(128, 128, 255));
     /* se le crea un borde vacio */
     mainPanel.setBorder(BorderFactory.createEmptyBorder());

     /* AGREGAR COMPONENTES EN EL PANEL PRINCIPAL */

     mainPanel.add(tfPantalla, BorderLayout.NORTH);
     mainPanel.add(CalcuPanel, BorderLayout.CENTER);

      /* ---------------------- Listener para el cierre de la ventana ---------------- */

         // Agrega un "escuchador" para eventos relacionados con la ventana, como su cierre.
         addWindowListener(new WindowAdapter() {


            @Override
            /*  Sobrescribe el comportamiento predeterminado al cerrar la ventana. */
            public void windowClosing(WindowEvent e){
                JOptionPane.showMessageDialog(null,
                "Gracias por utilizar la Calculadora Cuenta Pollos", 
                "Adios", JOptionPane.INFORMATION_MESSAGE);

                System.exit(0);
            }
        });

     /*
      * -------------------------- PROPIEDADES DE LA VENTANA ------------------------
      */

     setTitle("CALCULADORA CUENTA POLLOS");
     setSize(400, 600);
     setMinimumSize(new Dimension(300, 500));
     setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     add(mainPanel); // agrega mainPanel al JFrame
     setVisible(true);

 }

    
    //Se determina el metodo principal
    public static void main(String[] args) {
        
        //Se crea un objeto llamado calculadora a partir de la clase principal calculadora.
        
       
        Calculadora calculadora = new Calculadora();
        calculadora.iniciar();

         /*
        Al los metodos y variables ser private no static no se puede llamar directamente a ellas 
        ya que no son compartidas entre todas las instancias por lo tanto debemos crear un objeto (calculadora)
        para poder acceder a ellas.
        */

    }

}