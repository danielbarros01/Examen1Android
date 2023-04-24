package com.example.mimenu.ui.listaNotas;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.mimenu.MainActivity;
import com.example.mimenu.R;
import com.example.mimenu.databinding.FragmentCargarNotaBinding;
import com.example.mimenu.databinding.FragmentNotasBinding;

import java.io.Console;

public class CargarNotaFragment extends Fragment {

    private FragmentCargarNotaBinding binding;
    private CargarNotaViewModel viewModel;
    private EditText nota;
    private Button btnCargar;

    public static CargarNotaFragment newInstance() {
        return new CargarNotaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCargarNotaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        nota = binding.etNota;
        btnCargar = binding.btnCargar;

        viewModel = new ViewModelProvider(this).get(CargarNotaViewModel.class);

        viewModel.getNota().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                //validacion necesaria para cuando cambio de activity no se vuelva a cargar el ultimo elemento
                if (!MainActivity.listNotas.contains(s)) {
                    MainActivity.listNotas.add(s);
                }
                Log.d("1", MainActivity.listNotas.size()+"");
                nota.setText("");
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel

        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = nota.getText().toString();
                viewModel.cargarNota(n);
            }
        });
    }

}