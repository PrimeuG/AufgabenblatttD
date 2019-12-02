
import java.util.Formatter;


/**
 * The type Cd.
 */
//Tom Cybart 17469

public class CD extends Medium {
    private String label;
    private String kuenstler;


    /**
     * Gets kuenstler.
     *
     * @return the kuenstler
     */
    public String getKuenstler() {
        return kuenstler;
    }


    /**
     * Sets kuenstler.
     *
     * @param kuenstler the kuenstler
     */
    public void setKuenstler(String kuenstler) {
        this.kuenstler = kuenstler;
    }


    /**
     * Gets label.
     *
     * @return the label
     */
    public String getLabel() {
        return label;
    }


    /**
     * Sets label.
     *
     * @param label the label
     */
    public void setLabel(String label) {
        this.label = label;
    }


    @Override
    public String calculateRepresentation() {
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);

        formatter.format("Titel: %s", this.getTitel());
        stringBuilder.append(System.getProperty("line.separator"));

        formatter.format("Label: %s", this.getLabel());
        stringBuilder.append(System.getProperty("line.separator"));

        formatter.format("Künstler: %s", this.getKuenstler());
        stringBuilder.append(System.getProperty("line.separator"));

        return stringBuilder.toString();
    }


    @Override
    public void validate() throws ValidationException {
        super.validate();

        if (this.label == null || this.label.trim().equals("")) {
            throw new ValidationException("empty label not allowed");
        }

        if (this.kuenstler == null || this.kuenstler.trim().equals("")) {
            throw new ValidationException("empty kuenstler not allowed");
        }
    }
}

