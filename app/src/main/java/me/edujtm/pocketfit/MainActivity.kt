package me.edujtm.pocketfit

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import me.edujtm.pocketfit.databinding.ActivityMainBinding
import me.edujtm.pocketfit.di.components.MainActivityComponent
import me.edujtm.pocketfit.di.components.MainActivityComponentProvider
import me.edujtm.pocketfit.platform.injector

class MainActivity : AppCompatActivity(), MainActivityComponentProvider {

    override val activityInjector: MainActivityComponent by lazy {
        injector.mainActivityInjector.create()
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_exercises, R.id.navigation_last_workouts, R.id.navigation_progress
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}