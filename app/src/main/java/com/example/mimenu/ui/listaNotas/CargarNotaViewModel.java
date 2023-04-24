package com.example.mimenu.ui.listaNotas;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class CargarNotaViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<String> nota = new MutableLiveData<>();;

    public CargarNotaViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }
    // TODO: Implement the ViewModel

    public LiveData<String> getNota(){
        if (nota == null) {
            this.nota = new MutableLiveData<>();
        }

        return nota;
    }

    public void cargarNota(String n){
        if(n != null && !n.isEmpty()){
            nota.setValue(n.trim());
        }else{
            Toast.makeText(context, "La nota debe contener caracteres", Toast.LENGTH_LONG).show();
        }
    }
}