package com.example.borja.aplicacionloteria;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Borja on 10/10/2015.
 */
public class AdaptadorListview extends ArrayAdapter<Boleto>{
    private Boleto[]datos;

    public AdaptadorListview(Context context, Boleto[]datos) {
        super(context,R.layout.listitem_boleto, datos);
        this.datos=datos;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater=LayoutInflater.from(getContext());
        View item=inflater.inflate(R.layout.listitem_boleto, null);

        TextView tvNumero=(TextView)item.findViewById(R.id.tvnumero);
        tvNumero.setText(datos[position].getNumero());

        TextView tvSerie=(TextView)item.findViewById(R.id.tvserie);
        tvSerie.setText(datos[position].getSerie());

        TextView tvTipo=(TextView)item.findViewById(R.id.tvtipo);
        tvTipo.setText(datos[position].getTipo());
        return (item);
    }
}
