package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.main.Main;
import es.ulpgc.eite.clean.mvp.sample.hello.Hello;
import es.ulpgc.eite.clean.mvp.sample.second.Second;
import es.ulpgc.eite.clean.mvp.sample.second.SecondPresenter;

public interface Mediator {
    void startingDummyScreen(Main.ToMain presenter);

    void startingHelloScreen(Hello.ToHello presenter);

    void startingMainScreen(Main.ToMain presenter);


    void startingSecondScreen(Second.ToSecond presenter);
}
