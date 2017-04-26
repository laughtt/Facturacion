package com.example.jose.nubefact.Formularios;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jose.nubefact.Formats.MoneyTextWatcher;
import com.example.jose.nubefact.R;
import com.example.jose.nubefact.Ventas;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jose on 4/14/2017.
 */

public class ventas_formulario extends AppCompatActivity{
    @BindView(R.id.spinner_clientes)
    Spinner clientes_spinner;
    @BindView(R.id.spinner_tipo_documento)
    Spinner documento;
    @BindView(R.id.input_numero_docu)
    TextView Numero;
    @BindView(R.id.emision)
    DatePicker emision;
    @BindView(R.id.vencimiento)
    DatePicker vencimiento;
    @BindView(R.id.spinner_moneda)
    Spinner moneda;
    @BindView(R.id.input_tip_cambio)
    EditText tip_cambio;
    @BindView(R.id.radio_detraccion)
    RadioButton detraccion;
    @BindView(R.id.input_vehiculo)
    TextView vehiculo;
    @BindView(R.id.input_compra)
    TextView Compra;
    @BindView(R.id.btn_generar)
    Button generar;
    @BindView(R.id.btn_Guardar)
    Button guardar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_ventas);
        ButterKnife.bind(this);
        tip_cambio.addTextChangedListener(new MoneyTextWatcher(tip_cambio));
        ArrayAdapter<CharSequence> clientes = ArrayAdapter.createFromResource(this,
                R.array.clientes, android.R.layout.simple_spinner_item);
        clientes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clientes_spinner.setAdapter(clientes);
        ArrayAdapter<CharSequence> tip_docu = ArrayAdapter.createFromResource(this,
                R.array.tipo_doc, android.R.layout.simple_spinner_item);
        tip_docu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        documento.setAdapter(tip_docu);
        ArrayAdapter<CharSequence> Moneda = ArrayAdapter.createFromResource(this,
                R.array.moneda, android.R.layout.simple_spinner_item);
        Moneda.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        moneda.setAdapter(Moneda);



        generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_generar();
            }
        });
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_guardar();
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
    public void login_guardar() {

        if (!validate()) {
            onLoginFailed();
            return;
        }
        generar.setEnabled(false);
        onLoginSuccess();

    }
    public void login_generar() {

        if (!validate()) {
            onLoginFailed();
            return;
        }
        guardar.setEnabled(false);
        generar.setEnabled(false);
        onLoginSuccess();
    }

    public void onLoginSuccess() {
        guardar.setEnabled(true);
        generar.setEnabled(true);
        finish();
    }
    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Ingreso erroneo", Toast.LENGTH_LONG).show();
        guardar.setEnabled(true);
        generar.setEnabled(true);
    }



    public boolean validate() {
        boolean valid = true;

        String nume_docu = Numero.getText().toString();
        String tipo_cambio = tip_cambio.getText().toString();
        String vehi = vehiculo.getText().toString();
        String compra = Compra.getText().toString();


        String clientes = clientes_spinner.getItemAtPosition(clientes_spinner.getSelectedItemPosition()).toString();
        String tip_docu = documento.getItemAtPosition(documento.getSelectedItemPosition()).toString();



        if (nume_docu.isEmpty() || nume_docu.length() < 6) {
            Numero.setError("al menos 7 caracteres");
            valid = false;
        } else {
            Numero.setError(null);
        }




        return valid;
    }}




