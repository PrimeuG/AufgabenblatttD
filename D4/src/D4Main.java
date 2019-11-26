import java.util.ArrayList;

public class D4Main {
    public static void main(String[] args) {

        String a = "<team><person><vorname>Norrin</vorname><nachname></nachname><alias>Silver Surfer</alias></person><person><vorname>Ben</vorname><nachname>Grimm</nachname><alias>DasDing</alias></person></team> ";
        ArrayList<String> Personen = new ArrayList<>();
        ArrayList<String> Buchstaben = new ArrayList<>();
        ArrayList<String> Vorname = new ArrayList<>();
        ArrayList<String> Nachname = new ArrayList<>();
        ArrayList<String> Aliasname = new ArrayList<>();



        //System.out.println(a.substring(a.indexOf("<person><")));


        int c = a.indexOf("<person><");
        int d = a.indexOf("</person>");
        //System.out.println(a.substring(c,d));

        String Worte [] = a.split(">");

        for (int b = 0; b < Worte.length; b++){
            Buchstaben.add(Worte[b]);
        }


        for (int b = 0; b < Buchstaben.size(); b++){
            if (Buchstaben.get(b).equals("<vorname")){
                Vorname.add(Buchstaben.get(b+1));
            }
            if (Buchstaben.get(b).equals("<nachname")){
                Nachname.add(Buchstaben.get(b+1));
            }
            if (Buchstaben.get(b).equals("<alias")){
                Aliasname.add(Buchstaben.get(b+1));
            }
        }


        //System.out.println(Vorname);
        for (int b = 0 ; b < Vorname.size(); b++){
            int v = Vorname.get(b).indexOf("<");
            String Speicherer = Vorname.get(b).substring(0, v);
            Vorname.set(b, Speicherer);
        }
        for (int b = 0 ; b < Nachname.size(); b++){
            int v = Nachname.get(b).indexOf("<");
            String Speicherer = Nachname.get(b).substring(0, v);
            Nachname.set(b, Speicherer);
        }
        for (int b = 0 ; b < Aliasname.size(); b++){
            if (Aliasname.get(b) != null){
                int v = Aliasname.get(b).indexOf("<");
                String Speicherer = Aliasname.get(b).substring(0, v);
                Aliasname.set(b, Speicherer);
            }
        }
        for (int b = 0 ; b < Aliasname.size(); b++){
            Personen.add(0, Aliasname.get(b));
            Personen.add(0, Nachname.get(b));
            Personen.add(0, Vorname.get(b));
        }
        //ausgabe noch ändern
        for (int b = 0; b < Personen.size(); b++){
            System.out.println(Personen.get(b));
        }
    }
}
