package go.faddy.hmrsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import go.faddy.hmrsystem.ui.popup.DeletePopUp;
import go.faddy.hmrsystem.ui.popup.InsertPopUp;
import go.faddy.hmrsystem.ui.popup.UpdatePopUp;
import go.faddy.hmrsystem.ui.testfragment.TestFragmentSearch;

public class ShowingItems extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showing_items);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.showing_items, menu);



//        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                searchView.clearFocus();
//             /*   if(list.contains(query)){
//                    adapter.getFilter().filter(query);
//                }else{
//                    Toast.makeText(MainActivity.this, "No Match found",Toast.LENGTH_LONG).show();
//                }*/
//                return false;
//
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
////                adapter.getFilter().filter(newText);
//                Toast.makeText(ShowingItems.this, newText, Toast.LENGTH_SHORT).show();
//                Log.d("serach", newText);
//                return false;
//            }
//        });
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_insert) {
            startActivity(new Intent(getApplicationContext(), InsertPopUp.class));
            onResumeFragments();
            return true;
        } else if (item.getItemId() == R.id.action_update) {
            startActivity(new Intent(getApplicationContext(), UpdatePopUp.class));
            onResumeFragments();
            return true;
        } else if (item.getItemId() == R.id.action_delete) {
            startActivity(new Intent(getApplicationContext(), DeletePopUp.class));
            onResumeFragments();
            return true;
        }
//        else if (item.getItemId() == R.id.app_bar_search) {
//            FragmentManager fm = getSupportFragmentManager();
//            FragmentTransaction ft = fm.beginTransaction();
//            Fragment fragment = null;
//            fragment = new TestFragmentSearch();
//
//            ft.replace(R.id.nav_host_fragment, fragment);
//            ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
//            ft.commit();
//        }
            return super.onOptionsItemSelected(item);


    }
}