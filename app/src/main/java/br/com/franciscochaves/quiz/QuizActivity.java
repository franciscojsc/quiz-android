package br.com.franciscochaves.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView pergunta;
    private RadioGroup radioGroup;
    private RadioButton rbResposta1;
    private RadioButton rbResposta2;
    private RadioButton rbResposta3;
    private RadioButton rbResposta4;

    private int respostaCerta;
    private int pontos = 0;

    List<Questao> questoes = new ArrayList<Questao>(){
        {
            add(new Questao("Quem descobriu o Brasil?", R.id.radio_resposta1, "Pedro Álvares Cabral", "Cristóvão Colombo", "Donald Trump", "Francisco Chaves"));
            add(new Questao("Qual o melhor site ?", R.id.radio_resposta2, "www.g1.com", "franciscochaves.com.br", "www.facebook.com", "www.twitter.com"));
            add(new Questao("Qual o melhor político do Brasil?", R.id.radio_resposta3, "Tiririca", "Eneas Carneiro", "Nenhum presta", "Todos são bons"));
            add(new Questao("Qual a melhor plataforma mobile?", R.id.radio_resposta4, "Symbian", "BlackBerry", "iOS", "Android <<<"));
        }
    };

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

        carregarQuestao();
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

        carregarQuestao();
    }

    private void carregarQuestao(){
        if(questoes.size() > 0){
            Questao q = questoes.remove(0);
            pergunta.setText(q.getPergunta());
            List<String> resposta = q.getRespostas();
            rbResposta1.setText(resposta.get(0));
            rbResposta2.setText(resposta.get(1));
            rbResposta3.setText(resposta.get(2));
            rbResposta4.setText(resposta.get(3));
            respostaCerta = q.getRespostaCerta();
        }else {
            Intent intent = new Intent(this, RespostaActivity.class);
            intent.putExtra("pontos", pontos);
            startActivity(intent);
            finish();
        }

    }
}
