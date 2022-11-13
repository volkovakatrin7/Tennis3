import java.util.ArrayList;
import java.util.Random;

public class Player {

    // class members
    private String Name, Vorname, Mannschaft;
    private int punkte = 0;
    private int anzahlSaetzeGewonnen = 0;

    enum mannschaftEnum {
        A,
        B
    }

    private static ArrayList<Player> players = new ArrayList<Player>();

    // constructor
    public Player(String Name, String Vorname, mannschaftEnum ms) {
        this.Name = Name;
        this.Vorname = Vorname;
        this.Mannschaft = String.valueOf(ms);

        players.add(this);
    }

    // getters and setters
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

    // helpers
    public static void printMannschaft(String Mannschaft) {
        ArrayList<Player> mannschaft = getMannschaft(Mannschaft);
        for (Player player : mannschaft) {
            System.out.println("Mannschaft: " + player.Mannschaft + ", Name: " + player.Name + " , Vorname: " + player.Vorname + ", Punkte: " + player.punkte + ", Spiele_gewonnen: " + player.anzahlSaetzeGewonnen);
        }
        System.out.println("\n");
    }

    public static void printSpieler(Player player) {
        System.out.println("Mannschaft: " + player.Mannschaft + ", Name: " + player.Name + " , Vorname: " + player.Vorname);
    }

    // methods to simulate a tournament
    public static void turnier(String ersteMannschaft, String zweiteMannschaft) {
        System.out.println("Turnierstart\n");
        int counter_match = 1;
        ArrayList <Player> mannschaftA = getMannschaft(ersteMannschaft);
        ArrayList <Player> mannschaftB = getMannschaft(zweiteMannschaft);

        while(true) {
            System.out.println("" + counter_match + ". Match");
            Player verlierer = match(mannschaftA, mannschaftB);
            counter_match ++;

           if (mannschaftA.contains(verlierer)) {
               mannschaftA.remove(verlierer);
               System.out.println("Gewonnen von Mannschaft B");
           }

            else if (mannschaftB.contains(verlierer)) {
                mannschaftB.remove(verlierer);
                System.out.println("Gewonnen von Mannschaft A");
            }
            System.out.println("\n");


            if (mannschaftA.isEmpty()) {
                System.out.println("Gewinner des Tourniers:");
                for (Player player : mannschaftB){
                    printSpieler(player);
                }
                break;
            } else if (mannschaftB.isEmpty()) {
                System.out.println("Gewinner des Tourniers:");
                for (Player player : mannschaftA){
                    printSpieler(player);
                }
                break;
            }
        }
    }

    public static Player match(ArrayList mannschaftA, ArrayList mannschaftB){
        ArrayList <Player> mathchPair = getPair(mannschaftA, mannschaftB);
        // returns Verlierer
        while (true){
            satz(mathchPair);
            if (mathchPair.get(0).getAnzahlSaetzeGewonnen() == 3){
                mathchPair.get(0).setAnzahlSaetzeGewonnen(0);
                mathchPair.get(1).setAnzahlSaetzeGewonnen(0);
                return mathchPair.get(1);
            }
            else if (mathchPair.get(1).getAnzahlSaetzeGewonnen() == 3){
                mathchPair.get(1).setAnzahlSaetzeGewonnen(0);
                mathchPair.get(0).setAnzahlSaetzeGewonnen(0);
                return mathchPair.get(0);
            }
        }
    }

    public static Player spielerNominieren(ArrayList<Player> mannschaft) {
        Random r = new Random();
        int spielerNummer = r.nextInt(0, mannschaft.size());
        Player nominiert = mannschaft.get(spielerNummer);
        return nominiert;
    }

    public static ArrayList<Player> getPair(ArrayList<Player> ersteMannschaft, ArrayList<Player> zweiteMannschaft) {
        ArrayList<Player> pair = new ArrayList<>();
        pair.add(spielerNominieren(ersteMannschaft));
        pair.add(spielerNominieren(zweiteMannschaft));
        for (Player player : pair){
            printSpieler(player);
        }
        return pair;
    }


    public static void satz(ArrayList<Player> mathchPair) {
        while (true) {
            Random r = new Random();
            int gewinner = r.nextInt(2);
            int verlierer = 1 - gewinner;

            mathchPair.get(gewinner).setPunkte(mathchPair.get(gewinner).getPunkte() + 1);

            if (mathchPair.get(gewinner).getPunkte() == 6) {
                System.out.println("" + mathchPair.get(0).getPunkte() + " - " + mathchPair.get(1).getPunkte());
                mathchPair.get(gewinner).setAnzahlSaetzeGewonnen(mathchPair.get(gewinner).getAnzahlSaetzeGewonnen() + 1);
                mathchPair.get(gewinner).setPunkte(0);
                mathchPair.get(verlierer).setPunkte(0);
                break;
                }

            }
        }
}