package com.example.whatsapp.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.util.ArrayList;

public class Contactos
{
    String nombre;
    String urlPerfil;
    String textInferior;
    String textHora;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlPerfil() { return urlPerfil; }

    public void setUrlPerfil(String urlPerfil) { this.urlPerfil = urlPerfil; }

    public String getTextInferior() { return textInferior; }

    public void setTextInferior(String textInferior) { this.textInferior = textInferior; }

    public String getTextHora() { return textHora; }

    public void setTextHora(String txtHora) { this.textHora = txtHora; }

    public Contactos(JSONObject a) throws JSONException {
        nombre =  a.getString("first_name").toString() + " " + a.getString("last_name").toString();
        urlPerfil = a.getString("avatar").toString();
    }
    public static ArrayList<Contactos> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Contactos> contactos = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            contactos.add(new Contactos(datos.getJSONObject(i)));
        }
        return contactos;
    }
}


