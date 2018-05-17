package com.example.nitin.logicaltest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    int i1,i2,i3,c,i;
    String db;
    Button b;
     RadioGroup g1,g2,g3;
     RadioButton r1,r2,r3;
     private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        g1=(RadioGroup)findViewById(R.id.one);
        g2=(RadioGroup)findViewById(R.id.two);
        g3=(RadioGroup)findViewById(R.id.three);
        b=(Button)findViewById(R.id.next);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final ProgressDialog progressDialog= new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Loading...");
                progressDialog.setTitle("ProgressDialog");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();

                final StringBuilder ndb=new StringBuilder(3);
                i=0;
                db=" ";
                mDatabase= FirebaseDatabase.getInstance().getReference();
                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        StringBuilder ns=null;
                        ns=clicked(view);
                        for(DataSnapshot postSnapshot:dataSnapshot.getChildren()){
                            db=postSnapshot.getValue(String.class);
                            ndb.append(db);
                            i++;
                            if(i==3){
                                progressDialog.dismiss();
                                checking(ndb,ns);
                        }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }
        });
    }
    public StringBuilder clicked(View v) {
        StringBuilder s=new StringBuilder(3);
        i1 = g1.getCheckedRadioButtonId();
        i2 = g2.getCheckedRadioButtonId();
        i3 = g3.getCheckedRadioButtonId();
        if (i1 != -1 && i2 != -1 && i3 != -1) {
            r1 = (RadioButton) findViewById(i1);
            r2 = (RadioButton) findViewById(i2);
            r3 = (RadioButton) findViewById(i3);

            s.append(r1.getText().toString());
            s.append(r2.getText().toString());
            s.append(r3.getText().toString());

        }return s;
    }
    public void checking(StringBuilder a, StringBuilder b){
        if(a.toString().equals(b.toString())){
            Intent i1 =new Intent(MainActivity.this,CorrectAnswers.class);
            startActivity(i1);
        }
        else{
//            Toast.makeText(MainActivity.this,b,Toast.LENGTH_SHORT).show();
//            Toast.makeText(MainActivity.this,a,Toast.LENGTH_SHORT).show();
            Intent i2 =new Intent(MainActivity.this,FirstChance.class);
            startActivity(i2);
        }
    }

}
