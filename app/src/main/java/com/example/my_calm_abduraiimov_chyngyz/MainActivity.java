package com.example.my_calm_abduraiimov_chyngyz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn_g;
    TextView tv_otvet, tv_main_answer;
    int getOtvetInt, genOtvetInt, otvetInt;
    LottieAnimationView lotty_sun, lotty_one, lotty_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_g = findViewById(R.id.btn_generate);
        tv_otvet = findViewById(R.id.tv_otvet);
        tv_main_answer = findViewById(R.id.tv_main_answer);
        lotty_sun = findViewById(R.id.lotty_sun);
        lotty_one = findViewById(R.id.lotty_one);
        lotty_two = findViewById(R.id.lotty_two);

        lotty_sun.setAnimation(R.raw.sunshine);
        lotty_one.setAnimation(R.raw.animation_fire);
        lotty_two.setAnimation(R.raw.fun_time);

        btn_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                genOtvetInt = random.nextInt(100);
                otvetInt = genOtvetInt;
                if ((otvetInt !=0)&& (otvetInt > 0)){
                    tv_otvet.setText(String.valueOf(otvetInt)+"%");
                    printAnswer();
                    btn_g.setVisibility(View.INVISIBLE);
                }else{
                    Toast.makeText(MainActivity.this,"Нажми еще раз Generate", Toast.LENGTH_LONG).show();
                    btn_g.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void printAnswer(){
        if(otvetInt>= 1 && otvetInt <50){
            tv_main_answer.setText("Бывало и лучше");
            lotty_two.setVisibility(View.VISIBLE);
        }else{
            if(otvetInt > 50 && otvetInt <=70){
                tv_main_answer.setText("Нормально, нормально");
                lotty_two.setVisibility(View.VISIBLE);
            }else{
                if(otvetInt > 70 && otvetInt <=100){
                    tv_main_answer.setText("Супер класс");
                    lotty_one.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}
