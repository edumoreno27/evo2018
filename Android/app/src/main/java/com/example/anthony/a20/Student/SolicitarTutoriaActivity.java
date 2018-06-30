package com.example.anthony.a20.Student;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.anthony.a20.Adapters.CursoSpinnerAdapter;
import com.example.anthony.a20.Adapters.HorarioSpinnerAdapter;
import com.example.anthony.a20.BusinessLogic.CursoGradoRepo;
import com.example.anthony.a20.BusinessLogic.HorarioRepo;
import com.example.anthony.a20.BusinessLogic.ICursoGradoRepo;
import com.example.anthony.a20.BusinessLogic.IHorarioRepo;
import com.example.anthony.a20.BusinessLogic.IPadreRepo;
import com.example.anthony.a20.BusinessLogic.IProfeHorarioRepo;
import com.example.anthony.a20.BusinessLogic.IProfeRepo;
import com.example.anthony.a20.BusinessLogic.ITutoriaRepo;
import com.example.anthony.a20.BusinessLogic.PadreRepo;
import com.example.anthony.a20.BusinessLogic.ProfeHorarioRepo;
import com.example.anthony.a20.BusinessLogic.TutoriaRepo;
import com.example.anthony.a20.Entities.Cursogrado;
import com.example.anthony.a20.Entities.Horario;
import com.example.anthony.a20.Entities.Padre;
import com.example.anthony.a20.Entities.ProfeHorario;
import com.example.anthony.a20.Entities.Tutoria;
import com.example.anthony.a20.R;
import com.example.anthony.a20.RegisterActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SolicitarTutoriaActivity extends AppCompatActivity {
    int idprofe=0;
    int idhorario;
    public Tutoria tuto;
    ArrayList<ProfeHorario> listita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_tutoria);
   }

    @Override
    protected void onStart() {
        super.onStart();
        GetTaskLLenarCursos task2=new GetTaskLLenarCursos();
        task2.execute();
        GetTaskLlenarHorario task3=new GetTaskLlenarHorario();
        task3.execute();

        Button btnSave = findViewById(R.id.button_solcitar_tutoria);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner spinnerhorario =findViewById(R.id.spinner_horario_tutoria);
                Horario horario=(Horario)spinnerhorario.getSelectedItem();
                Spinner spinnercurso =findViewById(R.id.spinner_cursos_tutoria);
                Cursogrado cursito=(Cursogrado)spinnercurso.getSelectedItem();
                idhorario=horario.getIdhorario();

                GetTaskPreparandoParaElPost task4=new GetTaskPreparandoParaElPost();
                task4.execute();


            }
        });
    }

    void fillSpinnerCurso(ArrayList<Cursogrado> curso)
    {
        Spinner spinner = findViewById(R.id.spinner_cursos_tutoria);
        CursoSpinnerAdapter adapter = new CursoSpinnerAdapter(this,android.R.layout.simple_spinner_item,curso);
        spinner.setAdapter(adapter);
    }
    void fillSpinnerHorario(ArrayList<Horario> horario)
    {
        Spinner spinner = findViewById(R.id.spinner_horario_tutoria);
        HorarioSpinnerAdapter adapter = new HorarioSpinnerAdapter(this,android.R.layout.simple_spinner_item,horario);
        spinner.setAdapter(adapter);
    }



    class GetTaskLLenarCursos extends AsyncTask<String,ArrayList<Cursogrado>,ArrayList<Cursogrado>> {

        @Override
        protected ArrayList<Cursogrado> doInBackground(String... strings) {
            Bundle bundle = getIntent().getExtras();
            int idprofe = bundle.getInt("idProfesorInfo2");
            ICursoGradoRepo repo = new CursoGradoRepo();
            ArrayList<Cursogrado> items = repo.getCursosDelProfe(idprofe);

            return items;
        }

        @Override
        protected void onPostExecute(ArrayList<Cursogrado> cursogrados) {
            super.onPostExecute(cursogrados);
            fillSpinnerCurso(cursogrados);
        }
    }
    class GetTaskLlenarHorario extends AsyncTask<String,ArrayList<Horario>,ArrayList<Horario>> {

        @Override
        protected ArrayList<Horario> doInBackground(String... strings) {
            Bundle bundle = getIntent().getExtras();
            int idprofe = bundle.getInt("idProfesorInfo2");
            IHorarioRepo repo = new HorarioRepo();
            ArrayList<Horario> items = repo.getHorariosDelProfe2(idprofe,"Disponible");

            return items;
        }

        @Override
        protected void onPostExecute(ArrayList<Horario> cursogrados) {
            super.onPostExecute(cursogrados);
            fillSpinnerHorario(cursogrados);
        }
    }
    class GetTaskPreparandoParaElPost extends AsyncTask<String,ArrayList<ProfeHorario>,ArrayList<ProfeHorario>> {

        @Override
        protected ArrayList<ProfeHorario> doInBackground(String... strings) {
            Bundle bundle = getIntent().getExtras();
            int idprofe = bundle.getInt("idProfesorInfo2");
            IProfeHorarioRepo repo = new ProfeHorarioRepo();
            ArrayList<ProfeHorario> items = repo.get(idprofe,idhorario);
            listita=items;
            return items;
        }

        @Override
        protected void onPostExecute(ArrayList<ProfeHorario> cursogrados) {
            super.onPostExecute(cursogrados);

            Spinner spinnerhorario =findViewById(R.id.spinner_horario_tutoria);
            Horario horario=(Horario)spinnerhorario.getSelectedItem();
            Spinner spinnercurso =findViewById(R.id.spinner_cursos_tutoria);
            Cursogrado cursito=(Cursogrado)spinnercurso.getSelectedItem();


            Date fecha=null;
            Date hora=null;
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-mm-dd");
            String prueba2="2018-07-02";
            try {
                fecha =  sd.parse(prueba2);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            SimpleDateFormat sf = new SimpleDateFormat("HH:mm:ss");
            String prueba=horario.getHorainicio();
            try {
                hora=sf.parse(prueba);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Double precio= 20.0;
            String comentario="";
            int calificacion=0;
            Bundle bundle = getIntent().getExtras();
            int userid = 9;

            String estado="En espera";
            String curso=cursito.getNombre();

            int id_horarioprofe=listita.get(0).getId();
            EditText numerohoras =findViewById(R.id.item_numero_horas_tutoria);

            int numerodehoras=Integer.valueOf(numerohoras.getText().toString());
            Tutoria tuto=new Tutoria();
            tuto.setCalificacion(calificacion);
            tuto.setComentario(comentario);
            tuto.setCurso(curso);
            tuto.setEstado(estado);
            tuto.setFecha(fecha);
            tuto.setHora(hora);
            tuto.setId_horario(id_horarioprofe);
            tuto.setId_padre(userid);
            tuto.setId_servicio(1);
            tuto.setNumerohoras(numerodehoras);
            tuto.setPrecio(precio);

            PostTask postear=new PostTask();
            postear.execute(tuto);

          //  Intent intent= new Intent(getApplicationContext(),StudentActivity.class);
          //  startActivity(intent);

        }


    }
    class PostTask extends AsyncTask<Tutoria,Void,Void> {
        @Override
        protected Void doInBackground(Tutoria... tutorias) {
            ITutoriaRepo padreAPI = new TutoriaRepo();
            padreAPI.createTutoria(tutorias[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //Toast.makeText(getContext(),"EXITO",Toast.LENGTH_LONG);
        }
    }
}
