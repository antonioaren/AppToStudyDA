package es.ulpgc.eite.clean.mvp.sample.main;

import android.content.Context;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.Presenter;

/**
 * Created by Luis on 12/11/16.
 */

public interface Main {


    ///////////////////////////////////////////////////////////////////////////////////
    // State /////////////////////////////////////////////////////////////////////////

    interface ToMain {
        void onScreenStarted();

        void setToolbarVisibility(boolean visible);

        void setTextVisibility(boolean visible);

        void setPosition(Integer position);

        void setFirstTimeRunning(boolean firstTimeRunning);
    }

    interface MainTo {
        Context getManagedContext();

        void destroyView();

        boolean isToolbarVisible();

        boolean isTextVisible();

        Integer getStatePosition();

        boolean isFirstTimeRunning();
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Screen ////////////////////////////////////////////////////////////////////////

    /**
     * Methods offered to VIEW to communicate with PRESENTER
     */
    interface ViewToPresenter extends Presenter<PresenterToView> {
        void onButtonNextClicked();

        void onButtonBackClicked();

        void onButtonNextPageClicked();
    }

    /**
     * Required VIEW methods available to PRESENTER
     */
    interface PresenterToView extends ContextView {
        void finishScreen();

        void hideToolbar();

        void hideText();

        void showText();

        void setDisplay(String txt);

        void setBtnNextLabel(String txt);

        void setBtnBackLabel(String txt);

        void setBtnNextPageLabel(String txt);

        void ShowBtnBack();

        void HideBtnBack();

        void ShowBtnNext();

        void HideBtnNext();
    }

    /**
     * Methods offered to MODEL to communicate with PRESENTER
     */
    interface PresenterToModel extends Model<ModelToPresenter> {
        void onChangeMsgByBtnClicked();

        String getText();

        String getLabel();

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

        //Tamaño de la lista
        Integer SizeList();

        //Label de los botones.
        String getLabelNextBtn();

        String getLabelBackBtn();

        String getButtonNextPageLabel();

        void setDefault();
    }

    /**
     * Required PRESENTER methods available to MODEL
     */
    interface ModelToPresenter {

    }
}
