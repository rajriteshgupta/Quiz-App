package com.example.quiz;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText fName,lName,email,age,num,uName,pass,conPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        fName = findViewById(R.id.fname);
        lName = findViewById(R.id.lname);
        email = findViewById(R.id.email);
        age = findViewById(R.id.age);
        num = findViewById(R.id.num);
        uName = findViewById(R.id.uname);
        pass = findViewById(R.id.pass);
        conPass = findViewById(R.id.confirmPass);

        TextView terms = findViewById(R.id.terms);
        TextView signIn = findViewById(R.id.signIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, ContactUs.class);
                startActivity(intent);
            }
        });
    }

    public void SignUp(View view){
        String firstName = fName.getText().toString();
        String lastName = lName.getText().toString();
        String eMail = email.getText().toString();
        String mAge = age.getText().toString();
        String number = num.getText().toString();
        String username = uName.getText().toString();
        String password = pass.getText().toString();
        String confirmPass = conPass.getText().toString();
        String type = "signup";
        String name = firstName+" "+lastName;
        if(confirmPass.equals(password) && firstName !=null && lastName !=null && eMail !=null && number !=null && username !=null && password !=null && confirmPass !=null) {
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, name, eMail, mAge, number, username, password);
        }
        else if(!confirmPass.equals(password)){
            Toast.makeText(SignUpActivity.this,"Password and Confirm Password Are different.",Toast.LENGTH_LONG).show();
        }
    }
}