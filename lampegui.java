/**
 * Beschreiben Sie hier die Klasse LampeGui.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import basis.*;

public class LampeGUI
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private Fenster fenster;
    private Knopf kEnde;
    private Knopf kZeige;
    private Knopf kAn;
    private Knopf kAus;
    private Stift stift;
    private Maus maus;
    private WahlBox partyModus;
    
    //Hier müssen noch die Variablen für die Lampen ergänzt werden.
    private Lampe lampe1;
    private Lampe lampe2;
   
    public  LampeGui()
    {
      fenster =new Fenster(600,600);
      kEnde =new Knopf("Ende",460,400,80,20);
      kZeige =new Knopf("Zeige",60,400,80,20);
      kAn = new Knopf("AN", 150,400,60,20);
      kAus = new Knopf("AUS",370,400,60,20);
      stift = new Stift();
      maus = new Maus();
      partyModus = new WahlBox("Party", 250 ,400, 80, 20);

      //Hier müssen noch die beiden Lampenobjekte erzeugt werden.
      lampe1 = new Lampe();
      lampe2 = new Lampe();
      
      //Wenn ihr Lampenobjete erzeugt habt, müsst ihr die Methode
      //setzePosition() der Lampe nutzen, um die aktuelle Position
      //festzulegen.
      lampe1.setzePosition(100, 100);
      lampe2.setzePosition(200, 100);
      
      lampe1.schalteAn(); // Problem beheben mit fehlerhaften Erstellung
      
      fuehreAus();
    }


    public void fuehreAus()
    {
        //innerhalb der while-Schleife findet ihr schon die if-Abfragen
        //für die verschiedenen Knöpfe. Innerhalb der if-Abfragen sollt
        //ihr die Methoden der Lampenobjekte nutzen, um die Lampen zu
        //manipulieren.
        while (!kEnde.wurdeGedrueckt()) {
            Hilfe.warte(10);
            
            if (kZeige.wurdeGedrueckt()) {
                lampe1.zeige();
                lampe2.zeige();
            }
            
            if (kAn.wurdeGedrueckt()) {
                lampe1.schalteAn();
                lampe2.schalteAn();
            }
            
            if (kAus.wurdeGedrueckt()) {
                lampe1.schalteAus();
                lampe2.schalteAus();
            }
            
            if (partyModus.wurdeGewaehlt()) {
                lampe1.partyModusWechseln();
                lampe2.partyModusWechseln();
            }

            //Lampe soll blinken, wenn Mauszeiger über der Lampe ist. 
            //In der folgenden if-Anweisung müsst ihr zuerst von den
            //Lampenobjekten, ob der Mauszeiger über ihnen ist. Dazu
            //gibt es eine passende Methode. Wenn das der Fall ist, dann
            //soll die Lampe blinken. Es gibt zwei if-Anweisungen, weil
            //es zwei Lampen gibt.
            
            if (lampe1.istDrin(maus.hPosition(), maus.vPosition())) {
                lampe1.blinke();
            }
            
            if (lampe2.istDrin(maus.hPosition(), maus.vPosition())) {
                lampe2.blinke();
            }
                
           
        }
    }
//}
