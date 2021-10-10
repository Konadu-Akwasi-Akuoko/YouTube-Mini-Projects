package com.example.cardchecker.customFunctions;

import android.text.method.NumberKeyListener;

public class HomeScreenFunctions {

    //This function checks whether the card is valid or invalid.
    public Boolean ValidateNumber(String cardNo) {
        //Boolean to validate if the card is valid or not.
        boolean isValid = false;
        try {
            System.out.println(cardNo);
            //The sum of all the idNumbers after being processed. It must always be 0 when this method is called.
            int checkSum = 0;
            //This array is where all the card numbers will go, with each number getting a space.
            String[] arrayOfCardNo = new String[cardNo.length()];

            for (int i = 0; i < cardNo.length(); i++) {
                //Put every number from our cardNumber into the arrayOfCardNo, with each cardNumber getting a space.
                arrayOfCardNo[i] = String.valueOf(cardNo.charAt(i));

                //Check and see if the number is at a location which is divisible by two with a reminder, because we are interested
                //in second digits from the rightmost, thus we only want numbers which are located at odd indexes in the array.
                if (i % 2 != 0) {
                    //When found that item is multiplied by two and stored inside the array index where it was found.
                    arrayOfCardNo[i] = String.valueOf(Integer.parseInt(arrayOfCardNo[i]) * 2);

                    //Check and see if the number you just stored is two numbers by using length of a string.
                    if (arrayOfCardNo[i].length() >= 2) {
                        //If it is two numbers access the numbers separately and add them together, and store it where it was picked from.
                        //And there is now way the number will be more than two lengths.
                        int addTwoNo = Integer.parseInt(String.valueOf(arrayOfCardNo[i].charAt(0))) + Integer.parseInt(String.valueOf(arrayOfCardNo[i].charAt(1)));
                        arrayOfCardNo[i] = String.valueOf(addTwoNo);
                    }
                }

                //Sum up the values
                checkSum += Integer.parseInt(arrayOfCardNo[i]);
            }

            //Check to see if the sum of the id number is valid or not,
            // by checking to see if the number modulo 10 is 0, then return.
            isValid = checkSum % 10 == 0;
        } catch (NumberFormatException e) {
            System.out.println(e.getCause());
        }

        return isValid;
    }
}
