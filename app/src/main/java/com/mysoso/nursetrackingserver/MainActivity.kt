package com.mysoso.nursetrackingserver

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.gson.GsonBuilder

import com.mysoso.nursetrackingserver.services.mqtt.MqttFun
import org.eclipse.paho.android.service.MqttAndroidClient
import java.io.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var mqttHelper: MQTTHelper
    private lateinit var mqttAndroidClient: MqttAndroidClient

    private var DatetimeServer: String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
    private var gson = GsonBuilder().setPrettyPrinting().create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //
//        val filename = "myfile.json"
//        val file = File(filesDir, "myfile.json")
//        val fileContents = "Hi Hi"
//        this.openFileOutput(filename, Context.MODE_PRIVATE).use {
//            it.write(fileContents.toByteArray())
//        }
        //

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_server), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        //
        MQTTStart()
        //
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    fun delayTime(){
        val mainHandler = Handler(Looper.getMainLooper())
        mainHandler.post(object : Runnable {
            override fun run() {
                val JsonRoomList = readAsset("room_list.json")
                mainHandler.postDelayed(this, 10000)
            }
        })
    }

    fun readAsset(s: String): String = applicationContext.assets.open(s).bufferedReader().use(BufferedReader::readText)

    fun MQTTStart(){
        mqttHelper = MQTTHelper(applicationContext)
        val JsonAndroidbox = readAsset("androidbox.json")
        val JsonBrand = readAsset("brand.json")
        val JsoniTAGList = readAsset("itag_list.json")
        val JsonRoomList = readAsset("room_list.json")
        val JsonLayout = readAsset("layout.json")
        val array : ArrayList<String> = ArrayList()
        array.add(JsonAndroidbox)
        array.add(JsonBrand)
        array.add(JsoniTAGList)
        array.add(JsonRoomList)
        array.add(JsonLayout)
        MqttFun(applicationContext).startMqtt(mqttHelper,array)

    }

}

//        val SettingRegisterBrandEntity = SettingRegisterBrandEntity()
//        SettingRegisterBrandEntity.title = "Hi"
//        SettingRegisterBrandEntity.distance = -25
//        var phyathaiDatabase = PhyathaiDatabase.getDatabase(MainActivity@this)
//        GlobalScope.launch {
//            phyathaiDatabase?.SettingRegisterBrandDao()?.insertBrand(SettingRegisterBrandEntity)
//            val eee = phyathaiDatabase?.SettingRegisterBrandDao()?.getAll()
//            Log.d("Dao",eee.toString())
//        }

//        SettingRegisterBrandFunc().Insert(MainActivity@this,"iTAG",-72)