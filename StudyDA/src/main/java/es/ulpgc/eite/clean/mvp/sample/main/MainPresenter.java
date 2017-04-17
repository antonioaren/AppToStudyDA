package es.ulpgc.eite.clean.mvp.sample.main;


import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;

public class MainPresenter extends GenericPresenter
        <Main.PresenterToView, Main.PresenterToModel, Main.ModelToPresenter, MainModel>
        implements Main.ViewToPresenter, Main.ModelToPresenter, Main.MainTo, Main.ToMain {

    private Integer k;
    private boolean isFirstTimeRunning;

    /**
     * Operation called during VIEW creation in {@link GenericActivity#onResume(Class, Object)}
     * Responsible to initialize MODEL.
     * Always call {@link GenericPresenter#onCreate(Class, Object)} to initialize the object
     * Always call  {@link GenericPresenter#setView(ContextView)} to save a PresenterToView reference
     *
     * @param view The current VIEW instance
     */
    @Override
    public void onCreate(Main.PresenterToView view) {
        super.onCreate(MainModel.class, this);
        setView(view);
        Log.d(TAG, "calling onCreate()");

        Log.d(TAG, "calling startingMainScreen()");
        Mediator app = (Mediator) getView().getApplication();
        setFirstTimeRunning(true);
        app.startingMainScreen(this);

    }
    /**
     * Operation called by VIEW after its reconstruction.
     * Always call {@link GenericPresenter#setView(ContextView)}
     * to save the new instance of PresenterToView
     *
     * @param view The current VIEW instance
     */
    @Override
    public void onResume(Main.PresenterToView view) {
        setView(view);
        Log.d(TAG, "calling onResume()");

    }
    /**
     * Helper method to inform Presenter that a onBackPressed event occurred
     * Called by {@link GenericActivity}
     */
    @Override
    public void onBackPressed() {
        Log.d(TAG, "calling onBackPressed()");
    }
    /**
     * Hook method called when the VIEW is being destroyed or
     * having its configuration changed.
     * Responsible to maintain MVP synchronized with Activity lifecycle.
     * Called by onDestroy methods of the VIEW layer, like: {@link GenericActivity#onDestroy()}
     *
     * @param isChangingConfiguration true: configuration changing & false: being destroyed
     */
    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        super.onDestroy(isChangingConfiguration);
        Log.d(TAG, "calling onDestroy()");
    }


    ///////////////////////////////////////////////////////////////////////////////////
    // View To Presenter /////////////////////////////////////////////////////////////

    @Override
    public void onButtonNextClicked() {
        Log.d(TAG, "calling onBtnNextClicked()");
        if (isViewRunning()) {
            getModel().nextPosition();
            CheckBtnVisibility();
            getView().setDisplay(getModel().getName());
        }
        //checkTextVisibility();
    }

    @Override
    public void onButtonBackClicked() {
        Log.d(TAG, "calling onBtnBackClicked()");
        if (isViewRunning()) {
            getModel().backPosition();
            CheckBtnVisibility();
            getView().setDisplay(getModel().getName());
        }
        //checkTextVisibility();
    }

    @Override
    public void onButtonNextPageClicked() {
        Log.d(TAG, "calling onBtnNextPageClicked()");
        Navigator app = (Navigator) getView().getApplication();

        setFirstTimeRunning(false);
        app.goToSecondScreen(this);
    }


    ///////////////////////////////////////////////////////////////////////////////////
    // To Second //////////////////////////////////////////////////////////////////////

    @Override
    public void onScreenStarted() {
        Log.d(TAG, "calling onScreenStarted()");
        if (isViewRunning()) {

            CheckPosition();
            getView().setDisplay(getModel().getName());
            getView().setBtnNextLabel(getModel().getLabelNextBtn());
            getView().setBtnBackLabel(getModel().getLabelBackBtn());
            getView().setBtnNextPageLabel(getModel().getButtonNextPageLabel());
        }
        //checkToolbarVisibility();
        //checkTextVisibility();
        CheckBtnVisibility();
    }

    @Override
    public Context getManagedContext() {
        return getActivityContext();
    }

    /////////////////////////////// Second To //////////////////////////////////////////////////////

    @Override
    public void destroyView() {
        if (isViewRunning()) {
            getView().finishScreen();
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////
    /////////////////////// State //////////////////////////////////////////////////////
    @Override
    public void setPosition(Integer position) {
        this.k = position;
    }
    @Override
    public Integer getStatePosition() {
        return getModel().getK();
    }


    @Override
    public boolean isFirstTimeRunning() {
        return isFirstTimeRunning;
    }
    @Override
    public void setFirstTimeRunning(boolean firstTimeRunning) {
        isFirstTimeRunning = firstTimeRunning;
    }


    ////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////


    private void CheckBtnVisibility() {
        CheckBtnBackVisibility();
        CheckBtnNextVisibility();
    }
    private void CheckBtnBackVisibility() {
        if (getModel().getK() != getModel().getF()) {
            getView().ShowBtnBack();
        } else {
            getView().HideBtnBack();
        }
    }
    private void CheckBtnNextVisibility() {
        if (getModel().getK() != getModel().getL()) {
            getView().ShowBtnNext();
        } else {
            getView().HideBtnNext();
        }
    }

    private void CheckPosition() {
        if (isFirstTimeRunning) {
            getModel().setDefault();
        }
    }

}
