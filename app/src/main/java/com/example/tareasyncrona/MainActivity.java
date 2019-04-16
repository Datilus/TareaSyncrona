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
import com.example.tareasyncrona.API.BankServiceImpl;
import com.example.tareasyncrona.API.CatalogueCFDIServiceImpl;
import com.example.tareasyncrona.API.CediServiceImpl;
import com.example.tareasyncrona.API.ChargeServiceImpl;
import com.example.tareasyncrona.API.ClientAuthorizationServiceImpl;
import com.example.tareasyncrona.API.ClientServiceImpl;
import com.example.tareasyncrona.API.EmployeeServiceImpl;
import com.example.tareasyncrona.API.TypeClientServiceImpl;
import com.example.tareasyncrona.Modelo.jsonModel.Bank;
import com.example.tareasyncrona.Modelo.jsonModel.CatalogueCFDI;
import com.example.tareasyncrona.Modelo.jsonModel.Cedi;
import com.example.tareasyncrona.Modelo.jsonModel.Charge;
import com.example.tareasyncrona.Modelo.jsonModel.Client;
import com.example.tareasyncrona.Modelo.jsonModel.ClientAuthorization;
import com.example.tareasyncrona.Modelo.jsonModel.Employee;
import com.example.tareasyncrona.Modelo.jsonModel.TypeClient;
import com.example.tareasyncrona.Modelo.realmModel.BankEntity;
import com.example.tareasyncrona.Modelo.realmModel.CatalogueCFDIEntity;
import com.example.tareasyncrona.Modelo.realmModel.CediEntity;
import com.example.tareasyncrona.Modelo.realmModel.ChargeEntity;
import com.example.tareasyncrona.Modelo.realmModel.ClientAuthorizationEntity;
import com.example.tareasyncrona.Modelo.realmModel.ClientEntity;
import com.example.tareasyncrona.Modelo.realmModel.EmployeeEntity;
import com.example.tareasyncrona.Modelo.realmModel.TypeClientEntity;
import com.example.tareasyncrona.services.dataBase.BankServiceDataBase;
import com.example.tareasyncrona.services.dataBase.CatalogueCFDIDataBase;
import com.example.tareasyncrona.services.dataBase.CediServiceDataBase;
import com.example.tareasyncrona.services.dataBase.ChargeServiceDataBase;
import com.example.tareasyncrona.services.dataBase.ClientAuthorizationDataBase;
import com.example.tareasyncrona.services.dataBase.ClientServiceDataBase;
import com.example.tareasyncrona.services.dataBase.EmployeeServiceDataBase;
import com.example.tareasyncrona.services.dataBase.TypeClientServiceDataBase;

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
            try (Realm realmInstance = Realm.getDefaultInstance()) {
                realmInstance.executeTransaction(realm -> realm.delete(EmployeeEntity.class));
                realmInstance.executeTransaction(realm -> realm.delete(TypeClientEntity.class));
                realmInstance.executeTransaction(realm -> realm.delete(BankEntity.class));
                realmInstance.executeTransaction(realm -> realm.delete(CatalogueCFDIEntity.class));
                realmInstance.executeTransaction(realm -> realm.delete(CediEntity.class));
                realmInstance.executeTransaction(realm -> realm.delete(ChargeEntity.class));
                realmInstance.executeTransaction(realm -> realm.delete(ClientEntity.class));
                realmInstance.executeTransaction(realm -> realm.delete(ClientAuthorizationEntity.class));
            }
            Toast.makeText(this, "Se borro la informacion de las tablas", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    public class ProgressDialogAsyncTask extends AsyncTask<String, Integer, Integer> {

        @Override
        protected Integer doInBackground(String... strings) {
            publishProgress(0);
            ArrayList<Employee> employees = EmployeeServiceImpl.getInstance().fetch();
            if (employees != null) {
                EmployeeServiceDataBase.getInstance().addList(employees);
            } else {
                this.cancel(true);
            }

            publishProgress(1);
            ArrayList<TypeClient> typeClients = TypeClientServiceImpl.getInstance().fetch();
            if (typeClients != null) {
                TypeClientServiceDataBase.getInstance().addList(typeClients);
            } else {
                this.cancel(true);
            }

            publishProgress(2);
            ArrayList<Bank> banks = BankServiceImpl.getInstance().fetch();
            if (banks != null) {
                BankServiceDataBase.getInstance().addList(banks);
            } else {
                this.cancel(true);
            }

            publishProgress(3);
            ArrayList<CatalogueCFDI> catalogueCFDIS = CatalogueCFDIServiceImpl.getInstance().fetch();
            if (catalogueCFDIS != null) {
                CatalogueCFDIDataBase.getInstance().addList(catalogueCFDIS);
            } else {
                this.cancel(true);
            }

            publishProgress(4);
            Cedi cedi = CediServiceImpl.getInstance().fetch();
            if (cedi != null) {
                CediServiceDataBase.getInstance().addObject(cedi);
            } else {
                this.cancel(true);
            }

            publishProgress(5);
            ArrayList<Charge> charges = ChargeServiceImpl.getInstance().fetch();
            if (charges != null){
                ChargeServiceDataBase.getInstance().addList(charges);
            } else {
                this.cancel(true);
            }

            publishProgress(6);
            ArrayList<Client> clients = ClientServiceImpl.getInstance().fetch();
            if (clients != null){
                ClientServiceDataBase.getInstance().addList(clients);
            } else {
                this.cancel(true);
            }

            publishProgress(7);
            ArrayList<ClientAuthorization> clientAuthorizations = ClientAuthorizationServiceImpl.getInstance().fetch();
            if (clientAuthorizations != null){
                ClientAuthorizationDataBase.getInstance().addList(clientAuthorizations);
            } else {
                this.cancel(true);
            }

            return 20;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setTitle("Simulando descarga ...");
            mProgressDialog.setMessage("CONECTANDO");
            mProgressDialog.setProgressStyle(mProgressDialog.STYLE_SPINNER);
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
            switch (values[0]) {
                case 0:
                    mProgressDialog.setMessage("SINCRONIZANDO EMPLEADOS");
                    break;
                case 1:
                    mProgressDialog.setMessage("SINCRONIZANDO TIPO DE CLIENTES");
                    break;
                case 2:
                    mProgressDialog.setMessage("SINCRONIZANDO BANCOS");
                    break;
                case 3:
                    mProgressDialog.setMessage("SINCRONIZANDO CATALOGO CFDI");
                    break;
                case 4:
                    mProgressDialog.setMessage("SINCRONIZANDO CEDIS");
                    break;
                case 5:
                    mProgressDialog.setMessage("SINCRONIZANDO CARGOS");
                    break;
                case 6:
                    mProgressDialog.setMessage("SINCRONIZANDO CLIENTES");
                    break;
                case 7:
                    mProgressDialog.setMessage("SINCRONIZANDO AUTORIZACIONES");
                    break;
                default:
                    mProgressDialog.setMessage("CONECTANDO");
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
