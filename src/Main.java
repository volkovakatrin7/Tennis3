import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // String ArrayList Mannschaft A
        // String ArrayList Mannschaft B
        Player Hugo = new Player("Hugo", "Meier", Player.mannschaftEnum.A);
        Player Susi = new Player("Susi", "Sorglos", Player.mannschaftEnum.A);
        Player Fred = new Player("Fred", "Feuerstein", Player.mannschaftEnum.A);
        Player Marie = new Player("Marie", "Müller", Player.mannschaftEnum.A);

        Player Fritz = new Player("Fritz", "Como", Player.mannschaftEnum.B);
        Player Walter = new Player("Walter", "Reindl", Player.mannschaftEnum.B);
        Player Sigrid = new Player("Sigrid", "Volk", Player.mannschaftEnum.B);
        Player Annemarie = new Player("Annemarie", "Bienemann", Player.mannschaftEnum.B);

        Player.printMannschaft("A");
        Player.printMannschaft("B");

        ArrayList<Player> mannschaftA = Player.getMannschaft("A");
        ArrayList<Player> mannschaftB = Player.getMannschaft("B");

        System.out.println(Player.getPair(mannschaftA, mannschaftB));

        Player.match(Player.getPair(mannschaftA, mannschaftB), mannschaftA, mannschaftB);
        Player.printMannschaft("A");
        Player.printMannschaft("B");

    }
}