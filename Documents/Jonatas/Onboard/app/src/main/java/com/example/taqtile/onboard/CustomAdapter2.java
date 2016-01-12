package com.example.taqtile.onboard;

/**
 * Created by taqtile on 1/11/16.
 */

import android.app.Activity;
import android.database.Cursor;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by taqtile on 1/6/16.
 */
public class CustomAdapter2 extends ArrayAdapter<String> {

    private final Activity context;
    private ArrayList info;
    private int[] countView;
    BancoController crud;
    public CustomAdapter2(Activity context, ArrayList info, int[] countView) {
        super(context, R.layout.item_lista2, info);
        // TODO Auto-generated constructor stub
        this.crud = new BancoController(context.getBaseContext());
        this.context=context;
        this.info = info;
        this.countView = countView;
    }

    public View getView(final int position,View view,ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_lista2, null, true);
        TextView id_item = (TextView) rowView.findViewById(R.id.item_id);
        ImageView marcador_item = (ImageView) rowView.findViewById(R.id.bolinha);
        final TextView info_item = (TextView) rowView.findViewById(R.id.texto_item);
        ImageView deleteImg = (ImageView) rowView.findViewById(R.id.deletar);
        ImageView editImg = (ImageView) rowView.findViewById(R.id.editar);
        deleteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = crud.CarregaDados();
                for(int i = 0;i != position;i++, c.move(1));
                String name = c.getString(c.getColumnIndex("first_name"));
                String lastname = c.getString(c.getColumnIndex("last_name"));
                //Toast.makeText(getContext(),"Nome: "+name+" Sobrenome: "+lastname,Toast.LENGTH_SHORT).show();
                crud.DeletarDados(name, lastname);
                String userName = info.get(position).toString();
                for(int i = 0; i < info.size(); i++){
                    if(info.get(i).toString() == userName){
                        info.remove(i);
                        notifyDataSetChanged();
                    }
                }
                //info.remove(position);

            }
        });
        editImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Cliquei em editar na posicao "+position+" Count "+getCount(),Toast.LENGTH_SHORT).show();
            }
        });
        if(countView[position] != 0){
            marcador_item.setVisibility(View.GONE);
        }
        id_item.setText("ID: "+position);
        info_item.setText(info.get(position).toString());
        return rowView;

    };

    public class ViewHolder{
        ImageView bolinha;
        TextView idItem;
        ImageView editImg;
        ImageView deleteImg;
        TextView userInfo;
    }
}

