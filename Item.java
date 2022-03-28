public class Item {
    private String id;
    private String title;
    private String location;
    private String author;


    public Item(String id, String title, String location, String author) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.author = author;
    }

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getAuthor() {
        return author;
    }
}
