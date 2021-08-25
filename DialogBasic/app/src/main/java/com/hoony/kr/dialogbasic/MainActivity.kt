package com.hoony.kr.dialogbasic

import android.app.DatePickerDialog
import android.app.ProgressDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TimePicker
import androidx.appcompat.app.AlertDialog
import com.hoony.kr.dialogbasic.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var pro:ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("기본 다이얼로그")
            builder.setMessage("다이얼로그의 본문입니다")
            builder.setIcon(R.mipmap.ic_launcher)

            var listener = object:DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    when(which) {
                        DialogInterface.BUTTON_POSITIVE ->
                            binding.textView.text = "기본 다이얼로그 : Positive"
                        DialogInterface.BUTTON_NEUTRAL ->
                            binding.textView.text = "기본 다이얼로그 : Neutral"
                        DialogInterface.BUTTON_NEGATIVE ->
                            binding.textView.text = "기본 다이얼로그 : Negative"
                    }
                }
            }

            builder.setPositiveButton("Positive", listener)
            builder.setNeutralButton("Neutral", listener)
            builder.setNegativeButton("Negative", listener) // 보통 취소버튼은 리스너가 필요없다.

            builder.show()
        }

        binding.button2.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("커스텀 다이얼로그")
            builder.setIcon(R.mipmap.ic_launcher)

            var v1 = layoutInflater.inflate(R.layout.dialog, null)
            builder.setView(v1)

            var listener = object:DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    var alert = dialog as AlertDialog
                    var edit1: EditText? = alert.findViewById<EditText>(R.id.editText1)
                    var edit2: EditText? = alert.findViewById<EditText>(R.id.editText2)

                    binding.textView.text = "edit1 : ${edit1?.text}\n"
                    binding.textView.append("edit2 : ${edit2?.text}")

                }
            }
            builder.setPositiveButton("확인", listener)
            builder.setNegativeButton("취소", null)

            builder.show()
        }

        binding.button3.setOnClickListener {
            var calendar = Calendar.getInstance()
            var year = calendar.get(Calendar.YEAR)
            var month = calendar.get(Calendar.MONTH)
            var day = calendar.get(Calendar.DAY_OF_MONTH)

            var listener = object: DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    binding.textView.text = "${year}년 ${month + 1}월 ${dayOfMonth}일"
                }
            }

            var picker = DatePickerDialog(this, listener, year, month, day)
            picker.show()
       }

        binding.button4.setOnClickListener {
            var calendar = Calendar.getInstance()
            var hour = calendar.get(Calendar.HOUR)
            var minute = calendar.get(Calendar.MINUTE)

            var listener = object:TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                    binding.textView.text = "${hourOfDay}시 ${minute}분"
                }
            }

            var picker = TimePickerDialog(this, listener, hour, minute, false)
            picker.show()
        }

        binding.button5.setOnClickListener {
            pro = ProgressDialog.show(this, "타이틀입니다", "메시지입니다")

            var handler = Handler()
            var thread = object:Runnable {
                override fun run() {
                    pro?.cancel()
                }
            }
            handler.postDelayed(thread, 5000)
        }
    }
}