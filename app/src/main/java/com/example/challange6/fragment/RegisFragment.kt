package com.example.challange6.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.challange6.R
import com.google.firebase.auth.FirebaseAuth

AndroidEntryPoint
class RegisFragment : Fragment() {
    lateinit var binding: FragmentRegisBinding
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var pref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pref = requireContext().getSharedPreferences("dataregistrasi", Context.MODE_PRIVATE)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnRegis.setOnClickListener {
            registAccount()
        }
    }

    private fun registAccount() {
        val username = binding.etNama.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPw.text.toString()

        val regist = pref.edit()
        regist.putString("username", username)
        regist.putString("email", email)
        regist.putString("password", password)
        regist.apply()

        if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(context, "Registration Success", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_regisFragment_to_loginFragment)
                } else {
                    Toast.makeText(context, "Data tidak sesuai", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}