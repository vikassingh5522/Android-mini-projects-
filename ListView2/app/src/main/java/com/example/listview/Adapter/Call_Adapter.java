package com.example.listview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listview.ModelClassAdapter.callSetGet;
import com.example.listview.R;

import java.util.ArrayList;

public class Call_Adapter extends BaseAdapter {

    private Context context;
    private ArrayList<callSetGet> callList;

    public Call_Adapter(Context context, ArrayList<callSetGet> callList) {
        this.context = context;
        this.callList = callList;
    }

    @Override
    public int getCount() {
        return callList.size();
    }

    @Override
    public Object getItem(int position) {
        return callList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_main_activity2call, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Get current item
        callSetGet currentItem = callList.get(position);

        // Set data to TextViews
        viewHolder.contactName.setText(currentItem.getName());
        viewHolder.contactNumber.setText(currentItem.getContactNumber());
        viewHolder.callCount.setText(currentItem.getCallCount());

        // Handle Accept Call Click (Make a Call)
        viewHolder.callUp.setOnClickListener(v -> {
            String phoneNumber = currentItem.getContactNumber();
            if (phoneNumber != null && !phoneNumber.isEmpty()) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + phoneNumber));

                try {
                    context.startActivity(callIntent);
                } catch (SecurityException e) {
                    Toast.makeText(context, "Call permission not granted!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(context, "Invalid phone number!", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle Reject Call Click
        viewHolder.cancelCall.setOnClickListener(v -> {
            Toast.makeText(context, "Rejecting call from " + currentItem.getName(), Toast.LENGTH_SHORT).show();
        });

        return convertView;
    }

    // ViewHolder class to optimize performance
    private static class ViewHolder {
        TextView contactName, contactNumber, callCount;
        ImageView callUp, cancelCall;

        ViewHolder(View view) {
            contactName = view.findViewById(R.id.contactName);
            contactNumber = view.findViewById(R.id.contactNumber);
            callCount = view.findViewById(R.id.callCount);
            callUp = view.findViewById(R.id.call_up);
            cancelCall = view.findViewById(R.id.cancel_call);
        }
    }
}
