import java.io.Serializable;

//this is our bean

public class Product implements Serializable {
    //id
    private long id;
    //title
    private String title;
    //PriceCents
    private long PriceInCents;
    //description
    private String description;

    // our zero argument constructor
    public Product(){

    }
    //getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPriceInCents() {
        return PriceInCents;
    }

    public void setPriceInCents(long priceInCents) {
        PriceInCents = priceInCents;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
