package es.ulpgc.eite.clean.mvp.sample.main;

import android.util.Log;

import java.util.ArrayList;

import es.ulpgc.eite.clean.mvp.GenericModel;

import es.ulpgc.eite.clean.mvp.sample.storage.Storage;


public class MainModel extends GenericModel<Main.ModelToPresenter>
        implements Main.PresenterToModel {


    private Integer k;
    private Integer f;
    private Integer l;

    private String ButtonNextPageLabel;



    /**
     * Method that recovers a reference to the PRESENTER
     * You must ALWAYS call {@link super#onCreate(Object)} here
     *
     * @param presenter Presenter interface
     */
    @Override
    public void onCreate(Main.ModelToPresenter presenter) {
        super.onCreate(presenter);

        Log.d(TAG, "calling CreatingModel");

        f = 0;
        l = getSize() - 1;

        ButtonNextPageLabel = "Second";

    }

    /**
     * Called by layer PRESENTER when VIEW pass for a reconstruction/destruction.
     * Usefull for kill/stop activities that could be running on the background Threads
     *
     * @param isChangingConfiguration Informs that a change is occurring on the configuration
     */
    @Override
    public void onDestroy(boolean isChangingConfiguration) {
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Presenter To Model ////////////////////////////////////////////////////////////

    @Override
    public String getName() {
        return Storage.getInstance().getNames(getK());
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////// Puntero Dinámico //////////////////////////////////////////

    @Override
    public void Default() {
        k = 0;
    }

    @Override
    public void LoadItems() {

    }

    @Override
    public Integer getK() {
        return k;
    }
    @Override
    public void setK(Integer pointer) {
        this.k = pointer;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////// Puntero Estático Primer elemento //////////////////////////////////

    @Override
    public Integer getF() {
        return f;
    }
    @Override
    public void setF(Integer FirstPosition) {
        this.f = FirstPosition;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////// Puntero Estático último elemento ////////////////////////////////

    @Override
    public Integer getL() {
        return l;
    }
    @Override
    public void setL(Integer l) {
        this.l = l;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////// Mover puntero dinámico ///////////////////////////////////////

    @Override
    public void nextPosition() {
        k++;
    }
    @Override
    public void backPosition() {
        k--;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////// Tamaño de la lista ///////////////////////////////////////////

    private Integer getSize() {
        return Storage.getInstance().getSize();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////// Labels /////////////////////////////////////////////////
    @Override
    public String getLabelNextBtn() {
        return Storage.getInstance().getButtonNextLabel();
    }
    @Override
    public String getLabelBackBtn() {
        return Storage.getInstance().getButtonBackLabel();
    }
    @Override
    public String getButtonNextPageLabel() {
        return ButtonNextPageLabel;
    }
}
