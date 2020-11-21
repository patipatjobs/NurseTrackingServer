package com.mysoso.nursetrackingserver

import android.content.Context
import android.util.Log
import org.eclipse.paho.android.service.MqttAndroidClient
import org.eclipse.paho.client.mqttv3.*

class MQTTHelper(private val mContext: Context) {

    lateinit var mqttAndroidClient: MqttAndroidClient
    val serverUriFWG = "tcp://10.32.11.94:1883"
    val serverUriHome = "tcp://192.168.1.51:1883"
    val serverUriLong = "tcp://192.168.43.129:1883"
    val serverUri = serverUriFWG
    private val clientId = "ExampleAndroidClient"
    private val Topic = "Phyathai"
    private val Ward = "Ward1"
    private val subscriptionTopic = Topic + '/' + Ward + '/' + "Client"
    private val subscriptionTopic2 = Topic + '/' + Ward
    var publishTopicServer = subscriptionTopic2 + '/' + "Server"
    var publishTopicDashboard = subscriptionTopic2 + '/' + "Dashboard"
    private val username = ""
    private val password = ""

    fun init() {
        mqttAndroidClient = MqttAndroidClient(mContext, serverUri, clientId)
        mqttAndroidClient.setCallback(object : MqttCallbackExtended {
            override fun connectComplete(b: Boolean, s: String) {
                Log.w("MQTT connectComplete", s)
            }

            override fun connectionLost(throwable: Throwable) {
                Log.d("MQTT connectionLost","Disconnect")
            }

            @Throws(Exception::class)
            override fun messageArrived(topic: String, mqttMessage: MqttMessage) {
                Log.d("Mqtt messageArrived", mqttMessage.toString())
            }

            override fun deliveryComplete(iMqttDeliveryToken: IMqttDeliveryToken) {

            }
        })
        connect()
    }

    fun setCallback(callback: MqttCallbackExtended) {
        mqttAndroidClient.setCallback(callback)
    }

    private fun connect() {
        val mqttConnectOptions = MqttConnectOptions()
        mqttConnectOptions.isAutomaticReconnect = true
        mqttConnectOptions.isCleanSession = false
        //mqttConnectOptions.userName = username
        //mqttConnectOptions.password = password.toCharArray()

        try {

            mqttAndroidClient.connect(mqttConnectOptions, null, object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken) {

                    val disconnectedBufferOptions = DisconnectedBufferOptions()
                    disconnectedBufferOptions.isBufferEnabled = true
                    disconnectedBufferOptions.bufferSize = 100
                    disconnectedBufferOptions.isPersistBuffer = false
                    disconnectedBufferOptions.isDeleteOldestMessages = false
                    mqttAndroidClient.setBufferOpts(disconnectedBufferOptions)
                    subscribeToTopic()
                }

                override fun onFailure(asyncActionToken: IMqttToken, exception: Throwable) {
                    Log.w("Mqtt", "Failed to connect to: " + serverUri + exception.toString())
                }
            })

        } catch (ex: MqttException) {
            ex.printStackTrace()
        }

    }

    private fun subscribeToTopic() {
        try {
            mqttAndroidClient.subscribe(subscriptionTopic, 0, null, object : IMqttActionListener {
                override fun onSuccess(asyncActionToken: IMqttToken) {
                    Log.w("Mqtt", subscriptionTopic+ " Subscribed!")
                }

                override fun onFailure(asyncActionToken: IMqttToken, exception: Throwable) {
                    Log.w("Mqtt", "Subscribed fail!")
                }
            })

        } catch (ex: MqttException) {
            System.err.println("Exceptionst subscribing")
            ex.printStackTrace()
        }
    }

    fun publishJson(type:String,valor: String){
        var message = MqttMessage(valor.toByteArray())
        var topic = ""
        if(type=="dashboard"){
            topic = "Phyathai/Ward1/Dashboard"
        }else if(type=="server"){
            topic = "Phyathai/Ward1/Server"
        }
        mqttAndroidClient.publish(topic, message)
        Log.d("mqtt server Publish "+topic.toString(),message.toString() )
    }

}