package dev.nibirugamer.thealteningapi;

import net.sf.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class Example {
/**
 *
 * @author https://nibirugamer.dev
 * @created 22/12/2021 - 19:42
 */
public static void main(String[] args) {
    String apikey = "";
    try {
        URL url = new URL("http://api.thealtening.com/v2/generate?key=" + apikey + "&info=true");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        if(conn.getResponseCode() == 200) {
            Scanner scan = new Scanner(url.openStream());
            while(scan.hasNext()) {
                String temp = scan.nextLine();
                JSONObject jsonObject = JSONObject.fromObject(temp);
                String tokenfromapi = (String) jsonObject.get("token");
                System.out.println(tokenfromapi);
                scan.close();
            }
        }

    } catch (ProtocolException e) {
        e.printStackTrace();
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();

    }

}


}
