/**
 * The type Item.
 */

//Tom Cybart 17469

public class Item {

    private String title;

    public Item() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return this.title;
    }
}
