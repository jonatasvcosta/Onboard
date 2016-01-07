package com.example.taqtile.onboard;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by taqtile on 1/6/16.
 */
public class CustomAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private String[] info;
    private int[] countView;
    public CustomAdapter(Activity context, String[] info, int[] countView) {
        super(context, R.layout.item_lista, info);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.info = info;
        this.countView = countView;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_lista, null, true);
        TextView id_item = (TextView) rowView.findViewById(R.id.item_id);
        ImageView marcador_item = (ImageView) rowView.findViewById(R.id.bolinha);
        TextView info_item = (TextView) rowView.findViewById(R.id.texto_item);

        if(countView[position] != 0){
            marcador_item.setVisibility(View.GONE);
        }
        id_item.setText("ID: "+position);
        info_item.setText(info[position]);
        return rowView;

    };
}

