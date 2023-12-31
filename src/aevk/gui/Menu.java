/*

 */
package aevk.gui;

import aevk.persistencia.Serializar;
import aevk.datos.Jugador;
import aevk.datos.AevkJugadores;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Menu {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        menu(); 
    }

    private static void menu() throws IOException, FileNotFoundException, ClassNotFoundException {
        BufferedImage imagen = ImageIO.read(new File("src/aevk/gui/Logo.png"));
        ImageIcon icono = new ImageIcon(imagen.getScaledInstance(50, 50, 100));
        
        String menu = 
                 "Lista de funciones de la base de datos AevkCorp\n"                                                  
                + "\n1. Ingresar un nuevo jugador      "
                + "\n2. Listar jugadores  "
                + "\n3. Buscar un jugador por su nombre de usuario "
                + "\n4. Eliminar un jugador dado su nombre de usuario  "
                + "\n5. Cantidad de jugadores en la base de datos            "
                + "\n6. Listar jugadores por su rol de juego     "
                + "\n7. Listar a los 10 jugadores con más dinero (monedas arx)     "
                + "\n8. Salir del programa\n  "; 
        
        Serializar persi = new Serializar();
        AevkJugadores jugadoresAevk = persi.toGet(); 
        int opcion=0; 
        
        do {            
            opcion = Integer.parseInt((String) JOptionPane.showInputDialog(null, menu, "Bienvenido al menu de opciones de AevkCorp", 0, icono, null, "Ingrese su opción")); 
            switch (opcion) {
                case 1:
                    String usuario = JOptionPane.showInputDialog("Digite el nombre de usuario del jugador a registrar: "); 
                    String rol = JOptionPane.showInputDialog("Digite el rol del jugador a registrar: ");
                    int nivelXp = Integer.parseInt(JOptionPane.showInputDialog("Digite el nivel de Xp del jugador a registrar: ")); 
                    double arx = Double.parseDouble(JOptionPane.showInputDialog("Digite el numero de monedas (arx) del jugador a registrar: "));
                    int nVictorias= Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de victorias del jugador a registrar: ")); 
                    int nDuelos = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de duelos del jugador a registrar: ")); 
                    Jugador jug = new Jugador(usuario, rol, nivelXp, arx, nVictorias, nDuelos);
                    jugadoresAevk.add(jug);
                    JOptionPane.showConfirmDialog(null, "¡Jugador ingresado correctamente!"); 
                    
                    persi.save(jugadoresAevk);
                    break;
                case 2: 
                    JOptionPane.showMessageDialog(null, jugadoresAevk.toString());
                    break;
                case 3:
                    String usuarioBusc = JOptionPane.showInputDialog("Digite el nombre de usuario del jugador a buscar: ");
                    Jugador usuarioABuscar = jugadoresAevk.buscar(usuarioBusc);
                    if( usuarioABuscar != null){
                        JOptionPane.showMessageDialog(null, "   "+usuarioABuscar);
                    }else{
                        JOptionPane.showMessageDialog(null, "El nombre de usuario ingresado no está en la base de datos");
                    }
                    break; 
                case 4: 
                    String usuarioEli = JOptionPane.showInputDialog("Digite el nombre de usuario del jugador a eliminar: ");
                    jugadoresAevk.eliminar(usuarioEli);
                    JOptionPane.showMessageDialog(null, "Listado de jugadores resultante luego de eliminar: "+jugadoresAevk.toString());
                    persi.save(jugadoresAevk);
                    break;  
                case 5: 
                    JOptionPane.showMessageDialog(null, "El numero de jugadores en la base de datos es: "+jugadoresAevk.nDeJugadores());
                    break;
                case 6:
                    String rolBusc= JOptionPane.showInputDialog(null, "Digite el rol de juego que quiere listar: "); 
                    String list="";
                    for (Jugador jugador : jugadoresAevk.hallarJugadoresPorRol(rolBusc)) {
                        list+=jugador.toString()+"\n";
                    }
                    JOptionPane.showMessageDialog(null, "Listado de jugadores con el rol de juego indicado: \n"+list+"\n");
                    break; 
                case 7: 
                    String lis ="";
                    for (Jugador jugador : jugadoresAevk.top10ConMasDinero()) {
                        lis+=jugador.toString()+"\n";
                    }
                    JOptionPane.showMessageDialog(null, "10 jugadores con mayor cantidad de monedas (arx)"+"\n"+lis);
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar el programa de AevkCorp");
                    break;
                default: 
                    JOptionPane.showMessageDialog(null, "El numero digitado no se encuentra entre las opciones disponibles ");
                    break; 
            }
            
        } while (opcion != 8);
       
    }
  
}
