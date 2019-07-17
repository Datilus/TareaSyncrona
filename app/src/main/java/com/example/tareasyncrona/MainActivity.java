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
import com.example.tareasyncrona.data.api.FormVisit;
import com.example.tareasyncrona.data.db.FormVisitEntity;
import com.example.tareasyncrona.services.api.BankApiServiceImpl;
import com.example.tareasyncrona.services.api.CatalogueCFDIApiServiceImpl;
import com.example.tareasyncrona.services.api.CediApiServiceImpl;
import com.example.tareasyncrona.services.api.ChargeApiServiceImpl;
import com.example.tareasyncrona.services.api.ClientAuthorizationApiServiceImpl;
import com.example.tareasyncrona.services.api.ClientExhibitorApiServiceImpl;
import com.example.tareasyncrona.services.api.ClientProductBonificationApiServiceImpl;
import com.example.tareasyncrona.services.api.ClientApiServiceImpl;
import com.example.tareasyncrona.services.api.EmployeeApiServiceImpl;
import com.example.tareasyncrona.services.api.ExhibitorApiServiceImpl;
import com.example.tareasyncrona.services.api.FolioApiServiceImpl;
import com.example.tareasyncrona.services.api.FormVisitApiServiceImpl;
import com.example.tareasyncrona.services.api.FuelTicketApiServiceImpl;
import com.example.tareasyncrona.services.api.LineApiServiceImpl;
import com.example.tareasyncrona.services.api.MethodOfPaymentApiServiceImpl;
import com.example.tareasyncrona.services.api.PaymentApiServiceImpl;
import com.example.tareasyncrona.services.api.PriceApiServiceImpl;
import com.example.tareasyncrona.services.api.ProductRMIApiServiceImpl;
import com.example.tareasyncrona.services.api.ProductApiServiceImpl;
import com.example.tareasyncrona.services.api.RouteApiServiceImpl;
import com.example.tareasyncrona.services.api.TaxApiServiceImpl;
import com.example.tareasyncrona.services.api.TypeClientApiServiceImpl;
import com.example.tareasyncrona.data.api.Bank;
import com.example.tareasyncrona.data.api.CatalogueCFDI;
import com.example.tareasyncrona.data.api.Cedi;
import com.example.tareasyncrona.data.api.Charge;
import com.example.tareasyncrona.data.api.Client;
import com.example.tareasyncrona.data.api.ClientAuthorization;
import com.example.tareasyncrona.data.api.ClientExhibitor;
import com.example.tareasyncrona.data.api.ClientProductBonification;
import com.example.tareasyncrona.data.api.Employee;
import com.example.tareasyncrona.data.api.Exhibitor;
import com.example.tareasyncrona.data.api.Folio;
import com.example.tareasyncrona.data.api.FuelTicket;
import com.example.tareasyncrona.data.api.Line;
import com.example.tareasyncrona.data.api.MethodOfPayment;
import com.example.tareasyncrona.data.api.Payment;
import com.example.tareasyncrona.data.api.Price;
import com.example.tareasyncrona.data.api.Product;
import com.example.tareasyncrona.data.api.ProductRMI;
import com.example.tareasyncrona.data.api.ResponseDataWithCode;
import com.example.tareasyncrona.data.api.Route;
import com.example.tareasyncrona.data.api.Tax;
import com.example.tareasyncrona.data.api.TypeClient;
import com.example.tareasyncrona.data.db.BankEntity;
import com.example.tareasyncrona.data.db.CatalogueCFDIEntity;
import com.example.tareasyncrona.data.db.CediEntity;
import com.example.tareasyncrona.data.db.ChargeEntity;
import com.example.tareasyncrona.data.db.ClientAuthorizationEntity;
import com.example.tareasyncrona.data.db.ClientEntity;
import com.example.tareasyncrona.data.db.ClientExhibitorEntity;
import com.example.tareasyncrona.data.db.ClientProductBonificationEntity;
import com.example.tareasyncrona.data.db.EmployeeEntity;
import com.example.tareasyncrona.data.db.ExhibitorEntity;
import com.example.tareasyncrona.data.db.FolioEntity;
import com.example.tareasyncrona.data.db.FuelTicketEntity;
import com.example.tareasyncrona.data.db.LineEntity;
import com.example.tareasyncrona.data.db.MethodOfPaymentEntity;
import com.example.tareasyncrona.data.db.PaymentEntity;
import com.example.tareasyncrona.data.db.PriceEntity;
import com.example.tareasyncrona.data.db.ProductEntity;
import com.example.tareasyncrona.data.db.ProductRMIEntity;
import com.example.tareasyncrona.data.db.RouteEntity;
import com.example.tareasyncrona.data.db.TaxEntity;
import com.example.tareasyncrona.data.db.TypeClientEntity;
import com.example.tareasyncrona.services.db.BankDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.CatalogueCFDIDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.CediDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.ChargeDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.ClientAuthorizationDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.ClientExhibitorDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.ClientProductBonificationDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.ClientDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.EmployeeDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.ExhibitorDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.FolioDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.FormVisitDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.FuelTicketDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.LineDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.MethodOfPaymentDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.PaymentDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.PriceDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.ProductDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.ProductRMIDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.RouteDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.TaxDatabaseServiceImpl;
import com.example.tareasyncrona.services.db.TypeClientDatabaseServiceImpl;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //INICIA TODOS LOS SERVICIOS DE NETWORKING CON OKHTTPCLIENT
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                . writeTimeout(30, TimeUnit.SECONDS)
                .build();
        AndroidNetworking.initialize(getApplicationContext(), okHttpClient);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> new ProgressDialogAsyncTask().execute());

        Realm.init(getApplicationContext());
        setUpRealmConfig();
        Realm realm = Realm.getDefaultInstance();
        realm.close();

        Constants.Api.URL.setIP();
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
        deleteRealm(ClientAuthorizationEntity.class);
        deleteRealm(ClientEntity.class);
        deleteRealm(ClientExhibitorEntity.class);
        deleteRealm(ClientProductBonificationEntity.class);
        deleteRealm(EmployeeEntity.class);
        deleteRealm(ExhibitorEntity.class);
        deleteRealm(FolioEntity.class);
        deleteRealm(FormVisitEntity.class);
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
                    case "BankDatabaseServiceImpl": {
                        BankDatabaseServiceImpl.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "CatalogueCFDIDatabaseServiceImpl": {
                        CatalogueCFDIDatabaseServiceImpl.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "CediDatabaseServiceImpl": {
                        CediDatabaseServiceImpl.getInstance().addObject(responseDataWithCode.getDataAsCedi());
                        break;
                    }
                    case "ChargeDatabaseServiceImpl": {
                        ChargeDatabaseServiceImpl.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "ClientAuthorizationDatabaseServiceImpl": {
                        ClientAuthorizationDatabaseServiceImpl.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "ClientExhibitorDatabaseServiceImpl": {
                        ClientExhibitorDatabaseServiceImpl.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "ClientDatabaseServiceImpl": {
                        ClientDatabaseServiceImpl.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "ClientProductBonificationDatabaseServiceImpl": {
                        ClientProductBonificationDatabaseServiceImpl.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "EmployeeDatabaseServiceImpl": {
                        EmployeeDatabaseServiceImpl.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "TypeClientDatabaseServiceImpl": {
                        TypeClientDatabaseServiceImpl.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "ExhibitorDatabaseServiceImpl": {
                        ExhibitorDatabaseServiceImpl.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "FolioDatabaseServiceImpl": {
                        FolioDatabaseServiceImpl.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "FuelTicketDatabaseServiceImpl": {
                        FuelTicketDatabaseServiceImpl.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "LineDatabaseServiceImpl": {
                        LineDatabaseServiceImpl.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "MethodOfPaymentDatabaseServiceImpl": {
                        MethodOfPaymentDatabaseServiceImpl.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "PaymentDatabaseServiceImpl": {
                        PaymentDatabaseServiceImpl.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "PriceDatabaseServiceImpl": {
                        PriceDatabaseServiceImpl.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "ProductDatabaseServiceImpl": {
                        ProductDatabaseServiceImpl.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "ProductRMIDatabaseServiceImpl": {
                        ProductRMIDatabaseServiceImpl.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "RouteDatabaseServiceImpl": {
                        RouteDatabaseServiceImpl.getInstance().addObject(responseDataWithCode.getDataAsRoute());
                        break;
                    }
                    case "TaxDatabaseServiceImpl": {
                        TaxDatabaseServiceImpl.getInstance().addList(responseDataWithCode.getDataAsArray());
                        break;
                    }
                    case "FormVisitDatabaseServiceImpl": {
                        FormVisitDatabaseServiceImpl.getInstance().addList(responseDataWithCode.getDataAsArray());
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
            for (int i = 0; i <= 21; i++) {
                switch (i) {
                    case 0: {
                        publishProgress(0);
                        ResponseDataWithCode<ArrayList<Bank>> bank = BankApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(bank, BankDatabaseServiceImpl.class);
                        break;
                    }
                    case 1: {
                        publishProgress(1);
                        ResponseDataWithCode<ArrayList<CatalogueCFDI>> catalogueCFDIs = CatalogueCFDIApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(catalogueCFDIs, CatalogueCFDIDatabaseServiceImpl.class);
                        break;
                    }
                    case 2: {
                        publishProgress(2);
                        ResponseDataWithCode<Cedi> cedi = CediApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(cedi, CediDatabaseServiceImpl.class);
                        break;
                    }
                    case 3: {
                        publishProgress(3);
                        ResponseDataWithCode<ArrayList<Charge>> charges = ChargeApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(charges, ChargeDatabaseServiceImpl.class);
                        break;
                    }
                    case 4: {
                        publishProgress(4);
                        ResponseDataWithCode<ArrayList<Client>> clients = ClientApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(clients, ClientDatabaseServiceImpl.class);
                        break;
                    }
                    case 5: {
                        publishProgress(5);
                        ResponseDataWithCode<ArrayList<ClientAuthorization>> clientAuthorizations = ClientAuthorizationApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(clientAuthorizations, ClientAuthorizationDatabaseServiceImpl.class);
                        break;
                    }
                    case 6: {
                        publishProgress(6);
                        ResponseDataWithCode<ArrayList<ClientExhibitor>> clientExhibitors = ClientExhibitorApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(clientExhibitors, ClientExhibitorDatabaseServiceImpl.class);
                        break;
                    }
                    case 7: {
                        publishProgress(7);
                        ResponseDataWithCode<ArrayList<ClientProductBonification>> clientProductBonifications = ClientProductBonificationApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(clientProductBonifications, ClientProductBonificationDatabaseServiceImpl.class);
                        break;
                    }
                    case 8: {
                        publishProgress(8);
                        ResponseDataWithCode<ArrayList<Exhibitor>> exhibitors = ExhibitorApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(exhibitors, ExhibitorDatabaseServiceImpl.class);
                        break;
                    }
                    case 9: {
                        publishProgress(9);
                        ResponseDataWithCode<ArrayList<Employee>> employees = EmployeeApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(employees, EmployeeDatabaseServiceImpl.class);
                        break;
                    }
                    case 10: {
                        publishProgress(10);
                        ResponseDataWithCode<ArrayList<Folio>> folios = FolioApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(folios, FolioDatabaseServiceImpl.class);
                        break;
                    }
                    case 11: {
                        publishProgress(11);
                        ResponseDataWithCode<ArrayList<FuelTicket>> fuelTickets = FuelTicketApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(fuelTickets, FuelTicketDatabaseServiceImpl.class);
                        break;
                    }
                    case 12: {
                        publishProgress(12);
                        ResponseDataWithCode<ArrayList<Line>> lines = LineApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(lines, LineDatabaseServiceImpl.class);
                        break;
                    }
                    case 13: {
                        publishProgress(13);
                        ResponseDataWithCode<ArrayList<MethodOfPayment>> methodOfPayments = MethodOfPaymentApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(methodOfPayments, MethodOfPaymentDatabaseServiceImpl.class);
                        break;
                    }
                    case 14: {
                        publishProgress(14);
                        ResponseDataWithCode<ArrayList<Payment>> payments = PaymentApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(payments, PaymentDatabaseServiceImpl.class);
                        break;
                    }
                    case 15: {
                        publishProgress(15);
                        ResponseDataWithCode<ArrayList<Price>> prices = PriceApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(prices, PriceDatabaseServiceImpl.class);
                        break;
                    }
                    case 16: {
                        publishProgress(16);
                        ResponseDataWithCode<ArrayList<Product>> products = ProductApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(products, ProductDatabaseServiceImpl.class);
                        break;
                    }
                    case 17: {
                        publishProgress(17);
                        ResponseDataWithCode<ArrayList<ProductRMI>> productsRMI = ProductRMIApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(productsRMI, ProductRMIDatabaseServiceImpl.class);
                        break;
                    }
                    case 18: {
                        publishProgress(18);
                        ResponseDataWithCode<Route> route = RouteApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(route, RouteDatabaseServiceImpl.class);
                        break;
                    }
                    case 19: {
                        publishProgress(19);
                        ResponseDataWithCode<ArrayList<Tax>> taxes = TaxApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(taxes, TaxDatabaseServiceImpl.class);
                        break;
                    }
                    case 20: {
                        publishProgress(20);
                        ResponseDataWithCode<ArrayList<TypeClient>> typeClients = TypeClientApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(typeClients, TypeClientDatabaseServiceImpl.class);
                        break;
                    }
                    case 21: {
                        publishProgress(21);
                        ResponseDataWithCode<ArrayList<FormVisit>> formVisits = FormVisitApiServiceImpl.getInstance().fetch();
                        saveWithStatusCode(formVisits, FormVisitDatabaseServiceImpl.class);
                        break;
                    }
                    default: {

                    }
                }
                if (isCancelled()) break;
            }

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
                case 21:
                    mProgressDialog.setMessage("FORMA DE VISITA");
                    break;
                default:
                    mProgressDialog.setMessage("CONECTANDO");
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            mProgressDialog.dismiss();
            Toast.makeText(MainActivity.this, "ERROR DE CONEXION CON EL SERVIDOR", Toast.LENGTH_LONG).show();
        }
    }
}


