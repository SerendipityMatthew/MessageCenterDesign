package com.xuwanjin.messagecenterlib.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.xuwanjin.messagecenterlib.repository.BaseMessageRepository

class MessageCenterViewModel(
    private val repository:BaseMessageRepository,
    private val savedStateHandle: SavedStateHandle
): ViewModel(){
}