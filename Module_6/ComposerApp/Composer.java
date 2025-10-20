package Module_6.ComposerApp;

public class Composer {
    // 1–3. private fields
    private int id;          // integer id
    private String name;     // composer name
    private String genre;    // musical genre

    // 4. no-arg constructor (default values)
    public Composer() {
        this.id = 0;
        this.name = "";
        this.genre = "";
    }

    // 5. all-args constructor
    public Composer(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    // 6. accessors
    public int getId() { return id; }
    public String getName() { return name; }
    public String getGenre() { return genre; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setGenre(String genre) { this.genre = genre; }

    // 7. toString(): each field on its own line
    @Override
    public String toString() {
        return "ID: " + id + "\n"
             + "Name: " + name + "\n"
             + "Genre: " + genre;
    }
}

