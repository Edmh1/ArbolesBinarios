/*

 */
package aevk.gui;

import aekv.persistencia.Serializar;
import aevk.datos.Jugador;
import aevk.datos.AevkJugadores;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Menu {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        menu(); 
    }

    private static void menu() throws IOException, FileNotFoundException, ClassNotFoundException {
        String menu = "\n°~~~~~~~~~~~~   Bienvenido al menu de opciones  ~~~~~~~~~~°       "
                + "\n                                                    "
                + "\n1. Ingresar un nuevo jugador      "
                + "\n2. Buscar un jugador por su nombre de usuario   "
                + "\n3. Listar jugadores"
                + "\n4. Cantidad de jugadores en la base de datos      "
                + "\n5. Eliminar un jugador daddo su nombre de usuario"; 
        Serializar persi = new Serializar();
        AevkJugadores jugadoresAevk = persi.toGet(); 
        int opcion=0; 
        
        do {            
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu)); 
            switch (opcion) {
                case 1:
                    String usuario = JOptionPane.showInputDialog("Digite el nombre de usuario del jugador a registrar: "); 
                    String rol = JOptionPane.showInputDialog("Digite el rol del jugador a registrar: ");
                    int nivelXp = Integer.parseInt(JOptionPane.showInputDialog("Digite el nivel de Xp del jugador a registrar: ")); 
                    float arx = Float.parseFloat(JOptionPane.showInputDialog("Digite el numero de monedas (arx) del jugador a registrar: "));
                    int nVictorias= Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de victorias del jugador a registrar: ")); 
                    int nDuelos = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de duelos del jugador a registrar: ")); 
                    Jugador jug = new Jugador(usuario, rol, nivelXp, arx, nVictorias, nDuelos);
                    jugadoresAevk.add(jug);
                    JOptionPane.showConfirmDialog(null, "¡Jugador ingresado correctamente!"); 
                    
                    persi.save(jugadoresAevk);
                    break;
                    
                case 2: 
                    String usuarioBusc = JOptionPane.showInputDialog("Digite el nombre de usuario del jugador a buscar: ");
                    JOptionPane.showMessageDialog(null, "   "+jugadoresAevk.buscar(usuarioBusc));
                    
                    break; 
                    
                    
                case 3:
                    JOptionPane.showMessageDialog(null, jugadoresAevk.toString());
                    
                    break; 
                    

                case 4: 
                    JOptionPane.showMessageDialog(null, "El numero de jugadores en la base de datos es: "+jugadoresAevk.nDeJugadores());
                    
                    break; 
                    
                case 5: 
                    String usuarioEli = JOptionPane.showInputDialog("Digite el nombre de usuario del jugador a buscar: ");
                    jugadoresAevk.eliminar(usuarioEli);
                    JOptionPane.showMessageDialog(null, "Listado de jugadores resultante luego de eliminar: "+jugadoresAevk.toString());
                    
                    break; 
                    
                case 6:
                    
                    break; 
            }
            
        } while (opcion != 10);
        
        
    }
    
    
    
    
}
