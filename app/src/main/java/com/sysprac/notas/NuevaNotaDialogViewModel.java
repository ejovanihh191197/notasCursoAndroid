package com.sysprac.notas;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.sysprac.notas.db.entity.NotaEntity;

import java.util.List;

public class NuevaNotaDialogViewModel extends AndroidViewModel {
    // TODO: Implement the ViewModel
    private LiveData<List<NotaEntity>> allNotas;
    private NotaRepository notaRepository;

    public NuevaNotaDialogViewModel(Application application){
        super(application);
        notaRepository = new NotaRepository(application);
        allNotas = notaRepository.getAll();
    }

    //FRagmento que necesita recibir la nueva lista de datos
    public LiveData<List<NotaEntity>> getAllNotas(){
        return allNotas;
    }

    //El fragment que inserte una nueva nota, deberá comunicarlo a este view model
    public void insertarNota(NotaEntity notaEntity){
        notaRepository.insert(notaEntity);
    }

    public void updateNota(NotaEntity notaEntity){
        notaRepository.update(notaEntity);
    }

}
