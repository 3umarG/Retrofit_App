package com.example.sampleretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var tvTitle: TextView
    private lateinit var etTitle: EditText
    private lateinit var etBody: EditText
    private lateinit var etUserId: EditText
    private lateinit var btnPost: Button
    private lateinit var tvOutPut: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tvTitle = findViewById(R.id.tvTitle)
        etTitle = findViewById(R.id.etTitle)
        etBody = findViewById(R.id.etBody)
        etUserId = findViewById(R.id.etUserId)
        btnPost = findViewById(R.id.btnPost)
        tvOutPut = findViewById(R.id.tvPostOutPut)


        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val apiInterface: ApiInterface = retrofitBuilder.create(ApiInterface::class.java)


        val call: Call<Model> = apiInterface.getModel(4)

        val allCalls: Call<List<Model>> = apiInterface.getAllPosts("2")


        allCalls.enqueue(object : Callback<List<Model>> {
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
                tvTitle.text = response.body()?.get(0)?.title ?: "Not yet"
            }

            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                tvTitle.text = t.message
            }
        })


        btnPost.setOnClickListener {
            val postCall : Call<Model> = apiInterface.postModel(hashMapOf(
                "title" to etTitle.text.toString(),
                "body" to etBody.text.toString(),
                "userId" to etUserId.text.toString().toInt()
            ))

            postCall.enqueue(object : Callback<Model>{
                override fun onResponse(call: Call<Model>, response: Response<Model>) {
                    val result = "ID : ${response.body()?.id} \n" +
                            "Title : ${response.body()?.title} \n" +
                            "Body : ${response.body()?.body} \n" +
                            "User ID : ${response.body()?.userId}"
                    tvOutPut.text = result
                }

                override fun onFailure(call: Call<Model>, t: Throwable) {
                   tvOutPut.text = t.message
                }
            })


        }

    }
}