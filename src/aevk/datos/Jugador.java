/*

 */
package aevk.datos;

public class Jugador implements Comparable<Jugador>{
    
    //Atributos 
    private String usuario; //nombre
    private String rol; //clase de jugador
    private int nivelXp; //nivel
    private double arx; //moneda
    private int nvictorias; //n° de duelos ganados
    private int nDuelos; //n° duelos jugados

    public Jugador(String usuario, String rol, int nivelXp, double arx, int nvictorias, int nDuelos) {
        this.usuario = usuario;
        this.rol = rol;
        this.nivelXp = nivelXp;
        this.arx = arx;
        this.nvictorias = nvictorias;
        this.nDuelos = nDuelos;
    }

    public Jugador(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Jugador{" + "usuario=" + getUsuario() + ", rol=" + getRol() + ", nivelXp=" + getNivelXp() + ", arx=" + getArx() + ", nvictorias=" + getNvictorias() + ", nDuelos=" + getnDuelos() + '}';
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @return the nivelXp
     */
    public int getNivelXp() {
        return nivelXp;
    }

    /**
     * @return the arx
     */
    public double getArx() {
        return arx;
    }

    /**
     * @return the nvictorias
     */
    public int getNvictorias() {
        return nvictorias;
    }

    /**
     * @return the nDuelos
     */
    public int getnDuelos() {
        return nDuelos;
    }

    @Override
    public int compareTo(Jugador o) {
        return getUsuario().compareToIgnoreCase(o.getUsuario());
    }
   

  
}
