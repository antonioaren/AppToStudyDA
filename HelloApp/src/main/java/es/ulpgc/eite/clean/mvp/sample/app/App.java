package es.ulpgc.eite.clean.mvp.sample.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.clean.mvp.sample.main.Main;
import es.ulpgc.eite.clean.mvp.sample.main.MainView;
import es.ulpgc.eite.clean.mvp.sample.hello.Hello;
import es.ulpgc.eite.clean.mvp.sample.second.Second;
import es.ulpgc.eite.clean.mvp.sample.second.SecondView;


public class App extends Application implements Mediator, Navigator {

    private DummyState toDummyState, dummyToState;

    private HelloState toHelloState;
    private ByeState helloToByeState;

    private MainState toMainState;
    private SecondState MaintoSecondState;


    @Override
    public void onCreate() {
        super.onCreate();
        toDummyState = new DummyState();
        toDummyState.toolbarVisibility = false;
        toDummyState.textVisibility = false;

        toHelloState = new HelloState();

        toMainState = new MainState();
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Mediator //////////////////////////////////////////////////////////////////////

    @Override
    public void startingDummyScreen(Main.ToMain presenter) {
        if (toDummyState != null) {
            presenter.setToolbarVisibility(toDummyState.toolbarVisibility);
            presenter.setTextVisibility(toDummyState.textVisibility);
        }
        presenter.onScreenStarted();
    }

    @Override
    public void startingHelloScreen(Hello.ToHello presenter) {
        if (toHelloState != null) {
            presenter.setToolbarVisibility(toHelloState.toolbarVisibility);
            //presenter.setTextVisibility(toHelloState.textVisibility);
        }
        presenter.onScreenStarted();
    }

    ///////////////////////////////////////////////////////////////////////////////////

    @Override
    public void startingMainScreen(Main.ToMain presenter) {
        if (toMainState != null) {
            presenter.setPosition(toMainState.Position);
            presenter.setFirstTimeRunning(toMainState.MainFirstTime);
        }
        presenter.onScreenStarted();
    }

    @Override
    public void startingSecondScreen(Second.ToSecond presenter) {
        if (MaintoSecondState != null) {
            presenter.setPositionState(MaintoSecondState.position);

        }
        presenter.onScreenStarted();
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Navigator /////////////////////////////////////////////////////////////////////

    @Override
    public void goToNextScreen(Main.MainTo presenter) {
        dummyToState = new DummyState();
        dummyToState.toolbarVisibility = presenter.isToolbarVisible();
        dummyToState.textVisibility = presenter.isTextVisible();

        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, MainView.class));
            presenter.destroyView();
        }

    }

    @Override
    public void goToByeScreen(Hello.HelloToBye presenter) {
        helloToByeState = new ByeState();
        helloToByeState.toolbarVisibility = presenter.isToolbarVisible();

        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, MainView.class));
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////


    @Override
    public void goToMainScreen(Second.SecondTo presenter) {
        toMainState = new MainState();
        toMainState.Position = presenter.getPositionState();

        Context view = presenter.getManagedContext(); //contexto Android
        if (view != null) {
            view.startActivity(new Intent(view, MainView.class));
        }

    }

    @Override
    public void goToSecondScreen(Main.MainTo presenter) {
        MaintoSecondState = new SecondState();

        MaintoSecondState.position = presenter.getStatePosition();
        MaintoSecondState.MainFirstTime = presenter.isFirstTimeRunning();


        Context view = presenter.getManagedContext(); //contexto Android
        if (view != null) {
            view.startActivity(new Intent(view, SecondView.class));
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // State /////////////////////////////////////////////////////////////////////////

    private class DummyState {
        boolean toolbarVisibility;
        boolean textVisibility;
    }

    private class ByeState {
        boolean toolbarVisibility;
        //boolean textVisibility;
    }

    private class HelloState {
        boolean toolbarVisibility;
        //boolean textVisibility;
    }

    private class MainState {
        Integer Position;
        boolean MainFirstTime;

    }

    private class SecondState {
        Integer position;
        boolean MainFirstTime;

    }

}
