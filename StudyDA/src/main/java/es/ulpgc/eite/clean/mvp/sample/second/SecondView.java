package es.ulpgc.eite.clean.mvp.sample.second;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

public class SecondView
        extends GenericActivity<Second.PresenterToView, Second.ViewToPresenter, SecondPresenter>
        implements Second.PresenterToView {

    private Toolbar toolbar;

    private Button btnNext;
    private Button btnBack;
    private Button btnBackPage;

    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        display = (TextView) findViewById(R.id.display2);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnNext = (Button) findViewById(R.id.BtnNext2);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onButtonNextClicked();
            }
        });

        btnBack = (Button) findViewById(R.id.BtnBack2);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onButtonBackClicked();
            }
        });

        btnBackPage = (Button) findViewById(R.id.ActivityBack);
        btnBackPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onButtonBackPageClicked();
            }
        });

    }

    /**
     * Method that initialized MVP objects
     * {@link super#onResume(Class, Object)} should always be called
     */
    @Override
    protected void onResume() {
        super.onResume(SecondPresenter.class, this);
    }


    ///////////////////////////////////////////////////////////////////////////////////
    // Presenter To View /////////////////////////////////////////////////////////////

    @Override
    public void finishScreen() {
        finish();
    }

    public void setDisplay(String txt) {
        display.setText(txt);
    }

    ////////////////////////////////////Set Labels////////////////////////////////////////////////////

    @Override
    public void setBtnNextLabel(String txt) {
        btnNext.setText(txt);
    }

    @Override
    public void setBtnBackLabel(String txt) {
        btnBack.setText(txt);
    }

    @Override
    public void setBtnBackPageLabel(String txt) {
        btnBackPage.setText(txt);
    }

    /////////////////////////////////Set Visibility///////////////////////////////////////////////////
    @Override
    public void ShowBtnBack() {
        btnBack.setVisibility(View.VISIBLE);
    }

    @Override
    public void HideBtnBack() {
        btnBack.setVisibility(View.GONE);
    }

    @Override
    public void ShowBtnNext() {
        btnNext.setVisibility(View.VISIBLE);
    }

    @Override
    public void HideBtnNext() {
        btnNext.setVisibility(View.GONE);
  }


}
