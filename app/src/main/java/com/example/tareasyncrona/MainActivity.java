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
import com.example.tareasyncrona.api.BankServiceImpl;
import com.example.tareasyncrona.api.CatalogueCFDIServiceImpl;
import com.example.tareasyncrona.api.CediServiceImpl;
import com.example.tareasyncrona.api.ChargeServiceImpl;
import com.example.tareasyncrona.api.ClientAuthorizationServiceImpl;
import com.example.tareasyncrona.api.ClientExhibitorServiceImpl;
import com.example.tareasyncrona.api.ClientProductBonificationServiceImpl;
import com.example.tareasyncrona.api.ClientServiceImpl;
import com.example.tareasyncrona.api.EmployeeServiceImpl;
import com.example.tareasyncrona.api.ExhibitorServiceImpl;
import com.example.tareasyncrona.api.FolioServiceImpl;
import com.example.tareasyncrona.api.FuelTicketServiceImpl;
import com.example.tareasyncrona.api.LineServiceImpl;
import com.example.tareasyncrona.api.MethodOfPaymentServiceImp;
import com.example.tareasyncrona.api.PaymentServiceImpl;
import com.example.tareasyncrona.api.PriceServiceImpl;
import com.example.tareasyncrona.api.ProductRMIServiceImpl;
import com.example.tareasyncrona.api.ProductServiceImpl;
import com.example.tareasyncrona.api.RouteServiceImpl;
import com.example.tareasyncrona.api.TaxServiceImpl;
import com.example.tareasyncrona.api.TypeClientServiceImpl;
import com.example.tareasyncrona.modelo.jsonModel.Bank;
import com.example.tareasyncrona.modelo.jsonModel.CatalogueCFDI;
import com.example.tareasyncrona.modelo.jsonModel.Cedi;
import com.example.tareasyncrona.modelo.jsonModel.Charge;
import com.example.tareasyncrona.modelo.jsonModel.Client;
import com.example.tareasyncrona.modelo.jsonModel.ClientAuthorization;
import com.example.tareasyncrona.modelo.jsonModel.ClientExhibitor;
import com.example.tareasyncrona.modelo.jsonModel.ClientProductBonification;
import com.example.tareasyncrona.modelo.jsonModel.Employee;
import com.example.tareasyncrona.modelo.jsonModel.Exhibitor;
import com.example.tareasyncrona.modelo.jsonModel.Folio;
import com.example.tareasyncrona.modelo.jsonModel.FuelTicket;
import com.example.tareasyncrona.modelo.jsonModel.Line;
import com.example.tareasyncrona.modelo.jsonModel.MethodOfPayment;
import com.example.tareasyncrona.modelo.jsonModel.Payment;
import com.example.tareasyncrona.modelo.jsonModel.Price;
import com.example.tareasyncrona.modelo.jsonModel.Product;
import com.example.tareasyncrona.modelo.jsonModel.ProductRMI;
import com.example.tareasyncrona.modelo.jsonModel.ResponseDataWithCode;
import com.example.tareasyncrona.modelo.jsonModel.Route;
import com.example.tareasyncrona.modelo.jsonModel.Tax;
import com.example.tareasyncrona.modelo.jsonModel.TypeClient;
import com.example.tareasyncrona.modelo.realmModel.BankEntity;
import com.example.tareasyncrona.modelo.realmModel.CatalogueCFDIEntity;
import com.example.tareasyncrona.modelo.realmModel.CediEntity;
import com.example.tareasyncrona.modelo.realmModel.ChargeEntity;
import com.example.tareasyncrona.modelo.realmModel.ClientAuthorizationEntity;
import com.example.tareasyncrona.modelo.realmModel.ClientEntity;
import com.example.tareasyncrona.modelo.realmModel.ClientExhibitorEntity;
import com.example.tareasyncrona.modelo.realmModel.ClientProductBonificationEntity;
import com.example.tareasyncrona.modelo.realmModel.EmployeeEntity;
import com.example.tareasyncrona.modelo.realmModel.ExhibitorEntity;
import com.example.tareasyncrona.modelo.realmModel.FolioEntity;
import com.example.tareasyncrona.modelo.realmModel.FuelTicketEntity;
import com.example.tareasyncrona.modelo.realmModel.LineEntity;
import com.example.tareasyncrona.modelo.realmModel.MethodOfPaymentEntity;
import com.example.tareasyncrona.modelo.realmModel.PaymentEntity;
import com.example.tareasyncrona.modelo.realmModel.PriceEntity;
import com.example.tareasyncrona.modelo.realmModel.ProductEntity;
import com.example.tareasyncrona.modelo.realmModel.ProductRMIEntity;
import com.example.tareasyncrona.modelo.realmModel.RouteEntity;
import com.example.tareasyncrona.modelo.realmModel.TaxEntity;
import com.example.tareasyncrona.modelo.realmModel.TypeClientEntity;
import com.example.tareasyncrona.services.dataBase.BankServiceDatabase;
import com.example.tareasyncrona.services.dataBase.CatalogueCFDIServiceDatabase;
import com.example.tareasyncrona.services.dataBase.CediServiceDatabase;
import com.example.tareasyncrona.services.dataBase.ChargeServiceDatabase;
import com.example.tareasyncrona.services.dataBase.ClientAuthorizationServiceDatabase;
import com.example.tareasyncrona.services.dataBase.ClientExhibitorServiceDatabase;
import com.example.tareasyncrona.services.dataBase.ClientProductBonificationServiceDatabase;
import com.example.tareasyncrona.services.dataBase.ClientServiceDatabase;
import com.example.tareasyncrona.services.dataBase.EmployeeServiceDatabase;
import com.example.tareasyncrona.services.dataBase.ExhibitorServiceDatabase;
import com.example.tareasyncrona.services.dataBase.FolioServiceDatabase;
import com.example.tareasyncrona.services.dataBase.FuelTicketServiceDatabase;
import com.example.tareasyncrona.services.dataBase.LineServiceDatabase;
import com.example.tareasyncrona.services.dataBase.MethodOfPaymentServiceDatabase;
import com.example.tareasyncrona.services.dataBase.PaymentServiceDatabase;
import com.example.tareasyncrona.services.dataBase.PriceServiceDatabase;
import com.example.tareasyncrona.services.dataBase.ProductRMIServiceDatabase;
import com.example.tareasyncrona.services.dataBase.ProductServiceDatabase;
import com.example.tareasyncrona.services.dataBase.RouteServiceDatabase;
import com.example.tareasyncrona.services.dataBase.TaxServiceDatabase;
import com.example.tareasyncrona.services.dataBase.TypeClientServiceDatabase;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;

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

    public <T extends RealmObject> void deleteRealm(Class<T> clase) {
        try (Realm realmInstance = Realm.getDefaultInstance()) {
            realmInstance.executeTransaction(realm -> realm.delete(clase));
        }
    }

    public void dropAllData() {
        deleteRealm(BankEntity.class);
        deleteRealm(CatalogueCFDIEntity.class);
        deleteRealm(CediEntity.class);
        deleteRealm(ChargeEntity.class);
        deleteRealm(ClientEntity.class);
        deleteRealm(ClientAuthorizationEntity.class);
        deleteRealm(ClientExhibitorEntity.class);
        deleteRealm(ClientProductBonificationEntity.class);
        deleteRealm(EmployeeEntity.class);
        deleteRealm(ExhibitorEntity.class);
        deleteRealm(FolioEntity.class);
        deleteRealm(FuelTicketEntity.class);
        deleteRealm(LineEntity.class);
        deleteRealm(MethodOfPaymentEntity.class);
        deleteRealm(PaymentEntity.class);
        deleteRealm(PriceEntity.class);
        deleteRealm(ProductEntity.class);
        deleteRealm(ProductRMIEntity.class);
        deleteRealm(RouteEntity.class);
        deleteRealm(TaxEntity.class);
        deleteRealm(TypeClientEntity.class);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            dropAllData();
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
                        CediServiceDatabase.getInstance().addObject(responseDataWithCode.getDataAsCedi());
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
                    case "ClientProductBonificationServiceDatabase": {
                        ClientProductBonificationServiceDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
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
                    case "ExhibitorServiceDatabase": {
                        ExhibitorServiceDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "FolioServiceDatabase": {
                        FolioServiceDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "FuelTicketServiceDatabase": {
                        FuelTicketServiceDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "LineServiceDatabase": {
                        LineServiceDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "MethodOfPaymentServiceDatabase": {
                        MethodOfPaymentServiceDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "PaymentServiceDatabase": {
                        PaymentServiceDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "PriceServiceDatabase": {
                        PriceServiceDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "ProductServiceDatabase": {
                        ProductServiceDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "ProductRMIServiceDatabase": {
                        ProductRMIServiceDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "RouteServiceDatabase": {
                        RouteServiceDatabase.getInstance().addObject(responseDataWithCode.getDataAsRoute());
                        break;
                    }
                    case "TaxServiceDatabase": {
                        TaxServiceDatabase.getInstance().addList(responseDataWithCode.getDataAsArray());
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
            saveWithStatusCode(clientProductBonifications, ClientProductBonificationServiceDatabase.class);

            publishProgress(8);
            ResponseDataWithCode<ArrayList<Exhibitor>> exhibitors = ExhibitorServiceImpl.getInstance().fetch();
            saveWithStatusCode(exhibitors, ExhibitorServiceDatabase.class);

            publishProgress(9);
            ResponseDataWithCode<ArrayList<Employee>> employees = EmployeeServiceImpl.getInstance().fetch();
            saveWithStatusCode(employees, EmployeeServiceDatabase.class);

            publishProgress(10);
            ResponseDataWithCode<ArrayList<Folio>> folios = FolioServiceImpl.getInstance().fetch();
            saveWithStatusCode(folios, FolioServiceDatabase.class);

            publishProgress(11);
            ResponseDataWithCode<ArrayList<FuelTicket>> fuelTickets = FuelTicketServiceImpl.getInstance().fetch();
            saveWithStatusCode(fuelTickets, FuelTicketServiceDatabase.class);

            publishProgress(12);
            ResponseDataWithCode<ArrayList<Line>> lines = LineServiceImpl.getInstance().fetch();
            saveWithStatusCode(lines, LineServiceDatabase.class);

            publishProgress(13);
            ResponseDataWithCode<ArrayList<MethodOfPayment>> methodOfPayments = MethodOfPaymentServiceImp.getInstance().fetch();
            saveWithStatusCode(methodOfPayments, MethodOfPaymentServiceDatabase.class);

            publishProgress(14);
            ResponseDataWithCode<ArrayList<Payment>> payments = PaymentServiceImpl.getInstance().fetch();
            saveWithStatusCode(payments, PaymentServiceDatabase.class);

            publishProgress(15);
            ResponseDataWithCode<ArrayList<Price>> prices = PriceServiceImpl.getInstance().fetch();
            saveWithStatusCode(prices, PriceServiceDatabase.class);

            publishProgress(16);
            ResponseDataWithCode<ArrayList<Product>> products = ProductServiceImpl.getInstance().fetch();
            saveWithStatusCode(products, ProductServiceDatabase.class);

            publishProgress(17);
            ResponseDataWithCode<ArrayList<ProductRMI>> productsRMI = ProductRMIServiceImpl.getInstance().fetch();
            saveWithStatusCode(productsRMI, ProductRMIServiceDatabase.class);

            publishProgress(18);
            ResponseDataWithCode<Route> route = RouteServiceImpl.getInstance().fetch();
            saveWithStatusCode(route, RouteServiceDatabase.class);

            publishProgress(19);
            ResponseDataWithCode<ArrayList<Tax>> taxes = TaxServiceImpl.getInstance().fetch();
            saveWithStatusCode(taxes, TaxServiceDatabase.class);

            publishProgress(20);
            ResponseDataWithCode<ArrayList<TypeClient>> typeClients = TypeClientServiceImpl.getInstance().fetch();
            saveWithStatusCode(typeClients, TypeClientServiceDatabase.class);

            return 20;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setTitle("Sincronizando ...");
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
                    mProgressDialog.setMessage("BANCOS");
                    break;
                case 1:
                    mProgressDialog.setMessage("CATALOGO CFDI");
                    break;
                case 2:
                    mProgressDialog.setMessage("CEDIS");
                    break;
                case 3:
                    mProgressDialog.setMessage("CARGOS");
                    break;
                case 4:
                    mProgressDialog.setMessage("CLIENTES");
                    break;
                case 5:
                    mProgressDialog.setMessage("EXHIBIDORES");
                    break;
                case 6:
                    mProgressDialog.setMessage("AUTORIZACIONES");
                    break;
                case 7:
                    mProgressDialog.setMessage("BONIFICACIONES");
                    break;
                case 8:
                    mProgressDialog.setMessage("EXHIBIDORES");
                    break;
                case 9:
                    mProgressDialog.setMessage("EMPLEADOS");
                    break;
                case 10:
                    mProgressDialog.setMessage("FOLIOS");
                    break;
                case 11:
                    mProgressDialog.setMessage("COMBUSTIBLES");
                    break;
                case 12:
                    mProgressDialog.setMessage("LINEAS");
                    break;
                case 13:
                    mProgressDialog.setMessage("METODOS DE PAGO");
                    break;
                case 14:
                    mProgressDialog.setMessage("PAGOS");
                    break;
                case 15:
                    mProgressDialog.setMessage("LISTA DE PRECIOS");
                    break;
                case 16:
                    mProgressDialog.setMessage("PRODUCTOS");
                    break;
                case 17:
                    mProgressDialog.setMessage("RMI");
                    break;
                case 18:
                    mProgressDialog.setMessage("RUTA");
                    break;
                case 19:
                    mProgressDialog.setMessage("IMPUESTOS");
                    break;
                case 20:
                    mProgressDialog.setMessage("TIPO DE CLIENTES");
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


