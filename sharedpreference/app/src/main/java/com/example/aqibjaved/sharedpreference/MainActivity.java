package com.example.aqibjaved.sharedpreference;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
    private ListView view;
    String items[]={"Home","Setting","Exit"};
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,items);
      view= (ListView)findViewById(R.id.listView1);
        view.setAdapter(adapter);










//   SharedPrefManagment.getInstance().init(getApplicationContext())
//           .insert(new LoginBean("ali","ali123"));
//       LoginBean login= SharedPrefManagment.getInstance().read();
//


//        savingCache();
    }

    private void savingCache() {
        String name="aqib";
        String password="aqib123";
        //MODE_PRIVATE is a private mode of file
        SharedPreferences preferences= getSharedPreferences("abc", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("USER_NAME",name);
        editor.putString("USER_PASSWORD",password);
        editor.commit();





    }
    public void readingCache(){
        SharedPreferences preferences = getSharedPreferences("abc",MODE_PRIVATE);
       String password= preferences.getString("USER_NAME","NOT FOUND");
    }
}
