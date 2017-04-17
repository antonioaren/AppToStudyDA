package es.ulpgc.eite.clean.mvp.sample.second;


import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;
import es.ulpgc.eite.clean.mvp.sample.main.Main;

public class SecondPresenter extends GenericPresenter
        <Second.PresenterToView, Second.PresenterToModel, Second.ModelToPresenter, SecondModel>
        implements Second.ViewToPresenter, Second.ModelToPresenter, Second.SecondTo, Second.ToSecond {


    private boolean toolbarVisible;
    private boolean buttonClicked;
    private boolean textVisible;

    private Integer savedPosition;

    /**
     * Operation called during VIEW creation in {@link GenericActivity#onResume(Class, Object)}
     * Responsible to initialize MODEL.
     * Always call {@link GenericPresenter#onCreate(Class, Object)} to initialize the object
     * Always call  {@link GenericPresenter#setView(ContextView)} to save a PresenterToView reference
     *
     * @param view The current VIEW instance
     */
    @Override
    public void onCreate(Second.PresenterToView view) {
        super.onCreate(SecondModel.class, this);
        setView(view);
        Log.d(TAG, "calling onCreate()");

        Log.d(TAG, "calling startingMainScreen()");
        Mediator app = (Mediator) getView().getApplication();
        app.startingSecondScreen(this);
    }

    /**
     * Operation called by VIEW after its reconstruction.
     * Always call {@link GenericPresenter#setView(ContextView)}
     * to save the new instance of PresenterToView
     *
     * @param view The current VIEW instance
     */
    @Override
    public void onResume(Second.PresenterToView view) {
        setView(view);
        Log.d(TAG, "calling onResume()");


        if (configurationChangeOccurred()) {
            getView().setBtnNextLabel(getModel().getLabel());

            checkToolbarVisibility();
            checkTextVisibility();

            if (buttonClicked) {
                getView().setDisplay(getModel().getText());
            }
        }

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
    public void onButtonBackPageClicked() {
        Log.d(TAG, "calling onBtnBackPageClicked()");
        Navigator app = (Navigator) getView().getApplication();
        app.goToMainScreen(this);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////// To Second //////////////////////////////////////////////////////

    @Override
    public void onScreenStarted() {
        Log.d(TAG, "calling onScreenStarted()");
        if (isViewRunning()) {
            getView().setDisplay(getModel().getName());
            getView().setBtnNextLabel(getModel().getLabelNextBtn());
            getView().setBtnBackLabel(getModel().getLabelBackBtn());
            getView().setBtnBackPageLabel(getModel().getButtonBackPageLabel());
        }
        //checkToolbarVisibility();
        //checkTextVisibility();
        CheckBtnVisibility();
    }

    @Override
    public void setToolbarVisibility(boolean visible) {
        toolbarVisible = visible;
    }
    @Override
    public void setTextVisibility(boolean visible) {
        textVisible = visible;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////// Second To Main /////////////////////////////////////////////////

    @Override
    public Context getManagedContext() {
        return getActivityContext();
    }

    @Override
    public void destroyView() {
        if (isViewRunning()) {
            getView().finishScreen();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////// States /////////////////////////////////////////////////////////

    @Override
    public void setPositionState(Integer Position) {
        getModel().setK(Position);
    }
    @Override
    public Integer getPositionState() {
        return getModel().getK();
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////// Metodos propios /////////////////////////////////////////////////

    private void checkToolbarVisibility() {
        Log.d(TAG, "calling checkToolbarVisibility()");
        if (isViewRunning()) {
            if (!toolbarVisible) {
                getView().hideToolbar();
            }
        }

    }

    private void checkTextVisibility() {
        Log.d(TAG, "calling checkTextVisibility()");
        if (isViewRunning()) {
            if (!textVisible) {
                getView().hideText();
            } else {
                getView().showText();
            }
        }
    }

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

}
