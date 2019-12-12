package com.example.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.edit_text);
        Button button  = findViewById(R.id.button);
        final ListView listView = findViewById(R.id.list_view);

        final ArrayList<String> names = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,names);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                names.add(name);
                adapter.notifyDataSetChanged();

                editText.setText("");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater  = getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        ListView listView = findViewById(R.id.list_view);

        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "Delete selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.bluetooth:
                Toast.makeText(this, "Bluetooth selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                Intent help = new Intent(this,HelpActivity.class);
                startActivity(help);
                return true;
            case R.id.settings:
                Intent settings = new Intent(this,SettingsActivity.class);
                startActivity(settings);

            case R.id.item3:
                Toast.makeText(this, "Item 3 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem1:
                Toast.makeText(this, "Sub Item 1 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subitem2:
                Toast.makeText(this, "Sub Item 2 selected", Toast.LENGTH_SHORT).show();
                return true;
                default:
                    return super.onOptionsItemSelected(item);

        }

    }
}
