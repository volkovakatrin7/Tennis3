import java.util.ArrayList;

public class Player {
    private String Name, Vorname, Mannschaft;
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
