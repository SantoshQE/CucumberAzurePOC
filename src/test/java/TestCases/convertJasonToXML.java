package TestCases;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class convertJasonToXML
{
    public static void main(String[] args) throws IOException {
        String reportXmlPath = System.getProperty("user.dir") + "\\target\\cucumber-reports\\Cucumber.json";
        String exampleRequest = FileUtils.readFileToString(new File(reportXmlPath), StandardCharsets.UTF_8);
        //System.out.println(exampleRequest.length());
        exampleRequest = exampleRequest.substring(2,exampleRequest.length()-1);
        System.out.println(exampleRequest);
      //  System.out.println(exampleRequest);
        String str = exampleRequest;
        //Convert JSON to XML
        String xml = convert(str, "testsuite"); // This method converts json object to xml string
        System.out.println(xml);
    }
    public static String convert(String json, String testsuite) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<"+testsuite+">" + XML.toString(jsonObject) + "</"+testsuite+">";
        return xml;
    }
}
