package edu.tjhsst.jboyle.lifecycle1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tev1, tev2, tev3, tev4, tev5, tev6, tev7;
    private int one, two, three, four, five, six, seven = 0;
    private SharedPreferences mypref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mypref = getApplicationContext().getSharedPreferences("mypref", 0);
        boolean boo = mypref.getBoolean("hasinit", false);
        SharedPreferences.Editor edit = mypref.edit();
        if(!boo)
        {
            edit.putInt("cre", 0);
            edit.putInt("sta", 0);
            edit.putInt("res", 0);
            edit.putInt("pau", 0);
            edit.putInt("sto", 0);
            edit.putInt("rst", 0);
            edit.putInt("des", 0);
            edit.putBoolean("hasinit", true);
        }

        tev1 = (TextView)findViewById(R.id.create);
        tev2 = (TextView)findViewById(R.id.start);
        tev3 = (TextView)findViewById(R.id.resume);
        tev4 = (TextView)findViewById(R.id.pause);
        tev5 = (TextView)findViewById(R.id.stop);
        tev6 = (TextView)findViewById(R.id.restart);
        tev7 = (TextView)findViewById(R.id.destroy);
        one = mypref.getInt("cre", 0);
        one++;
        edit.putInt("cre", one);
        edit.commit();
        two = mypref.getInt("sta", 0);
        three = mypref.getInt("res", 0);
        four = mypref.getInt("pau", 0);
        five = mypref.getInt("sto", 0);
        six = mypref.getInt("rst", 0);
        seven = mypref.getInt("des", 0);
        tev1.setText("onCreate: " + one);
        tev2.setText("onStart: " + two);
        tev3.setText("onResume: " + three);
        tev4.setText("onPause: " + four);
        tev5.setText("onStop: " + five);
        tev6.setText("onRestart: " + six);
        tev7.setText("onDestroy: " + seven);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences.Editor edit = mypref.edit();
        tev2 = (TextView)findViewById(R.id.start);
        two++;
        edit.putInt("sta", two);
        tev2.setText("onStart: " + two);
        edit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences.Editor edit = mypref.edit();
        tev3 = (TextView)findViewById(R.id.resume);
        three++;
        edit.putInt("res", three);
        tev3.setText("onResume: " + three);
        edit.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor edit = mypref.edit();
        tev4 = (TextView)findViewById(R.id.pause);
        four++;
        edit.putInt("pau", four);
        tev4.setText("onPause: " + four);
        edit.commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor edit = mypref.edit();
        tev5 = (TextView)findViewById(R.id.stop);
        five++;
        edit.putInt("sto", five);
        tev5.setText("onStop: " + five);
        edit.commit();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPreferences.Editor edit = mypref.edit();
        tev6 = (TextView)findViewById(R.id.restart);
        six++;
        edit.putInt("rst", six);
        tev6.setText("onRestart: " + six);
        edit.commit();
    }

    @Override
    protected void onDestroy() {
        SharedPreferences.Editor edit = mypref.edit();
        tev7 = (TextView)findViewById(R.id.destroy);
        seven++;
        edit.putInt("des", seven);
        tev7.setText("onDestroy: " + seven);
        edit.commit();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
