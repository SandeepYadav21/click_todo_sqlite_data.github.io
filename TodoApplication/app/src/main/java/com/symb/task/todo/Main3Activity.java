package com.symb.task.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    DatabaseHelper myDB;
    Button save;
    EditText edittxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        edittxt = (EditText) findViewById(R.id.edittext);
        save = (Button) findViewById(R.id.savebtn);
        myDB = new DatabaseHelper(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = edittxt.getText().toString();
                if (edittxt.length() != 0) {
                    AddData(newEntry);
                    edittxt.setText("");
                } else {
                    Toast.makeText(Main3Activity.this, "You must put something in the text field!", Toast.LENGTH_LONG).show();
                }
            }

        });

    }

            private void AddData(String newEntry) {
                boolean insertData = myDB.addData(newEntry);

                if(insertData==true){
                    Toast.makeText(this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show();
                }


            }
        
    }

