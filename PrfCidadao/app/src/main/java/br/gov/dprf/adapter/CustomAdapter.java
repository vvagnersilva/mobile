package br.gov.dprf.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.gov.dprf.R;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int flags[];
    String[] estados;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, int[] flags, String[] estados) {
        this.context = applicationContext;
        this.flags = flags;
        this.estados = estados;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return flags.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.custom_spinner_items, null);
        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
        TextView names = (TextView) view.findViewById(R.id.textView);
        icon.setImageResource(flags[i]);
        names.setText(estados[i]);
        return view;
    }
}
