package com.example.jose.nubefact.Formularios;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jose.nubefact.Clientes;
import com.example.jose.nubefact.Login.LoginActivity;
import com.example.jose.nubefact.R;
import com.example.jose.nubefact.adapters.Adapter_object;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jose on 4/15/2017.
 */

public class clientes_formulario extends AppCompatActivity {
    @BindView(R.id.input_numero) TextView documento;
    @BindView(R.id.input_denominacion) TextView denominacion;
    @BindView(R.id.input_telefono) TextView telefono ;
    @BindView(R.id.btn_grabar) Button grabar ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the principal layout file
        setContentView(R.layout.add_clientes);
        ButterKnife.bind(this);
        Spinner spinner = (Spinner) findViewById(R.id.spinner_doc);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Tipo_doc, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    public void login() {
        Log.d("cargando", "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        grabar.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(clientes_formulario.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Authenticating...");
        progressDialog.show();


        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    public void onLoginSuccess() {
        grabar.setEnabled(true);
        finish();
    }
    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Ingreso erroneo", Toast.LENGTH_LONG).show();

        grabar.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String doc = documento.getText().toString();
        String mobile = telefono.getText().toString();

       
        if (doc.isEmpty() || doc.length() < 7) {
            documento.setError("al menos 7 caracteres");
            valid = false;
        } else {
            documento.setError(null);
        }

        if (mobile.isEmpty() || mobile.length()!=9) {
            telefono.setError("ingrese un numero valido");
            valid = false;
        } else {
            telefono.setError(null);
        }


        return valid;
    }




}