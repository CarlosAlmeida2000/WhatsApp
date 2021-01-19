package com.example.whatsapp.Fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.whatsapp.Adaptadores.ChatsAdapter;
import com.example.whatsapp.Modelos.Contactos;
import com.example.whatsapp.R;
import com.example.whatsapp.WebServices.Asynchtask;
import com.example.whatsapp.WebServices.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Chats#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Chats extends Fragment implements Asynchtask {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView rcvChat;

    public Chats() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Chats.
     */
    // TODO: Rename and change types and number of parameters
    public static Chats newInstance(String param1, String param2) {
        Chats fragment = new Chats();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_chats, container, false);
        rcvChat = (RecyclerView)rootView.findViewById(R.id.rcvChats);
        rcvChat.setHasFixedSize(true);
        rcvChat.setLayoutManager(new LinearLayoutManager(getContext()));

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://reqres.in/api/users", datos, getContext(), this);
        ws.execute("GET");
        return rootView;
    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Contactos> lstContactos = new ArrayList<Contactos> ();
        try {
            JSONObject JSONlista =  new JSONObject(result);
            JSONArray JSONlistaContactos =  JSONlista.getJSONArray("data");
            lstContactos = Contactos.JsonObjectsBuild(JSONlistaContactos);

            ChatsAdapter adapatorChats = new ChatsAdapter(getContext(), lstContactos);
            rcvChat.setAdapter(adapatorChats);
        }
        catch (JSONException e)
        {
            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_LONG);
        }
    }
}