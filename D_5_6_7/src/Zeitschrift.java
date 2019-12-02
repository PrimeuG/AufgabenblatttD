import java.util.Formatter;

/**
 * The type Zeitschrift.
 */
//Tom Cybart 17469

public class Zeitschrift extends Medium {
    private String issn;
    private Integer volume;
    private Integer nummer;

    /**
     * Gets nummer.
     *
     * @return the nummer
     */
    public int getNummer() {
        return nummer;
    }

    /**
     * Sets nummer.
     *
     * @param nummer the nummer
     */
    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    /**
     * Gets volume.
     *
     * @return the volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Sets volume.
     *
     * @param volume the volume
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Gets issn.
     *
     * @return the issn
     */
    public String getIssn() {
        return issn;
    }

    /**
     * Sets issn.
     *
     * @param issn the issn
     */
    public void setIssn(String issn) {
        this.issn = issn;
    }


    @Override
    public String calculateRepresentation() {
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);

        // Titel
        formatter.format("Titel: %s", this.getTitel());
        stringBuilder.append(System.getProperty("line.separator"));

        // ISSN
        formatter.format("ISSN: %s", this.getIssn());
        stringBuilder.append(System.getProperty("line.separator"));

        // Volume
        formatter.format("Volume: %d", this.getVolume());
        stringBuilder.append(System.getProperty("line.separator"));

        // Nummer
        formatter.format("Nummer: %d", this.getNummer());
        stringBuilder.append(System.getProperty("line.separator"));

        return stringBuilder.toString();
    }


    @Override
    public void validate() throws ValidationException {
        // validate fields inherited from superclass
        super.validate();

        // validate field volume
        if (this.volume == null) {
            throw new ValidationException("volume cannot be null");
        }

        // validate field nummer
        if (this.nummer == null) {
            throw new ValidationException("nummer can't be null");
        }

        // validate field issn
        if (this.issn == null || this.issn.trim().equals("")) {
            throw new ValidationException("empty issn not allowed");
        }
    }
}
