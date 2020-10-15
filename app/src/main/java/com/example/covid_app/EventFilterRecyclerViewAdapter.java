package com.example.covid_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventFilterRecyclerViewAdapter extends RecyclerView.Adapter<EventFilterRecyclerViewAdapter.ViewHolder>{


    private List<EventClass> filterList;
    private Context context;

    public EventFilterRecyclerViewAdapter(List<EventClass> eventClassList
            , Context ctx) {
        filterList = eventClassList;
        context = ctx;
    }

    @Override
    public EventFilterRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                        int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filter_brand_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        EventClass filterM = filterList.get(position);
        holder.title.setText(String.valueOf(filterM.gettitle()));
        holder.date.setText("" + filterM.getDate());
        holder.time.setText("" + filterM.getTime());
        if (filterM.isSelected()) {
            holder.selectionState.setChecked(true);
        } else {
            holder.selectionState.setChecked(false);
        }

    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView title;
        public TextView date;
        public TextView time;
        public CheckBox selectionState;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            date = (TextView) view.findViewById(R.id.date);
            time = (TextView) view.findViewById(R.id.time);
            selectionState = (CheckBox) view.findViewById(R.id.brand_select);

            //item click event listener
            view.setOnClickListener(this);

            /**
            //checkbox click event handling
            selectionState.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {
                    if (isChecked) {
                        Toast.makeText(ProductFilterRecyclerViewAdapter.this.context,
                                "selected brand is " + title.getText(),
                                Toast.LENGTH_LONG).show();
                    } else {

                    }
                }
            });*/
        }

        @Override
        public void onClick(View v) {
            //TextView brndName = (TextView) v.findViewById(R.id.title);
            //show more information about brand
        }
    }
}

