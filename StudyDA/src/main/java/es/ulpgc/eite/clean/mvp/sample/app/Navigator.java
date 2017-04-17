package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.main.Main;
import es.ulpgc.eite.clean.mvp.sample.hello.Hello;
import es.ulpgc.eite.clean.mvp.sample.second.Second;

public interface Navigator {
    void goToNextScreen(Main.MainTo presenter);

    void goToByeScreen(Hello.HelloToBye presenter);

    void goToSecondScreen(Main.MainTo presenter);

    void goToMainScreen(Second.SecondTo presenter);
}
