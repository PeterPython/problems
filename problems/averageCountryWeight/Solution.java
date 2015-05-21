import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        // TreeMap to keep countries in alphabetic order. It contains a country as key and user ID as value with previous weight
        TreeMap<String, HashMap<Integer, Double>> countrySet = new TreeMap<String, HashMap<Integer, Double>>();
        
        // HashMap to keep track of how much weight a user has lost <userID, currentLost>
        HashMap<Integer, Double> currentLost = new HashMap<Integer, Double>();
        Scanner in = new Scanner(System.in);
        
        while(in.hasNextLine()) {
            String line[] = in.nextLine().split(",");
            String country = line[0];
            int userID = Integer.parseInt(line[1]);
            double weight = Double.parseDouble(line[2]);

            // Adding country to TreeMap if it does not contain yet
            if(!countrySet.containsKey(country)) {
                HashMap<Integer, Double> user = new HashMap<Integer, Double>();
                user.put(userID, weight);
                countrySet.put(country, user);
                currentLost.put(userID, 0.0);
            }
            else {  // If it is already in the tree
                HashMap<Integer, Double> users = countrySet.get(country);
                if(!users.containsKey(userID)) {  // If the user ID is not in the country yet, add it
                    users.put(userID, weight);
                    currentLost.put(userID, 0.0);
                }
                else {
                    Double previousWeight = users.get(userID);
                    Double dif = previousWeight - weight;  // Getting current difference
                    
                    Double previousSum = currentLost.get(userID);
                    currentLost.put(userID, previousSum + dif);
                    users.put(userID, weight);
                }
            }
            
            // Print each country and its average
            String result = "";
            for(String c : countrySet.keySet()) {
                HashMap<Integer, Double> u = countrySet.get(c);
                Double avg = 0.0;
                Double sum = 0.0;
                
                for(Integer id : u.keySet()) {
                    Double userWeightLost = currentLost.get(id);
                    sum = sum + userWeightLost;
                }
                
                avg = sum / u.size();
                avg = (double) Math.round(avg * 10) / 10; // Roundind to 1 decimal place
                
                // Printing out result
                if(result.equals("")) {
                    result += c + ": " + avg;
                }
                else {
                   result += ", " + c + ": " + avg; 
                }
            }
            System.out.println(result);
        }
    }
}