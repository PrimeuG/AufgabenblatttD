import java.security.InvalidParameterException;
import java.util.ArrayList;

//Tom Cybart 17469

public class D4Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        String a = "<team><person><vorname>Norrin</vorname><nachname>Radd</nachname><alias>Silver Surfer</alias></person><person><vorname>Ben</vorname><nachname>Grimm</nachname><alias>Das Ding</alias></person></team>";
        /*String a = "<team><person><nachname>Radd</nachname><alias>Silver Surfer</alias>" +
                "<vorname>Norrin</vorname></person>" +
                "<mensch><vorname>Ben</vorname><nachname>Grimm</nachname><alias>Das" +
                "Ding</alias></person></team>  ";*/
        // String a = "<team><person><nachname>Radd</nachname><alias>Silver Surfer</alias><vorname>Norrin</vorname></person><mensch><vorname>Ben</vorname><nachname>Grimm</nachname><alias>DasDing</alias></person></team>";
        ArrayList<String> Personen = new ArrayList<>();
        ArrayList<String> Buchstaben = new ArrayList<>();
        ArrayList<String> doppler = new ArrayList<>();
        ArrayList<String> Wortzähler = new ArrayList<>();
        String v;
        String o;
        String g;
        String fina;

        o = a.replaceAll("\n", "");
        g = o.replaceAll("\t", "");
        v = g.replaceAll("> <", "><");
        fina = v.replaceAll("<>", "");
        String e = fina.replaceAll("/", "");

        String Worte[] = a.split(">");


        for (int b = 0; b < Worte.length; b++) {
            Buchstaben.add(Worte[b]);
        }
        for (int b = 0; b < Buchstaben.size(); b++) {
            if (Buchstaben.get(Buchstaben.size() - 1).charAt(0) == 32) {
                Buchstaben.remove(Buchstaben.size() - 1); // Leerzeichen am Ende wird entfernt
            }
        }

        if (Buchstaben.contains("")) {                          //Durch das Splitten waren Lücken entstanden die Entfernt werden mussten
            Buchstaben.remove("");
        }

        for (int b = 0; b < e.length(); b++) {                  // Hier wird alles außer < und > aussortiert um zu schauen ob jede geöffnete Klammer auch geschlossen wird
            if (e.charAt(b) == 60 || e.charAt(b) == 62) {
                doppler.add(String.valueOf(e.charAt(b)));
            }

        }

        for (int b = 0; b < doppler.size(); b++) {
            if (doppler.get(b).equals("<") && b < doppler.size() - 1) {
                if (doppler.get(b + 1).equals("<")) {
                    throw new IllegalArgumentException("< ist hintereinander gekommen! < wurde noch nicht geschlossen");
                }
            } else if (doppler.get(b).equals("<") && b == doppler.size() - 1) {
                throw new InvalidParameterException("Am Ende der XML-Struktur befindet sich eine offene Klammer, die nicht geschlossen wurde");
            } else if (doppler.get(b).equals(">") && b == 0) {
                throw new InvalidParameterException("Am Anfang der XML-Struktur befindet sich eine geschlossene Klammer, obwohl keine geöffnet wurde");
            } else if (doppler.get(b).equals(">") && b <= (doppler.size() - 2)) {
                if (doppler.get(b + 1).equals(">")) {
                    throw new InvalidParameterException("Es befinden sich zwei geschlossene Klammern direkt hintereinander");
                }
            }
        }

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
            String weitere_Worte[] = doppler.get(b).split("<");         //Hier werden alles nach "<" gesplitted und nur das Element nach < wird in die Arrayliste hinzugefügt
            Wortzähler.add(String.valueOf(weitere_Worte[1]));
        }

        for (int b = 0; b < Wortzähler.size(); b++) {
            if (Wortzähler.indexOf(Wortzähler.get(b)) < Wortzähler.indexOf("/" + Wortzähler.get(b))) {
                Wortzähler.remove("/" + Wortzähler.get(b));                 // Hier wird geschaut ob jedes Tag auch ein schließendes "/Tag" hat und danach aus der Liste entfernt
                Wortzähler.remove(Wortzähler.get(b));
                b--;
            } else {
                System.out.println(Wortzähler);                                 // Hier wird dann eine Exception gethrowed wenn das mit dem /Tag nicht der Fall ist und die Liste wird ausgegeben um Direkt zu gucken welche Tags dort sind und wo das /Tag fehlt
                throw new InvalidParameterException("nicht jeder Tag wurde mit /Tag geschlossen");
            }
        }

        if (Wortzähler.size() != 0) {
            System.out.println(Wortzähler);
            throw new InvalidParameterException("Nicht jedem Tag konnte ein /Tag zugeordnet werden, anbei die Tags die keinem anderen Tag zugeordnet werden konnten");
        }


        doppler.clear();                                //Arrayliste muss nochmal neu Beschrieben werden daher doppeln sich diese Zeilen

        for (int b = 0; b < Worte.length; b++) {
            doppler.add(Worte[b]);
        }
        for (int b = 0; b < doppler.size(); b++) {
            if (doppler.get(doppler.size() - 1).charAt(0) == 32) {
                doppler.remove(doppler.size() - 1);
            }
        }

        for (int b = 0; b < doppler.size(); b++) {                              //Hier werden nun die Namen der Personen in die Liste eingefügt
            String weitere_Worte[] = doppler.get(b).split("<");
            Personen.add(String.valueOf(weitere_Worte[0]));
        }

        for (int b = 0; b < Personen.size(); b++) {                             //falls noch Leerzeichen oder Leerezeichen in der Liste vorhanden sind, werden diese entfernt
            if (Personen.get(b).equals("")) {
                Personen.remove(b);
                b--;
            }
        }
        //Richtige Ausgabe wird hier angeordnet
        System.out.println(Personen.get(Personen.indexOf("Norrin")) + " " + Personen.get(Personen.indexOf("Radd")) + " - " + Personen.get(Personen.indexOf("Silver Surfer")) + "\n" + Personen.get(Personen.indexOf("Ben")) + " " + Personen.get(Personen.indexOf("Grimm")) + " - " + Personen.get(Personen.indexOf("Das Ding")));
    }
}




