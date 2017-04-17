package es.ulpgc.eite.clean.mvp.sample.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.clean.mvp.sample.main.Main;
import es.ulpgc.eite.clean.mvp.sample.main.MainView;
import es.ulpgc.eite.clean.mvp.sample.second.Second;
import es.ulpgc.eite.clean.mvp.sample.second.SecondView;

public class App extends Application implements Mediator, Navigator {

    private MainState toMainState;
    private SecondState MaintoSecondState;

    @Override
    public void onCreate() {
        super.onCreate();
        toMainState = new MainState();
        toMainState.Position = 0;
        toMainState.MainFirstTime = true;
        //Estados iniciales de algunas de las variables.
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Mediator //////////////////////////////////////////////////////////////////////

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


    private class MainState {
        Integer Position;
        boolean MainFirstTime;
    }
    private class SecondState {
        Integer position;
        boolean MainFirstTime;

    }

}
