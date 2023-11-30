package models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projetocma.R;

public class Eventos extends BaseAdapter {

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    Context context;
    String name[];
    int image[];
    String date[];

    LayoutInflater inflater;

    public Eventos(Context context, String[] name, int[] image, String[] date) {
        this.context = context;
        this.name = name;
        this.image = image;
        this.date = date;
    }

    private Museu.OnItemClickListener onItemClickListener;

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView == null){
            convertView = inflater.inflate(R.layout.grid_event_item,null);
        }

        ImageView imageView = convertView.findViewById(R.id.eventImage);
        TextView textView = convertView.findViewById(R.id.textViewEventTitle);
        TextView textView1 = convertView.findViewById(R.id.textViewEventDate);

        imageView.setImageResource(image[position]);
        textView.setText(name[position]);
        textView1.setText(date[position]);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });

        return convertView;
    }
}
