package com.weeg.mobile48;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText ETname, pass;
    Button regis, log;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ETname =(EditText)findViewById(R.id.Editname);
        pass =(EditText)findViewById(R.id.Editpass);

        regis =(Button)findViewById(R.id.Bregis);
        log =(Button)findViewById(R.id.Blogin);

        ref = FirebaseDatabase.getInstance().getReference().child("User");

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(MainActivity.this,Activity2.class);
                startActivity(next);
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(MainActivity.this,Activity3.class);
                startActivity(gologin);
                login();
            }
        });
    }

    public void login(){
        String Name = ETname.getText().toString();
        final String Pass = pass.getText().toString();


            ref.child(Name).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    User newuser = dataSnapshot.getValue(User.class);
                    if (Pass.equals(newuser.getPass())) {
                        Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_LONG).show();
                        Intent start = new Intent(MainActivity.this, Activity3.class);
                        startActivity(start);
                    } else {
                        Toast.makeText(MainActivity.this, "Enter Correct pass..!", Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
    }

}
