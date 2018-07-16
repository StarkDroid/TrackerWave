package supportsystem.trackerwave;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.ExpandableBadgeDrawerItem;
import com.mikepenz.materialdrawer.model.ExpandableDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity {
    private Drawer resultAppended = null;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbarMain);
        toolbar.setTitle("Trackerwave Support System");

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
                        switch (position){
                            case 1: break;
                            case 2: break;
                        }
                        return true;
                    }
                })
                .build();

        resultAppended = new DrawerBuilder()
                .withActivity(this)
                .withDisplayBelowStatusBar(true)
                .withSavedInstance(savedInstanceState)
                .addDrawerItems(
                        new SectionDrawerItem().withName("Notifications")
                )
                .withDrawerGravity(Gravity.END)
                .append(result);
    }
}
