import java.util.ArrayList;
import java.util.Random;

public class Player {
    private String Name, Vorname, Mannschaft;
    private int punkte = 0;
    private int anzahlSaetzeGewonnen = 0;
    enum mannschaftEnum{
        A,
        B
    }
    private static ArrayList<Player> players = new ArrayList<Player>();

    public Player(String Name, String Vorname, mannschaftEnum ms) {
        this.Name = Name;
        this.Vorname = Vorname;
        this.Mannschaft = String.valueOf(ms);

        players.add(this);
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }
    public int getPunkte() {
        return punkte;
    }
    public void setAnzahlSaetzeGewonnen(int anzahlSaetzeGewonnen) {
        this.anzahlSaetzeGewonnen = anzahlSaetzeGewonnen;
    }

    public int getAnzahlSaetzeGewonnen() {
        return anzahlSaetzeGewonnen;
    }

    public static ArrayList<Player> getMannschaft(String Mannschaft) {
        ArrayList<Player> mannschaft = new ArrayList<Player>();
        for (Player player : players) {
            if (player.Mannschaft.equals(Mannschaft)) {
                mannschaft.add(player);
            }
        }
        return mannschaft;
    }

    public static void printMannschaft(String Mannschaft){
        ArrayList<Player> mannschaft = getMannschaft(Mannschaft);
        for (Player player : mannschaft){
            System.out.println("Mannschaft: " + player.Mannschaft + ", Name: " + player.Name + " , Vorname: " + player.Vorname);
        }
        System.out.println("\n");
    }

    public static void turnier(String ersteMannschaft, String zweiteMannschaft){
        System.out.println("Der Tournir hat beendet");
    }

    public static Player spielerNominieren(ArrayList<Player> mannschaft){
        Random r = new Random();
        int spielerNummer = r.nextInt(0,4);
        Player nominiert = mannschaft.get(spielerNummer);
        return nominiert;
    }

    public static ArrayList<Player> getPair(ArrayList<Player> ersteMannschaft, ArrayList<Player> zweiteMannschaft){
        ArrayList<Player> pair = new ArrayList<>();
        pair.add(spielerNominieren(ersteMannschaft));
        pair.add(spielerNominieren(zweiteMannschaft));
        return pair;
    }

    //public Player match(ArrayList<Player> mathchPair){
// um ein match zu gewinnen, braucht ein Spieler 3 Sätze zu gewinnen
      //  return ;
   // }

    //public Player satz(ArrayList<Player> mathchPair){
// um ein satz zu gewinnen, braucht ein Spieler 6 Punkte zu sammeln
   //     return ;
    //}
    public static void set(ArrayList<Player> mathchPair){
    while(mathchPair.get(0).getPunkte() < 6 && mathchPair.get(1).getPunkte() < 6){
        Random r = new Random();
        int a = r.nextInt(7);
        int b = r.nextInt(7);
        if (a >= b){
            mathchPair.get(0).setPunkte(mathchPair.get(0).getPunkte() + 1);
        }
        else if (a < b){
            mathchPair.get(1).setPunkte(mathchPair.get(1).getPunkte() + 1);
        }
    }
        System.out.println(mathchPair.get(0).getPunkte());
        System.out.println(mathchPair.get(1).getPunkte());
    }


    // Spieler aus der Mannschaft zum Spiel nominieren: arg - String ArrayList Mannschaft, return - String Spieler;


    // Verlierer aus der Mannschaft löschen: arg - String Spieler, return - String ArrayList Mannschaft

    // Match Simulation: arg - Spieler A, Spieler B, return - Sieger
    // Zähler. Schleife bis 6, dann return Sieger
    // Zufallszahlengenerator: Liste mit 2 Zahlen (0, 1) >> shuffle
    // Summe erhöhen

    // Spiel Simulation: arg - Spieler A, Spieler B, return - Verlierer
    // Zähler. Schleife bis 3, dann return Verlierer
    // "Match Simulation" aufrufen



}
