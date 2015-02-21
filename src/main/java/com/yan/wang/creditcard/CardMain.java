package com.yan.wang.creditcard;

import com.yan.wang.creditcard.dao.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.envers.internal.tools.Triple;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.persistence.Tuple;
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
    static private List<Customer> customerList = new ArrayList<Customer>();
    static private List<Voucher> voucherList = new ArrayList<Voucher>();
    static private List<CustomerVoucher> customerVoucherList = new ArrayList<CustomerVoucher>();

    static String[] filePaths = new String [] {
            "/home/ywang/Progs/workspace_idea/APIConnectorsAllIInOne/resources/AmericanExpress.json"
            ,"/home/ywang/Progs/workspace_idea/APIConnectorsAllIInOne/resources/DinersClub.json"
            ,"/home/ywang/Progs/workspace_idea/APIConnectorsAllIInOne/resources/JCB.json"
            ,"/home/ywang/Progs/workspace_idea/APIConnectorsAllIInOne/resources/MasterCard.json"
            ,"/home/ywang/Progs/workspace_idea/APIConnectorsAllIInOne/resources/Visa.json"
            ,"/home/ywang/Progs/workspace_idea/APIConnectorsAllIInOne/resources/Voyager.json"
            ,"/home/ywang/Progs/workspace_idea/APIConnectorsAllIInOne/resources/Discover.json"
    };

    public static void main (String[] args) {
        CreditCardParser creditCardParser = new CreditCardParser();


        Triple<String, List<? extends CreditCard>, Integer> triple1 = new Triple<String, List<? extends CreditCard>, Integer>(filePaths[0], aMexList, 1);
        Triple<String, List<? extends CreditCard>, Integer> triple2 = new Triple<String, List<? extends CreditCard>, Integer>(filePaths[1], dinersClubList, 2);
        Triple<String, List<? extends CreditCard>, Integer> triple3 = new Triple<String, List<? extends CreditCard>, Integer>(filePaths[2], jCBList, 3);
        Triple<String, List<? extends CreditCard>, Integer> triple4 = new Triple<String, List<? extends CreditCard>, Integer>(filePaths[3], masterCardList, 4);
        Triple<String, List<? extends CreditCard>, Integer> triple5 = new Triple<String, List<? extends CreditCard>, Integer>(filePaths[4], visaList, 5);
        Triple<String, List<? extends CreditCard>, Integer> triple6 = new Triple<String, List<? extends CreditCard>, Integer>(filePaths[5], voyagerList, 6);
        Triple<String, List<? extends CreditCard>, Integer> triple7 = new Triple<String, List<? extends CreditCard>, Integer>(filePaths[6], discoverList, 7);


        List<Triple<String, List<? extends CreditCard>, Integer>> list = new ArrayList<Triple<String, List<? extends CreditCard>, Integer>>();
        list.add(triple1);
        list.add(triple2);
        list.add(triple3);
        list.add(triple4);
        list.add(triple5);
        list.add(triple6);
        list.add(triple7);


        for (Triple<String, List<? extends CreditCard>, Integer> triple : list) {
            parseCreditCard(triple);
        }

        parseCustomerAndVoucher();

        Session session = HibernateUtil.getSession();

        Transaction tx1 = session.beginTransaction();
        for (AMEX amex : aMexList) {
            long id = (Long) session.save(amex);
        }

        for (DinersClub dinersClub : dinersClubList) {
            long id = (Long) session.save(dinersClub);
        }

        for (JCB jcb : jCBList) {
            long id = (Long) session.save(jcb);
        }

        for (MasterCard masterCard : masterCardList) {
            long id = (Long) session.save(masterCard);
        }

        for (Visa visa : visaList) {
            long id = (Long) session.save(visa);
        }

        for (Voyager voyager : voyagerList) {
            long id = (Long) session.save(voyager);
        }

        for (Discover discover : discoverList) {
            long id = (Long) session.save(discover);
        }

        for (Customer customer : customerList) {
            long id = (Long) session.save(customer);
        }

        for (Voucher voucher : voucherList) {
            long id = (Long) session.save(voucher);
        }

        for (CustomerVoucher customerVoucher : customerVoucherList) {
            long id = (Long) session.save(customerVoucher);
        }
        tx1.commit();
    }


    public static void parseCreditCard(Triple<String, List<? extends CreditCard>, Integer> triple) {

        try {

            // read the json file
            FileReader reader = new FileReader(triple.getFirst());

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

                switch (triple.getThird()) {
                    case 1:
                        AMEX amex = new AMEX((Integer.valueOf(i)).longValue(), issuingNetwork, cardNumber);
                        aMexList.add(amex);
                        break;
                    case 2:
                        DinersClub dinersClub = new DinersClub((Integer.valueOf(i)).longValue(), issuingNetwork, cardNumber);
                        dinersClubList.add(dinersClub);
                        break;
                    case 3:
                        JCB jcb = new JCB((Integer.valueOf(i)).longValue(), issuingNetwork, cardNumber);
                        jCBList.add(jcb);
                        break;
                    case 4:
                        MasterCard masterCard = new MasterCard((Integer.valueOf(i)).longValue(), issuingNetwork, cardNumber);
                        masterCardList.add(masterCard);
                        break;
                    case 5:
                        Visa visa = new Visa((Integer.valueOf(i)).longValue(), issuingNetwork, cardNumber);
                        visaList.add(visa);
                        break;
                    case 6:
                        Voyager voyager = new Voyager((Integer.valueOf(i)).longValue(), issuingNetwork, cardNumber);
                        voyagerList.add(voyager);
                        break;
                    case 7:
                        Discover discover = new Discover((Integer.valueOf(i)).longValue(), issuingNetwork, cardNumber);
                        discoverList.add(discover);
                        break;
                }
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


        /*for (AMEX amex : aMexList) {
            System.out.println(amex.getId() + " - " + amex.getIssuingNetwork() + " - " + amex.getCardNumber());
        }

        for (Discover discover : discoverList) {
            System.out.println(discover.getId() + " - " + discover.getIssuingNetwork() + " - " + discover.getCardNumber());
        }*/
    }

    public static void parseCustomerAndVoucher() {
        Customer customer1 = new Customer(Integer.valueOf(1).longValue(), "yan.wang.ch@gmail.com");
        Customer customer2 = new Customer(Integer.valueOf(2).longValue(), "yan.wang.geneva@gmail.com");
        customerList.add(customer1);
        customerList.add(customer2);

        Voucher voucher1 = new Voucher(Integer.valueOf(1).longValue(), "TAB : 0001 - $10", "Starbucks", Integer.valueOf(1).longValue());
        Voucher voucher2 = new Voucher(Integer.valueOf(2).longValue(), "TAB : 0002 - $50", "Starbucks", Integer.valueOf(1).longValue());
        Voucher voucher3 = new Voucher(Integer.valueOf(3).longValue(), "TAB : 0003 - $100", "Starbucks", Integer.valueOf(0).longValue());
        Voucher voucher4 = new Voucher(Integer.valueOf(4).longValue(), "TAB : 0004 - $200", "Starbucks", Integer.valueOf(0).longValue());
        Voucher voucher5 = new Voucher(Integer.valueOf(5).longValue(), "TAB : 0005 - $500", "Starbucks", Integer.valueOf(0).longValue());
        Voucher voucher6 = new Voucher(Integer.valueOf(6).longValue(), "TAB : 000A - $25", "TimHorton", Integer.valueOf(0).longValue());
        Voucher voucher7 = new Voucher(Integer.valueOf(7).longValue(), "TAB : 000B - $50", "TimHorton", Integer.valueOf(0).longValue());
        Voucher voucher8 = new Voucher(Integer.valueOf(8).longValue(), "TAB : 000C - $100", "TimHorton", Integer.valueOf(0).longValue());
        Voucher voucher9 = new Voucher(Integer.valueOf(9).longValue(), "TAB : 000D - $150", "TimHorton", Integer.valueOf(0).longValue());
        Voucher voucher10 = new Voucher(Integer.valueOf(10).longValue(), "TAB : 000E - $200", "TimHorton", Integer.valueOf(0).longValue());
        voucherList.add(voucher1);
        voucherList.add(voucher2);
        voucherList.add(voucher3);
        voucherList.add(voucher4);
        voucherList.add(voucher5);
        voucherList.add(voucher6);
        voucherList.add(voucher7);
        voucherList.add(voucher8);
        voucherList.add(voucher9);
        voucherList.add(voucher10);

        CustomerVoucher customerVoucher1 = new CustomerVoucher(Integer.valueOf(1).longValue(), Integer.valueOf(1).longValue(), Integer.valueOf(1).longValue());
        CustomerVoucher customerVoucher2 = new CustomerVoucher(Integer.valueOf(2).longValue(), Integer.valueOf(2).longValue(), Integer.valueOf(2).longValue());
        customerVoucherList.add(customerVoucher1);
        customerVoucherList.add(customerVoucher2);
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
