package com.cdvdev.basetemplate.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cdvdev.basetemplate.R;
import com.cdvdev.basetemplate.models.TestModel;

import java.util.ArrayList;

/**
 * ArrayAdapter for demonstrate source folders structure
 *
 * @author Dmitriy V. Chernysh (dmitriy.chernysh@gmail.com)
 */
public class TestAdapter extends ArrayAdapter<TestModel> {

    private Context mContext;

    public TestAdapter(Context context, ArrayList<TestModel> list) {
        super(context, 0, list);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TestModel testModel = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = ((Activity) mContext).getLayoutInflater().inflate(R.layout.item_test_list, null);
            viewHolder.itemName = (TextView) convertView.findViewById(R.id.item_text_view);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (viewHolder.itemName != null) {
            viewHolder.itemName.setText(testModel.getItemName());
        }

        return convertView;
    }


    private static class ViewHolder {
        TextView itemName;
    }

}
