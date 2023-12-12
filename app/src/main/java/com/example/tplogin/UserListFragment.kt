package com.example.tplogin

import android.os.Bundle
import android.util.Log.i
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tplogin.data.UserEntity
import com.example.tplogin.databinding.FragmentUsersListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class UserListFragment : Fragment() {

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding =
            FragmentUsersListBinding.inflate(layoutInflater, container, false)
        myData(binding)

        return binding.root}


    private fun myData(binding: FragmentUsersListBinding) {

        val txt = binding.textView2

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<UserEntity>?> {
            override fun onResponse(
                call: Call<List<UserEntity>?>,
                response: Response<List<UserEntity>?>
            ) {
                val myStringBuilder = StringBuilder()
                val responseBody = response.body()!!

                for (i in responseBody) {
                    myStringBuilder.append(i.id)
                    myStringBuilder.append("\n")
                }

                txt.text = myStringBuilder

            }
            override fun onFailure(call: Call<List<UserEntity>?>, t:
            Throwable) {
                i("erreur api", t.message.toString())
            }
        }
        )



    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}