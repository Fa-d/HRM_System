package go.faddy.hmrsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import go.faddy.hmrsystem.ui.gallery.GalleryFragment;
import go.faddy.hmrsystem.ui.popup.DeletePopUp;
import go.faddy.hmrsystem.ui.popup.InsertPopUp;
import go.faddy.hmrsystem.ui.popup.UpdatePopUp;

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
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}