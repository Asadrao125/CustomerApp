package com.example.asadrao.customerapp;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    EditText edtText;
    Button btnAdd,btnView;
    DatabaseHelper mDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtText = (EditText)findViewById(R.id.edtText);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnView = (Button)findViewById(R.id.btnView);
        mDatabaseHelper = new DatabaseHelper(this);
        addData();
        viewData();
    }
    public void addData()
    {
       btnAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               boolean isInsert = mDatabaseHelper.insert(edtText.getText().toString());
               if (isInsert) Toast.makeText(MainActivity.this, "Inserted Succefully", Toast.LENGTH_SHORT).show();
               else Toast.makeText(MainActivity.this, "Failed To Insert", Toast.LENGTH_SHORT).show();
           }
       });
    }
    public void viewData()
    {
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this,ListDataActivity.class));
            }
        });
    }
}