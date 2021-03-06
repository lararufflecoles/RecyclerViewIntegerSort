package es.rufflecol.lara.recyclerviewintegersort;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String SAVED_INSTANCE_STATE_KEY = "Key";

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putIntegerArrayList(SAVED_INSTANCE_STATE_KEY, (ArrayList<Integer>) adapter.getItems());
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ArrayList<Integer> list = savedInstanceState.getIntegerArrayList(SAVED_INSTANCE_STATE_KEY);
        adapter.setItems(list);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToolbarLRC toolbar = (ToolbarLRC) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        Button buttonAdd = (Button) findViewById(R.id.button_add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editTextInput = (EditText) findViewById(R.id.input);
                String stringInput = editTextInput.getText().toString();

                int input = Integer.parseInt(stringInput);

                adapter.addItem(input);
                editTextInput.getText().clear();
            }
        });

        final Button buttonSort = (Button) findViewById(R.id.button_sort);
        buttonSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adapter.sortItem();
            }
        });
    }
}
