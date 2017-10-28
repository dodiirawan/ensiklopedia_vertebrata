package irawan.org.appensiklopediaoffline.fragment.list;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import irawan.org.appensiklopediaoffline.R;
import irawan.org.appensiklopediaoffline.entity.Hewan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dodi on 26/10/17.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<Hewan> listItems;
    private Context context;

    private ItemClickCallback itemClickCallback;

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public ListAdapter(List<Hewan> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_hewan_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Hewan hewan = listItems.get(position);

        holder.textViewNmHewan.setText(hewan.getNama());
        holder.textViewSpesiesHewan.setText(hewan.getSpesies());

        byte[] decodeString = Base64.decode(hewan.getImage(),Base64.DEFAULT);
        Bitmap decoded = BitmapFactory.decodeByteArray(decodeString,0,decodeString.length);

        holder.image_recyler_view.setImageBitmap(decoded);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, hewan.getId() + " " + hewan.getNama(), Toast.LENGTH_SHORT).show();
                itemClickCallback.onItemClick(hewan.getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewNmHewan;
        public TextView textViewSpesiesHewan;
        public ImageView image_recyler_view;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.list_hewan_list);
            textViewNmHewan = (TextView) itemView.findViewById(R.id.textViewNmHewanList);
            textViewSpesiesHewan = (TextView) itemView.findViewById(R.id.textViewSpesiesHewanList);
            image_recyler_view = (ImageView) itemView.findViewById(R.id.image_recyler_view);
        }
    }

    public void setFilter(ArrayList<Hewan> hewanList) {
        listItems = new ArrayList<>();
        listItems.addAll(hewanList);
        notifyDataSetChanged();
    }


}
