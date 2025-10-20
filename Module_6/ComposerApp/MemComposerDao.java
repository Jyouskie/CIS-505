package Module_6.ComposerApp;

import java.util.ArrayList;
import java.util.List;

public class MemComposerDao implements ComposerDao {

    // 1. in-memory list of composers
    private final List<Composer> composers = new ArrayList<>();

    // 2. no-arg constructor with 5 default composers
    public MemComposerDao() {
        composers.add(new Composer(1001, "Ludwig van Beethoven", "Classical"));
        composers.add(new Composer(1002, "Wolfgang Amadeus Mozart", "Classical"));
        composers.add(new Composer(1003, "Johann Sebastian Bach", "Baroque"));
        composers.add(new Composer(1004, "Frédéric Chopin", "Romantic"));
        composers.add(new Composer(1005, "Claude Debussy", "Impressionist"));
    }

    // 3. findAll
    @Override
    public List<Composer> findAll() {
        // return a copy so callers can't mutate our internal list directly
        return new ArrayList<>(composers);
    }

    // 4. findBy (id)
    @Override
    public Composer findBy(Integer id) {
        for (Composer c : composers) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null; // not found
    }

    // 5. insert
    @Override
    public void insert(Composer composer) {
        composers.add(composer);
    }
}
