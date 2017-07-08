package com.ihub.ihub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class todo extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    String messageText;
    int position;

    public Button addErrand;
    public void init(){
        addErrand = (Button)findViewById(R.id.addErrand);
        addErrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toy = new Intent(todo.this, editMessageClass.class);

                startActivity(toy);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        init();
        listView = (ListView)findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(todo.this,editMessageClass.class);
                intent.putExtra(Intent_Constants.INTENT_MESSAGE_DATA,arrayList.get(position).toString());
                intent.putExtra(Intent_Constants.INTENT_ITEM_POSITION,position);
                startActivityForResult(intent,Intent_Constants.INTENT_REQUEST_CODE_TWO);
            }
        });
    }

    public void onClick(View v){
        Intent intent = new Intent();
        intent.setClass(todo.this, EditFieldClass.class);
        startActivityForResult(intent, Intent_Constants.INTENT_REQUEST_CODE);
    }

    /*
    here is the result of clicking on the saved button youtube video 34:55
    https://www.youtube.com/watch?v=3QHgJnPPnqQ
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==Intent_Constants.INTENT_REQUEST_CODE){
            messageText = data.getStringExtra(Intent_Constants.INTENT_MESSAGE_FIELD);
            arrayList.add(messageText);
            arrayAdapter.notifyDataSetChanged();
        }
        else if(resultCode==Intent_Constants.INTENT_REQUEST_CODE_TWO){
            messageText = data.getStringExtra(Intent_Constants.INTENT_CHANGED_MESSAGE);
            position = data.getIntExtra(Intent_Constants.INTENT_ITEM_POSITION,-1);
            arrayList.add(position,messageText);
            arrayAdapter.notifyDataSetChanged();

        }
    }
}
