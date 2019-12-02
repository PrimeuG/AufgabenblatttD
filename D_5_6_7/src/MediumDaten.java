import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The type Medium daten.
 */
//Tom Cybart 17469

public class MediumDaten { //revision

    private Date timestamp;                                                                                                         //Datum der letzten Änderung
    private MediumUserDaten contributor;//Autor
    private WikiBooks lagerOrt;

    /**
     * Gets contributor.
     *
     * @return the contributor
     */
    public MediumUserDaten getContributor() {
        return contributor;
    }

    /**
     * Gets lager ort.
     *
     * @return the lager ort
     */
    public WikiBooks getLagerOrt() {
        return lagerOrt;
    }

    /**
     * Sets lager ort.
     *
     * @param lagerOrt the lager ort
     */
    public void setLagerOrt(WikiBooks lagerOrt) {
        this.lagerOrt = lagerOrt;
    }

    /**
     * Sets contributor.
     *
     * @param contributor the contributor
     */
    public void setContributor(MediumUserDaten contributor) {
        this.contributor = contributor;
    }

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {                                                                                                      //String Builder für Autor, Zeit und Lagerort
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy 'um' HH:mm 'Uhr' (z)");
        return lagerOrt + "\nUrheber: " + this.contributor + System.lineSeparator() + "Letzte Änderung: " + dateFormat.format(timestamp);
    }
}
