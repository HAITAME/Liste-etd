package com.example.liste_etd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editCode, editNom;
    private Button btnAjouter;
    private ListView listEtudiants;
    private ArrayList<Etudiant> etudiantsList;
    private EtudiantAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editCode = findViewById(R.id.editCode);
        editNom = findViewById(R.id.editNom);
        btnAjouter = findViewById(R.id.btnAjouter);
        listEtudiants = findViewById(R.id.listEtudiants);

        etudiantsList = new ArrayList<>();
        adapter = new EtudiantAdapter(etudiantsList);
        listEtudiants.setAdapter(adapter);

        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = editCode.getText().toString();
                String nom = editNom.getText().toString();

                Etudiant etudiant = new Etudiant(code, nom);
                etudiantsList.add(etudiant);
                adapter.notifyDataSetChanged();

                editCode.setText("");
                editNom.setText("");
            }
        });
    }

    private class EtudiantAdapter extends ArrayAdapter<Etudiant> {

        public EtudiantAdapter(ArrayList<Etudiant> etudiants) {
            super(MainActivity.this, 0, etudiants);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_etudiant, parent, false);
            }

            TextView textCode = convertView.findViewById(R.id.textCode);
            TextView textNom = convertView.findViewById(R.id.textNom);

            Etudiant etudiant = getItem(position);
            if (etudiant != null) {
                textCode.setText(etudiant.getCode());
                textNom.setText(etudiant.getNom());
            }

            return convertView;
        }
    }
}
