package com.example.jose.nubefact.adapters;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jose.nubefact.R;

import java.util.ArrayList;

/**
 * Created by jose on 4/14/2017.
 */

public class Adapter extends ArrayAdapter<Adapter_object> {

    private int mcolorRefactor ;
    public Adapter(Activity context, ArrayList<Adapter_object> palabra, int colorRefactor) {

        super(context, 0, palabra);
        mcolorRefactor = colorRefactor;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.adapter_layout, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        final Adapter_object currentword = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView factura = (TextView) listItemView.findViewById(R.id.Factura_ventas);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        factura.setText(currentword.getcod());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView cliente = (TextView) listItemView.findViewById(R.id.Cliente_ventas);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        cliente.setText(currentword.getNombre());




        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
