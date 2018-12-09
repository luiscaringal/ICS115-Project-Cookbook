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

public class FoodList extends ArrayAdapter<Food> {
    private Activity context;
    private List<Food> foodList;

    public FoodList(@NonNull Activity context, List<Food> foodList) {
        super(context, R.layout.menu_page, foodList);
        this.context = context;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.food_list_layout,null,true);

        TextView foodName = (TextView) listViewItem.findViewById(R.id.foodName);
        TextView foodType = (TextView) listViewItem.findViewById(R.id.foodType);

        Food food = foodList.get(position);

        foodName.setText(food.getFoodName());
        foodType.setText(food.getFoodType());

        return listViewItem;
    }
}
