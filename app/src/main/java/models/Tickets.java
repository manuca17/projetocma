package models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projetocma.R;

public class Tickets extends BaseAdapter {

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    Context context;
    String name[];
    int image[];
    String price[];
    String description[];
    private OnItemClickListener onItemClickListener;

    public Tickets(Context context, String[] name, int[] image, String[] price, String[] description, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.onItemClickListener = onItemClickListener;
    }

    LayoutInflater inflater;


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
            convertView = inflater.inflate(R.layout.ticket_grid_item,null);
        }

        ImageView imageView = convertView.findViewById(R.id.ticketImg);
        TextView textView = convertView.findViewById(R.id.ticketName);
        TextView textView2 = convertView.findViewById(R.id.ticketPrice);

        imageView.setImageResource(image[position]);
        textView.setText(name[position]);
        textView2.setText(price[position]);

        convertView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position);
            }
        });

        return convertView;

    }
    }

