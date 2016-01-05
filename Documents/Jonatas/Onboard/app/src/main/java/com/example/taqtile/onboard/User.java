package com.example.taqtile.onboard;

import java.util.*;


/**
 * Created by taqtile on 1/5/16.
 */
public class User {
    /*Classe de informações do usuário: nome, sobrenome e avatar */
    public class info {
        public String first_name, last_name, avatar;
        public void set(String first_name, String last_name, String avatar){
            this.first_name = first_name;
            this.last_name = last_name;
            this.avatar  = avatar;
        }
    }

    public int ViewCount;
    /*static info Info = new info("Joao","Carlos","http://queconceito.com.br/wp-content/uploads/2015/01/Emoticon.jpg");*/
    static ArrayList<HashMap<Integer, info>> lista;
    static String[] nome = {"Joao","Jose","Jaime","Carlos","Jhennifer","Camila","Stefanie","Marcos"};
    static String[] sobrenome = {"Silva","Costa","Lopez","Vargas","Buuck","Steuer","Ferreira","Gouveia"};

    public ArrayList<HashMap<Integer, info>> list(int Pagina){
        lista = new ArrayList<HashMap<Integer, info>>();
        int n1, n2;
        info random_info = new info();
        Random r = new Random();
        for(int i = 0; i < 10; i++){
            n1 = r.nextInt(7);
            n2 = r.nextInt(7);
            random_info.set(nome[n1],sobrenome[n2],"http://queconceito.com.br/wp-content/uploads/2015/01/Emoticon.jpg");
        }
        System.out.println(lista);
        return lista;
    }
    public void incrementViewCount(int id){
        this.ViewCount += 1;
    }
    public void resetViewCount(int id){
        this.ViewCount = 0;
    }
    public int getViewCount(){
        return this.ViewCount;
    }
}
