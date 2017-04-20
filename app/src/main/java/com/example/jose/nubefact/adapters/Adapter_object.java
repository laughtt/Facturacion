package com.example.jose.nubefact.adapters;

import android.media.MediaPlayer;

/**
 * Created by jose on 4/13/2017.
 */

public class Adapter_object {


    private String nombre ;
    private String cod;
    private float costo ;
    private String cod_personal ;
    private String email ;



    public Adapter_object(String Cod , String Nom , float Costo , boolean Estado ) {

        this.nombre = Nom ;
        this.cod= Cod ;
        this.costo= Costo;

    }
    public Adapter_object(String cod_personal, String nom_Cliente , String email ) {

        this.nombre = nom_Cliente ;
        this.cod_personal = cod_personal;
        this.email = email;
    }

    public String getNombre(){

     return nombre;
     }


    public String getcod(){

        return cod;
    }
    public float getcosto(){

        return costo;
    }
    public String getCod_personal(){

        return cod_personal;
    }
    public String getemail(){
        return email;


    }
}
