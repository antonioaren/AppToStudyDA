package es.ulpgc.eite.clean.mvp.sample.storage;

import java.util.ArrayList;

/**
 * Created by Pedro Arenas on 18/4/17.
 */

public class Storage {
    private ArrayList nombres;
//    private Integer f;
//    private Integer l;
//    private Integer k;

    private static final Storage Instance = new Storage();


    private Storage() {
        nombres = new ArrayList<String>();
        nombres.add("Pedro");
        nombres.add("Carolina");
        nombres.add("Pedro Antonio");
//
    }


    public String getName(int position) {
        return (String) nombres.get(position);
    }

    public Storage getInstance() {
        return Instance;
    }


}
