package com.example.material;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    EditText b;
    MaterialButton button;
    EditText a;
    Firebase firebaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        a=findViewById(R.id.user);
        b=findViewById(R.id.pass);
        button=findViewById(R.id.btn);
        firebaseReference=new Firebase("https://material-e45eb.firebaseio.com/");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String u=dataSnapshot.getValue(String.class);
                a.setText(u);
                String p=dataSnapshot.getValue(String.class);
                b.setText(p);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
            //just checking if im able to update this in github
        });
       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firebaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String u=dataSnapshot.getValue(String.class);
                        a.setText(u);
                        String p=dataSnapshot.getValue(String.class);
                        b.setText(p);

                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });

            }
        });
*/
    }
}
