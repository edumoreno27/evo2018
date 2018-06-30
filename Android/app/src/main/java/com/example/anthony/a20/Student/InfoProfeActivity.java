package com.example.anthony.a20.Student;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.anthony.a20.BusinessLogic.CursoGradoRepo;
import com.example.anthony.a20.BusinessLogic.ICursoGradoRepo;
import com.example.anthony.a20.BusinessLogic.IProfeFavoritoRepo;
import com.example.anthony.a20.BusinessLogic.IProfeRepo;
import com.example.anthony.a20.BusinessLogic.ITutoriaRepo;
import com.example.anthony.a20.BusinessLogic.IZonaRepo;
import com.example.anthony.a20.BusinessLogic.ProfeFavoritoRepo;
import com.example.anthony.a20.BusinessLogic.ProfeRepo;
import com.example.anthony.a20.BusinessLogic.TutoriaRepo;
import com.example.anthony.a20.BusinessLogic.ZonaRepo;
import com.example.anthony.a20.Entities.Cursogrado;
import com.example.anthony.a20.Entities.ProfeFavorito;
import com.example.anthony.a20.Entities.Profesor;
import com.example.anthony.a20.Entities.Tutoria;
import com.example.anthony.a20.Entities.Zona;
import com.example.anthony.a20.R;

import java.util.ArrayList;

public class InfoProfeActivity extends AppCompatActivity {

    TextView nombres;
    TextView descripcion;
    TextView experiencia;
    TextView cursos2;
    TextView zonas2;
    ImageView imagen;
    Button boton;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ProfeFavorito auxiliar;
    int idprofeenconsulta=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_profe);
    }
    @Override
    protected void onStart() {
        super.onStart();
        nombres        = findViewById(R.id.item_nombre_apellidos);
        descripcion     = findViewById(R.id.item_profe_descripcion);
        experiencia     = findViewById(R.id.item_profe_exp);
        cursos2= findViewById(R.id.item_profe_cursos);
        zonas2       = findViewById(R.id.item_profe_zonas);
        boton= findViewById(R.id.button_solicitar_tutoria);
    imagen=findViewById((R.id.imagen_favorito));
        new GetTaskDatos().execute();
        new GetTaskCursos().execute();
        new GetTaskZonas().execute();
        //new GetTaksProfesFavoritos().execute();

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), SolicitarTutoriaActivity.class);
                Bundle bundle = getIntent().getExtras();
                int idprofeenconsulta = bundle.getInt("idProfesorInfo");
                bundle.putInt("idProfesorInfo2",idprofeenconsulta);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int contador=0;
                if(contador==0) {
                    Bundle bundle = getIntent().getExtras();
                    int idprofeenconsulta = bundle.getInt("idProfesorInfo");
                    int idpadre = 9;

                    ProfeFavorito aux=new ProfeFavorito();
                    aux.setId_padre(idpadre);
                    aux.setId_profesor(idprofeenconsulta);
                    PostTaskFavorito tareasDeFavorito = new PostTaskFavorito();
                    tareasDeFavorito.execute(aux);
                    imagen.setImageResource(R.drawable.ic_favorite_black_24dp);
                    contador++;

                }
                else {
                    imagen.setImageResource(R.drawable.ic_favorite_border_black_24dp);
                    contador=0;
                }
            }
        });



    }

    public void fillSpinner(Profesor profesor) {
        nombres.setText(String.valueOf(profesor.getNombre()+profesor.getApellido()));
        descripcion.setText(String.valueOf(profesor.getDescripcion()));
        experiencia.setText(String.valueOf(profesor.getExperiencia()));
    }
    public void fillSpinner2(ArrayList<Cursogrado> cursos) {
        String letra="";
        for(Cursogrado c: cursos)
        {
            if(letra.equals("")) {
                letra = letra + c.getNombre();
            }
            else{
                letra=letra + " , " + c.getNombre();
            }
        }
        cursos2.setText(letra);
    }
    public void fillSpinner3(ArrayList<Zona> zonas) {
        String letra="";
        for(Zona c: zonas)
        {
            if(letra.equals("")) {
                letra = letra + c.getZona1();
            }
            else{
                letra=letra + " , " + c.getZona1();
            }
        }
        zonas2.setText(letra);
    }
    class GetTaskDatos extends AsyncTask<String,Profesor,Profesor> {

        @Override
        protected Profesor doInBackground(String... strings) {
            Bundle bundle = getIntent().getExtras();
            int id = bundle.getInt("idProfesorInfo");
            IProfeRepo repo = new ProfeRepo();
            Profesor profe= repo.getProfesor2(id);
             return profe;
        }

        @Override
        protected void onPostExecute(Profesor profesor) {
            super.onPostExecute(profesor);
            fillSpinner(profesor);
        }

    }
    class GetTaskCursos extends AsyncTask<String,ArrayList<Cursogrado>,ArrayList<Cursogrado>> {

        @Override
        protected ArrayList<Cursogrado> doInBackground(String... strings) {
            Bundle bundle = getIntent().getExtras();
            int id = bundle.getInt("idProfesorInfo");
            ICursoGradoRepo repo = new CursoGradoRepo();
            ArrayList<Cursogrado> profe= repo.getCursosDelProfe(id);
            return profe;
        }

        @Override
        protected void onPostExecute(ArrayList<Cursogrado> profesor) {
            super.onPostExecute(profesor);
            fillSpinner2(profesor);
        }

    }
    class GetTaskZonas extends AsyncTask<String,ArrayList<Zona>,ArrayList<Zona>> {

        @Override
        protected ArrayList<Zona> doInBackground(String... strings) {
            Bundle bundle = getIntent().getExtras();
            int id = bundle.getInt("idProfesorInfo");
            IZonaRepo repo = new ZonaRepo();
            ArrayList<Zona> profe= repo.getZonasDelProfe(id);
            return profe;
        }

        @Override
        protected void onPostExecute(ArrayList<Zona> profesor) {
            super.onPostExecute(profesor);
            fillSpinner3(profesor);
        }

    }

    class PostTaskFavorito extends AsyncTask<ProfeFavorito,Void,Void> {
        @Override
        protected Void doInBackground(ProfeFavorito... tutorias) {
            IProfeFavoritoRepo padreAPI = new ProfeFavoritoRepo();
            padreAPI.createProfeFavorito(tutorias[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //Toast.makeText(getContext(),"EXITO",Toast.LENGTH_LONG);
        }
    }
    class GetTaksProfesFavoritos extends AsyncTask<String,ArrayList<ProfeFavorito>,ArrayList<ProfeFavorito>> {
        @Override
        protected ArrayList<ProfeFavorito> doInBackground(String... strings) {
            Bundle bundle = getIntent().getExtras();
            int id = bundle.getInt("idProfesorInfo");
            IProfeFavoritoRepo repo = new ProfeFavoritoRepo();
            ArrayList<ProfeFavorito> profe=new ArrayList<ProfeFavorito>();
            int idpadre = 9;
            if(repo.get(idpadre,id) != null)
                profe= repo.get(idpadre,id);

            return profe;
        }

        @Override
        protected void onPostExecute(ArrayList<ProfeFavorito> profesor) {
            super.onPostExecute(profesor);
            auxiliar=profesor.get(0);

        }


    }
}
