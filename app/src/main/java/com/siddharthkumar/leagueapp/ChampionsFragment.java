package com.siddharthkumar.leagueapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ChampionsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ChampionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChampionsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private ArrayList<Champion> champions2 = new ArrayList<Champion>();

    // TODO: Rename and change types of parameters
   // private ArrayList<Champion>

    public class ChampionsListAdapter extends ArrayAdapter<Champion>{

        public ChampionsListAdapter(@NonNull Context context,   ArrayList<Champion> champs ) {
            super(context, 0, champs);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            Champion champion=getItem(position);

            if(convertView==null){

                convertView=LayoutInflater.from(getContext()).inflate(R.layout.champions_list_item,parent,false);
            }
            TextView name=(TextView) convertView.findViewById(R.id.champName);
            ImageView image=(ImageView) convertView.findViewById(R.id.champImage);

            name.setText(champion.name);

            Image image2 = champion.image;
            ByteBuffer buffer = image2.getPlanes()[0].getBuffer();
            byte[] bytes = new byte[buffer.capacity()];
            buffer.get(bytes);
            Bitmap bitmapImage = BitmapFactory.decodeByteArray(bytes, 0, bytes.length, null);

            image.setImageBitmap(bitmapImage);


            return super.getView(position, convertView, parent);
        }
    }

    public void setArray(ArrayList<Champion> e){
        champions2=e;
    }

    private OnFragmentInteractionListener mListener;

    public ChampionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChampionsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChampionsFragment newInstance(ArrayList<Champion> champions) {
        ChampionsFragment fragment = new ChampionsFragment();
        fragment.setArray(champions);


        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this


        ChampionsListAdapter cla = new ChampionsListAdapter(getContext(),champions2);

        ListView list = (ListView) container.findViewById(R.id.championsView);

        list.setAdapter(cla);

        return inflater.inflate(R.layout.fragment_champions, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            mListener=new OnFragmentInteractionListener() {
                @Override
                public void onFragmentInteraction(Uri uri) {

                }
            };
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
}
