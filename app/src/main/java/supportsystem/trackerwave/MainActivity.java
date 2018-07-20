package supportsystem.trackerwave;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ExpandableDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity {

    MaterialSearchView searchView;
    private Drawer resultAppended = null;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbarMain);
        toolbar.setTitle("Support System");
        setSupportActionBar(toolbar);

        searchView = (MaterialSearchView)findViewById(R.id.search_view);

        ImageButton imageButton = (ImageButton) toolbar.findViewById(R.id.notifications);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        // Create the AccountHeader
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem().withName("TrackerWave").withEmail("Trackerwave@gmail.com").withIcon(getResources().getDrawable(R.drawable.profile))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        //if you want to update the items at a later time it is recommended to keep it in a variable
//        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Tickets");
//        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("About");


        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(toolbar)
                .withHasStableIds(true)
                .addDrawerItems(
                        new ExpandableDrawerItem().withName("Tickets").withIcon(R.drawable.ic_tickets).withIdentifier(1).withSubItems(
                                new SecondaryDrawerItem().withName("Open tickets").withBadge("20").withIcon(R.drawable.ic_create_ticket_black),
                                new SecondaryDrawerItem().withName("Closed Tickets").withBadge("35").withIcon(R.drawable.ic_closed_ticket),
                                new SecondaryDrawerItem().withName("Overdue Tickets").withBadge("20").withIcon(R.drawable.ic_overdue)
                        ),
                        new PrimaryDrawerItem().withName("About us").withIcon(R.drawable.ic_about).withIdentifier(2),
                        new PrimaryDrawerItem().withName("Settings").withIcon(R.drawable.ic_settings).withIdentifier(3)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        switch (position) {
                            case 1:
                                break;
                            case 2:
                                break;
                        }
                        return true;
                    }
                })
                .build();

//        resultAppended = new DrawerBuilder()
//                .withActivity(this)
//                .withDisplayBelowStatusBar(true)
//                .withSavedInstance(savedInstanceState)
//                .addDrawerItems(
//                        new SectionDrawerItem().withName("Notifications").withTextColor(R.color.red_500)
//                )
//                .withDrawerGravity(Gravity.END)
//                .append(result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu_item,menu);
       MenuItem item =  menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        return true;
    }
}
