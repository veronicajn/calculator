/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author veronica
 */
public class Controlador {
      boolean operando = true;
    String operador = "=";
    Double acumulador;
    Double resultadofinal;
    
    Vista v ;

    public Controlador(Vista v) {
        this.v = v;
    }
    
    public void run(){
        addListener();
    }
   

    private void addListener() {
     for(int i= 0; i<20; i++){
         
     
     v.boton[i].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
              //donde pone si es con ifelse

                String digito = ae.getActionCommand();// muestra el botón que se vaya tecleando
                String textopantalla = v.Resultado.getText();//Poner texto por pantalla
                acumulador = (double) Double.parseDouble(textopantalla);// convertirlo a numérico real 
                //Comprobar si el valor obtenido es "C"
                if (digito.equals("C")) {
                    v.Resultado.setText("0");
                }
                //Valor obtenido es un digito 1...9
                else if("1234567890".contains(digito)){
                    if (operando) {
                        operando = false;
                        v.Resultado.setText(digito);
                    }//Sumar dos strings para poder poner dos numeros o mas seguidos escritos
                    //concatenar el valor obtenido...
                    else {
                        v.Resultado.setText(textopantalla + digito);
                    }
                    //Si el valor obtenido es .
                } else if (digito.equals(".")) {
                    if (!textopantalla.contains(digito)) {

                        if (operando) {
                            operando = false;
                            v.Resultado.setText("0.");

                        } else {//Para no poder colocar mas de un punto
                            v.Resultado.setText(textopantalla + digito);
                        }
                    }
                }
//SQRT RAIZ CUADRADA
                else if(digito.equals("sqrt") ){
                 acumulador =    Math.sqrt(acumulador); //Asignar con un =
                    v.Resultado.setText( ""+ acumulador); //mostrar resultado por pantalla 
                    operando = true;// poner booleano a true
                }
                //Si el valor obtenido es "+/-
                else if (digito.equals("+/-")){
                    acumulador = acumulador*-1;
                    v.Resultado.setText(""+acumulador);
                    operando = true;
                }
                //Si el valor obtenido es "AC":Inicializar todos los datos miembros
                else if(digito.equals("AC")){
                    operando = true;
                    acumulador = 0.0;
                    v.Resultado.setText("0");// lo que te muestra por pantalla 
                    
                    
                }else{
                switch (operador){
                    case "=":
                      resultadofinal = acumulador  ;
                        break;
                    case "+":
                        resultadofinal += acumulador;
                        break;
                    case "-":
                        resultadofinal -= acumulador;
                            break;
                    case "*":
                        resultadofinal *= acumulador;
                        break;
                    case "/":
                        resultadofinal /= acumulador;
                        break;
                        
                        
                        
                        
                }
                //GUARDAR EL ULTIMO DIGITO
                operador= digito;
                //PONER BOOLEANO TRUE PARA INICIAR OTRO NÚMERO U OPERACIÓN
                operando = true;
                //MOSTRAR POR PANTALLA
                v.Resultado.setText(""+resultadofinal);
                }
            }
        }
    );
    }

}
}
