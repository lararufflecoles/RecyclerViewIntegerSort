package es.rufflecol.lara.recyclerviewintegersort;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    /** Required **/
    private List<Integer> items;

    /** Required **/
    public RecyclerAdapter() { /** Constructor **/
        this.items = new ArrayList<>(); /** Here we are initialising an empty list so the RecyclerView displays without crashing **/
    }

    /** Required: Where the layout is inflated and ViewHolder created **/
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    /** Required: Where the data is bound to the ViewHolder **/
    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        int item = items.get(position);
        holder.textView.setText(Integer.toString(item));
    }

    /** Required: Tells the RecyclerView how many items are in the list **/
    @Override
    public int getItemCount() {

        return items.size();
    }

    /** Required: Nested ViewHolder class **/
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public ViewHolder(View itemView) { /** Constructor **/
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.item);
        }
    }

    /** New method specific to this app **/
    public void addItem(int item) {
        items.add(item);
        notifyDataSetChanged();
    }
}