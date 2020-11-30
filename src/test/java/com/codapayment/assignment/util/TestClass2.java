
package com.codapayment.assignment.util;

import java.io.*;
import java.util.*;



public class TestClass2 {
    static int minParkingSpaces(int[][] parkingStartEndTimes) {
        Arrays.sort(parkingStartEndTimes,Comparator.comparingInt(item ->item[0]));
        // YOUR CODE HERE
        int startIndex=0;
        int endIndex=parkingStartEndTimes.length-1;
        int minParkingSpaceNeeded=0;
        while(startIndex < endIndex){
            if((parkingStartEndTimes[startIndex][0]< parkingStartEndTimes[endIndex][0]) && (parkingStartEndTimes[startIndex][1] < parkingStartEndTimes[endIndex][1])){
                minParkingSpaceNeeded ++;
                startIndex++;
                endIndex--;
            }
            else{
                startIndex++;
            }
        }
        return minParkingSpaceNeeded;

    }

    // DO NOT MODIFY ANYTHING BELOW THIS LINE!!

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        int[][] parkingStartEndTimeList = new int[n][2];
        String[] parkingStartEndTimes = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
            for (int j = 0; j < parkingStartEndTime.length; j++) {
                parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
            }
        }

        int out = minParkingSpaces(parkingStartEndTimeList);
        System.out.println(out);

        wr.close();
        br.close();
    }
}
