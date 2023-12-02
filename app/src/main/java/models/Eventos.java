package models;

import static androidx.navigation.Navigation.findNavController;

import static java.sql.DriverManager.println;

import android.content.Context;
import android.util.Log;
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
    String description[];
    String imgDescription[];

    private OnItemClickListener onItemClickListener;

    LayoutInflater inflater;

    public Eventos(Context context, String[] name, int[] image, String[] date, OnItemClickListener onItemClickListener, String[] description,String[] ImgDescription) {
        this.context = context;
        this.name = name;
        this.image = image;
        this.date = date;
        this.onItemClickListener = onItemClickListener;
        this.description = description;
        this.imgDescription = imgDescription;

    }


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

        convertView = inflater.inflate(R.layout.grid_event_item, parent, false);


        ImageView imageView = convertView.findViewById(R.id.eventImage);
        TextView textView = convertView.findViewById(R.id.textViewEventTitle);
        TextView textView1 = convertView.findViewById(R.id.textViewEventDate);

        imageView.setImageResource(image[position]);
        textView.setText(name[position]);
        textView1.setText(date[position]);


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("EventAdapter", "Item clicked at position: " + position);
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });


        return convertView;
    }
}
