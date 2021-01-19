package com.example.whatsapp.Adaptadores;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.whatsapp.Fragmentos.Chats;
import com.example.whatsapp.Fragmentos.Estados;
import com.example.whatsapp.Fragmentos.Llamadas;
import com.example.whatsapp.Modelos.Contactos;
import com.example.whatsapp.WebServices.Asynchtask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PagerController extends FragmentPagerAdapter{
    int numoftabs;

    public PagerController(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numoftabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Chats();
            case 1:
                return new Estados();
            case 2:
                return new Llamadas();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numoftabs;
    }

}
