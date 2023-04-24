package com.example.mimenu.ui.listaNotas;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class NotasViewModel extends AndroidViewModel {
    ArrayList<String> lista = new ArrayList<String>();
    private MutableLiveData<ArrayList<String>> notasData = new MutableLiveData<>();

    public NotasViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<ArrayList<String>> getNotas() {
        if (notasData.getValue() == null) {
            this.notasData = new MutableLiveData<>();
        }

        return notasData;
    }

    public void setNotas(@NonNull ArrayList<String> notas){
        lista.clear();
        lista.addAll(notas);
        notasData.setValue(lista);
    }
}