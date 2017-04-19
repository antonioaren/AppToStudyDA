package es.ulpgc.eite.clean.mvp.sample.storage;

import java.util.ArrayList;

/**
 * Created by Pedro Arenas on 18/4/17.
 */

public class Storage {
    private ArrayList nombres;
    private Integer f;
    private Integer l;
    private Integer k;

    private static final Storage Instance = new Storage();


    private Storage() {
        nombres = new ArrayList<String>();
        nombres.add("Pedro");
        nombres.add("Carolina");
        nombres.add("Pedro Antonio");

        f = 0;
        l = nombres.size() - 1;
    }


    public String getName(int position) {
        setK(position);
        return (String) nombres.get(k);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////// Puntero Dinámico ////////////////////////////////////////////

    public Integer getK() {
        return k;
    }

    public void setK(Integer position) {
        this.k = position;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////Puntero Estático Primer elemento/////////////////////////////

    public Integer getF() {
        return f;
    }

    public void setF(Integer FirstPosition) {
        this.f = FirstPosition;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////Puntero Estático último elemento//////////////////////////////

    public Integer getL() {
        return l;
    }

    public void setL(Integer l) {
        this.l = l;
    }


    public static Storage getInstance() {
        return Instance;
    }

}
