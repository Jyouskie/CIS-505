package Module_6.ComposerApp;

// DAO specialized for Composer, using Integer as key
public interface ComposerDao extends GenericDao<Composer, Integer> {
    
    // inherits findAll, findBy, insert
}
