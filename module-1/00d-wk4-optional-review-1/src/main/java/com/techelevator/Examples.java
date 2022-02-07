package com.techelevator;

import java.util.*;

public class Examples {




    public static void main(String[] args) {
        String[] states = { "AK - Alaska",
                "DC - District of Columbia",
                "DE - Delaware",
                "FL - Florida",
                "AL - Alabama",
                "AR - Arkansas",
                "AS - American Samoa",
                "AZ - Arizona",
                "CA - California",
                "CO - Colorado",
                "CT - Connecticut",
                "GA - Georgia",
                "GU - Guam",
                "HI - Hawaii",
                "IA - Iowa",
                "ID - Idaho",
                "IL - Illinois",
                "IN - Indiana",
                "KS - Kansas",
                "KY - Kentucky",
                "LA - Louisiana",
                "MA - Massachusetts",
                "MD - Maryland",
                "ME - Maine",
                "MI - Michigan",
                "MN - Minnesota",
                "MO - Missouri",
                "MS - Mississippi",
                "MT - Montana",
                "NC - North Carolina",
                "ND - North Dakota",
                "NE - Nebraska",
                "NH - New Hampshire",
                "NJ - New Jersey",
                "NM - New Mexico",
                "NV - Nevada",
                "NY - New York",
                "OH - Ohio",
                "OK - Oklahoma",
                "OR - Oregon",
                "PA - Pennsylvania",
                "PR - Puerto Rico",
                "RI - Rhode Island",
                "SC - South Carolina",
                "SD - South Dakota",
                "TN - Tennessee",
                "TX - Texas",
                "UT - Utah",
                "VA - Virginia",
                "VI - Virgin Islands",
                "VT - Vermont",
                "WA - Washington",
                "WI - Wisconsin",
                "WV - West Virginia",
                "WY - Wyoming" };

        System.out.println( states[27] );


        for (int i = 0; i < states.length; i++) {
            System.out.println( states[i] );
        }

        for (String state : states) {
            System.out.println( state );
        }

        List<String> stateList = Arrays.asList(states);

        for (String state: stateList) {


            if (state.substring(0,1).equalsIgnoreCase("C")) {
                continue;
            }

            if (state.substring(0,1).equalsIgnoreCase("h")) {
                break;
            }

            System.out.println( state.substring(0,2) );
            System.out.println( state.substring(5) );
        }


        Map<String, String> mapOfUSStates = new HashMap<String, String>() {
            {
                put("AL", "Alabama");
                put("AK", "Alaska");
                put("AZ", "Arizona");
                put("AR", "Arkansas");
                put("CA", "California");
                put("CO", "Colorado");
                put("CT", "Connecticut");
                put("DE", "Delaware");
                put("DC", "Dist of Columbia");
                put("FL", "Florida");
                put("GA", "Georgia");
                put("HI", "Hawaii");
                put("ID", "Idaho");
                put("IL", "Illinois");
                put("IN", "Indiana");
                put("IA", "Iowa");
                put("KS", "Kansas");
                put("KY", "Kentucky");
                put("LA", "Louisiana");
                put("ME", "Maine");
                put("MD", "Maryland");
                put("MA", "Massachusetts");
                put("MI", "Michigan");
                put("MN", "Minnesota");
                put("MS", "Mississippi");
                put("MO", "Missouri");
                put("MT", "Montana");
                put("NE", "Nebraska");
                put("NV", "Nevada");
                put("NH", "New Hampshire");
                put("NJ", "New Jersey");
                put("NM", "New Mexico");
                put("NY", "New York");
                put("NC", "North Carolina");
                put("ND", "North Dakota");
                put("OH", "Ohio");
                put("OK", "Oklahoma");
                put("OR", "Oregon");
                put("PA", "Pennsylvania");
                put("RI", "Rhode Island");
                put("SC", "South Carolina");
                put("SD", "South Dakota");
                put("TN", "Tennessee");
                put("TX", "Texas");
                put("UT", "Utah");
                put("VT", "Vermont");
                put("VA", "Virginia");
                put("WA", "Washington");
                put("WV", "West Virginia");
                put("WI", "Wisconsin");
                put("WY", "Wyoming");
            }
        };

        Scanner in = new Scanner(System.in);
        System.out.println("State Code: ");
        String code = in.nextLine();

        System.out.println( mapOfUSStates.get(code) );

        Rectangle rect = new Rectangle(10, 15);

    }
}

