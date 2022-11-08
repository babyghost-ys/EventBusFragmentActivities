package com.winandmac.eventbusfragmentactivities.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.winandmac.eventbusfragmentactivities.CustomMessageEvent
import com.winandmac.eventbusfragmentactivities.R
import com.winandmac.eventbusfragmentactivities.databinding.FragmentSubscriberBBinding
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class SubscriberBFragment : Fragment(R.layout.fragment_subscriber_b) {

    private lateinit var binding: FragmentSubscriberBBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSubscriberBBinding.bind(view)
    }

    // EventBus - Subscribe to the event
    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    // EventBus - Unsubscribe from the event
    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    // EventBus - Receive the event
    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: CustomMessageEvent) {
        binding.textOutputAnother.text = event.message
    }
}