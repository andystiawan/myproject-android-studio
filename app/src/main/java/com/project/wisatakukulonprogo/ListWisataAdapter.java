package com.project.wisatakukulonprogo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListWisataAdapter extends RecyclerView.Adapter<ListWisataAdapter.ListViewHolder>{

    public ArrayList<Wisata> listWisata;
    private Context context;
    private Activity activity;

    public ListWisataAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Wisata> getListWisata() {
        return listWisata;
    }
    public void setListWisata(ArrayList<Wisata> listWisata) {
        this.listWisata = listWisata;
    }


    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_wisata, viewGroup, false);
        ListViewHolder viewHolder = new ListViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        final Wisata w = listWisata.get(position);
        Glide.with(context)
                .load(w.getPhoto())
                .apply(new RequestOptions().override(65, 65))
                .into(holder.imgPhoto);
        holder.tvName.setText(w.getName());
        holder.tvDeskripsi.setText(w.getDeskripsi());
        holder.tvlokasi.setText(w.getLokasi());
        holder.wisata = w;

        holder.btnshare.setOnClickListener(new CustomOnClick(position, new CustomOnClick.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share"+ getListWisata().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));


    }

    @Override
    public int getItemCount() {
        return getListWisata().size();
    }
    public void startactivity(Intent intent){

    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        ImageView imgPhoto;
        TextView tvName, tvlokasi, tvDeskripsi;
        Button btnshare,btndetail;
        Wisata wisata;


        public ListViewHolder( View itemView) {
            super(itemView);
            imgPhoto = (ImageView) itemView.findViewById(R.id.img_item_photo);
            tvName = (TextView) itemView.findViewById(R.id.tv_item_name);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.tv_item_deskripsi);
            tvlokasi = (TextView) itemView.findViewById(R.id.tv_item_lokasi);
            btnshare = (Button) itemView.findViewById(R.id.btn_set_share);
            btndetail = (Button) itemView.findViewById(R.id.btn_set_detail);
            btndetail.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, DetailWisata.class);
            intent.putExtra("key", wisata);
            context.startActivity(intent);
        }
    }

}
