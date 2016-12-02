package vpn.connect.manager;


import android.app.Activity;
import android.content.Intent;
import android.net.VpnService;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

public class SolarVpnClient extends Activity implements View.OnClickListener {
    private TextView mServerAddress;
    private TextView mServerPort;
    private TextView mSharedSecret;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        mServerAddress = (TextView) findViewById(R.id.address);
        mServerPort = (TextView) findViewById(R.id.port);
        mSharedSecret = (TextView) findViewById(R.id.secret);

        findViewById(R.id.connect).setOnClickListener(this);
        findViewById(R.id.disconnect).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    	
    	
switch (v.getId() /*to get clicked view id**/) {
    	
        case R.id.connect:
        	// do something when the connect is clicked
        	Intent intent = VpnService.prepare(this);
            if (intent != null) {
                startActivityForResult(intent, 0);
            } else {
                onActivityResult(0, RESULT_OK, null);
            }

            
            break;
            
        

        case R.id.disconnect:
        	
        	
        	
        		Toast.makeText(this, "Disconnect function not yet Coded!", Toast.LENGTH_SHORT).show();
            	
        		// Disconnect function not yet Coded!
        		// it should be similar to onDestroy
        		/*  
        		    public void onDestroy() {
        		        if (mThread != null) {
        		            mThread.interrupt();
        		        }
        		 	}
        		 */
        		
        		
        	
        	
            break;
        
    	}
    	
    	
    	
    	
    	
        
    }

    @Override
    protected void onActivityResult(int request, int result, Intent data) {
        if (result == RESULT_OK) {
            String prefix = getPackageName();
            Intent intent = new Intent(this, SolarVpnService.class)
                    .putExtra(prefix + ".ADDRESS", mServerAddress.getText().toString())
                    .putExtra(prefix + ".PORT", mServerPort.getText().toString())
                    .putExtra(prefix + ".SECRET", mSharedSecret.getText().toString());
            startService(intent);
        }
    }
}
    	
    	
