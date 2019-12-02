import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import java.util.ArrayList;

//Tom Cybart 17469

/**
 * The type Item content handler.
 */
public class ItemContentHandler implements ContentHandler {

    private ArrayList<Item> alleItems = new ArrayList<>();
    private String aktuellerPunkt;
    private Item item;


    public void characters(char[] ch, int start, int length)
            throws SAXException {
        aktuellerPunkt = new String(ch, start, length);
    }

    public void startElement(String uri, String localName, String qName,
                             Attributes atts) throws SAXException {
        if (localName.equals("item")) {
            item = new Item();

        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        // Titel setzen
        if (localName.equals("title") && item != null) {
            item.setTitle(aktuellerPunkt);
        }


        if (localName.equals("item")) {
            alleItems.add(item);
            System.out.println(item);
        }

    }

    public void endDocument() throws SAXException {
    }

    public void endPrefixMapping(String prefix) throws SAXException {
    }

    public void ignorableWhitespace(char[] ch, int start, int length)
            throws SAXException {
    }

    public void processingInstruction(String target, String data)
            throws SAXException {
    }

    public void setDocumentLocator(Locator locator) {
    }

    public void skippedEntity(String name) throws SAXException {
    }

    public void startDocument() throws SAXException {
    }

    public void startPrefixMapping(String prefix, String uri)
            throws SAXException {
    }
}
