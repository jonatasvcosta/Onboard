package com.example.taqtile.onboard;

import java.util.*;
import android.util.Log;


/**
 * Created by taqtile on 1/5/16.
 */
public class User {
    /*Classe de informações do usuário: nome, sobrenome e avatar */
    public class info extends HashMap<Integer, info> {
        public String first_name, last_name, avatar;
        public void set(String first_name, String last_name, String avatar){
            this.first_name = first_name;
            this.last_name = last_name;
            this.avatar  = avatar;
        }
    }

    /*static info Info = new info("Joao","Carlos","http://queconceito.com.br/wp-content/uploads/2015/01/Emoticon.jpg");*/
    static ArrayList<HashMap<Integer, info>> lista;
    static String[] nome = {"Joao","Jose","Jaime","Carlos","Jhennifer","Camila","Stefanie","Marcos"};
    static String[] sobrenome = {"Silva","Costa","Lopez","Vargas","Buuck","Steuer","Ferreira","Gouveia"};
    int [] ViewCount = new int[10];
    public static final String USER_TAG = "User";

    public ArrayList<HashMap<Integer, info>> list(int Pagina){
        Log.i(USER_TAG,"list");
        lista = new ArrayList<HashMap<Integer, info>>();
        int n1, n2;
        info random_info = new info();
        Random r = new Random();
        for(int i = 0; i < 10; i++){
            n1 = r.nextInt(7);
            n2 = r.nextInt(7);
            random_info.set(nome[n1],sobrenome[n2],"http://queconceito.com.br/wp-content/uploads/2015/01/Emoticon.jpg");

            lista.add(i,random_info);
        }
        
        return lista;
    }
    public void incrementViewCount(int id){
        Log.i(USER_TAG,"incrementViewCount");
        ViewCount[id] += 1;
    }
    public void resetViewCount(int id){
        Log.i(USER_TAG,"resetViewCount");
        ViewCount[id] = 0;
    }
    public int getViewCount(int id)
    {
        Log.i(USER_TAG,"getViewCount");
        return ViewCount[id];
    }
}
