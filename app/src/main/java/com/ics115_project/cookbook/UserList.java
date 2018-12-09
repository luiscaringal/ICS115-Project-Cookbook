package com.ics115_project.cookbook;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class UserList extends ArrayAdapter<User> {
    private Activity context;
    private List<User> mUserList;

    public UserList(Activity context, List<User> userList){
        super(context, R.layout.home_page, userList);
        this.context = context;
        this.mUserList = userList;
    }

//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater inflater = context.getLayoutInflater();
//
//        View listViewItem = inflater.inflate(R.layout.home_page,null,true);
//
//        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
//        TextView textViewSpecialty = (TextView) listViewItem.findViewById(R.id.textViewSpecialty);
//
//        home_page_activity home = UserList.get();
//    }
}
