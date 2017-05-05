package br.edu.poli.aplicationtest;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String LOGIN_DEFAULT = "teste@gmail.com";
    private static final String PASS_DEFAULT = "123456";

    private static final String INVALID_LOGIN_MESSAGE = "Por favor informe um email válido !";
    private static final String INVALID_PASSWORD_MESSAGE = "Por favor informe uma senha válida !";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button enter = (Button) findViewById(R.id.enter);
        enter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        EditText login = (EditText) findViewById(R.id.login);
        EditText password = (EditText) findViewById(R.id.password);

        if (login.getText().toString().equalsIgnoreCase(LOGIN_DEFAULT)){

            if (password.getText().toString().equalsIgnoreCase(PASS_DEFAULT)){
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
            }else{

                showAlertDialog(INVALID_PASSWORD_MESSAGE);
            }
        }else{

            showAlertDialog(INVALID_LOGIN_MESSAGE);
        }

    }

    private void showAlertDialog(String message){
        new AlertDialog.Builder(this)
                .setTitle("Login Inválido")
                .setMessage(message)
                .setNeutralButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
