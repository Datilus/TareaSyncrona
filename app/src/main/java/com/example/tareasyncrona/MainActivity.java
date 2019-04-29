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
import com.example.tareasyncrona.API.ClientExhibitorServiceImpl;
import com.example.tareasyncrona.API.ClientProductBonificationServiceImpl;
import com.example.tareasyncrona.API.ClientServiceImpl;
import com.example.tareasyncrona.API.EmployeeServiceImpl;
import com.example.tareasyncrona.API.TypeClientServiceImpl;
import com.example.tareasyncrona.Modelo.jsonModel.Bank;
import com.example.tareasyncrona.Modelo.jsonModel.CatalogueCFDI;
import com.example.tareasyncrona.Modelo.jsonModel.Cedi;
import com.example.tareasyncrona.Modelo.jsonModel.Charge;
import com.example.tareasyncrona.Modelo.jsonModel.Client;
import com.example.tareasyncrona.Modelo.jsonModel.ClientAuthorization;
import com.example.tareasyncrona.Modelo.jsonModel.ClientExhibitor;
import com.example.tareasyncrona.Modelo.jsonModel.ClientProductBonification;
import com.example.tareasyncrona.Modelo.jsonModel.Employee;
import com.example.tareasyncrona.Modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.Modelo.jsonModel.TypeClient;
import com.example.tareasyncrona.Modelo.realmModel.BankEntity;
import com.example.tareasyncrona.Modelo.realmModel.CatalogueCFDIEntity;
import com.example.tareasyncrona.Modelo.realmModel.CediEntity;
import com.example.tareasyncrona.Modelo.realmModel.ChargeEntity;
import com.example.tareasyncrona.Modelo.realmModel.ClientAuthorizationEntity;
import com.example.tareasyncrona.Modelo.realmModel.ClientEntity;
import com.example.tareasyncrona.Modelo.realmModel.ClientExhibitorEntity;
import com.example.tareasyncrona.Modelo.realmModel.EmployeeEntity;
import com.example.tareasyncrona.Modelo.realmModel.TypeClientEntity;
import com.example.tareasyncrona.services.dataBase.BankServiceDatabase;
import com.example.tareasyncrona.services.dataBase.CatalogueCFDIServiceDatabase;
import com.example.tareasyncrona.services.dataBase.CediServiceDatabase;
import com.example.tareasyncrona.services.dataBase.ChargeServiceDatabase;
import com.example.tareasyncrona.services.dataBase.ClientAuthorizationServiceDatabase;
import com.example.tareasyncrona.services.dataBase.ClientExhibitorServiceDatabase;
import com.example.tareasyncrona.services.dataBase.ClientProductBonificationDatabase;
import com.example.tareasyncrona.services.dataBase.ClientServiceDatabase;
import com.example.tareasyncrona.services.dataBase.EmployeeServiceDatabase;
import com.example.tareasyncrona.services.dataBase.TypeClientServiceDatabase;
import com.example.tareasyncrona.services.interfaces.CediService;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.Response;

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

    public void deleteRealm(Class clase){
        try (Realm realmInstance = Realm.getDefaultInstance()) {
            realmInstance.executeTransaction(realm -> realm.delete(clase));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            deleteRealm(BankEntity.class);
            deleteRealm(CatalogueCFDIEntity.class);
            deleteRealm(CediEntity.class);
            deleteRealm(ChargeEntity.class);
            deleteRealm(ClientEntity.class);
            deleteRealm(ClientAuthorizationEntity.class);
            deleteRealm(ClientExhibitorEntity.class);
            deleteRealm(ClientProductBonification.class);
            deleteRealm(EmployeeEntity.class);
            deleteRealm(TypeClientEntity.class);
            Toast.makeText(this, "Se borro la informacion de las tablas", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    public class ProgressDialogAsyncTask extends AsyncTask<String, Integer, Integer> {

        private void saveWithStatusCode(ResponseDataWithCode responseDataWithCode, Class manager) {
            if (responseDataWithCode.getData() != null) {
                System.out.println(manager.getSimpleName());
                System.out.println(responseDataWithCode.getData().getClass().getSimpleName());
                switch (manager.getSimpleName()) {
                    case "BankServiceDatabase": {
                        BankServiceDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "CatalogueCFDIServiceDatabase": {
                        CatalogueCFDIServiceDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "CediServiceDatabase": {
                        CediServiceDatabase.getInstance().addObject(responseDataWithCode.getDataAsObject());
//                        CediServiceDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "ChargeServiceDatabase": {
                        ChargeServiceDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "ClientAuthorizationServiceDatabase": {
                        ClientAuthorizationServiceDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "ClientExhibitorServiceDatabase": {
                        ClientExhibitorServiceDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "ClientServiceDatabase": {
                        ClientServiceDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "ClientProductBonificationDatabase": {
                        ClientProductBonificationDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "EmployeeServiceDatabase": {
                        EmployeeServiceDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "TypeClientServiceDatabase": {
                        TypeClientServiceDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    default: {

                    }
                }
            } else {
                if (responseDataWithCode.getCode() == 102) {
                    this.cancel(true);
                }
            }
        }

        @Override
        protected Integer doInBackground(String... strings) {

            publishProgress(0);
            ResponseDataWithCode<ArrayList<Bank>> bank = BankServiceImpl.getInstance().fetch();
            saveWithStatusCode(bank, BankServiceDatabase.class);

            publishProgress(1);
            ResponseDataWithCode<ArrayList<CatalogueCFDI>> catalogueCFDIs = CatalogueCFDIServiceImpl.getInstance().fetch();
            saveWithStatusCode(catalogueCFDIs, CatalogueCFDIServiceDatabase.class);

//            publishProgress(2);
//            ResponseDataWithCode<ArrayList<Cedi>> cedis = CediServiceImpl.getInstance().jalar();
//            saveWithStatusCode(cedis, CediServiceDatabase.class);

            publishProgress(2);
            ResponseDataWithCode<Cedi> cedi = CediServiceImpl.getInstance().fetch();
            saveWithStatusCode(cedi, CediServiceDatabase.class);

            publishProgress(3);
            ResponseDataWithCode<ArrayList<Charge>> charges = ChargeServiceImpl.getInstance().fetch();
            saveWithStatusCode(charges, ChargeServiceDatabase.class);

            publishProgress(4);
            ResponseDataWithCode<ArrayList<Client>> clients = ClientServiceImpl.getInstance().fetch();
            saveWithStatusCode(clients, ClientServiceDatabase.class);

            publishProgress(5);
            ResponseDataWithCode<ArrayList<ClientAuthorization>> clientAuthorizations = ClientAuthorizationServiceImpl.getInstance().fetch();
            saveWithStatusCode(clientAuthorizations, ClientAuthorizationServiceDatabase.class);

            publishProgress(6);
            ResponseDataWithCode<ArrayList<ClientExhibitor>> clientExhibitors = ClientExhibitorServiceImpl.getInstance().fetch();
            saveWithStatusCode(clientExhibitors, ClientExhibitorServiceDatabase.class);

            publishProgress(7);
            ResponseDataWithCode<ArrayList<ClientProductBonification>> clientProductBonifications = ClientProductBonificationServiceImpl.getInstance().fetch();
            saveWithStatusCode(clientProductBonifications, ClientProductBonificationDatabase.class);

            publishProgress(8);
            ResponseDataWithCode<ArrayList<Employee>> employees = EmployeeServiceImpl.getInstance().fetch();
            saveWithStatusCode(employees, EmployeeServiceDatabase.class);

            publishProgress(9);
            ResponseDataWithCode<ArrayList<TypeClient>> typeClients = TypeClientServiceImpl.getInstance().fetch();
            saveWithStatusCode(typeClients, TypeClientServiceDatabase.class);

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
                    mProgressDialog.setMessage("SINCRONIZANDO BANCOS");
                    break;
                case 1:
                    mProgressDialog.setMessage("SINCRONIZANDO CATALOGO CFDI");
                    break;
                case 2:
                    mProgressDialog.setMessage("SINCRONIZANDO CEDIS");
                    break;
                case 3:
                    mProgressDialog.setMessage("SINCRONIZANDO CARGOS");
                    break;
                case 4:
                    mProgressDialog.setMessage("SINCRONIZANDO CLIENTES");
                    break;
                case 5:
                    mProgressDialog.setMessage("SINCRONIZANDO EXHIBIDORES");
                    break;
                case 6:
                    mProgressDialog.setMessage("SINCRONIZANDO AUTORIZACIONES");
                    break;
                case 7:
                    mProgressDialog.setMessage("SINCRONIZANDO BONIFICACIONES");
                    break;
                case 8:
                    mProgressDialog.setMessage("SINCRONIZANDO EMPLEADOS");
                    break;
                case 9:
                    mProgressDialog.setMessage("SINCRONIZANDO TIPO DE CLIENTES");
                    break;
                default:
                    mProgressDialog.setMessage("CONECTANDO");
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            mProgressDialog.dismiss();
            Toast.makeText(MainActivity.this, "ERROR DE CONEXION CON EL SERVIDOR", Toast.LENGTH_SHORT).show();
        }
    }
}
