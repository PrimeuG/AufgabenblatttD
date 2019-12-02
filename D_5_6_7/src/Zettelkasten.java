import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

//Tom Cybart 17469

/**
 * The type Zettelkasten.
 */
public class Zettelkasten implements Iterable<Medium>, Serializable {
    private SortedState sorted = SortedState.NONE;
    private ArrayList<Medium> mediumArrayList = new ArrayList<>();

    /**
     * Add medium.
     *
     * @param medium the medium
     * @throws ValidationException the validation exception
     */
    public void addMedium(Medium medium) throws Medium.ValidationException {
        medium.validate();
        mediumArrayList.add(medium);
        this.sorted = SortedState.NONE;
    }

    /**
     * Drop medium.
     *
     * @param title the title
     * @throws DuplicateEntryException the duplicate entry exception
     * @throws EntryNotFoundException  the entry not found exception
     */
    public void dropMedium(String title) throws DuplicateEntryException, EntryNotFoundException {
        ArrayList<Medium> results = new ArrayList<>();

        for (Medium medium : mediumArrayList) {
            if (medium.getTitel().equals(title)) {
                results.add(medium);
            }
        }

        if (results.size() > 1) {
            throw new DuplicateEntryException();
        } else if (results.size() == 0) {
            throw new EntryNotFoundException();
        } else {
            results.remove(results.get(0));
        }
    }

    /**
     * Drop medium.
     *
     * @param title the title
     * @param index the index
     * @throws EntryNotFoundException the entry not found exception
     */
    public void dropMedium(String title, int index) throws EntryNotFoundException {
        if (index < 0) {
            throw new IllegalArgumentException("index can't be lower than 0");
        }

        ArrayList<Medium> results = this.findMedium(title);

        if (results.size() > index) {
            mediumArrayList.remove(index);
        }

        throw new EntryNotFoundException();
    }

    /**
     * Find medium array list.
     *
     * @param title the title
     * @return the array list
     */
    public ArrayList<Medium> findMedium(String title) {
        ArrayList<Medium> results = new ArrayList<>();

        for (Medium medium : mediumArrayList) {
            if (medium.getTitel().equals(title)) {
                results.add(medium);
            }
        }

        results.sort(Comparator.comparing(a -> a.getClass().getCanonicalName()));

        return results;
    }

    /**
     * Sort.
     *
     * @param reversed the reversed
     */
    public void sort(boolean reversed) {
        if (this.sorted == SortedState.NONE) {
            this.mediumArrayList.sort(Comparator.naturalOrder());
            this.sorted = SortedState.ASC;
        }

        if ((reversed && this.sorted != SortedState.DESC) || (!reversed && this.sorted != SortedState.ASC)) {
            this.mediumArrayList.sort(Comparator.reverseOrder());
            this.sorted = SortedState.DESC;
        }
    }


    /**
     * Sort.
     */
    public void sort() {
        this.sort(false);
    }

    @Override
    public Iterator<Medium> iterator() {
        return mediumArrayList.iterator();
    }

    /**
     * The type Duplicate entry exception.
     */
    static class DuplicateEntryException extends Exception {
        /**
         * Instantiates a new Duplicate entry exception.
         */
        DuplicateEntryException() {
            super();
        }
    }

    /**
     * The type Entry not found exception.
     */
    static class EntryNotFoundException extends Exception {
        /**
         * Instantiates a new Entry not found exception.
         */
        EntryNotFoundException() {
            super();
        }
    }

    /**
     * The enum Sorted state.
     */
    static enum SortedState {
        /**
         * None sorted state.
         */
        NONE,
        /**
         * Asc sorted state.
         */
        ASC,
        /**
         * Desc sorted state.
         */
        DESC;
    }
}