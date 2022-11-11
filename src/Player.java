import java.util.ArrayList;
import java.util.Random;

public class Player {
    private String Name, Vorname, Mannschaft;
    private int punkte = 0;
    private int anzahlSaetzeGewonnen = 0;

    enum mannschaftEnum {
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

    public static void printMannschaft(String Mannschaft) {
        ArrayList<Player> mannschaft = getMannschaft(Mannschaft);
        for (Player player : mannschaft) {
            System.out.println("Mannschaft: " + player.Mannschaft + ", Name: " + player.Name + " , Vorname: " + player.Vorname);
        }
        System.out.println("\n");
    }

    public static void turnier(String ersteMannschaft, String zweiteMannschaft) {
        System.out.println("Der Tournir hat beendet");
    }

    public static Player spielerNominieren(ArrayList<Player> mannschaft) {
        Random r = new Random();
        int spielerNummer = r.nextInt(0, 4);
        Player nominiert = mannschaft.get(spielerNummer);
        return nominiert;
    }

    public static ArrayList<Player> getPair(ArrayList<Player> ersteMannschaft, ArrayList<Player> zweiteMannschaft) {
        ArrayList<Player> pair = new ArrayList<>();
        pair.add(spielerNominieren(ersteMannschaft));
        pair.add(spielerNominieren(zweiteMannschaft));
        System.out.println("Match zwischen : "+pair.get(0).Vorname + " "+pair.get(0).Name+ " - " + pair.get(1).Vorname+" "+pair.get(1).Name);
        return pair;
    }

    public static void match(ArrayList<Player> mathchPair, ArrayList mannschaftA, ArrayList mannschaftB){
// removes Verlierer aus der Mannschaft!!

        boolean runLoop = true;
        while (true){
            getGewinner(mathchPair);

            if (mathchPair.get(0).getAnzahlSaetzeGewonnen() == 3){
                mannschaftB.remove(mathchPair.get(1));
                System.out.println("debugA0 "+mannschaftA.contains(mathchPair.get(1)));
                System.out.println("debugB0 "+mannschaftA.contains(mathchPair.get(1)));
                return;
            }
            else if (mathchPair.get(1).getAnzahlSaetzeGewonnen() == 3){

                mannschaftA.remove(mathchPair.get(0));
                return;
            }
        }
    }

    public static void getGewinner(ArrayList<Player> mathchPair) {
        boolean runLoop = true;
        while (true) {
            Random r = new Random();
            Random r2 = new Random();
            int a = r.nextInt(10);
            int b = r2.nextInt(10);

            if (a >= b) {
                mathchPair.get(0).setPunkte(mathchPair.get(0).getPunkte() + 1);
                if (mathchPair.get(0).getPunkte() == 6) {
                    mathchPair.get(0).setPunkte(0);
                    mathchPair.get(0).setAnzahlSaetzeGewonnen(mathchPair.get(0).getAnzahlSaetzeGewonnen() + 1);
                    return;
                }
            } else if (a < b) {
                mathchPair.get(1).setPunkte(mathchPair.get(1).getPunkte() + 1);
                if (mathchPair.get(1).getPunkte() == 6) {
                    mathchPair.get(1).setPunkte(0);
                    mathchPair.get(1).setAnzahlSaetzeGewonnen(mathchPair.get(1).getAnzahlSaetzeGewonnen() + 1);
                    return;
                }
            }
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
}