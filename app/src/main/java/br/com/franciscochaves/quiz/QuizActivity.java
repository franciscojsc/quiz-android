package br.com.franciscochaves.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private TextView pergunta;
    private RadioButton rbResposta1;
    private RadioButton rbResposta2;
    private RadioButton rbResposta3;
    private RadioButton rbResposta4;

    private int respostaCerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        pergunta = findViewById(R.id.text_quiz_pergunta);
        rbResposta1 = findViewById(R.id.radio_resposta1);
        rbResposta2 = findViewById(R.id.radio_resposta2);
        rbResposta3 = findViewById(R.id.radio_resposta3);
        rbResposta4 = findViewById(R.id.radio_resposta4);

        respostaCerta = R.id.radio_resposta1;
    }

    public void btnResponderOnclick(View view ) {
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radio_grup_pergunta);
        Intent intent = new Intent(this, RespostaActivity.class);
        intent.putExtra("acertou", radioGroup.getCheckedRadioButtonId() == respostaCerta);
        startActivity(intent);
    }

    @Override
    protected void onRestart(){
        super.onRestart();

        pergunta.setText("Qual é o melhor site?");
        rbResposta1.setText("www.g1.com");
        rbResposta2.setText("franciscochaves.com.br");
        rbResposta3.setText("www.facebook.com");
        rbResposta4.setText("www.twitter.com");

        respostaCerta = R.id.radio_resposta2;
    }
}
