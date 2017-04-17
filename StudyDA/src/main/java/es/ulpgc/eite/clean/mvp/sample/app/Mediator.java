package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.main.Main;

import es.ulpgc.eite.clean.mvp.sample.second.Second;

public interface Mediator {

    void startingMainScreen(Main.ToMain presenter);
    void startingSecondScreen(Second.ToSecond presenter);
}
