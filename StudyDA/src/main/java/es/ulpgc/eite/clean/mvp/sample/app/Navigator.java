package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.main.Main;
import es.ulpgc.eite.clean.mvp.sample.second.Second;

public interface Navigator {

    void goToSecondScreen(Main.MainTo presenter);

    void goToMainScreen(Second.SecondTo presenter);
}
