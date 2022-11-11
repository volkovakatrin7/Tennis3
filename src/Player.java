import java.util.ArrayList;

public class Player {
    private String Name, Vorname;
    private enum mannschaft{
        A,
        B
    }
    private static ArrayList<Player> players = new ArrayList<Player>();

    public Player(String Name, String Vorname, String Mannschaft) {
        this.Name = Name;
        this.Vorname = Vorname;
        this.Mannschaft = Mannschaft;

        players.add(this);
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
}
