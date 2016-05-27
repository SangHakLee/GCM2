package com.bridge.gcmapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sec on 2016-05-24.
 */
public class SecondActivity extends Activity {

    ArrayList<Song> al = new ArrayList<Song>();

    ListView lv ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);


        al.add(new Song("[공통]2016 하계 단기해외수업 모집공고","2016 하계 단기해외수업 모집공고..."));
        al.add(new Song("[공통]2016 사회봉사 교과목 운영안내","2016 사회봉사 교과목 운영안내..."));
        al.add(new Song("[공통]2016-1학기 중 휴학 마감안내","-1학기 중 휴학 마감안내..."));

        final MyAdapter adapter = new MyAdapter(
                getApplicationContext(),
                R.layout.row,
                al);

        lv = (ListView) findViewById(R.id.listView1);
        //
/*        final ArrayAdapter<Song> arrayAdapter = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, al);*/
        //
        lv.setAdapter(adapter);

        //
        /*final EditText edtItem = (EditText)findViewById(R.id.edtItem);*/
        Button btnAdd = (Button)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                adapter.notifyDataSetChanged();
            }
        });
        //


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(
                        getApplicationContext(),
                        DetailActivity.class


                );

                intent.putExtra("title", al.get(position).title);
                al.remove(id);
                adapter.notifyDataSetChanged();


                startActivity(intent);
            }
        });
    }
}

    class MyAdapter extends BaseAdapter { // 리스트 뷰의 아답타
        Context context;
        int layout;
        ArrayList<Song> al;
        LayoutInflater inf;
        public MyAdapter(Context context, int layout, ArrayList<Song> al) {
            this.context = context;
            this.layout = layout;
            this.al = al;
            inf = (LayoutInflater)context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            return al.size();
        }
        @Override
        public Object getItem(int position) {
            return al.get(position);
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null) {
                convertView = inf.inflate(layout, null);
            }
            TextView tvName = (TextView)convertView.findViewById(R.id.textView1);
            TextView tvInfo = (TextView)convertView.findViewById(R.id.textView2);

            Song m = al.get(position);
            tvName.setText(m.title);
            tvInfo.setText(m.artist);

            return convertView;
        }
    }

    class Song { // 자바빈
        String title = ""; // title
        String artist = ""; // artist
        public Song(String title,  String artist) {
            super();
            this.title = title;
            this.artist = artist;
        }
        public Song() {}
    }

