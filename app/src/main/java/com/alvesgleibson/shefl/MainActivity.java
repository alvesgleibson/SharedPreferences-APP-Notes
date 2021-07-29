package com.alvesgleibson.shefl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

        private FloatingActionButton fab;
        private EditText editText;
        private SharedClass sharedClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fabSalvar);
        editText = findViewById(R.id.txtEditavel);

        sharedClass = new SharedClass(getApplicationContext());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();

                if(s.equals("")){
                    Snackbar.make(v, "Anotação vazia, digite algo para salvar", Snackbar.LENGTH_LONG).show();
                }
                else{
                    sharedClass.SaveSP(s);
                    Snackbar.make(v, "Salvo com sucesso!!!", Snackbar.LENGTH_LONG).show();

                }

            }
        });

        String s = sharedClass.recoverSP();

        if(!s.equals("")){
            editText.setText(s);
        }

    }
}