package mastermind.models.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import mastermind.models.SessionImplementantion;
import mastermind.models.StateValue;

public class SessionDAOImplementation {

    private static final String EXTENSION = ".mm";

    private static final String DIRECTORY = "/Kiko/Master CloudApps 2019/02 - 4954 - Patrones y arquitectura software/Semana 09-10-2019/Repo/4954-PatrArqui-Practica1/0.Mastermind/partidas";

    private static File directory;

    static {
        SessionDAOImplementation.directory = new File(SessionDAOImplementation.DIRECTORY);
    }

    private SessionImplementantion sessionImplementation;

    private GameDAO gameDAO;

    public void associate(SessionImplementantion sessionImplementation) {
        this.sessionImplementation = sessionImplementation;
        this.gameDAO = new GameDAO(this.sessionImplementation.getGame());
    }

    public void load(String name) {
        this.sessionImplementation.setName(name);
        File file = new File(SessionDAOImplementation.directory, name);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            this.gameDAO.load(bufferedReader);
            this.sessionImplementation.resetRegistry();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.sessionImplementation.setStateValue(StateValue.IN_GAME);
        if (this.sessionImplementation.isLooser() || this.sessionImplementation.isWinner()) {
            this.sessionImplementation.setStateValue(StateValue.FINAL);
        }
    }

    public void save() {
        this.save(this.sessionImplementation.getName());
    }

    public void save(String name) {
        if (name.endsWith(SessionDAOImplementation.EXTENSION)) {
            name = name.replace(SessionDAOImplementation.EXTENSION, "");
        }
        File file = new File(SessionDAOImplementation.directory, name + SessionDAOImplementation.EXTENSION);
        try {
            FileWriter fileWriter = new FileWriter(file);
            this.gameDAO.save(fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] getGamesNames() {
        return SessionDAOImplementation.directory.list();
    }

    public boolean exists(String name) {
        for (String auxName : this.getGamesNames()) {
            if (auxName.equals(name + SessionDAOImplementation.EXTENSION)) {
                return true;
            }
        }
        return false;
    }

}
