package com.example.abmo;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class taskAdapter extends ArrayAdapter<task> {
  private final Context context;
  private final List<task> values;

  public taskAdapter(Context context, List<task> values) {
    super(context, R.layout.rowlayout, values);
    this.context = context;
    this.values = values;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
    TextView textView = (TextView) rowView.findViewById(R.id.tasklabel);
    ImageView imageView = (ImageView) rowView.findViewById(R.id.taskicon);
    textView.setText(values.get(position).desc);
    return rowView;
  }
} 
