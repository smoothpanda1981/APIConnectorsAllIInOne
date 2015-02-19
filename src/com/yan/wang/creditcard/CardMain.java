package com.yan.wang.creditcard;

import com.yan.wang.creditcard.dao.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.envers.internal.tools.Triple;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by ywang on 17.02.15.
 */
public class CardMain {

    static private List<AMEX> aMexList = new ArrayList<AMEX>();
    static private List<DinersClub> dinersClubList = new ArrayList<DinersClub>();
    static private List<JCB> jCBList = new ArrayList<JCB>();
    static private List<MasterCard> masterCardList = new ArrayList<MasterCard>();
    static private List<Visa> visaList = new ArrayList<Visa>();
    static private List<Voyager> voyagerList = new ArrayList<Voyager>();
    static private List<Discover> discoverList = new ArrayList<Discover>();

    static String[] filePaths = new String [] {
            "/home/ywang/MyStuff/temp/APIConnectorsAllIInOne/resources/AmericanExpress.json"
            ,"/home/ywang/MyStuff/temp/APIConnectorsAllIInOne/resources/DinersClub.json"
            ,"/home/ywang/MyStuff/temp/APIConnectorsAllIInOne/resources/JCB.json"
            ,"/home/ywang/MyStuff/temp/APIConnectorsAllIInOne/resources/MasterCard.json"
            ,"/home/ywang/MyStuff/temp/APIConnectorsAllIInOne/resources/Visa.json"
            ,"/home/ywang/MyStuff/temp/APIConnectorsAllIInOne/resources/Voyager.json"
            ,"/home/ywang/MyStuff/temp/APIConnectorsAllIInOne/resources/Discover.json"
    };

    static Map<String, Triple<String, Object, String>> listOfCards = new HashMap<String, Triple<String, Object, String>>();

    public static void main (String[] args) {
        CreditCardParser creditCardParser = new CreditCardParser();



        Triple<String, Object, String> triple1 = new Triple<String, Object, String>(filePaths[0], aMexList, "AMEX");
        Triple<String, Object, String> triple2 = new Triple<String, Object, String>(filePaths[1], dinersClubList, "DINERS");
        Triple<String, Object, String> triple3 = new Triple<String, Object, String>(filePaths[2], jCBList, "JCB");
        Triple<String, Object, String> triple4 = new Triple<String, Object, String>(filePaths[3], masterCardList, "MC");
        Triple<String, Object, String> triple5 = new Triple<String, Object, String>(filePaths[4], visaList, "VISA");
        Triple<String, Object, String> triple6 = new Triple<String, Object, String>(filePaths[5], voyagerList, "VOYAGER");
        Triple<String, Object, String> triple7 = new Triple<String, Object, String>(filePaths[6], discoverList, "DISCOVER");

        listOfCards.put("AMEX", triple1);
        listOfCards.put("DINERS", triple2);
        listOfCards.put("JCB", triple3);
        listOfCards.put("MC", triple4);
        listOfCards.put("VISA", triple5);
        listOfCards.put("VOYAGER", triple6);
        listOfCards.put("DISCOVER", triple7);


        for (String key : listOfCards.keySet()) {
            Triple<String, Object, String> tempTriple = listOfCards.get(key);
            if ("AMEX".equals(tempTriple.getThird())) {
                parseCreditCard(tempTriple.getFirst(), (List<AMEX>) tempTriple.getSecond());
            } else if ("DINERS".equals(tempTriple.getThird())) {
                parseCreditCard(tempTriple.getFirst(), (List<DinersClub>) tempTriple.getSecond());
            } else if ("JCB".equals(tempTriple.getThird())) {
                parseCreditCard(tempTriple.getFirst(), (List<JCB>) tempTriple.getSecond());
            }
        }


        Session session = HibernateUtil.getSession();


        //Query q = session.createQuery("select * from AMEX");

    }


    public static void parseCreditCard(String path, Object storingList) {
        try {
            // read the json file
            FileReader reader = new FileReader(path);

            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;

            Iterator<JSONObject> iter = jsonArray.iterator();

            int i = 1;
            while (iter.hasNext()) {
                JSONObject creditCard = new JSONObject();
                creditCard = (JSONObject) iter.next();

                JSONObject obj2 = (JSONObject) creditCard.get("CreditCard");

                Long cardNumber = (Long) obj2.get("CardNumber");
                String issuingNetwork = (String) obj2.get("IssuingNetwork");


                storingList.add(null);
                i++;
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

    /*class CC<T extends CreditCard> {
        private T typeOfCrediCard;

        public CC(T typeOfCrediCard) {
            this.typeOfCrediCard = typeOfCrediCard;
        }

        public T getTypeOfCrediCard() {
            return typeOfCrediCard;
        }

        public void setTypeOfCrediCard(T typeOfCrediCard) {
            this.typeOfCrediCard = typeOfCrediCard;
        }
    }*/

}
