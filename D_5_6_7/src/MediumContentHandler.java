import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Tom Cybart 17469

/**
 * The type Medium content handler.
 */
public class MediumContentHandler implements ContentHandler {

    private String aktuellerStand;                                                                                                        //aktueller Wert des parsers
    private MediumSeite mediaSeite = null;                                                                                               //die gesamte Website
    private MediumDaten mediaDaten = null;                                                                                               //enthält timestamp und contributor
    private MediumUserDaten websiteUserDaten = null;                                                                                     //enthält Nutzername und IP
    private WikiBooks wikiBuch = null;                                                                                                   //Lagerort der Bücher, sowie Kapitel

    public void characters(char[] ch, int start, int length) throws SAXException {
        aktuellerStand = new String(ch, start, length);
    }

    public void startElement(String uri, String localname, String qName, Attributes atts) throws SAXException {                         //start Element für die einzelnen Objekte
        switch (localname) {
            case "page":
                mediaSeite = new MediumSeite();
                mediaDaten = new MediumDaten();
                break;
            case "contributor":
                websiteUserDaten = new MediumUserDaten();
                break;
            case "text":
                wikiBuch = new WikiBooks();
                break;
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {                                            //end Element mit den einzelnen cases
        if (wikiBuch != null) {
            switch (localName) {
                case "text":                                                                                                            //setzt Regal und Lagerort
                    wikiBuch.setRegal(aktuellerStand); // Regal und Kategorie sind hier null, finde den Fehler für Aufgabe 7 nicht
                    mediaDaten.setLagerOrt(wikiBuch);
                    wikiBuch = null;
                    break;
            }
        } else if (websiteUserDaten != null) {
            switch (localName) {
                case "ip":                                                                                                              //setzt ip falls gefunden
                    websiteUserDaten.setIp(aktuellerStand);
                    break;
                case "username":                                                                                                        //setzt username falls gefunden
                    websiteUserDaten.setUsername(aktuellerStand);
                    break;
                case "contributor":                                                                                                     //wertet ip und username aus und setzt dann cotributor
                    mediaDaten.setContributor(websiteUserDaten);
                    websiteUserDaten = null;
                    break;
            }
        } else if (mediaDaten != null) {
            switch (localName) {
                case "timestamp":                                                                                                        //sucht nach timestamp und parsed dann das Datum
                    SimpleDateFormat datum = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                    try {
                        Date date = datum.parse(aktuellerStand);
                        mediaDaten.setTimestamp(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case "revision":
                    mediaSeite.setNeuesteMediaDaten(mediaDaten);                                                                           //setzt die MediumDaten für MediumSeite
                    mediaDaten = null;
                    break;
            }
        } else if (mediaSeite != null) {                                                                                                   //setzt den Titel
            switch (localName) {
                case "title":
                    mediaSeite.setTitel(aktuellerStand);
                    break;
            }
        }

    }

    /**
     * Gets media seite.
     *
     * @return the media seite
     * @throws Exception the exception
     */
    public MediumSeite getMediaSeite() throws Exception {                                                                                    //falls keine Seite erstellt wurde (weil nicht gefunden) schmeißt er die Fehlermeldung, ansonsten gibt er die Seite zurück
        if (mediaSeite == null) {
            throw new Exception("Website nicht gefunden!");
        }
        return mediaSeite;
    }

    public void endDocument() throws SAXException {
    }

    public void endPrefixMapping(String prefix) throws SAXException {
    }

    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
    }

    public void processingInstruction(String target, String data) throws SAXException {
    }

    public void setDocumentLocator(Locator locator) {
    }

    public void skippedEntity(String name) throws SAXException {
    }

    public void startDocument() throws SAXException {
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }
}