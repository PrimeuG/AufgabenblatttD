import java.util.Formatter;

/**
 * The type Buch.
 */
//Tom Cybart 17469

public class Buch extends Medium {

    private Integer erscheinungsjahr;
    private String verfasser;
    private String verlag;
    private String isbn;

    /**
     * Gets erscheinungsjahr.
     *
     * @return the erscheinungsjahr
     */
    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    /**
     * Sets erscheinungsjahr.
     *
     * @param erscheinungsjahr the erscheinungsjahr
     */
    public void setErscheinungsjahr(int erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }

    /**
     * Gets isbn.
     *
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets isbn.
     *
     * @param isbn the isbn
     */
    public void setIsbn(String isbn) {
        if (!Buch.checkISBN(isbn)) {
            System.out.println("Fehler: ungültige ISBN!");
        }

        this.isbn = isbn;
    }

    /**
     * Gets verfasser.
     *
     * @return the verfasser
     */
    public String getVerfasser() {
        return verfasser;
    }

    /**
     * Sets verfasser.
     *
     * @param verfasser the verfasser
     */
    public void setVerfasser(String verfasser) {
        this.verfasser = verfasser;
    }

    /**
     * Gets verlag.
     *
     * @return the verlag
     */
    public String getVerlag() {
        return verlag;
    }

    /**
     * Sets verlag.
     *
     * @param verlag the verlag
     */
    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }

    @Override
    public String calculateRepresentation() {
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);

        // Titel
        formatter.format("Titel: %s", this.getTitel());
        stringBuilder.append(System.getProperty("line.separator"));

        // ISBN
        formatter.format("ISBN: %s", this.getIsbn());
        stringBuilder.append(System.getProperty("line.separator"));

        // Erscheinungsjahr
        formatter.format("Erscheinungsjahr: %d", this.getErscheinungsjahr());
        stringBuilder.append(System.getProperty("line.separator"));

        // Verfasser
        formatter.format("Verfasser: %s", this.getVerfasser());
        stringBuilder.append(System.getProperty("line.separator"));

        // Verlag
        formatter.format("Verlag: %s", this.getVerlag());
        stringBuilder.append(System.getProperty("line.separator"));

        return stringBuilder.toString();
    }

    @Override
    public void validate() throws ValidationException {
        super.validate();

        if (this.erscheinungsjahr == null) {
            throw new ValidationException("erscheinungsjahr cannot be null");
        }

        if (this.isbn == null || this.isbn.trim().equals("")) {
            throw new ValidationException("empty ISBN not allowed");
        }

        if (this.verfasser == null || this.verfasser.trim().equals("")) {
            throw new ValidationException("empty verfasser not allowed");
        }


        if (this.verlag == null || this.verlag.trim().equals("")) {
            throw new ValidationException("empty verlag not allowed");
        }
    }

    /**
     * Check isbn boolean.
     *
     * @param isbn the isbn
     * @return the boolean
     */
    public static boolean checkISBN(String isbn) {
        isbn = isbn.replace("-", "");

        isbn = isbn.replace(" ", "");

        if (isbn.length() == 10) {
            int[] isbn10 = new int[10];

            for (int i = 0; i < 10; i++) {
                int digit = Character.getNumericValue(isbn.charAt(i));

                if (digit < 0 || digit > 9) {
                    return false;
                }

                isbn10[i] = digit;
            }

            return checkISBN10(isbn10);
        } else if (isbn.length() == 13) {
            int[] isbn13 = new int[13];

            for (int i = 0; i < 13; i++) {
                int digit = Character.getNumericValue(isbn.charAt(i));

                if (digit < 0 || digit > 9) {
                    return false;
                }

                isbn13[i] = digit;
            }

            return checkISBN13(isbn13);
        } else {
            return false;
        }
    }

    private static boolean checkISBN10(int[] isbn) {
        int sum = 0;
        for (int i = 1; i <= isbn.length; i++) {
            sum += i * isbn[i - 1];
        }
        if (sum % 11 == 0) {
            return true;
        } else {
            return false;
        }
    }


    private static boolean checkISBN13(int[] isbn) {
        int sum = 0;
        for (int i = 1; i < isbn.length; i++) {
            if (i % 2 == 0) {
                sum += isbn[i - 1] * 3;
            } else {
                sum += isbn[i - 1];
            }
        }
        int lastDigit = sum % 10;
        int check = (10 - lastDigit) % 10;
        if (isbn[isbn.length - 1] == check) {
            return true;
        } else {
            return false;
        }
    }
}
