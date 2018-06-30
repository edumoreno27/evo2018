package com.example.anthony.a20;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.ProviderQueryResult;

public class ForgotPasswordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Button btn_Send = findViewById(R.id.continuar);
        btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtForgotEmail = findViewById(R.id.txt_forgotemail);
                String email = edtForgotEmail.getText().toString();
                if (email.isEmpty())
                {
                    edtForgotEmail.setError("Required");
                }
                else emailIsRegistered(email);
            }
        });
    }

    public void emailIsRegistered(final String email) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.fetchProvidersForEmail(email).addOnCompleteListener(new OnCompleteListener<ProviderQueryResult>() {
            @Override
            public void onComplete(@NonNull Task<ProviderQueryResult> task) {
                if (task.getResult().getProviders().size() > 0) {
                    //Usuario registrado
                    sendPassword(email);
                }
                else{
                    AlertDialog.Builder alert= new AlertDialog.Builder(ForgotPasswordActivity.this);
                    alert.setMessage("Correo no encontrado");
                    alert.setTitle("Alerta");
                    AlertDialog dialog =alert.create();
                    dialog.show();
                }
            }
        });

    }

    private void sendPassword(final String email){
        FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            //Dialogo
                            AlertDialog.Builder alert= new AlertDialog.Builder(ForgotPasswordActivity.this);
                            alert.setMessage("Contraseña enviada al correo "+email );
                            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent a = new Intent(getApplicationContext(),MainActivity.class);
                                    startActivity(a);
                                }
                            });
                            alert.setTitle("Alerta");
                            AlertDialog dialog =alert.create();
                            dialog.show();
                        }
                    }
                });

    }
}
