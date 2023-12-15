package com.aktivo.framework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class QaTouchApiClient {
    public static String QA_TOUCH_API_TOKEN = "1f1778927a9e168863c4c21feb90c40fa7795be170d2c6de65c20199b5a473d5";
    public static String QA_TOUCH_DOMAIN = "aktivolabs";
    private static final String API_BASE_URL = "https://api.qatouch.com/api/v1/";


    public static void addTestRunStatus(String test_run, String project, String run_result,String newStatus, String newComments) {
        String s=  "{\"0\":{\"case\":\"CASE\",\"status\":\"value\"}}".replaceAll("CASE",run_result);
        String s1= s.replaceAll("value",newStatus);
        String addResultUrl =API_BASE_URL + "testRunResults/status/multiple?"+ "project=" + project + "&" + "test_run=" + test_run + "&" + "result=" + s1 + "&" + "comments=" + newComments;
        String addResult = addTestResults(QA_TOUCH_API_TOKEN, QA_TOUCH_DOMAIN, addResultUrl);
    }

    public static String addTestResults(String apiToken, String domain, String addResultUrl) {
        try {
            URL urlObj = new URL(addResultUrl);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.setRequestProperty("X-HTTP-Method-Override", "PATCH");
            connection.setRequestMethod("POST");
            connection.setRequestProperty("api-token", apiToken);
            connection.setRequestProperty("domain", domain);
            connection.setRequestProperty("url", addResultUrl);
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                System.out.println("response:"+response);
                return response.toString();

            } else {
                return "Error: " + responseCode;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

}
