package br.com.franciscochaves.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RespostaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);
        getSupportActionBar().hide();

        ImageView imgResposta = findViewById(R.id.image_resposta);
        TextView resposta = findViewById(R.id.text_mensagem_resposta);
        Button btnJogarNovamente = findViewById(R.id.button_jogar_novamente);

        Intent intent = getIntent();

        int qtdPontos = intent.getIntExtra("pontos", 0);

        if (intent.hasExtra("acertou")) {
            btnJogarNovamente.setVisibility(View.INVISIBLE);
            boolean acertou = intent.getBooleanExtra("acertou", false);
            if (acertou) {
                imgResposta.setImageResource(R.drawable.acertou);
                resposta.setText("Acertou! Pontos: " + qtdPontos);
            } else {
                imgResposta.setImageResource(R.drawable.errou);
                resposta.setText("Errou! Pontos: " + qtdPontos);
            }

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finish();
                }
            });

            thread.start();
        } else {
            btnJogarNovamente.setVisibility(View.VISIBLE);
            resposta.setText("Fez " + qtdPontos + " pontos!");

            if(qtdPontos >= 3)
                imgResposta.setImageResource(R.drawable.feliz);
            else
                imgResposta.setImageResource(R.drawable.triste);
        }

    }

    public void btnJogarNovamenteOnClick(View v){
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
        finish();
    }
}
