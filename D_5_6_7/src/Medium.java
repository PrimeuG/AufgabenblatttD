import java.io.Serializable;

/**
 * The type Medium.
 */
//Tom Cybart 17469

public abstract class Medium implements Comparable<Medium>, Serializable {
    private String titel;

    /**
     * Gets titel.
     *
     * @return the titel
     */
    public String getTitel() {
        return titel;
    }

    /**
     * Sets titel.
     *
     * @param titel the titel
     */
    public void setTitel(String titel) {
        this.titel = titel;
    }

    /**
     * Calculate representation string.
     *
     * @return the string
     */
    public abstract String calculateRepresentation();

    /**
     * Validate.
     *
     * @throws ValidationException the validation exception
     */
    public void validate() throws ValidationException {
        // validate field titel
        if (this.titel == null || this.titel.trim().equals("")) {
            throw new ValidationException("empty title not allowed");
        }
    }

    ;

    @Override
    public int compareTo(Medium o) {
        return this.getTitel().compareTo(o.getTitel());
    }

    /**
     * The type Validation exception.
     */
    static class ValidationException extends Exception {
        /**
         * Instantiates a new Validation exception.
         *
         * @param message the message
         */
        ValidationException(String message) {
            super(message);
        }
    }
}