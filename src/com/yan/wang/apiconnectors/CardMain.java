package com.yan.wang.apiconnectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * Created by ywang on 17.02.15.
 */
public class CardMain {

    static private List<CreditCard> aMexList = new ArrayList<CreditCard>();
    static private List<CreditCard> dinersClubList = new ArrayList<CreditCard>();
    static private List<CreditCard> jCBList = new ArrayList<CreditCard>();
    static private List<CreditCard> masterCardList = new ArrayList<CreditCard>();
    static private List<CreditCard> visaList = new ArrayList<CreditCard>();
    static private List<CreditCard> voyagerList = new ArrayList<CreditCard>();
    static private List<CreditCard> discoverList = new ArrayList<CreditCard>();

    static String[] filePaths = new String [] {
            "/home/ywang/MyStuff/temp/APIConnectorsAllIInOne/resources/AmericanExpress.json"
            ,"/home/ywang/MyStuff/temp/APIConnectorsAllIInOne/resources/DinersClub.json"
            ,"/home/ywang/MyStuff/temp/APIConnectorsAllIInOne/resources/JCB.json"
            ,"/home/ywang/MyStuff/temp/APIConnectorsAllIInOne/resources/MasterCard.json"
            ,"/home/ywang/MyStuff/temp/APIConnectorsAllIInOne/resources/Visa.json"
            ,"/home/ywang/MyStuff/temp/APIConnectorsAllIInOne/resources/Voyager.json"
            ,"/home/ywang/MyStuff/temp/APIConnectorsAllIInOne/resources/Discover.json"
    };

    static private Map<String, List<CreditCard>> listMap = new HashMap<String, List<CreditCard>>();

    public static void main (String[] args) {
        listMap.put(filePaths[0], aMexList);
        listMap.put(filePaths[1], dinersClubList);
        listMap.put(filePaths[2], jCBList);
        listMap.put(filePaths[3], masterCardList);
        listMap.put(filePaths[4], visaList);
        listMap.put(filePaths[5], voyagerList);
        listMap.put(filePaths[6], discoverList);

        for (String path : listMap.keySet()) {
            parseCreditCard(path, listMap.get(path));
        }

        for (CreditCard c: aMexList) {
            System.out.println(c.getCardNumber() + "  -  " + c.getIssuingNetwork());
        }
        for (CreditCard c: visaList) {
            System.out.println(c.getCardNumber() + "  -  " + c.getIssuingNetwork());
        }

    }

    public static void parseCreditCard(String path, List<CreditCard> storingList) {
        try {
            // read the json file
            FileReader reader = new FileReader(path);

            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;

            Iterator<JSONObject> iter = jsonArray.iterator();

            while (iter.hasNext()) {
                JSONObject creditCard = new JSONObject();
                creditCard = (JSONObject) iter.next();

                JSONObject obj2 = (JSONObject) creditCard.get("CreditCard");

                Long cardNumber = (Long) obj2.get("CardNumber");
                String issuingNetwork = (String) obj2.get("IssuingNetwork");
                CreditCard card = new CreditCard(issuingNetwork, cardNumber);
                storingList.add(card);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
}
