package com.example.anthony.a20.Student;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anthony.a20.Adapters.MyTutoriaRecyclerViewAdapter;
import com.example.anthony.a20.Adapters.MyTutoriaRecyclerViewAdapter;
import com.example.anthony.a20.BusinessLogic.IProfeRepo;
import com.example.anthony.a20.BusinessLogic.ITutoriaRepo;
import com.example.anthony.a20.BusinessLogic.ProfeRepo;
import com.example.anthony.a20.BusinessLogic.TutoriaRepo;
import com.example.anthony.a20.Entities.Padre;
import com.example.anthony.a20.Entities.Profesor;
import com.example.anthony.a20.Entities.Tutoria;
import com.example.anthony.a20.MainActivity;
import com.example.anthony.a20.R;
import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class MyTutoriaFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    ArrayList<Tutoria> tutorias=new ArrayList<Tutoria>();

     SharedPreferences mPrefs ;
    TutoriasTask tareas=new TutoriasTask();
    int userLoguin=0;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MyTutoriaFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();
    // mPrefs= this.getActivity().getApplicationContext().getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MyTutoriaFragment newInstance(int columnCount) {
        MyTutoriaFragment fragment = new MyTutoriaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

      //  Gson gson = new Gson();
      //  String json = mPrefs.getString("UserLoguin", "");
      //  Padre obj = gson.fromJson(json, Padre.class);
      // userLoguin=obj.getIdpadre();

          //int idName = mPrefs.getInt("userId", 0); //0 is the default value.

        userLoguin=9;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tutoria_list, container, false);
        tareas.execute(view);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener  {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Tutoria item);

    }
    class TutoriasTask extends AsyncTask<View,View,View> {

        @Override
        protected View doInBackground(View... strings) {

            ITutoriaRepo repo = new TutoriaRepo();
            tutorias=repo.getTutoriasDelPadre(9);

            return strings[0];
        }

        @Override
        protected void onPostExecute(View view) {
            super.onPostExecute(view);
            Context context = view.getContext();
            if (view instanceof RecyclerView) {

                RecyclerView recyclerView = (RecyclerView) view;
                if (mColumnCount <= 1) {
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                } else {
                    recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
                }
                recyclerView.setAdapter(new MyTutoriaRecyclerViewAdapter(tutorias, mListener));
            }

        }
    }
}
