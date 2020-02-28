package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {

    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.addIcon){
            startActivity(new Intent(HomeActivity.this,PostQuestionActivity.class));
        }
        else if(item.getItemId() == R.id.update){
            //startActivity(new Intent(HomeActivity.this,UpdateActivity.class));
        }
        else if(item.getItemId() == R.id.signOut){
            //startSignOut();
        }
        else if(item.getItemId() == R.id.exitApp){
            ExitApp();
        }
        return super.onOptionsItemSelected(item);
    }

    public void ExitApp(){
        builder.setMessage("Are You Sure?").setTitle("Exit");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(HomeActivity.this,LogInActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                intent.putExtra("EXIT", true);
                startActivity(intent);
//                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
        //AlertDialog dialog = builder.create();
        builder.show();
    }
}
