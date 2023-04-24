package com.example.mimenu.ui.listaNotas;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

import com.example.mimenu.MainActivity;
import com.example.mimenu.R;
import com.example.mimenu.databinding.FragmentNotasBinding;

import java.util.ArrayList;

public class NotasFragment extends Fragment {

    private FragmentNotasBinding binding;
    private NotasViewModel viewModel;

    public static NotasFragment newInstance() {
        return new NotasFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentNotasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(NotasViewModel.class);
        // TODO: Use the ViewModel

        RecyclerView rv = binding.rvLista;
        GridLayoutManager grilla = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(grilla);

        viewModel.setNotas(MainActivity.listNotas);

        viewModel.getNotas().observe(this, new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> notas) {
                NotaAdapter adapter = new NotaAdapter(getContext(), notas, getLayoutInflater());
                rv.setAdapter(adapter);
            }
        });
    }

}