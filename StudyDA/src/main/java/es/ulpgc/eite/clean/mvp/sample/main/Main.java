package es.ulpgc.eite.clean.mvp.sample.main;

import android.content.Context;

import java.util.List;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.Presenter;
import es.ulpgc.eite.clean.mvp.sample.modelview.ModelItem;

/**
 * Created by Luis on 12/11/16.
 */

public interface Main {


    ///////////////////////////////////////////////////////////////////////////////////
    // State /////////////////////////////////////////////////////////////////////////

    interface ToMain {
        void onScreenStarted();

        void setPosition(Integer position);
        void setFirstTimeRunning(boolean firstTimeRunning);
    }

    interface MainTo {
        Context getManagedContext();

        void destroyView();

        Integer getStatePosition();

        boolean isFirstTimeRunning();
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Screen ////////////////////////////////////////////////////////////////////////

    /**
     * Methods offered to VIEW to communicate with PRESENTER
     */
    interface ViewToPresenter extends Presenter<PresenterToView> {
//        void onButtonNextClicked();
//
//        void onButtonBackClicked();
//
//        void onButtonNextPageClicked();

        void onItemClicked(ModelItem item);
    }

    /**
     * Required VIEW methods available to PRESENTER
     */
    interface PresenterToView extends ContextView {
        void setDisplay(String txt);

//        void setBtnNextLabel(String txt);
//
//        void setBtnBackLabel(String txt);
//        void setBtnNextPageLabel(String txt);

//        void ShowBtnNext();
//
//        void ShowBtnBack();
//        void HideBtnNext();
//
//        void HideBtnBack();

        void finishScreen();

        //////////////////////////////////////// ADAPTER ///////////////////////////////////////////////
        void setRecyclerAdapterContent(List<ModelItem> items);
    }

    /**
     * Methods offered to MODEL to communicate with PRESENTER
     */
    interface PresenterToModel extends Model<ModelToPresenter> {



        ///////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////
        String getName();

        //Puntero Dinámico
        Integer getK();

        void setK(Integer pointer);

        //Puntero Estático Primer elemento
        Integer getF();

        void setF(Integer FirstPosition);

        //Puntero Estático último elemento
        Integer getL();

        void setL(Integer l);

        //Mover puntero dinámico
        void nextPosition();

        void backPosition();


        //Label de los botones.
        String getLabelNextBtn();

        String getLabelBackBtn();

        String getButtonNextPageLabel();

        void Default();

        void LoadItems();

        List<ModelItem> getItems();
    }

    /**
     * Required PRESENTER methods available to MODEL
     */
    interface ModelToPresenter {


    }
}
