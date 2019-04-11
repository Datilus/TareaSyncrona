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
import com.androidnetworking.common.ANRequest;
import com.androidnetworking.common.ANResponse;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.tareasyncrona.Modelo.TypeClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    ProgressDialog mProgressDialog;
    ANResponse response;
    ArrayList<TypeClient> typeClients;


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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class ProgressDialogAsyncTask extends AsyncTask<String, Integer, Integer> {

        @Override
        protected Integer doInBackground(String... strings) {
            for (int j = 1; j <= 50; j++) {
                try {
                    Thread.sleep(50);
                    mProgressDialog.incrementProgressBy(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            response = fetchEmployee();
            if (response.isSuccess()) {
                for (int j = 1; j <= 50; j++) {
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

    public ANResponse fetchEmployee() {
        ANRequest request = AndroidNetworking.get("http://172.16.1.2:8000/api/types_clients")
                .build();

        ANResponse<JSONObject> response = request.executeForJSONObject();

        request.getAsObject(ResponseList.class, new ParsedRequestListener<ResponseList>() {
            @Override
            public void onResponse(ResponseList response) {
                typeClients = new GsonBuilder()
                        .create()
                        .fromJson(new Gson().toJsonTree(response.getData()),
                                new TypeToken<ArrayList<TypeClient>>() {
                                }.getType());
                try (Realm realmInstance = Realm.getDefaultInstance()) {
                    realmInstance.executeTransaction(realm -> realm.copyToRealmOrUpdate(typeClients));
                }
            }

            @Override
            public void onError(ANError anError) {

            }
        });

        return response;
    }
}
