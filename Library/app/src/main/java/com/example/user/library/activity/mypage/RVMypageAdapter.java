package com.example.user.library.activity.mypage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.library.R;
import com.example.user.library.activity.main.Menu;

import java.util.List;

public class RVMypageAdapter extends RecyclerView.Adapter<RVMypageAdapter.MenuViewHolder> {

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView menuTitle;
        ImageView backgroudnImgae;
        int position;
        Context mcontext;

        MenuViewHolder(View itemView, final Context context) {
            super(itemView);
            mcontext = context;
            cv = (CardView)itemView.findViewById(R.id.cv);
            menuTitle = (TextView)itemView.findViewById(R.id.item_title);
            backgroudnImgae = (ImageView)itemView.findViewById(R.id.item_background);

            cv.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {

                    Intent intent;
                    switch(position){
                        case 0:
                            startBorrowing();
                            break;
                        case 1:
                            startType();
                            break;
                        case 2:
                            startBorrowed();
                            break;
                    }
                }
            });


        }

        public void startBorrowing(){
            Intent intent = new Intent(mcontext, MypageBorrowingAcitvity.class);
            mcontext.startActivity(intent);
        }
        public void startType(){
            Intent intent = new Intent(mcontext, MypageTypeActivity.class);
            mcontext.startActivity(intent);
        }
        public void startBorrowed(){
            Intent intent = new Intent(mcontext, MypageBorrowedActivity.class);
            mcontext.startActivity(intent);
        }

    }

    Context context;
    List<Menu> menus;

    public RVMypageAdapter(Context context, List<Menu> menus){
        this.context = context;
        this.menus = menus;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        MenuViewHolder mvh = new MenuViewHolder(v,context);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MenuViewHolder menuViewHolder, int position) {
        menuViewHolder.menuTitle.setText(menus.get(position).title);
        menuViewHolder.backgroudnImgae.setImageResource(menus.get(position).photoId);
        menuViewHolder.position = position;
    }

    @Override
    public int getItemCount() {
        return menus.size();
    }
}
