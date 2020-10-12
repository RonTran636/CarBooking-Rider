package com.carbooking.rider.services

import com.carbooking.rider.utils.Common
import com.carbooking.rider.utils.UserUtils
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.util.*

class MyMessagingService : FirebaseMessagingService(){
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        if (FirebaseAuth.getInstance().currentUser!=null){
            UserUtils.updateToken(this, token)
        }
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        val data = remoteMessage.data
        if (data !=null){
            Common.showNotification(this, Random().nextInt(),
            data[Common.NOTI_TITLE],
            data[Common.NOTI_BODY],
            null)
        }
    }
}