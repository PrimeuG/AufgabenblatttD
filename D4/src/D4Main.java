import java.util.ArrayList;
import java.util.Map;

public class D4Main {
    public static void main(String[] args) {

        //String a = "<team><person><vorname>Norrin</vorname><nachname>Radd</nachname><alias>Silver Surfer</alias></person><person><vorname>Ben</vorname><nachname>Grimm</nachname><alias>DasDing</alias></person></team>";
        /*String a = "<team><person><nachname>Radd</nachname><alias>Silver Surfer</alias>" +
                "<vorname>Norrin</vorname></person>" +
                "<mensch><vorname>Ben</vorname><nachname>Grimm</nachname><alias>Das" +
                "Ding</alias></person></team>  ";*/
        String a = "<team><person><nachname>Radd</nachname><alias>Silver Surfer</alias><vorname>Norrin</vorname></person><mensch><vorname>Ben</vorname><nachname>Grimm</nachname><alias>DasDing</alias></person></team>";
        ArrayList<String> Personen = new ArrayList<>();
        ArrayList<String> Buchstaben = new ArrayList<>();
        ArrayList<String> Vorname = new ArrayList<>();
        ArrayList<String> Nachname = new ArrayList<>();
        ArrayList<String> Aliasname = new ArrayList<>();
        ArrayList<String> doppler = new ArrayList<>();
        ArrayList<String> Wortzähler = new ArrayList<>();
        String d;
        String c;
        String v;
        String fina;

        v = a.replaceAll("> <", "><");
        d = a.replaceAll("<", "");
        c = a.replaceAll(">", "");
        fina = v.replaceAll("<>", "");
        String e = fina.replaceAll("/", "");

        String Worte[] = a.split(">");


        for (int b = 0; b < Worte.length; b++) {
            Buchstaben.add(Worte[b]);
        }
        for (int b = 0; b < Buchstaben.size(); b++) {
            if (Buchstaben.get(Buchstaben.size() - 1).charAt(0) == 32) {
                Buchstaben.remove(Buchstaben.size() - 1);
            }
        }

        System.out.println(Buchstaben);
        if (Buchstaben.contains("")) {
            Buchstaben.remove("");
        }

        for (int b = 0; b < e.length(); b++) {
            if (e.charAt(b) == 60 || e.charAt(b) == 62) {
                doppler.add(String.valueOf(e.charAt(b)));
            }

        }

        try {
            for (int b = 0; b < doppler.size(); b++) {
                if (doppler.get(b).equals("<") && b < doppler.size() - 1) {
                    if (doppler.get(b + 1).equals("<")) {
                        System.out.println("Hier muss eine Exeption gethrowed werden");
                    }
                } else if (doppler.get(b).equals("<") && b == doppler.size() - 1) {
                    System.out.println("ALAAAARM");
                } else if (doppler.get(b).equals(">") && b == 0) {
                    System.out.println("Exeotion");
                } else if (doppler.get(b).equals(">") && b <= (doppler.size() - 2)) {
                    if (doppler.get(b - 1).equals(">")) {
                        System.out.println("Expetion");
                    }
                }
            }
        } catch (IllegalArgumentException t) {
            t.printStackTrace();

        }

        System.out.println(doppler);

        doppler.clear();

        for (int b = 0; b < Worte.length; b++) {
            doppler.add(Worte[b]);
        }

        for (int b = 0; b < doppler.size(); b++) {
            if (doppler.get(doppler.size() - 1).charAt(0) == 32) {
                doppler.remove(doppler.size() - 1);
            }
        }

        for (int b = 0; b < doppler.size(); b++) {
            String weitere_Worte[] = doppler.get(b).split("<");
            System.out.println(String.valueOf(weitere_Worte[1]));
            Wortzähler.add(String.valueOf(weitere_Worte[1]));
        }

        for (int b = 0; b < Wortzähler.size(); b++) {
            if (Wortzähler.indexOf(Wortzähler.get(b)) < Wortzähler.indexOf("/" + Wortzähler.get(b))) {
                Wortzähler.remove("/" + Wortzähler.get(b));
                Wortzähler.remove(Wortzähler.get(b));
                b--;
            } else {
                System.out.println("Auch fehler");
            }
        }

        if (Wortzähler.size() != 0) {
            System.out.println("Fehler");
        }
        System.out.println(Wortzähler);

        doppler.clear();

        for (int b = 0; b < Worte.length; b++) {
            doppler.add(Worte[b]);
        }
        for (int b = 0; b < doppler.size(); b++) {
            if (doppler.get(doppler.size() - 1).charAt(0) == 32) {
                doppler.remove(doppler.size() - 1);
            }
        }

        for (int b = 0; b < doppler.size(); b++) {
            String weitere_Worte[] = doppler.get(b).split("<");
            Personen.add(String.valueOf(weitere_Worte[0]));
        }
        System.out.println(doppler);

        for (int b = 0; b < Personen.size(); b++) {
            if (Personen.get(b).equals("")) {
                Personen.remove(b);
                b--;
            }
        }


        System.out.println(Personen);
    }


}

