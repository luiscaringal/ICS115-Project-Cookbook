package com.ics115_project.cookbook;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class UserList extends ArrayAdapter<User> {
    private Activity context;
    private List<User> userList;

    public UserList(Activity context, List<User> userList){
        super(context, R.layout.home_page, userList);
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.user_list_layout,null,true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewUserName = (TextView) listViewItem.findViewById(R.id.textViewUserName);
        TextView textViewPhoneNumber = (TextView) listViewItem.findViewById(R.id.textViewPhoneNumber);
        ImageView doggieImage = (ImageView) listViewItem.findViewById(R.id.avatar);
        Button orderButton = (Button) listViewItem.findViewById(R.id.order_button_main);

        User user = userList.get(position);

        textViewName.setText(user.getName());
        textViewUserName.setText(user.getUserName());
        textViewPhoneNumber.setText(user.getPhoneNumber());
        doggieImage.setImageResource(R.drawable.doggie);
        orderButton.setText("ORDER");

        return listViewItem;
    }
}
