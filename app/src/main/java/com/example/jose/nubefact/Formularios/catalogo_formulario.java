package com.example.jose.nubefact.Formularios;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jose.nubefact.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.security.AccessController.getContext;

/**
 * Created by jose on 4/18/2017.
 */

public class catalogo_formulario extends AppCompatActivity {
     @BindView(R.id.input_codigo_catalogo)
     TextView codigo;
     @BindView(R.id.input_precio_unit)
     TextView precio;
     @BindView(R.id.input_descripcion)
     TextView descripcion;
     @BindView(R.id.btn_grabar_catalogo)
     Button grabar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_catalogo);
        ButterKnife.bind(this);
        Spinner spinner = (Spinner) findViewById(R.id.spinner_tipo);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tipo_doc, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
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
        onLoginSuccess();


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

        String cod = codigo.getText().toString();
        String prec = precio.getText().toString();
        String descr = descripcion.getText().toString();

        if (cod.isEmpty() || cod.length() < 3) {
            codigo.setError("al menos 3 caracteres");
            valid = false;
        } else {
            codigo.setError(null);
        }
        if (prec.isEmpty()|| prec.length() < 1) {
            precio.setError("al menos 1 caracter");
            valid = false;
        } else {
            precio.setError(null);
        }
        if (descr.isEmpty() || descr.length() < 3) {
            descripcion.setError("al menos 3 caracteres");
            valid = false;
        } else {
            descripcion.setError(null);
        }



        return valid;
    } }




