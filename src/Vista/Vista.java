/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author veronica
 */
public class Vista extends JFrame {
    public JTextField Resultado = null;
    public JButton[] boton;
    public JPanel pantalla, teclas;
    //CONSTRUCTOR
    public Vista(){
        setTitle("Calculadora");
        Pantalla();
        Teclado();
        setSize(250,250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        }
    //Método pantalla
    
    private void Pantalla() {
    pantalla = new JPanel();//Crear panel de pantalla
      pantalla.setLayout(new GridLayout(1,1));//Establecer Layout
      Resultado = new JTextField("0");//Texto inicial "0"
      Resultado.setHorizontalAlignment(JTextField.RIGHT);//Alinear a la derecha
      Resultado.setFont(new Font("New Times Roman", Font.BOLD, 25));//Color de texto
      Resultado.setBackground(Color.white);//Color de fondo
      Resultado.setBorder(BorderFactory.createLineBorder(Color.pink));//Añadir borde a la ventana
      
     pantalla.add(Resultado);
      getContentPane().add( pantalla,BorderLayout.NORTH);
    }

    private void Teclado() {
        teclas=new JPanel();//Crear panel nuevo
        teclas.setLayout(new GridLayout(4,5));//Establecer Layout( filas, columnas)
        addBoton(Color.MAGENTA);
        
       getContentPane().add(teclas,BorderLayout.CENTER);
        
   }
  public void addBoton( Color colorboton) {
         boton = new JButton[20];
String[] arrayN ={"7","8","9","/","C","4","5","6","*","√","1","2","3","-","AC","0", "±",",","+","="};
        
        

     
        for (int i = 0; i < boton.length; i++) {
            boton[i] = new JButton();
            boton[i].setText(arrayN[i]);
            boton[i].setForeground(colorboton);
            teclas.add(boton[i]);
        }
    }
}
