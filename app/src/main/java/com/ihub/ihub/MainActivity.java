package com.ihub.ihub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void navMap(View view) {
        Intent intent = new Intent(this, map.class);
        startActivity(intent);
    }

    public void navTodo(View view) {
        Intent intent = new Intent(this, todo.class);
        startActivity(intent);
    }
}
