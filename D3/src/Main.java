import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.net.*;
import java.io.*;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            ItemContentHandler itemContentHandler = new ItemContentHandler();
            xmlReader.setContentHandler(new ItemContentHandler());
            URL url = new URL("http://www.tagesschau.de/xml/rss2");
            URLConnection connection = url.openConnection();
            connection.setDoInput(true);
            InputStream inStream = connection.getInputStream();
            InputSource inputSource = new InputSource(inStream);
            xmlReader.parse(inputSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}