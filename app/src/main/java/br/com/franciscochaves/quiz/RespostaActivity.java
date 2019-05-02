package br.com.franciscochaves.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        Intent intent = getIntent();
        boolean acertou = intent.getBooleanExtra("acertou", false);
        if(acertou){
            imgResposta.setImageResource(R.drawable.acertou);
            resposta.setText("Acertou!");
        }else{
            imgResposta.setImageResource(R.drawable.errou);
            resposta.setText("Errou!");
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finish();
            }
        });

        thread.start();
    }
}
