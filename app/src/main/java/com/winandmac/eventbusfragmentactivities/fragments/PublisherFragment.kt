package com.winandmac.eventbusfragmentactivities.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.winandmac.eventbusfragmentactivities.CustomMessageEvent
import com.winandmac.eventbusfragmentactivities.R
import com.winandmac.eventbusfragmentactivities.databinding.FragmentPublisherBinding
import org.greenrobot.eventbus.EventBus


class PublisherFragment : Fragment(R.layout.fragment_publisher) {

    private lateinit var binding: FragmentPublisherBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPublisherBinding.bind(view)
        binding.notifyButton.setOnClickListener{
            val messageToSend = binding.inputMessage.text.toString()
            val messageEventToSend: CustomMessageEvent = CustomMessageEvent(messageToSend)
            EventBus.getDefault().postSticky(messageEventToSend)
        }
    }
}