package com.example.aqibjaved.evsbatch24customlistview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MainActivity extends Activity {
    private String items[]={"Awais","Tariq","Zulqernain","Mubashir","Sharoz"};
    private ListView listView;
    private List<ListEntity> entities;
    private ListViewCustomAdaptor adaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        listView = (ListView)findViewById(R.id.listView);
        addingElementInEntities();
        adaptor = new ListViewCustomAdaptor(getApplicationContext(),entities);
        listView.setAdapter(adaptor);
    }

    private void addingElementInEntities() {
    if(items != null && items.length > 0 ){
        entities = new ArrayList<>(items.length);
        int index = 1;
        for(String item : items){
            ListEntity entity = new ListEntity();
            entity.setName(item);
            if(isEven(x -> x % 2 == 0, index)){
                entity.setImgSrc(R.drawable.even);
            }else{
                entity.setImgSrc(R.drawable.odd);
            }
            index++;
        }
      }
    }
    public boolean isEven(Predicate<Integer> predicate,int no){
        return predicate.test(no);
    }
}
