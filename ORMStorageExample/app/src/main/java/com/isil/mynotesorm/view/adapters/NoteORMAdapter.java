package com.isil.mynotesorm.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.isil.mynotesorm.R;
import com.isil.mynotesorm.entity.NoteORMEntity;

import java.util.List;

/**
 * Created by emedinaa on 15/09/15.
 */
public class NoteORMAdapter extends BaseAdapter {

    private Context context;
    private List<NoteORMEntity> lsNoteEntities;

    public NoteORMAdapter(Context context, List<NoteORMEntity> lsNoteEntities) {
        this.context = context;
        this.lsNoteEntities = lsNoteEntities;
    }

    @Override
    public int getCount() {
        return lsNoteEntities.size();
    }

    @Override
    public Object getItem(int i) {
        return lsNoteEntities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if(v == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.row_note, null);
            ViewHolder holder = new ViewHolder();
            holder.tviName = (TextView)v.findViewById(R.id.tviName);
            v.setTag(holder);
        }
        NoteORMEntity entry = lsNoteEntities.get(position);
        if(entry != null) {
            ViewHolder holder = (ViewHolder)v.getTag();
            holder.tviName.setText(entry.getName());
        }

        return v;
    }

    static class ViewHolder
    {
        ImageView iviNote;
        TextView tviName;
    }
}
