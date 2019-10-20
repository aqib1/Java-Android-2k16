package com.example.muneebbutt.listviewproject;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MainActivity extends Activity {
    private ListView listView;
    private List<Entities> data;
    private String []items={"Home","Signup","Signin","Profile","Admin","Finance","Holders","Exit"};
//    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences pref= getSharedPreferences(getString(R.string.sharedPreferenceName),Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= pref.edit();
        editor.putString("username","aqib");
        editor.putString("password","AQI@3/aj$5/");
        editor.commit();
        String name=pref.getString("username","");








//
//        FragmentManager manager= getFragmentManager();
//        FragmentTransaction transaction= manager.beginTransaction();
//        MyFragOne one = new MyFragOne();
//        transaction.replace(R.id.ll,one,"one");
//        transaction.addToBackStack(null);
//        transaction.commit();
        initComponents();
        addingDataforList();
        settingUpAdaptor();
        settingUpListener();
    }

    private void settingUpAdaptor() {
        CustomAdaptor adaptor= new CustomAdaptor(data,this);
        listView.setAdapter(adaptor);
    }

    private void addingDataforList() {
        if(items.length!=0) {
            data= new ArrayList<>();
            for (int x = 0; x < items.length; x++) {
                Entities entities= new Entities();
//            Predicate<Integer> pre= new Predicate<Integer>() {
//                @Override
//                public boolean test(Integer integer) {
//                    return integer%2==0;
//                }
//            };
                if (isEven((y) -> y % 2 == 0, x+1))
                        entities.setIcon(R.drawable.even);
                else
                    entities.setIcon(R.drawable.odd);

                entities.setTitle(items[x]);

            }
        }
    }

    //Predicate is a funtional interface of java 8
    //it take one argument and return a boolean value
    private boolean isEven( Predicate<Integer> pre, Integer val) {
    return pre.test(val);
    }

//    @Override
//    public void onBackPressed() {
//        if(getFragmentManager().getBackStackEntryCount()>0){
//            getFragmentManager().popBackStack();
//        }else {
//            super.onBackPressed();
//        }
//    }

    private void settingUpListener() {
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//            Toast.makeText(MainActivity.this, "Clicked menu ["+items[i]+"]", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//        listView.setOnItemClickListener((adaptorView,view,index,l)->
//            Toast.makeText(this, "Clicked menu ["+items[index]+"]", Toast.LENGTH_SHORT).show()
//        );
    }

//    @Override
//    protected void onListItemClick(ListView l, View v, int position, long id) {
//            super.onListItemClick(l, v, position, id);
//    }

    private void initComponents() {
        listView=(ListView)findViewById(R.id.lv);
//        arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
//        listView.setAdapter(arrayAdapter);
//        setListAdapter(arrayAdapter);

     
    }
}
