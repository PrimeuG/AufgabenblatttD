public class Bibliothek {

    public static void main(String[] args) throws Medium.ValidationException, Exception {
        Zettelkasten zettelkasten = new Zettelkasten();                                                          //Aufgabenblatt C von Jasper Roloff übernommen!

        if (args.length < 1) {                                                                                  //guckt ob der Titel gesetzt wurde bzw ob er mindestens 1 Zeichen lang ist
            throw new Exception("Kein Titel angegeben!");
        }
        final String title = args[0];
        System.out.println(title);
        try {
            System.out.println(MediaRequest.readPageInfo(title).getNeusteMediaDaten());
        } catch (Exception e) {
            e.printStackTrace();
        }
}
