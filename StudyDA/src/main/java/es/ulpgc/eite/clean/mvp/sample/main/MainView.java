package es.ulpgc.eite.clean.mvp.sample.main;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

public class MainView
        extends GenericActivity<Main.PresenterToView, Main.ViewToPresenter, MainPresenter>
        implements Main.PresenterToView {

    private Toolbar toolbar;

    private Button btnNext;
    private Button btnBack;
    private Button btnNextPage;

    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Creating View");

        display = (TextView) findViewById(R.id.display);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onButtonNextClicked();
            }
        });

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onButtonBackClicked();
            }
        });

        btnNextPage = (Button) findViewById(R.id.btnNextPage);
        btnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onButtonNextPageClicked();
            }
        });

    }

    /**
     * Method that initialized MVP objects
     * {@link super#onResume(Class, Object)} should always be called
     */
    @Override
    protected void onResume() {
        super.onResume(MainPresenter.class, this);
    }

//  @Override
//  public boolean onCreateOptionsMenu(Menu menu) {
//    // Inflate the menu; this adds items to the action bar if it is present.
//    getMenuInflater().inflate(R.menu.menu_dummy, menu);
//    return true;
//  }
//
//  @Override
//  public boolean onOptionsItemSelected(MenuItem item) {
//    // Handle action bar item clicks here. The action bar will
//    // automatically handle clicks on the Home/Up btnNext, so long
//    // as you specify a parent activity in AndroidManifest.xml.
//    int id = item.getItemId();
//
//    //noinspection SimplifiableIfStatement
//    if (id == R.id.action_settings) {
//      return true;
//    }
//
//    return super.onOptionsItemSelected(item);
//  }


    ///////////////////////////////////////////////////////////////////////////////////
    // Presenter To View /////////////////////////////////////////////////////////////

    @Override
    public void finishScreen() {
        finish();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////////////// Display Settings /////////////////////////////////////////////

    @Override
    public void setDisplay(String txt) {
        Log.d(TAG, "calling setDisplay()");
        display.setText(txt);
    }

    /////////////////////////////////SetTextLabel///////////////////////////////////////////////////

    @Override
    public void setBtnNextLabel(String txt) {
        btnNext.setText(txt);
    }
    @Override
    public void setBtnBackLabel(String txt) {
        btnBack.setText(txt);
    }
    @Override
    public void setBtnNextPageLabel(String txt) {
        btnNextPage.setText(txt);
    }

    //////////////////////////////////Visibilility///////777777/////////////////////////////////////
    @Override
    public void ShowBtnBack() {
        btnBack.setVisibility(View.VISIBLE);
    }
    @Override
    public void HideBtnBack() {
        btnBack.setVisibility(View.INVISIBLE);
    }
    @Override
    public void ShowBtnNext() {
        btnNext.setVisibility(View.VISIBLE);
    }
    @Override
    public void HideBtnNext() {
        btnNext.setVisibility(View.INVISIBLE);
    }

}
