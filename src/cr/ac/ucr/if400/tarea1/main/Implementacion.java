
package cr.ac.ucr.if400.tarea1.main;

import cr.ac.ucr.if400.tarea1.Utilidades.Utilidades;
import javax.swing.JOptionPane;

/**
 *
 * @author Melissa Ramirez R
 */
public class Implementacion {
    
    public static void implementaLeer(){
       String result = JOptionPane.showInputDialog(null, "Ingrese el numero decimal");
       
        String flotantResult = Utilidades.leer(result);
        
        JOptionPane.showMessageDialog(null, "El resultado es: " + flotantResult);
    }
    
    public static void implementacionImprimir(){
        String result = JOptionPane.showInputDialog(null, "Ingrese el numero hexadecimal");
        
        String decimalResult = Utilidades.impresion(result);
        
        JOptionPane.showMessageDialog(null, decimalResult);
       
    }
}
