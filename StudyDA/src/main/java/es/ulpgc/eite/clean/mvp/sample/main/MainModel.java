package es.ulpgc.eite.clean.mvp.sample.main;

import java.util.ArrayList;

import es.ulpgc.eite.clean.mvp.GenericModel;


public class MainModel extends GenericModel<Main.ModelToPresenter>
        implements Main.PresenterToModel {

    private String dummyText;
    private String dummyLabel;
    private int numOfTimes;
    private String msgText;

    private ArrayList<String> nombres;
    private Integer k;
    private Integer f;
    private Integer l;
    private String ButtonNextLabel;
    private String ButtonBackLabel;
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

        nombres = new ArrayList<String>();
        nombres.add("Pedro");
        nombres.add("Carolina");
        nombres.add("Pedro Antonio");


        f = 0;
        l = nombres.size() - 1;

        ButtonNextLabel = "Siguiente";
        ButtonBackLabel = "Atrás";
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
    public void onChangeMsgByBtnClicked() {
        msgText = dummyText;
        if (numOfTimes > 0) {
            msgText += ", " + numOfTimes + " times";
        }
        numOfTimes++;
    }

    @Override
    public String getText() {
        return msgText;
    }

    @Override
    public String getLabel() {
        return dummyLabel;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public String getName() {
        return nombres.get(k);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////// Puntero Dinámico ////////////////////////////////////////////

    @Override
    public void setDefault() {
        setK(0);
    }

    @Override
    public Integer getK() {
        return k;
    }

    @Override
    public void setK(Integer pointer) {
        this.k = pointer;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////Puntero Estático Primer elemento/////////////////////////////

    @Override
    public Integer getF() {
        return f;
    }

    @Override
    public void setF(Integer FirstPosition) {
        this.f = FirstPosition;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////Puntero Estático último elemento//////////////////////////////

    @Override
    public Integer getL() {
        return l;
    }

    @Override
    public void setL(Integer l) {
        this.l = l;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////Mover puntero dinámico//////////////////////////////////////

    @Override
    public void nextPosition() {
        k++;
    }

    @Override
    public void backPosition() {
        k--;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////Tamaño de la lista////////////////////////////////////////

    @Override
    public Integer SizeList() {
        return nombres.size();
    }

//    public void CheckLastElement() {
//        if(k == nombres.size()){
//            setK(0);
//        }
//    }

    /////////////////////////////Labels of Buttons/////////////////////////////////////

    /////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////// Labels ///////////////////////////////////////////////////

    @Override
    public String getLabelNextBtn() {
        return ButtonNextLabel;
    }

    @Override
    public String getLabelBackBtn() {
        return ButtonBackLabel;
    }

    @Override
    public String getButtonNextPageLabel() {
        return ButtonNextPageLabel;
    }


}