package es.rufflecol.lara.recyclerviewintegersort;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Integer> items; /** Required **/

    public RecyclerAdapter() { /** Required: Constructor **/
        this.items = new ArrayList<>(); /** Here we are initialising an empty list so the RecyclerView displays without crashing **/
    }

    @Override /** Required: Where the layout is inflated and ViewHolder created **/
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override /** Required: Where the data is bound to the ViewHolder **/
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {

        int item = items.get(position);
        holder.textView.setText(Integer.toString(item));
    }

    @Override /** Required: Tells the RecyclerView how many items are in the list **/
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder { /** Required: ViewHolder class that is nested within the RecyclerAdapter **/

        public TextView textView;

        public ViewHolder(View itemView) { /** Constructor **/
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.item);
        }
    }

    public void addItem(int item) { /** New method specific to this app **/

        items.add(item);
        notifyDataSetChanged();
    }

    public void sortItem() { /** New method specific to this app **/

        Collections.sort(items);
        Collections.reverse(items);
        notifyDataSetChanged();
    }

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
        notifyDataSetChanged();
    }
}