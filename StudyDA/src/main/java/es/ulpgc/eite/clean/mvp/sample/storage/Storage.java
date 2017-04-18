package es.ulpgc.eite.clean.mvp.sample.storage;

import java.util.ArrayList;

import es.ulpgc.eite.clean.mvp.sample.main.MainModel;
import es.ulpgc.eite.clean.mvp.sample.second.SecondModel;

/**
 * Created by Pedro Arenas on 18/4/17.
 */

public class Storage {
    private ArrayList nombres;
    private static final Storage ourInstance = new Storage();

    public static Storage getInstance() {
        return ourInstance;
    }

    private Storage() {
        nombres = new ArrayList<String>();
        nombres.add("Pedro");
        nombres.add("Carolina");
        nombres.add("Pedro Antonio");


    }

}
