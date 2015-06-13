package com.ussoftwareltd.ramzan2015;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Bappy on 6/2/2015.
 */
public class Sheri_Ifter_Times extends ActionBarActivity {
    private SI_DB dbHelper;
    ListView lv;
    ArrayAdapter<SI_Times> adapter;
    ArrayList<SI_Times> allTimes;
    Spinner sp;
    ArrayAdapter<String> adapterCountry;
    String[] countryList={"Dhaka","Khulna","Sylhet","Chittagong","Barisal","Rajshahi","Rangpur"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sheri_ifter_time_layout);

        dbHelper=SI_DB.getInstance(getApplicationContext());

        lv=(ListView)findViewById(R.id.lvList);
        sp=(Spinner)findViewById(R.id.spinner);


        allTimes=dbHelper.searchRamjanTimes("Dhaka");
      //  timeRamjan=dbHelper.getAllTimes();

//        for(SI_Times s: allTimes){
//            Toast.makeText(getApplication(), s.toString(),Toast.LENGTH_LONG).show();
//        }

        //Spinner
        adapterCountry=new ArrayAdapter<String>(getApplicationContext(),R.layout.spiner_layout, countryList);
        sp.setAdapter(adapterCountry);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                allTimes=dbHelper.searchRamjanTimes(countryList[position]);
                adapter=new ArrayAdapter<SI_Times>(getApplicationContext(), R.layout.sheri_ifter_time_custom_listview_layout, allTimes){
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View v=convertView;
                        if(v==null){
                            LayoutInflater vi=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            v=vi.inflate(R.layout.sheri_ifter_time_custom_listview_layout,null);
                        }
                        TextView tv1=(TextView)v.findViewById(R.id.tvDate);
                        tv1.setText(allTimes.get(position).getDate());
                        TextView tv2=(TextView)v.findViewById(R.id.tvDay);
                        tv2.setText(allTimes.get(position).getDay());
                        TextView tv3=(TextView)v.findViewById(R.id.tvSher);
                        tv3.setText(allTimes.get(position).getSher());
                        TextView tv4=(TextView)v.findViewById(R.id.tvIfter);
                        tv4.setText(allTimes.get(position).getIftar());



                        return v;
                    };
                };

                lv.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Using ListView
        adapter=new ArrayAdapter<SI_Times>(getApplicationContext(), R.layout.sheri_ifter_time_custom_listview_layout, allTimes){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v=convertView;
                if(v==null){
                    LayoutInflater vi=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    v=vi.inflate(R.layout.sheri_ifter_time_custom_listview_layout,null);
                }
                TextView tv1=(TextView)v.findViewById(R.id.tvDate);
                tv1.setText(allTimes.get(position).getDate());
                TextView tv2=(TextView)v.findViewById(R.id.tvDay);
                tv2.setText(allTimes.get(position).getDay());
                TextView tv3=(TextView)v.findViewById(R.id.tvSher);
                tv3.setText(allTimes.get(position).getSher());
                TextView tv4=(TextView)v.findViewById(R.id.tvIfter);
                tv4.setText(allTimes.get(position).getIftar());



                return v;
            };
        };

        lv.setAdapter(adapter);

    }



}
