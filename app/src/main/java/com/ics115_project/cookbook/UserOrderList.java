package com.ics115_project.cookbook;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class UserOrderList extends ArrayAdapter<UserOrder> {
    private Activity context;
    private List<UserOrder> userOrderList;

    public UserOrderList(Activity context, List<UserOrder> userOrderList) {
        super(context, R.layout.fragment_order, userOrderList);
        this.context = context;
        this.userOrderList = userOrderList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.user_order_list_layout,null,true);

        TextView userOrderFoodName = (TextView) listViewItem.findViewById(R.id.userOrderFoodName);
        TextView userOrderQuantity = (TextView) listViewItem.findViewById(R.id.userOrderQuantity);
        TextView userOrderTotalPrice = (TextView) listViewItem.findViewById(R.id.userOrderTotalPrice);
        TextView userOrderChefUserName = (TextView) listViewItem.findViewById(R.id.userOrderChefUserName);

        UserOrder userOrder = userOrderList.get(position);

        userOrderFoodName.setText(userOrder.getOrderFood());
        userOrderQuantity.setText(userOrder.getOrderQuantity());
        userOrderTotalPrice.setText(userOrder.getModeOfPayment());
        userOrderChefUserName.setText(userOrder.getChefUsername());

        return listViewItem;
    }
}
