package es.ulpgc.eite.clean.mvp.sample.storage;

import java.util.ArrayList;

/**
 * Created by Pedro Arenas on 19/4/17.
 */

public class Storage {

    private ArrayList<String> nombres;
    private String ButtonNextLabel;
    private String ButtonBackLabel;

    //TODO Añadir lo que se repite en ambos modelos.

    private static final Storage ourInstance = new Storage();

    public static Storage getInstance() {
        return ourInstance;
    }

    private Storage() {
        nombres = new ArrayList<String>();

        nombres.add("Pedro");
        nombres.add("Carolina");
        nombres.add("Pedro Antonio");

        ButtonBackLabel = "Back";
        ButtonNextLabel = "Siguiente";
    }

    public String getNames(int position) {
        return nombres.get(position);
    }

    public Integer getSize() {
        return nombres.size();
    }

    public String getButtonNextLabel() {
        return ButtonNextLabel;
    }

    public String getButtonBackLabel() {
        return ButtonBackLabel;
    }
}
