package com.example.damfinalproject;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class TextAdapter extends BaseAdapter {
    private Context mContext;

    public TextAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return Randuri.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(mContext);
        if(position == 0 || position == 1){
            textView.setLayoutParams(new GridView.LayoutParams(300, 200));
            textView.setTextSize(18);
            textView.setTextColor(Color.rgb(0,153,51));
            textView.setTypeface(null, Typeface.BOLD);
        }
        else {
            textView.setTextSize(15);
        }
        textView.setText(Randuri[position]);
        return textView;
    }

    public String[] Randuri = {
            "Informatica", "Calculatoare",
            "- Curiculumul se bazeaza exclusiv pe componenta software.",
            "- Curiculumul contine atat elemente de hardware cat si unele de software.",
            "- Cursurile loate contin bazele a multiple limbaje de programare, baze de date si diferite tehnologi care se leaga " +
                    "atat de backend cat si de frontend.",
            "- Cursurile contine mai multe ore de fizica(electronica), cat si lucru direct cu elemente hardware. Se vor folosi atat libaje de programare" +
                    " high-end cat si low-end.",
            "Licenta in informatica", "Certificare Inginer programator"
    };
}
