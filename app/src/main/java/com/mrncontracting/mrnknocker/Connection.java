package com.mrncontracting.mrnknocker;

import android.os.AsyncTask;
import android.util.Log;

import com.mrncontracting.mrnknocker.dtos.*;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by Alyssa on 4/30/2016.
 */
public class Connection  extends AsyncTask<Object, Void, Void>{

    public Object result;
    public List results;

    @Override
    protected Void doInBackground(Object... params) {
        //param1 = token, param2 = returnobjecttypeid, param3=methodname, param4=boolean if something is sent

        GsonBuilder gsonB = new GsonBuilder();
                gsonB.enableComplexMapKeySerialization()
                .serializeNulls()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .setVersion(1.0);
        Gson gson = gsonB.create();
        String json = gson.toJson(params[0]);

        Integer intResult = 0;
        HttpURLConnection urlConnection;
        //StringBuilder result = new StringBuilder();

        String returnString = "";

        try {
            StringBuilder sb = new StringBuilder();
            sb.append("http://services.mrncontracting.com/MRNNexus_Service.svc/");
            sb.append(params[2]);

            String httpConnect = sb.toString();
            Log.d("TRAFFIC", "Post to: " + httpConnect);

            URL url = new URL(httpConnect);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput((boolean)params[3]);
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Accept", "application/json");
            //urlConnection.setRequestProperty("Content-Length", "" + Integer.toString(json.getBytes().length));
            urlConnection.setUseCaches(false);
            urlConnection.setConnectTimeout(100000);
            urlConnection.setReadTimeout(100000);

            urlConnection.connect();

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(urlConnection.getOutputStream());
            outputStreamWriter.write(json);
            outputStreamWriter.close();

            int statusCode = urlConnection.getResponseCode();
            Log.d("TRAFFIC", "StatusCode: " + statusCode);
            if (statusCode == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
                String line;
                sb.setLength(0);    // clear stringbuilder
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                returnString = sb.toString();

                /*BEGINNING DESERIALIZATION*/
                if((int)params[1] < 7)
                    result = gson.fromJson(returnString, getType((int)params[1]));
                else{
                    results = gson.fromJson(returnString, getType((int)params[1]));
                }
                System.out.print("");


            } else {
                intResult = 0; //"Failed to fetch data!";
                returnString = "";
            }

        } catch (Exception ex) {

            Log.d("TRAFFIC", "JSON Post ERROR: " + ex.toString());
            returnString = "";
        }

        return null;
    }

    private Type getType(int num){
        Type t = null;
        switch(num){
            case 1:
                return DTO_Employee.class;
            case 2:
                return DTO_CalendarData.class;
            case 3:
                return DTO_KnockerResponse.class;
            case 4:
                return DTO_Customer.class;
            case 5:
                return DTO_Address.class;
            case 6:
                return DTO_Lead.class;
            case 7:
                return new TypeToken<List<DTO_Employee>>(){}.getType();
            case 8:
                return new TypeToken<List<DTO_LU_KnockResponseType>>(){}.getType();

            default:
                t =  null;
        }

        return t;
    }
}
