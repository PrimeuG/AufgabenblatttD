import java.net.URL;
import java.util.Formatter;

/**
 * The type Elektronisches medium.
 */
//Tom Cybart 17469


public class ElektronischesMedium extends Medium {
    private String url;

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        if (!ElektronischesMedium.checkURL(url)) {
            System.out.println("Fehler: ungültige URL!");
        }
        this.url = url;
    }

    @Override
    public String calculateRepresentation() {
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);

        formatter.format("Titel: %s", this.getTitel());
        stringBuilder.append(System.getProperty("line.separator"));

        // URL
        formatter.format("URL: %s", this.getUrl());
        stringBuilder.append(System.getProperty("line.separator"));

        return stringBuilder.toString();
    }

    @Override
    public void validate() throws ValidationException {
        super.validate();

        if (this.url == null || this.url.trim().equals("")) {
            throw new ValidationException("empty url not allowed");
        }
    }

    /**
     * Check url boolean.
     *
     * @param urlString the url string
     * @return the boolean
     */
    public static boolean checkURL(String urlString) {
        try {
            URL url = new URL(urlString);
            url.toURI();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}