package com.vionavio.spinner


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.ListPopupWindow
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val category: MutableList<String> = ArrayList()
        category.add(0,"selected cateory")
        category.add("makan")
        category.add("mak")
        category.add("man")

        val nominalAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, category)

        nominalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter = nominalAdapter




        var selectedItemText: String = String()
        spinner1.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                selectedItemText = parent.getItemAtPosition(position) as String
                if (position > 0) {
                    Toast.makeText(applicationContext, "Selected : $selectedItemText", Toast.LENGTH_SHORT).show()
                    spinner2.isEnabled = false
                } else if(position == 0) {
                    spinner2.isEnabled = true
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        Log.d("aaaaaaa", "onCreate: $selectedItemText")

        val category2: MutableList<String> = ArrayList()
        category2.add(0,"selected cateory")
        category2.add("makan")
        category2.add("mak")
        category2.add("man")
        category2.add("1")
        category2.add("2")
        category2.add("4")
        category2.add("3")
        category2.add("m5an")
        category2.add("ma3n")
        category2.add("man4")
        category2.add("man3")
        category2.add("man2")
        category2.add("man1")
        category2.add("man2")
        category2.add("man11")
        category2.add("man12")

        val nominalAdapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, category2)

        nominalAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter = nominalAdapter2


        spinner2.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                try {
                    val popup = Spinner::class.java.getDeclaredField("mPopup")
                    popup.isAccessible = true

                    // Get private mPopup member variable and try cast to ListPopupWindow
                    val popupWindow = popup[spinner2] as ListPopupWindow
                    // Set popupWindow height to 500px

                    // Set popupWindow height to 500px
                    popupWindow.height = 100
                }
                catch (e: NoClassDefFoundError) {
                    // silently fail...
                } catch (e: ClassCastException) {
                } catch (e: NoSuchFieldException) {
                } catch (e: IllegalAccessException) {
                }

                val selectedItemText3 =
                    parent.getItemAtPosition(position) as String
                if (position > 0) {
                    Toast.makeText(applicationContext, "Selected : $selectedItemText3", Toast.LENGTH_SHORT).show()
                    spinner1.isEnabled = false
                } else if(position == 0) {
                    spinner1.isEnabled = true
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}