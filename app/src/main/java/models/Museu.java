package models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projetocma.R;

public class Museu extends BaseAdapter {

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    Context context;
    String name[];
    int image[];

    private OnItemClickListener onItemClickListener;


    LayoutInflater inflater;

    public Museu(Context context, String[] name, int[] image, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.name = name;
        this.image = image;
        this.onItemClickListener = onItemClickListener;
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

        if(convertView == null){
            convertView = inflater.inflate(R.layout.grid_item,null);
        }

        ImageView imageView = convertView.findViewById(R.id.gridImage);
        TextView textView = convertView.findViewById(R.id.gridName);

            imageView.setImageResource(image[position]);
            textView.setText(name[position]);

        convertView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position);
            }
        });

        return convertView;
    }
}
