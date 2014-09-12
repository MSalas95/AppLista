package com.example.manuel.applista;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class List extends ActionBarActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        String text1,text2;
        text1="Un tercio de los jugadores de PS4 vienen de Wii y Xbox 360";
        text2="Xataka";
        ArrayList<ListItem> datos = new ArrayList<ListItem>();

        for (int i=0;i<10;i++){
            datos.add(new ListItem(R.drawable.ps4,R.drawable.xataka,text2,text1,"15h"));
        }


        lista = (ListView) findViewById(R.id.lista);

        lista.setAdapter(new IconicAdapter(this, R.layout.item_list, datos) {
            @Override
            public void onEntrada(Object entrada, View view) {

                if (entrada != null) {
                    TextView tv1 = (TextView) view.findViewById(R.id.tv1);
                    TextView tv2 = (TextView) view.findViewById(R.id.tv2);
                    TextView tv3 = (TextView) view.findViewById(R.id.tv3);
                    ImageView img1 = (ImageView) view.findViewById(R.id.image1);
                    ImageView img2 = (ImageView) view.findViewById(R.id.image2);

                    tv1.setText(((ListItem)entrada).getTv1());
                    tv2.setText(((ListItem)entrada).getTv2());
                    tv3.setText(((ListItem)entrada).getTv3());
                    img1.setImageResource(((ListItem) entrada).getIcon1());
                        img2.setImageResource(((ListItem) entrada).getIcon2());
                }

            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {

                Intent I = new Intent(List.this,Post.class);
                startActivity(I);

            }
        });



    }

    abstract class IconicAdapter extends BaseAdapter {
        private Context contexto;
        private ArrayList<?> entradas;
        private int R_layout_IdView;

        public IconicAdapter(Context contexto, int R_layout_IdView, ArrayList<?> entradas) {
            super();
            this.contexto = contexto;
            this.entradas = entradas;
            this.R_layout_IdView = R_layout_IdView;
        }

        @Override
        public int getCount() {
            return entradas.size();
        }

        @Override
            public Object getItem(int position) {
            return entradas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup pariente) {
            if (view == null) {
                LayoutInflater vi = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = vi.inflate(R_layout_IdView, null);
            }

            onEntrada (entradas.get(position), view);
            return view;
        }

        public abstract void onEntrada (Object entrada, View view);

    }

}
