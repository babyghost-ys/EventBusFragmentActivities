package com.winandmac.eventbusfragmentactivities.fragments

import android.media.metrics.Event
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.winandmac.eventbusfragmentactivities.CustomMessageEvent
import com.winandmac.eventbusfragmentactivities.R
import com.winandmac.eventbusfragmentactivities.databinding.FragmentSubscriberABinding
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class SubscriberAFragment : Fragment(R.layout.fragment_subscriber_a) {

    private lateinit var binding: FragmentSubscriberABinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSubscriberABinding.bind(view)
    }

    // EventBus - Subscribe to the event
    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    // EventBus - Unsubscribe from the event
    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    // EventBus - Receive the event
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: CustomMessageEvent) {
        binding.textOutput.text = event.message
    }
}