package com.example.demo;

import static com.example.demo.R.*;

import static java.lang.String.*;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GuessNumbergame extends AppCompatActivity {

    EditText edittext;
    TextView textview;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edittext = findViewById(R.id.editText);
        textview = findViewById(R.id.textView3);
        button = findViewById(R.id.button);
        int originalno = (int) (Math.random() * 100 + 1);

        button.setOnClickListener(v -> {

            String input = edittext.getText().toString();
            int guessno = Integer.parseInt(input);
            if (guessno > originalno) {

                textview.setText(string.guess_too_high);


            } else if (guessno < originalno) {


                textview.setText(string.you_guessed_low);


            } else {
                textview.setText(format(getString(string.you_guessed_right_d), originalno));
            }


        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}