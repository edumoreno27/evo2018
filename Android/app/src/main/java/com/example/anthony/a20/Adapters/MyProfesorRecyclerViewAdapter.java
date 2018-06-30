package com.example.anthony.a20.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.anthony.a20.Entities.Profesor;
import com.example.anthony.a20.Entities.Tutoria;
import com.example.anthony.a20.R;
import com.example.anthony.a20.Student.InfoProfeActivity;

import com.example.anthony.a20.Student.ProfesorHomeFragment.OnListFragmentInteractionListener;
import com.example.anthony.a20.Student.SolicitarTutoriaActivity;
import com.example.anthony.a20.Student.StudentActivity;


import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Profesor} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyProfesorRecyclerViewAdapter extends RecyclerView.Adapter<MyProfesorRecyclerViewAdapter.ViewHolder> {

    private final List<Profesor> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyProfesorRecyclerViewAdapter(ArrayList<Profesor> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_profesor, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getNombre());
        holder.mContentView.setRating(mValues.get(position).getCalificacion());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {

                    Intent intent = new Intent(v.getContext(), InfoProfeActivity.class);
                    Bundle bundle = new Bundle();

                    int id = mValues.get(position).getIdprofesor();
                    bundle.putInt("idProfesorInfo",id);
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final RatingBar mContentView;

        public Profesor mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mContentView = (RatingBar) view.findViewById(R.id.rating_bar);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mIdView.getText() + "'";
        }
    }
}
