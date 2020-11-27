package com.sysprac.notas;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.sysprac.notas.db.entity.NotaEntity;

public class NuevaNotaDialogFragment extends DialogFragment {

    public static NuevaNotaDialogFragment newInstance() {
        return new NuevaNotaDialogFragment();
    }

    private View view;
    private EditText etTitulo, etContenido;
    private RadioGroup rgColor;
    private Switch swNotaFavorita;

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Nueva Nota");
        builder.setMessage("Introduzca los datos de la nueva nota")
                .setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                        String titulo = etTitulo.getText().toString();
                        String contenido = etContenido.getText().toString();
                        String color = "Rojo";
                        switch (rgColor.getCheckedRadioButtonId()){
                            case R.id.radioButtonColorOro:
                                color = "Dorado";
                            break;
                            case R.id.radioButtonColorVerde:
                                color = "Verde";
                            break;
                        }

                        boolean esFavorita = swNotaFavorita.isChecked();


                        NuevaNotaDialogViewModel mViewModel = ViewModelProviders.of(getActivity()).get(NuevaNotaDialogViewModel.class);
                        mViewModel.insertarNota(new NotaEntity(titulo,contenido,esFavorita,color));
                        dialog.dismiss();


                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss();
                    }
                });

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.nueva_nota_dialog_fragment, null);

        etTitulo = view.findViewById(R.id.editTextTitulo);
        etContenido = view.findViewById(R.id.editTextContenido);
        rgColor = view.findViewById(R.id.radioGroupColor);
        swNotaFavorita = view.findViewById(R.id.switchFavorita);

        builder.setView(view);

        // Create the AlertDialog object and return it
        return builder.create();
    }
}
