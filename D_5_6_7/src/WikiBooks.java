//Tom Cybart 17469

/**
 * The type Wiki books.
 */
public class WikiBooks extends Buch {
    private String regal;
    private String kapitel;

    /**
     * Gets regal.
     *
     * @return the regal
     */
    public String getRegal() {
        return regal;
    }

    /**
     * Sets regal.
     *
     * @param regal the regal
     */
    public void setRegal(String regal) {
        this.regal = regal;
    }

    /**
     * Gets kapitel.
     *
     * @return the kapitel
     */
    public String getKapitel() {
        return kapitel;
    }

    /**
     * Sets kapitel.
     *
     * @param kapitel the kapitel
     */
    public void setKapitel(String kapitel) {
        this.kapitel = kapitel;
    }

    @Override
    public String toString() {
        return "Regal: " + this.regal + "Kapitel: " + this.kapitel;
    }
}