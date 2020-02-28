package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PostQuestionActivity extends AppCompatActivity {

    Button mPost;
    EditText mQuestion,mOpt1,mOpt2,mOpt3,mOpt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_question);
        mPost = findViewById(R.id.post);
        mQuestion = findViewById(R.id.question);
        mOpt1 = findViewById(R.id.option1);
        mOpt2 = findViewById(R.id.option2);
        mOpt3 = findViewById(R.id.option3);
        mOpt4 = findViewById(R.id.option4);
    }

    public void PostQuestion(View view){
        String question = mQuestion.getText().toString();
        String option1 = mOpt1.getText().toString();
        String option2 = mOpt1.getText().toString();
        String option3 = mOpt1.getText().toString();
        String option4 = mOpt1.getText().toString();
        String type = "post_question";
        if(question!=null && option1!=null && option2!=null && option3!=null && option4!=null) {
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, question, option1, option2, option3, option4);
        }
        else{
            Toast.makeText(PostQuestionActivity.this,"Some Fields are Empty!!!",Toast.LENGTH_LONG).show();
        }
    }
}
