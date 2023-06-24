//package com.example.food_order_app;
//
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//public class MenuViewHolder extends RecyclerView.ViewHolder implements ItemClickListener {
//
//    public TextView txtMenuName;
//    public ImageView imageView;
//    private View.OnClickListener itemClickListener;
//
//
//    public MenuViewHolder(@NonNull View itemView) {
//        super(itemView);
//
//        txtMenuName = itemView.findViewById(R.id.menu_item);
//        imageView = itemView.findViewById(R.id.imageView);
//        itemView.setOnClickListener((View.OnClickListener) this);
//
//    }
//
//    public void setItemClickListener(ItemClickListener itemClickListener) {
//        this.itemClickListener = itemClickListener;
//    }
//
//    @Override
//    public void onClick1(View view, int position, boolean isLongClick) {
//        itemClickListener.onClick(view, getAbsoluteAdapterPosition(), false);
//    }
//}
