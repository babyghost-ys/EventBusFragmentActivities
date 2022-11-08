package com.winandmac.eventbusfragmentactivities.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.winandmac.eventbusfragmentactivities.R
import com.winandmac.eventbusfragmentactivities.databinding.FragmentSubscriberABinding

class SubscriberAFragment : Fragment(R.layout.fragment_subscriber_a) {

    private lateinit var binding: FragmentSubscriberABinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSubscriberABinding.bind(view)

    }
}