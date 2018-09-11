package com.weeg.mobile48;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Activity2 extends AppCompatActivity {

    EditText name, lname, pass;
    Button Bre;
    User add = new User();
    FirebaseDatabase data;
    DatabaseReference Ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        name =(EditText)findViewById(R.id.name);
        lname =(EditText)findViewById(R.id.lname);
        pass =(EditText)findViewById(R.id.pass);

        Bre = (Button)findViewById(R.id.regis);

        data = FirebaseDatabase.getInstance();
        Ref = data.getReference().child("User");

        Bre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bre_click();
                Intent back = new Intent(Activity2.this,MainActivity.class);
                startActivity(back);
            }
        });



    }

    public void Bre_click(){
        add.setName(name.getText().toString());
        add.setLname(lname.getText().toString());
        add.setPass(pass.getText().toString());

        Ref.child(add.getName()).setValue(add).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Activity2.this,"Register Success",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(Activity2.this,"Failed..!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
