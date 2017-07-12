package com.nawoori.android.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SingerAdapter adapter;
    EditText editText, editText2;
    Button button;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);


        listView = (ListView) findViewById(R.id.listView);

        adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("일번", "010-1000-1000", R.drawable.icon01));
        adapter.addItem(new SingerItem("이번", "010-2000-2000", R.drawable.icon02));
        adapter.addItem(new SingerItem("삼번", "010-3000-3000", R.drawable.icon03));
        adapter.addItem(new SingerItem("사번", "010-4000-4000", R.drawable.icon04));
        adapter.addItem(new SingerItem("오번", "010-5000-5000", R.drawable.icon05));
        adapter.addItem(new SingerItem("육번", "010-4000-4000", R.drawable.icon06));
        adapter.addItem(new SingerItem("칠번", "010-5000-5000", R.drawable.icon07));
        adapter.addItem(new SingerItem("팔번", "010-4000-4000", R.drawable.icon08));
        adapter.addItem(new SingerItem("구번", "010-5000-5000", R.drawable.icon09));
        adapter.addItem(new SingerItem("십번", "010-5000-5000", R.drawable.icon10));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택 :" + item.getName(), Toast.LENGTH_LONG).show();


            }
        });

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.getText().toString();
                String name = editText.getText().toString();
                String mobile = editText2.getText().toString();
                adapter.addItem(new SingerItem(name, mobile, R.drawable.icon01));
                adapter.notifyDataSetChanged();

            }
        });


    }


    class SingerAdapter extends BaseAdapter {

        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SingeritemView view = null;
            if (convertView == null){
                  view = new SingeritemView(getApplicationContext());
            } else {
                view = (SingeritemView) convertView;
            }


            SingerItem item = items.get(position);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImage(item.getResId());

            return view;
        }
    }

}
