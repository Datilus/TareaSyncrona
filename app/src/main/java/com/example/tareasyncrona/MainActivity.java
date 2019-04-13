package com.example.tareasyncrona;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.example.tareasyncrona.API.EmployeeServiceImpl;
import com.example.tareasyncrona.API.TypeClientServiceImpl;
import com.example.tareasyncrona.Modelo.Employee;
import com.example.tareasyncrona.Modelo.EmployeeEntity;
import com.example.tareasyncrona.Modelo.TypeClient;
import com.example.tareasyncrona.Modelo.TypeClientEntity;
import com.example.tareasyncrona.RealmQuery.EmployeeQuery;
import com.example.tareasyncrona.RealmQuery.TypeClientServiceDataBase;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AndroidNetworking.initialize(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> new ProgressDialogAsyncTask().execute());

        Realm.init(getApplicationContext());
        setUpRealmConfig();
        Realm realm = Realm.getDefaultInstance();
        realm.close();
    }

    private void setUpRealmConfig() {
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
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
            try(Realm realmInstance = Realm.getDefaultInstance()){
                realmInstance.executeTransaction(realm -> realm.delete(EmployeeEntity.class));
                realmInstance.executeTransaction(realm -> realm.delete(TypeClientEntity.class));
            }
            Toast.makeText(this, "Se borro la informacion de las tablas", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    public class ProgressDialogAsyncTask extends AsyncTask<String, Integer, Integer> {

        @Override
        protected Integer doInBackground(String... strings) {
            for (int j = 1; j <= 50; j++) {
                try {
                    Thread.sleep(10);
                    mProgressDialog.incrementProgressBy(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ArrayList<Employee> employees = EmployeeServiceImpl.getInstance().fetch();
            EmployeeQuery.getInstance().addList(employees);
            if (employees != null) {
                for (int j = 1; j <= 25; j++) {
                    try {
                        Thread.sleep(50);
                        mProgressDialog.incrementProgressBy(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                this.cancel(true);
            }
            ArrayList<TypeClient> typeClients= TypeClientServiceImpl.getInstance().fetch();
            TypeClientServiceDataBase.getInstance().addList(typeClients);
            if (typeClients != null) {
                for (int j = 1; j <= 25; j++) {
                    try {
                        Thread.sleep(50);
                        mProgressDialog.incrementProgressBy(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                this.cancel(true);
            }
            publishProgress();
            return 20;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setTitle("Simulando descarga ...");
            mProgressDialog.setMessage("Descarga en progreso ...");
            mProgressDialog.setProgressStyle(mProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setProgress(0);
            mProgressDialog.setMax(100);
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            mProgressDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if (mProgressDialog.getProgress() < mProgressDialog.getMax()) {
                mProgressDialog.setProgress(values[0]);
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            mProgressDialog.dismiss();
            Toast.makeText(MainActivity.this, "Descarga fallida!!", Toast.LENGTH_SHORT).show();
        }
    }
}
