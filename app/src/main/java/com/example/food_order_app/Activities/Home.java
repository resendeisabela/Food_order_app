//package com.example.food_order_app.Activities;
//
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.View;
//import android.widget.Toast;
//import android.widget.Toolbar;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.drawerlayout.widget.DrawerLayout;
//import androidx.navigation.NavController;
//import androidx.navigation.Navigation;
//import androidx.navigation.ui.AppBarConfiguration;
//import androidx.navigation.ui.NavigationUI;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.food_order_app.Entities.Categoria;
//import com.example.food_order_app.ItemClickListener;
//import com.example.food_order_app.MenuViewHolder;
//import com.example.food_order_app.R;
//import com.example.food_order_app.databinding.ActivityHomeBinding;
//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.google.android.material.navigation.NavigationView;
//import com.google.android.material.snackbar.Snackbar;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.squareup.picasso.Picasso;
//
//public class Home extends AppCompatActivity {
//
//    private AppBarConfiguration mAppBarConfiguration;
//    private ActivityHomeBinding binding;
//    private FirebaseDatabase database;
//    private DatabaseReference category;
//    private RecyclerView recycler_menu;
//    private RecyclerView.LayoutManager layoutManager;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        binding = ActivityHomeBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        //setSupportActionBar(toolbar);
//
//        setSupportActionBar(binding.appBarHome.toolbar);
//
//        database = FirebaseDatabase.getInstance();
//        category = database.getReference("Category");
//
//        binding.appBarHome.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        DrawerLayout drawer = binding.drawerLayout;
//        NavigationView navigationView = binding.navView;
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
//                .setOpenableLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
//
//        recycler_menu = findViewById(R.id.recycler_menu);
//        recycler_menu.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(this);
//        recycler_menu.setLayoutManager(layoutManager);
//
//        loadMenu();
//    }
//
//    private void loadMenu(){
//        FirebaseRecyclerAdapter<Categoria, MenuViewHolder> adapter = new FirebaseRecyclerAdapter<Categoria, MenuViewHolder>(Categoria.class, R.layout.menu_item, MenuViewHolder.class, category) {
//            @Override
//            protected void populateViewHolder(MenuViewHolder viewHolder, Categoria categoria, int i) {
//                viewHolder.txtMenuName.setText(categoria.getNome());
//                Picasso.with(getBaseContext()).load(categoria.getImagem())
//                        .into(viewHolder.imageView);
//                final Categoria clickItem = categoria;
//                viewHolder.setItemClickListener(new ItemClickListener(){
//                    @Override
//                    public void onClick1(View view, int position, boolean isLongClick) {
//                        Toast.makeText(Home.this, ""+clickItem.getNome(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        };
//
//        recycler_menu.setAdapter(adapter);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.home, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
//}