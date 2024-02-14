package com.luvizotto.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view) {
        verificarGanhador("Pedra");
    }

    public void selecionarPapel(View view) {
        verificarGanhador("Papel");
    }

    public void selecionarTesoura(View view) {
        verificarGanhador("Tesoura");
    }

    private String gerarEscolhaAleatoriaApp() {
        String[] opçoes = {"Pedra", "Papel", "Tesoura"};
        int numeroAleatorio = new Random().nextInt(3);
        ImageView imagemApp = findViewById(R.id.image_app);

        String escolhaApp = opçoes[numeroAleatorio];
        switch (escolhaApp) {
            case "Pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;

            case "Tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;

            case "Papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;

        }


        return escolhaApp;
    }

    private void verificarGanhador(String escolhadoUsuario) {
        //System.out.println("item clicado " + escolhadoUsuario);
        String escolhaAPP = gerarEscolhaAleatoriaApp();
        TextView textoResultado = findViewById(R.id.text_resultado);
        if (
            (escolhaAPP == "Pedra" && escolhadoUsuario == "Tesoura") ||
            (escolhaAPP == "Papel" && escolhadoUsuario == "Pedra") ||
            (escolhaAPP == "Tesoura" && escolhadoUsuario == "Papel")
        ) {//app ganhador
            textoResultado.setText("Você perdeu! X_X");
        } else if (
                (escolhadoUsuario == "Pedra" && escolhaAPP == "Tesoura") ||
                (escolhadoUsuario == "Papel" && escolhaAPP == "Pedra") ||
                (escolhadoUsuario == "Tesoura" && escolhaAPP == "Papel")
        ) {//usuario ganhador
            textoResultado.setText("Você ganhou! ╰(*°▽°*)╯");
        } else {//empate
            textoResultado.setText("Empatamos! ^_~");
        }
    }
}