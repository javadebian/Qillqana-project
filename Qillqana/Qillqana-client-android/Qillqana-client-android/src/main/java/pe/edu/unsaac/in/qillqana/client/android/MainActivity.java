package pe.edu.unsaac.in.qillqana.client.android;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import pe.edu.unsaac.in.qillqana.client.android.mediator.AndroidMediator;
import pe.edu.unsaac.in.qillqana.client.android.mediator.Mediator;
import pe.edu.unsaac.in.qillqana.client.android.mediator.SocketSuscriptor;
import pe.edu.unsaac.in.qillqana.client.android.mediator.UISuscriptor;

public class MainActivity extends ActionBarActivity {
    private Mediator mediator;
    private UISuscriptor uiSuscriptor;
    private SocketSuscriptor socketSuscriptor;

    private TextView txtIn;
    private TextView txtOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediator=new AndroidMediator();

        socketSuscriptor=new SocketSuscriptor(mediator);
        mediator.addSuscriptor(socketSuscriptor);
        new Thread(socketSuscriptor).start();

        txtIn=(TextView)findViewById(R.id.txtIn);
        txtOut=(TextView)findViewById(R.id.txtOut);
        uiSuscriptor=new UISuscriptor(mediator,txtIn,txtOut);
        mediator.addSuscriptor(uiSuscriptor);

        Log.i("Qillqana","Suscriptors="+mediator.size());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void btnSend_Click(View v){
        mediator.sendMessage(txtIn.getText().toString(),uiSuscriptor);
    }
    public void btnClear_Click(View v){
        txtOut.setText("");
    }
}
