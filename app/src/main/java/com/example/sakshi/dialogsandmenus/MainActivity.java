package com.example.sakshi.dialogsandmenus;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import static android.R.id.list;
import static com.example.sakshi.dialogsandmenus.R.id.date;

public class MainActivity extends AppCompatActivity{
    //declaring listView
    ListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //associating listView
        listview = (ListView)findViewById(R.id.list_item);

    }

    @Override
    //creating Options menu
    public boolean onCreateOptionsMenu(Menu menu) {
        //getting menuInflator
        MenuInflater menuInflater = getMenuInflater();
        //inflating menu from the menu directory
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    //on item select listener for Options menu
    public boolean onOptionsItemSelected(MenuItem item) {
        //getting selectedx item id
        int id= item.getItemId();
        //if id matches to that for add
        if(id==R.id.add){
            //call filldialog method
            filldialog();
        }

        return super.onOptionsItemSelected(item);
    }
    //Creating Custom ArrayLilst
    final ArrayList<Data> arrayList = new ArrayList<>();
    public void filldialog(){
        //creating dialog
        final Dialog dialog = new Dialog(MainActivity.this);
        //setting cancelable to false
        dialog.setCanceledOnTouchOutside(false);
        //setting dialog_layout
        dialog.setContentView(R.layout.dialog_layout);
        //show dialog
        dialog.show();
        //associating cancel button with its id
        Button cancel = (Button)dialog.findViewById(R.id.cancel);
        //onclick listener for cancel button
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dismiss dialog
                dialog.dismiss();
            }
        });
        //associating add button,EditTexts and DatePicker with their ids
        Button add = (Button)dialog.findViewById(R.id.additem);
        final EditText getnamedata = (EditText)dialog.findViewById(R.id.name);
        final EditText getagedata = (EditText)dialog.findViewById(R.id.age);
        final DatePicker datePicker = (DatePicker)dialog.findViewById(date);
        //set on click listener for add button
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getting data from editTexts and DatePicker
                String getname =  getnamedata.getText().toString();
                int getage = Integer.parseInt(getagedata.getText().toString());
                int mm,y,d;
                mm=datePicker.getMonth();
                y=datePicker.getYear();
                d=datePicker.getDayOfMonth();
                String getdate = d+"/"+mm+"/"+y;

                //Adding data to the arrayList
                Data data = new Data();
                data.setName(getname);
                data.setAge(getage);
                data.setDate(getdate);
                arrayList.add(data);

                //calling constructor for the CustomAdapter Class
                CustomAdapter customAdapter = new CustomAdapter(MainActivity.this,arrayList);
                //seeting custom adapter to the listView
                listview.setAdapter(customAdapter);
                //dismiss dialog after item is added
                dialog.dismiss();

            }
        });

    }
}
