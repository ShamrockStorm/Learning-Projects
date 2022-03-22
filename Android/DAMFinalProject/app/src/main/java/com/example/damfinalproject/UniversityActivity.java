package com.example.damfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class UniversityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university);
        ArrayList<UniversityListItem> universityList = getListData();
        final ListView lv = (ListView) findViewById(R.id.UniversityList);
        lv.setAdapter(new com.example.damfinalproject.CustomUniversityListAdapter(this,
                universityList));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                PopupMenu popupMenu = new PopupMenu(UniversityActivity.this, lv.getChildAt(position) );
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu,
                        popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        // Toast message on menu item clicked
                        Uri facultyWebpage = Uri.parse(universityList.get(position).getFacultyLink());
                        Intent intent = new Intent(Intent.ACTION_VIEW,facultyWebpage);
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }

    private ArrayList getListData() {
        ArrayList<com.example.damfinalproject.UniversityListItem> results = new
                ArrayList<>();
        com.example.damfinalproject.UniversityListItem faculty1 = new
                com.example.damfinalproject.UniversityListItem();
        faculty1.setUniversityName("Facultatea de Științe, Educație Fizicã şi Informaticã");
        faculty1.setFacultyName("Universitatea din Pitesti");
        faculty1.setUniversityCity("Pitesti");
        faculty1.setFacultyLink("https://www.upit.ro/ro/academia-reorganizata/facultatea-de-stiinte-educatie-fizica-si-informatica");
        faculty1.setFacultyImageLink("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQgMXD4LxsaPLdR4Dh-eJ29i8F9dPuCrerMJeY9lkKXMQtXw6_zoNlH5RJywiiQSSbQcWA&usqp=CAU");
        results.add(faculty1);

        com.example.damfinalproject.UniversityListItem faculty2 = new
                com.example.damfinalproject.UniversityListItem();
        faculty2.setUniversityName("Facultatea de Electronica, Comunicatii si Calculatoare");
        faculty2.setFacultyName("Universitatea din Pitesti");
        faculty2.setUniversityCity("Pitesti");
        faculty2.setFacultyLink("https://www.upit.ro/ro/academia-reorganizata/facultatea-de-electronica-comunicatii-si-calculatoare-2");
        faculty2.setFacultyImageLink("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjgj8tv82eCnF-ZTiejEccZYF5S3dTdWKEa0D2v3KfRdEghbmOoBqc6AZ1Kl6NIz1-4gM&usqp=CAU");
        results.add(faculty2);

        return results;
    }
}