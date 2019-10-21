package mastermind.models.DAO;

public interface SessionDAO {
    public void save();

    public void save(String name);

    public void load(String name);

    public String[] getSavedGamesNames();

    public boolean exists(String name);

    String[] getGamesNames();

}
