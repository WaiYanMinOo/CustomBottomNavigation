package com.myexample.custombottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.myexample.custombottomnavigation.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var bottomBar: BottomNavigationView
    private lateinit var frameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomBar = findViewById(R.id.bottomNavigation)
        frameLayout = findViewById(R.id.containerLayout)

        setFragment(HomeFragment())

        //bottomBar.inflateMenu(R.menu.nav_bar_items)
        //app:menu="@menu/nav_bar_items"
        //the above two usages are same, we can use one way to show menu items on Bottom Navigation View.
        //When our app has user-roles condition, we should use the first way.
        bottomBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    setFragment(HomeFragment())
                    Toast.makeText(applicationContext, "I am home!", Toast.LENGTH_SHORT).show()
                    bottomBar.itemBackgroundResource = R.color.colorAccent
                }
                R.id.nav_pizza -> {
                    setFragment(PizzaFragment())
                    Toast.makeText(applicationContext, "I am pizza!", Toast.LENGTH_SHORT).show()
                    bottomBar.itemBackgroundResource = R.color.colorPrimaryDark
                }
                R.id.nav_gallery -> {
                    setFragment(GalleryFragment())
                    Toast.makeText(applicationContext, "I am gallery!", Toast.LENGTH_SHORT).show()
                    bottomBar.itemBackgroundResource = R.color.colorPrimary
                }
                R.id.nav_camera -> {
                    setFragment(CameraFragment())
                    Toast.makeText(applicationContext, "I am camera!", Toast.LENGTH_SHORT).show()
                    bottomBar.itemBackgroundResource = R.color.colorPrimaryDark
                }
                R.id.nav_transport -> {
                    setFragment(TransportFragment())
                    Toast.makeText(applicationContext, "I am taxi!", Toast.LENGTH_SHORT).show()
                    bottomBar.itemBackgroundResource = R.color.colorAccent
                }
            }
            true
        }
    }

    private fun setFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
        transaction.replace(R.id.containerLayout, fragment)
        transaction.commit()
    }
}
