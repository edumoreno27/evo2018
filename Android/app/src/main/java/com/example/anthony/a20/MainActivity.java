package com.example.anthony.a20;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anthony.a20.Adapters.MyProfesorRecyclerViewAdapter;
import com.example.anthony.a20.BusinessLogic.IPadreRepo;
import com.example.anthony.a20.BusinessLogic.IProfeRepo;
import com.example.anthony.a20.BusinessLogic.PadreRepo;
import com.example.anthony.a20.BusinessLogic.ProfeRepo;
import com.example.anthony.a20.Entities.Padre;
import com.example.anthony.a20.Entities.Profesor;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.gson.Gson;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    public Padre padreLoguin=new Padre();
    public String email2="";
    UsuarioTask tarea=new UsuarioTask();
    SharedPreferences mPrefs ;
    @Override
    protected void onStart() {
        super.onStart();
        Context context = getApplicationContext();
        mPrefs = context.getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        //Si esta iniciada la sesion
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Variables
        mAuth = FirebaseAuth.getInstance();
        Button btnLogIn = findViewById(R.id.btn_login);
        TextView txtRegister = findViewById(R.id.txt_register);
        TextView txtForgotPassword = findViewById(R.id.txt_forgotpassword);
        //Funciones click
        txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextEmail = findViewById(R.id.email);
                EditText editTextContra = findViewById(R.id.password);
                email2=editTextEmail.getText().toString();
                if (validation(editTextContra.getText().toString(),editTextEmail.getText().toString()))
                Login(editTextEmail.getText().toString(),editTextContra.getText().toString());
                else
                {
                    AlertDialog.Builder alert= new AlertDialog.Builder(MainActivity.this);
                    alert.setMessage("Campos vacios. Ingrese correo y/o contrasena");
                    alert.setTitle("Alerta");
                    AlertDialog dialog =alert.create();
                    dialog.show();
                }
            }
        });
    }

    private boolean validation(String a, String b)
    {
        if (a.isEmpty()||b.isEmpty())
        {
            return false;
        }
        return true;
    }


    private void Login(final String email, String password) {
        Log.d("login", "signIn:" + email);
        //if (!validateForm()) {
        //    return;
        //}
        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            //Guardar objeto
                            tarea.execute();

                            Log.d("d", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("d", "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();


                        }
                    }
                });
        // [END sign_in_with_email]
    }
    class UsuarioTask extends AsyncTask<String,Padre,Padre> {
        @Override
        protected Padre doInBackground(String... strings) {
            IPadreRepo repo=new PadreRepo();
            padreLoguin=repo.getPadre(email2);

            return padreLoguin;
        }

        @Override
        protected void onPostExecute(Padre padre) {
            super.onPostExecute(padre);


            Intent intent = new Intent(getApplicationContext(), ChooseProfileActivity.class);
            Bundle bundle = new Bundle();
            int id = padreLoguin.getIdpadre();
            bundle.putInt("idUserLoguin",id);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
