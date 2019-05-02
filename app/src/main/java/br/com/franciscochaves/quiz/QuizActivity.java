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
    private RadioGroup radioGroup;
    private RadioButton rbResposta1;
    private RadioButton rbResposta2;
    private RadioButton rbResposta3;
    private RadioButton rbResposta4;

    private int respostaCerta;
    private int pontos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        pergunta = findViewById(R.id.text_quiz_pergunta);
        rbResposta1 = findViewById(R.id.radio_resposta1);
        rbResposta2 = findViewById(R.id.radio_resposta2);
        rbResposta3 = findViewById(R.id.radio_resposta3);
        rbResposta4 = findViewById(R.id.radio_resposta4);
        radioGroup = findViewById(R.id.radio_grup_pergunta);

        respostaCerta = R.id.radio_resposta1;
    }

    public void btnResponderOnclick(View view ) {
        RadioButton r = findViewById(radioGroup.getCheckedRadioButtonId());
        Intent intent = new Intent(this, RespostaActivity.class);
        if(radioGroup.getCheckedRadioButtonId() == respostaCerta){
            intent.putExtra("acertou", true);
            pontos++;
        }else{
            intent.putExtra("acertou", false);
        }

        intent.putExtra("pontos", pontos);

        startActivity(intent);
        r.setChecked(false);
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
