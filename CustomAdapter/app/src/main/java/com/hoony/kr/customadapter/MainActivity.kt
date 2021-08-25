package com.hoony.kr.customadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import com.hoony.kr.customadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var data = arrayOf("데이터1", "데이터2", "데이터3", "데이터4", "데이터5", "데이터6")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //var adapter = ArrayAdapter<String>(this, R.layout.row, R.id.textView2, data)
        var adapter = ListAdapter()
        binding.listView.adapter = adapter
    }

    inner class ListAdapter : BaseAdapter() {
        var listener = BtnListener()

        override fun getCount(): Int {
            return data.size
        }

        override fun getItem(position: Int): Any? {
            return null
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        /**
         * 항목 하나를 구성하기 위해 호출되는 메소드
         */
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
            var view:View? = convertView

            if(view == null) {
                view = layoutInflater.inflate(R.layout.row, null)
            }

            var text:TextView? = view?.findViewById<TextView>(R.id.textView2)
            var button1:Button? = view?.findViewById<Button>(R.id.button1)
            var button2:Button? = view?.findViewById<Button>(R.id.button2)


            button1?.setOnClickListener(listener)
            button2?.setOnClickListener(listener)
            text?.text = data[position]
            /* view 객체의 tag에 버튼객체의 index를 저장 */
            button1?.tag = position
            button2?.tag = position

            return view
        }
    }

    /**
     * 몇번째 항목인지에 대한 구분을 할수 없다   */
    inner class BtnListener : View.OnClickListener {

        override fun onClick(v: View?) {

            var position = v?.tag as Int

            when(v?.id) {
                R.id.button1 ->
                    binding.textView.text = "${position} : 첫 번째 버튼을 눌렀습니다.\n"
                R.id.button2 ->
                    binding.textView.text = "${position} : 두 번째 버튼을 눌렀습니다.\n"
            }
        }
    }
}