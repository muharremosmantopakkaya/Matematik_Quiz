package com.example.mathmagic

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.mathmagic.databinding.ActivityPlayBinding

class PlayActivity : AppCompatActivity() {
    private var binding: ActivityPlayBinding? = null
    private var position = 0
    private var timer: CountDownTimer? = null
    private var timeGiven = 0
    private var score = 0
    private var questionDataList = ArrayList<Question>(10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val questionType = intent.getStringExtra("questionType")
        questionDataList = QuestionList(questionType).getQuestionsList()

        updateHorizontalProgressBar()
        updateQuestion()
        updateOption()
        setGivenTime(questionType)
        startTimer()

        binding?.btnOption1?.setOnClickListener {
            onSelectOption(binding?.btnOption1?.text.toString())
        }
        binding?.btnOption2?.setOnClickListener {
            onSelectOption(binding?.btnOption2?.text.toString())
        }
        binding?.btnOption3?.setOnClickListener {
            onSelectOption(binding?.btnOption3?.text.toString())
        }
        binding?.btnOption4?.setOnClickListener {
            onSelectOption(binding?.btnOption4?.text.toString())
        }
    }

    override fun onBackPressed() {
        endGame()
    }

    private fun updateQuestion()
    {
        binding?.tvQuestion?.text = questionDataList[position].problem
    }
    private fun updateOption()
    {
        binding?.btnOption1?.text = questionDataList[position].option1
        binding?.btnOption2?.text = questionDataList[position].option2
        binding?.btnOption3?.text = questionDataList[position].option3
        binding?.btnOption4?.text = questionDataList[position].option4
    }

    private fun updateHorizontalProgressBar()
    {
        binding?.horizontalProgressBar?.incrementProgressBy(1)
    }

    private fun setGivenTime(level:String?)
    {
        timeGiven = when(level)
        {
            "easy"-> 10000
            "medium"-> 12000
            else-> 15000
        }
    }

    private fun startTimer()
    {
        var count = timeGiven/900
        binding?.circularProgressBar?.progress = timeGiven/900
        binding?.circularProgressBar?.max = timeGiven/900
        timer = object : CountDownTimer(timeGiven.toLong(),900)
        {
            override fun onTick(p0: Long) {
                binding?.circularProgressBar?.incrementProgressBy(-1)
                count--
                binding?.tvCountDown?.text = count.toString()
            }

            override fun onFinish() {
                setNextRound()
            }

        }.start()
    }

    private fun onSelectOption(option:String)
    {
        if (option == questionDataList[position].answer)
            score++
        questionDataList[position].selectedOption = option.toString()
        setNextRound()
    }
    private fun setNextRound()
    {
        if (position<9) {
            position++
            timer?.cancel()
            timer = null
            updateHorizontalProgressBar()
            startTimer()
            updateQuestion()
            updateOption()
        }
        else
            endGame()
    }

    private fun endGame()
    {
        val intent = Intent(this, FinishActivity::class.java)
        intent.putExtra("score",score)
        intent.putExtra("dataSet",questionDataList)
        startActivity(intent)
        finish()
        timer?.cancel()
        timer = null
        binding = null
    }
}