package com.ics115_project.cookbook.functions;

import android.app.AlertDialog;
import android.content.Context;
import android.icu.util.Output;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class register_function extends AsyncTask <String,Void,String> {

    Context context;
    public register_function(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... voids) {
        String result = "";
        String username = voids[0];
        String firstname = voids[1];
        String lastname = voids[2];
        String password = voids[3];
        String phonenumber = voids[4];
        String email = voids[5];

        String link = "http://192.168.1.4/android_api/register_user.php";

        try {
            URL url = new URL(link);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops, "UTF-8"));
            String data =   URLEncoder.encode("username","UTF-8") + "=" + URLEncoder.encode(username,"UTF-8") + "&&" +
                            URLEncoder.encode("firstname","UTF-8") + "=" + URLEncoder.encode(firstname,"UTF-8") + "&&" +
                            URLEncoder.encode("lastname","UTF-8") + "=" + URLEncoder.encode(lastname,"UTF-8") + "&&" +
                            URLEncoder.encode("password","UTF-8") + "=" + URLEncoder.encode(password,"UTF-8") + "&&" +
                            URLEncoder.encode("phonenumber","UTF-8") + "=" + URLEncoder.encode(phonenumber,"UTF-8") + "&&" +
                            URLEncoder.encode("email","UTF-8") + "=" + URLEncoder.encode(email,"UTF-8");

            writer.write(data);
            writer.flush();
            writer.close();
            ops.close();

            InputStream ips = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips,"ISO-8859-1"));
            String line = "";
            while((line = reader.readLine()) != null){
                result += line;
            };

            reader.close();
            ips.close();
            http.disconnect();
            return result;
        } catch (MalformedURLException e) {
            result = e.getMessage();
        }catch (IOException e) {
            result = e.getMessage();
        }

        return result;
    }
}
