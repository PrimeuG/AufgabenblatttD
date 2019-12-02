/**
 * The type Bibliothek.
 */
public class Bibliothek {

    //Tom Cybart Matrikelnummer 17469
    // Bibliothek von Jasper Roloff übernommen aus Aufgabenblatt C
    //Grundideen in Zusammenarbeit mit Florian Eimann und Nicklas Jordan


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws ValidationException the validation exception
     * @throws Exception           the exception
     */
    public static void main(String[] args) throws Medium.ValidationException, Exception {
        Zettelkasten zettelkasten = new Zettelkasten();

        //Überprüfung ob Titel mindest 1 Zeichen enthält
        if (args.length < 1) {
            throw new Exception("Kein Titel angegeben!");
        }
        final String title = args[0];
        System.out.println(title);
        try {
            System.out.println(MediumRequest.readPageInfo(title).getNeusteMediaDaten());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
