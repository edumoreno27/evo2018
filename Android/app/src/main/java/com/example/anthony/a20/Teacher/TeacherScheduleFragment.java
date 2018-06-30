package com.example.anthony.a20.Teacher;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.example.anthony.a20.BusinessLogic.IPadreRepo;
import com.example.anthony.a20.BusinessLogic.PadreRepo;
import com.example.anthony.a20.CalendarActivity;
import com.example.anthony.a20.Entities.Event;
import com.example.anthony.a20.Entities.Padre;
import com.example.anthony.a20.Entities.Popup;
import com.example.anthony.a20.R;
import com.framgia.library.calendardayview.CalendarDayView;
import com.framgia.library.calendardayview.EventView;
import com.framgia.library.calendardayview.PopupView;
import com.framgia.library.calendardayview.data.IEvent;
import com.framgia.library.calendardayview.data.IPopup;
import com.framgia.library.calendardayview.decoration.CdvDecorationDefault;
import com.squareup.timessquare.CalendarPickerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TeacherScheduleFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TeacherScheduleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeacherScheduleFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private EditText editText;
    private Calendar myCalendar;
    private ArrayList<IEvent> events;
    private ArrayList<IPopup> popups;
    private CalendarDayView dayView;
    private DatePickerDialog.OnDateSetListener date;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TeacherScheduleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TeacherScheduleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TeacherScheduleFragment newInstance(String param1, String param2) {
        TeacherScheduleFragment fragment = new TeacherScheduleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_teacher_schedule, container, false);
        Button btnCalendar = rootView.findViewById(R.id.btn_openCalendar);
        Button btn = rootView.findViewById(R.id.btn_calendar);
        editText = rootView.findViewById(R.id.date);
        myCalendar = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };
        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(getContext(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                Calendar nextWeek = Calendar.getInstance();
                int i = nextWeek.get(Calendar.WEEK_OF_MONTH);
                nextWeek.set(Calendar.WEEK_OF_MONTH,++i);
                dialog.getDatePicker().setMaxDate(nextWeek.getTimeInMillis());
                dialog.getDatePicker().setMinDate(new Date().getTime());
                dialog.show();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),CalendarActivity.class);
                startActivity(intent);

            }
        });
        dayView = rootView.findViewById(R.id.day_calendar);
        dayView.setLimitTime(8, 18);
        ((CdvDecorationDefault) (dayView.getDecoration())).setOnEventClickListener(new EventView.OnEventClickListener() {
            @Override
            public void onEventClick(EventView view, IEvent data) {

            }
            @Override
            public void onEventViewClick(View view, EventView eventView, IEvent data) {
                dayView.setEvents(events);
            }
        });
        ((CdvDecorationDefault) (dayView.getDecoration())).setOnPopupClickListener(new PopupView.OnEventPopupClickListener() {
            @Override
            public void onPopupClick(PopupView view, IPopup data) {

            }

            @Override
            public void onQuoteClick(PopupView view, IPopup data) {

            }

            @Override
            public void onLoadData(PopupView view, ImageView start, ImageView end, IPopup data) {
                start.setImageResource(R.drawable.profile);
            }
        });
        events = new ArrayList<>();
        setEvents();
        popups= new ArrayList<>();
        setPopups();
        dayView.setEvents(events);
        dayView.setPopups(popups);
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editText.setText(sdf.format(myCalendar.getTime()));
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void setEvents(){
        //EVENT
        int eventColor = ContextCompat.getColor(getContext(), R.color.blue);
        Calendar timeStart = Calendar.getInstance();
        timeStart.set(Calendar.HOUR_OF_DAY, 11);
        timeStart.set(Calendar.MINUTE, 0);
        Calendar timeEnd = (Calendar) timeStart.clone();
        timeEnd.set(Calendar.HOUR_OF_DAY, 15);
        timeEnd.set(Calendar.MINUTE, 30);
        Event event = new Event(1, timeStart, timeEnd, "Event", "Hockaido", eventColor);

        events.add(event);
        //POPUP

    }
    private void setPopups(){
        Calendar timeStart = Calendar.getInstance();
        timeStart.set(Calendar.HOUR_OF_DAY, 12);
        timeStart.set(Calendar.MINUTE, 0);
        Calendar timeEnd = (Calendar) timeStart.clone();
        timeEnd.set(Calendar.HOUR_OF_DAY, 13);
        timeEnd.set(Calendar.MINUTE, 30);

        Popup popup = new Popup();
        popup.setStartTime(timeStart);
        popup.setEndTime(timeEnd);
        popup.setImageStart("http://sample.com/image.png");
        popup.setTitle("event 1 with title");
        popup.setDescription("Yuong alsdf");
        popups.add(popup);
    }

}
