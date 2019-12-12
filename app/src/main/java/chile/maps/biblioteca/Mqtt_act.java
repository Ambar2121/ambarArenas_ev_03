package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Mqtt_act extends AppCompatActivity {

    static String MQTTHOST = "tcp://tailor.cloudmqtt.com:13803";
    static String USERNAME = "brppdqye";
    static String PASSWORD = "8yMPboY4pd8i";
    String topicStr = "LED";
    MqttAndroidClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqtt_act);

        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(this.getApplicationContext(), MQTTHOST, clientId );
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(USERNAME);
        options.setPassword(PASSWORD.toCharArray());

        try {
            IMqttToken token = client.connect(options);
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected
                    Toast.makeText(getBaseContext(),"SE HA CONECTADO", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    // Something went wrong e.g. connection timeout or firewall problems
                    Toast.makeText(getBaseContext(),"NO SE HA ESTABLECIDO LA CONEXIÓN", Toast.LENGTH_LONG).show();

                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void TextUno(View view){

        String topic = topicStr;
        String message = "Libro Revival";
        try {
            client.publish(topic, message.getBytes(),0,false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void TextDos(View view){

        String topic = topicStr;
        String message = "Libro Farenheit";
        try {
            client.publish(topic, message.getBytes(),0,false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void TextTres(View view){

        String topic = topicStr;
        String message = "Libro El alquimista";
        try {
            client.publish(topic, message.getBytes(),0,false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void TextCuatro(View view){

        String topic = topicStr;
        String message = "Libro El poder";
        try {
            client.publish(topic, message.getBytes(),0,false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public void TextCinco(View view){

        String topic = topicStr;
        String message = "Libro El despertar";
        try {
            client.publish(topic, message.getBytes(),0,false);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
