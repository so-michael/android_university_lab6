package com.codepath.nytimes;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.codepath.nytimes.ui.HomeFragment;
import com.codepath.nytimes.ui.SettingFragment;
import com.codepath.nytimes.ui.books.BestSellerBooksFragment;
import com.codepath.nytimes.ui.search.ArticleResultFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        // define your fragments here
        final Fragment fragment1 = new HomeFragment();
        final Fragment fragment2 = new BestSellerBooksFragment();
        final Fragment fragment3 = new ArticleResultFragment();
        final Fragment fragment4 = new SettingFragment();

        final BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    Fragment fragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            fragment = fragment1;
                            break;
                        case R.id.nav_book:
                            fragment = fragment2;
                            break;
                        case R.id.nav_search:
                            fragment = fragment3;
                            break;
                        case R.id.nav_settings:
                            fragment = fragment4;
                            break;
                        default:
                            fragment = fragment1;
                            break;
                    }
                    fragmentManager.beginTransaction().replace(R.id.activity_main, fragment).commit();
                    return true;
                });
        bottomNavigationView.setSelectedItemId(R.id.nav_home);
    }
}
