package com.example.fitnesstrackerapp.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fitnesstrackerapp.data.Way;
import com.example.fitnesstrackerapp.R;
import java.util.ArrayList;
import java.util.List;

public class TrackerAdapter extends RecyclerView.Adapter<TrackerAdapter.ViewHolder> {
    List<Way> wayList;

    public TrackerAdapter() {
        wayList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_way, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Way currentPath = wayList.get(position);
        try {
            holder.textView_time.setText(String.valueOf(currentPath.getTime()));
            holder.textView_speed.setText(String.valueOf(currentPath.getSpeed()));
            holder.textView_length.setText(String.valueOf(currentPath.getLength()));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public int getItemCount() {
        return wayList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView_length;
        private final TextView textView_time;
        private final TextView textView_speed;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_length = itemView.findViewById(R.id.list_length);
            textView_speed = itemView.findViewById(R.id.list_speed);
            textView_time = itemView.findViewById(R.id.list_time);
        }
    }
}