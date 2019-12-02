//Tom Cybart 17469

/**
 * The type Medium seite.
 */
public class MediumSeite extends ElektronischesMedium {

    private MediumDaten neuesteMediaDaten;                                                                                               //gibt die neuesten Daten zurück die alle in dem ContenHandler gesetzt wurden

    /**
     * Gets neuste media daten.
     *
     * @return the neuste media daten
     */
    public MediumDaten getNeusteMediaDaten() {
        return neuesteMediaDaten;
    }

    /**
     * Sets neueste media daten.
     *
     * @param neuesteMediaDaten the neueste media daten
     */
    public void setNeuesteMediaDaten(MediumDaten neuesteMediaDaten) {
        this.neuesteMediaDaten = neuesteMediaDaten;
    }
}


