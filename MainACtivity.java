package com.example.user.test;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.os.Parcelable;

import android.widget.ListView;

import java.lang.Object;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AbsListView;
import android.widget.ListView;
import java.lang.Object;

import java.util.concurrent.LinkedBlockingQueue;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;
import java.io.*;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import android.view.MotionEvent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;

public class MainACtivity extends  AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private static LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue<String>();

    String str = "room";
    TextView test;
    GestureDetectorCompat gestureDetector;
    TextView textResponse;
    EditText editTextAddress, editTextPort;
    Button buttonConnect, buttonClear, buttonDisconnect, head, lhand, rhand, lleg, rleg, b_head, b_lhand, b_rhand, b_lleg, b_rleg;
    Socket socket = null;

    //  ByteArrayOutputStream byteArrayOutputStream =
    //         new ByteArrayOutputStream(1024);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        test = (TextView) findViewById(R.id.test);
        editTextAddress = (EditText)findViewById(R.id.address);
        //editTextPort = (EditText)findViewById(R.id.port);
        buttonConnect = (Button)findViewById(R.id.connect);
        buttonClear = (Button) findViewById(R.id.clear);
        buttonDisconnect = (Button) findViewById(R.id.disconnect);
        head = (Button) findViewById(R.id.head);
        b_head = (Button) findViewById(R.id.b_head);
        lhand = (Button) findViewById(R.id.lhand);
        b_lhand = (Button) findViewById(R.id.b_lhand);
        rhand = (Button) findViewById(R.id.rhand);
        b_rhand = (Button) findViewById(R.id.b_rhand);
        lleg = (Button) findViewById(R.id.lleg);
        b_lleg = (Button) findViewById(R.id.b_lleg);
        rleg = (Button) findViewById(R.id.rleg);
        b_rleg = (Button) findViewById(R.id.b_rleg);
        textResponse = (TextView) findViewById(R.id.response);
        textResponse = (TextView) findViewById(R.id.response);

        this.gestureDetector = new GestureDetectorCompat(this, (GestureDetector.OnGestureListener) this);
        gestureDetector.setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) this);


        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textResponse.setText("");
            }
        });

        b_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    lbq.put("long_1_1");
                } catch (InterruptedException i) {
                    i.printStackTrace();
                }
            }
        });

        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    lbq.put("double_1_1");
                } catch (InterruptedException i) {
                    i.printStackTrace();
                }
            }
        });

        b_lhand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    lbq.put("long_2_2");
                } catch (InterruptedException i) {
                    i.printStackTrace();
                }
            }
        });

        lhand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    lbq.put("double_2_2");
                } catch (InterruptedException i) {
                    i.printStackTrace();
                }
            }
        });


        b_rhand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    lbq.put("long_3_3");
                } catch (InterruptedException i) {
                    i.printStackTrace();
                }
            }
        });

        rhand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    lbq.put("double_3_3");
                } catch (InterruptedException i) {
                    i.printStackTrace();
                }
            }
        });

        b_lleg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    lbq.put("long_4_4");
                } catch (InterruptedException i) {
                    i.printStackTrace();
                }
            }
        });

        lleg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    lbq.put("double_4_4");
                } catch (InterruptedException i) {
                    i.printStackTrace();
                }
            }
        });

        b_rleg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    lbq.put("long_5_5");
                } catch (InterruptedException i) {
                    i.printStackTrace();
                }
            }
        });

        rleg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    lbq.put("double_5_5");
                } catch (InterruptedException i) {
                    i.printStackTrace();
                }
            }
        });



        buttonDisconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });

        buttonConnect.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v) {
             MyClientTask myClientTask = new MyClientTask(
                editTextAddress.getText().toString(),8000);
        myClientTask.execute();
        }});
    }

    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public boolean onSingleTapConfirmed(MotionEvent e){
        int x = (int)e.getX();
        int y = (int)e.getY();
        test.setText("single tap " + x + " " + y);
        try {
            lbq.put("single_ " + x + "_" + y);
        } catch (InterruptedException i) {
            i.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        int x = (int)e.getX();
        int y = (int)e.getY();
        test.setText("OnDoubleTap");
        try {
            lbq.put("double_ "+ x + "_" + y);
        } catch (InterruptedException i) {
            i.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        int x1 = (int)e1.getX();
        int y1 = (int)e1.getY();
        int x2 = (int)e2.getX();
        int y2 = (int)e2.getY();
        test.setText("scroll");
        try {
            lbq.put("scroll_" + x1 + "_" + y1 + "_" + x2 + "_" + y2);
        } catch (InterruptedException i) {
            i.printStackTrace();
        }
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        int x = (int)e.getX();
        int y = (int)e.getY();
        test.setText("onLongPress");
        try {
            lbq.put("long_" + x + "_" + y);
        } catch (InterruptedException i) {
            i.printStackTrace();
        }
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        test.setText("OnDoubleTapEvent");
        return true;
    }
    @Override
    public boolean onDown(MotionEvent e) {
        test.setText("onDown");
        try {
            lbq.put("down");
        } catch (InterruptedException i) {
            i.printStackTrace();
        }
        return true;
    }
    @Override
    public void onShowPress(MotionEvent e) {
        test.setText("onShowPress");
    }
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        test.setText("onSingleTapUp");
        return true;
    }
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        test.setText("onFling");
        try {
            lbq.put("fling" );
        } catch (InterruptedException i) {
            i.printStackTrace();
        }
        return true;
    }

    public class MyClientTask extends AsyncTask<Void, Void, Void> {

    String dstAddress;
    int dstPort;
    String response = "";

    MyClientTask(String addr, int port){
        dstAddress = addr;
        dstPort = port;
    }

    @Override
    protected Void doInBackground(Void... arg0) {
        try {
            socket = new Socket(dstAddress, dstPort);
            OutputStream output = socket.getOutputStream();
            str = "play";
            //InputStream input = socket.getInputStream();
        while(true) {
            String s = lbq.take();
            output.write(s.getBytes());
        }
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response = "UnknownHostException: " + e.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response = "IOException: " + e.toString();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    //finally{
           //if(socket != null){
              //try {
            //     socket.close();
            //} catch (IOException e) {
               // TODO Auto-generated catch block
            //  e.printStackTrace();
          //}
        //}
        //}
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        textResponse.setText(response);
        super.onPostExecute(result);
    }
}


}


