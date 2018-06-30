package com.example.anthony.a20.Student;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anthony.a20.Adapters.MyProfesorRecyclerViewAdapter;
import com.example.anthony.a20.BusinessLogic.IProfeRepo;
import com.example.anthony.a20.BusinessLogic.ProfeRepo;
import com.example.anthony.a20.Entities.Profesor;
import com.example.anthony.a20.R;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ProfesorHomeFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    ArrayList<Profesor> teachers = new ArrayList<Profesor>();
    ProfesorsTask task=new ProfesorsTask();
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ProfesorHomeFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ProfesorHomeFragment newInstance(int columnCount) {
        ProfesorHomeFragment fragment = new ProfesorHomeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profesor_list, container, false);
        task.execute(view);
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
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Profesor item);
    }

    class ProfesorsTask extends AsyncTask<View,View,View> {

        @Override
        protected View doInBackground(View... strings) {

            IProfeRepo repo = new ProfeRepo();
            ArrayList<Profesor> profesorArrayList = new ArrayList<Profesor>();
            profesorArrayList.addAll(repo.getProfesors());
            for (int i=0;i<profesorArrayList.size();i++)
            {
               Profesor iterator= profesorArrayList.get(i);

            }
            Profesor aux=repo.getProfesor2(27);
            Profesor aux2=repo.getProfesor2(28);
            //teachers.add(aux);
            //teachers.add(aux2);
            teachers=profesorArrayList;
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
                recyclerView.setAdapter(new MyProfesorRecyclerViewAdapter(teachers, mListener));
            }

        }
    }
}

