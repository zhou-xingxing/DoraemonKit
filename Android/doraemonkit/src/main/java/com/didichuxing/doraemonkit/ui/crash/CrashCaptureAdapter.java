package com.didichuxing.doraemonkit.ui.crash;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.didichuxing.doraemonkit.R;

import java.io.File;
import java.util.List;

public class CrashCaptureAdapter extends BaseAdapter {
    private List<File> files;

    public CrashCaptureAdapter(List<File> files) {
        this.files = files;
    }

    @Override
    public int getCount() {
        return files.size();
    }

    @Override
    public Object getItem(int position) {
        return files.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dk_item_crash_capture, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.setData(files.get(position).getName());
        return convertView;
    }

    private class ViewHolder {
        private TextView textView;

        public ViewHolder(View view) {
            textView = view.findViewById(R.id.tv_crash_item);
        }

        public void setData(String string) {
            textView.setText(string);
        }
    }
}
