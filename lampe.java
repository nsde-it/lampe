/**
 * Beschreiben Sie hier die Klasse Lampe.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import basis.*;
import java.awt.Color;

public class Lampe
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Stift stift;
    private Color farbe;
    private int radius; // der Lampe
    private int x, y; // Position
    private boolean an; // an oder aus
    private boolean party;
   
    public Lampe()
    {
       stift = new Stift();
       farbe = Farbe.ROT;
       x = Hilfe.zufall(10,190);
       y = Hilfe.zufall(10,190);
       radius = 50;
       an = true;
       party = false;
       
       farbe = Farbe.rgb(247, 183, 98);
    }
    
    public void zufallsFarbe() {
        if (party) {
            farbe = Farbe.rgb(Hilfe.zufall(150,250),Hilfe.zufall(150,250),Hilfe.zufall(150,250));
        }
    }

    public void partyModusWechseln() {
        party = !party;
    }
    
    public void setzePosition(int pX, int pY) {
        //diese Methode ist vollständing und soll als Beispiel für die
        //setze-Methoden dienen.
        //zuerst wird der Kreis gelöscht.
        this.loesche();
        //dann werden die beiden Attribute x und y mit den Werten aus pX und 
        //pY neu gesetzt. 
        this.x = pX; this.y = pY;
        //dann wird der Kreis an der neuen Position wieder gezeichnet.
        this.zeige();
    }
    
    public void setzeFarbe(int r,int g, int b) {
        //hier sollst du nach dem Muster der Methode setzePosition() die
        //Farbe setzen.
        this.loesche();
        this.farbe = Farbe.rgb(r, g, b);
        this.zeige();
    } //setzeFarbe
    
    public void setzeRadius(int r) {
        //hier sollst du nach dem Muster der Methode setzePosition() den
        //Radius setzen.
        this.loesche();
        this.radius = r;
        this.zeige();
    } //setzePosition
    
    public void loesche() {
       stift.setzeFuellMuster(Muster.GEFUELLT);
       stift.radiere();
       stift.kreis(x,y,radius);
       //hier muss noch der Kreis an der aktuellen Position x,y wegradiert
       //werden.
       //this.gibX(), this.gibY();
    }
    
    public void zeige() {
        //diese Methode ist vollständig und zeichnet einen ausgefüllten Kreis
        //wenn an den true hat und eine "durchsichtigen" Kreis, wenn an den Wert
        //false hat.
        stift.normal();
        
        if (an) {
            stift.setzeFuellMuster(Muster.GEFUELLT);
            stift.setzeFarbe(farbe);
            stift.kreis(x,y,radius);
        }
         else {
             stift.setzeFuellMuster(Muster.DURCHSICHTIG);
             stift.setzeFarbe(Farbe.SCHWARZ);
             stift.kreis(x,y,radius);
        }
        
        
    }
    
    public void schalteAn() {
        //hier muss die Variable an verändert werden und die
        //Lampe gelöscht und wieder gezeichnet werden.
        this.an = true;
        this.loesche();
        this.zeige();
    }
    
    public void schalteAus() {
        //hier muss analog zu schalteAn() verfahren werden.
        this.an = false;
        this.loesche();
        this.zeige();
    }
    
    public void blinke() {
        //hier muss die Lampe aus und nach kurzer Pause wieder angeschaltet
        //werden.
        this.schalteAn();
        zufallsFarbe();
        Hilfe.warte(100);
        this.schalteAus();
    }
    
    public int gibX() {
        //dieses Methode ist vollständig und gibt die x-Position zurück
        //sie soll als Beispiel für die anderen get-Methoden dienen.
        return x;
    }
    
    public int gibY() {
        //analog zu gibX()
        return y;
    }
    
    public int gibRadius() {
        //analog zu gibX()
        return radius;
    }
    
    public boolean gibZustand() {
        //analog zu gibX()
        return an;
    }
    
    public boolean istDrin(int maus_x, int maus_y) {
        //diese Methode überprüft, ob sich der Mauszeiger über der Lampe
        //befindet. Wenn ja, liefert die Methode boolean zurück.
        if (Hilfe.betrag(this.x-maus_x)<this.radius && Hilfe.betrag(this.y-maus_y)<this.radius) {
            return true;
        }
        else
        {
            return false;
        }    
        
        
    }
}
