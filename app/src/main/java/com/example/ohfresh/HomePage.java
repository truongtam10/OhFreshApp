package com.example.ohfresh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.example.adapter.BestSellingAdapter;
import com.example.adapter.NewProductAdapter;
import com.example.adapter.ProductAdapter;
import com.example.adapter.SliderAdapter;
import com.example.adapter.VeggiesAdapter;
import com.example.model.BestSellingItems;
import com.example.model.NewProductItems;
import com.example.model.Product;
import com.example.model.VeggiesItems;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity implements VeggiesAdapter.OnClickListener, BestSellingAdapter.OnBestSellerListener {

    SliderView sliderView;
    int[] images = {R.drawable.banner1, R.drawable.img_banner2};
    SliderAdapter sldAdapter;
    //RecyclerViewVeggies
    RecyclerView rclVeggies;
    ArrayList<VeggiesItems> veggies;
    VeggiesAdapter adapter;
    //RecyclerViewBestSeller
    RecyclerView rclBestSelling;
    ArrayList<BestSellingItems> bestSellingItems;
    BestSellingAdapter bslAdapter;
    //GridViewNewProduct
    GridView gvNewProduct;
//    ArrayList<NewProductItems> newProducts;
//    NewProductAdapter npAdapter;
    GridView gvProduct;
    ArrayList<Product> products;
    NewProductAdapter npadapter;
    BottomNavigationView bottomNavigationView;
    ImageButton btnChat, btnCart;
    TextView txtMoreNewProduct, txtMoreBestSeller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        linkViews();
        configureNavigation();
        setSlider();
        initData();
        loadData();
        addEvents();
    }

    private void initData() {
        //VeggiesData
        veggies = new ArrayList<VeggiesItems>();
//        veggies.add(new VeggiesItems(R.drawable.item_all));
        veggies.add(new VeggiesItems(R.drawable.img_broccoli,R.drawable.rectangle_broccoli,"Bông cải"));
        veggies.add(new VeggiesItems(R.drawable.img_mushroom,R.drawable.rectangle_mushroom,"Nấm"));
        veggies.add(new VeggiesItems(R.drawable.img_cucumber,R.drawable.rectangle_cucumber,"Dưa chuột"));
        veggies.add(new VeggiesItems(R.drawable.img_greenpea,R.drawable.rectangle_greenpea,"Đậu hà lan"));
        //BestSellerData
        bestSellingItems = new ArrayList<BestSellingItems>();
        bestSellingItems.add(new BestSellingItems(R.drawable.img_strawberry,"Dâu tây"));
        bestSellingItems.add(new BestSellingItems(R.drawable.img_bellpepper,"Ớt chuông"));
        bestSellingItems.add(new BestSellingItems(R.drawable.img_pumpkin,"Bí ngô"));
        bestSellingItems.add(new BestSellingItems(R.drawable.img_tomato,"Cà chua"));
        bestSellingItems.add(new BestSellingItems(R.drawable.img_corn,"Ngô Mỹ"));
        //NewProduct
        products = new ArrayList<Product>();
        products.add(new Product(R.drawable.img_apple, "Táo", "35000", "KG"));
        products.add(new Product(R.drawable.img_banana, "Chuối", "15000", "KG"));
        products.add(new Product(R.drawable.img_cherry, "Cherry", "40000", "KG"));
        products.add(new Product(R.drawable.img_cabbage, "Bắp cải", "17000", "KG"));products.add(new Product(R.drawable.img_strawberry, "Dâu tây", "35000", "KG"));
        products.add(new Product(R.drawable.img_atiso, "Atiso", "35000", "Hoa"));
        products.add(new Product(R.drawable.img_blueberry, "Blueberry", "35000", "KG"));
//        products.add(new Product(R.drawable.img_tomato, "Cà chua", "35000", "KG"));
//        products.add(new Product(R.drawable.img_raspberry, "Mâm xôi", "35000", "KG"));
    }

    private void setSlider() {
        sldAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sldAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
    }

    private void linkViews() {

        sliderView = findViewById(R.id.sliderView);
        rclVeggies = findViewById(R.id.rclVeggies);
        rclBestSelling = findViewById(R.id.rclBestSeller);
        gvNewProduct = findViewById(R.id.gvNewProduct);
        bottomNavigationView = findViewById(R.id.navigation);
        btnChat = findViewById(R.id.btnChat);
        btnCart = findViewById(R.id.btnCart);
        txtMoreBestSeller = findViewById(R.id.txtMoreBestSeller);
        txtMoreNewProduct = findViewById(R.id.txtMoreNewProduct);
    }

    private void loadData() {
        //loadDataVeggies
        adapter = new VeggiesAdapter(getApplicationContext(),veggies,this);
        rclVeggies.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HomePage.this, RecyclerView.HORIZONTAL, false);
        rclVeggies.setLayoutManager(linearLayoutManager);
        //loadDataBestSeller
        bslAdapter = new BestSellingAdapter(getApplicationContext(),bestSellingItems,this);
        rclBestSelling.setAdapter(bslAdapter);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(HomePage.this, RecyclerView.HORIZONTAL, false);
        rclBestSelling.setLayoutManager(linearLayoutManager1);
        //loadDataNewProduct
//        npAdapter = new NewProductAdapter(HomePage.this, R.layout.item_newproduct, newProducts);
//        gvNewProduct.setAdapter(npAdapter);
        npadapter = new NewProductAdapter(HomePage.this, R.layout.item_newproduct, products);
        gvNewProduct.setAdapter(npadapter);
    }

    private void configureNavigation() {
        bottomNavigationView.setSelectedItemId(R.id.navHomepage);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navHomepage:
                        return true;
                    case R.id.navCategory:
                        startActivity(new Intent(getApplicationContext(), Category.class));
                        finish();
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navNotification:
                        startActivity(new Intent(getApplicationContext(), Notification.class));
                        finish();
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.navAccount:
                        startActivity(new Intent(getApplicationContext(), Account.class));
                        finish();
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

    }
    private void addEvents() {
        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, Chatting.class);
                startActivity(intent);
            }
        });

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, Cart.class);
                startActivity(intent);
            }
        });

        txtMoreNewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, MoreNewProduct.class);
                startActivity(intent);
            }
        });

        txtMoreBestSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this,MoreBestSeller.class);
                startActivity(intent);
            }
        });

        gvNewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product p = (Product) npadapter.getItem(i);
                Toast.makeText(HomePage.this,i + ": " + p.getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(int position) {
        switch (position){
            case 0:
                Intent intent0 = new Intent(HomePage.this, ProductDetail.class);
                startActivity(intent0);
                break;
            case 1:
                Intent intent1 = new Intent(HomePage.this, ProductDetail.class);
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(HomePage.this, ProductDetail.class);
                startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(HomePage.this, ProductDetail.class);
                startActivity(intent3);
                break;
        }


    }


    @Override
    public void OnBestSellerClick(int position) {
        switch (position){
            case 0:
                Intent intent0 = new Intent(HomePage.this, ProductDetail.class);
                startActivity(intent0);
                break;
            case 1:
                Intent intent1 = new Intent(HomePage.this, ProductDetail.class);
                startActivity(intent1);
                break;
            case 2:
                Intent intent2 = new Intent(HomePage.this, ProductDetail.class);
                startActivity(intent2);
                break;
            case 3:
                Intent intent3 = new Intent(HomePage.this, ProductDetail.class);
                startActivity(intent3);
                break;
            case 4:
                Intent intent4 = new Intent(HomePage.this, ProductDetail.class);
                startActivity(intent4);
                break;
        }

    }
}