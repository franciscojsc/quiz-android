package br.com.franciscochaves.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    public void btnResponderOnclick(View view ) {
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radio_grup_pergunta);
        Intent intent = new Intent(this, RespostaActivity.class);
        intent.putExtra("acertou", radioGroup.getCheckedRadioButtonId() == R.id.radio_resposta1);
        startActivity(intent);
    }
}
