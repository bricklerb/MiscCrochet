package MiscCrochet.TempertureBlanket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * temperture
 */
public class temperture {
    public static void main(String[] args) {
        Double[] temps = {};
        try {
            temps = getTempsFromCSV("temps.csv");
        } catch (Exception e) {
            System.out.println(e);
        }

        int clay = 0;
        int hazel = 0;
        int spice = 0;
        int maize = 0;
        int olive = 0;
        int lilac = 0;
        int blue = 0;
        int cement = 0;
        int vintage = 0;
        int charcoal = 0;

        for (int i = 0; i < temps.length; i++) {
            Double cur = temps[i];
            if (cur > 99) {
                clay++;
            } else if (cur > 87) {
                hazel++;
            } else if (cur > 76) {
                spice++;
            } else if (cur > 65) {
                maize++;
            } else if (cur > 54) {
                olive++;
            } else if (cur > 43) {
                lilac++;
            } else if (cur > 32) {
                blue++;
            } else if (cur > 21) {
                cement++;
            } else if (cur > 10) {
                vintage++;
            } else {
                charcoal++;
            }
        }

        System.out.println("Clay: " + Math.ceil(clay / 12f) + "\tRows: " + clay);
        System.out.println("Hazelwood: " + Math.ceil(hazel / 12f) + "\tRows: " + hazel);
        System.out.println("Spice: " + Math.ceil(spice / 12f) + "\tRows: " + spice);
        System.out.println("Maize: " + Math.ceil(maize / 12f) + "\tRows: " + maize);
        System.out.println("Olive Branch: " + Math.ceil(olive / 12f) + "\tRows: " + olive);
        System.out.println("Lilac: " + Math.ceil(lilac / 12f) + "\tRows: " + lilac);
        System.out.println("Bluestone: " + Math.ceil(blue / 12f) + "\tRows: " + blue);
        System.out.println("Cement: " + Math.ceil(cement / 12f) + "\tRows: " + cement);
        System.out.println("Vintage: " + Math.ceil(vintage / 12f) + "\tRows: " + vintage);
        System.out.println("Charcoal: " + Math.ceil(charcoal / 12f) + "\tRows: " + charcoal);
    }

    private static Double[] getTempsFromCSV(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();

        ArrayList<Double> ar = new ArrayList<Double>();
        while (line != null) {
            line = line.trim();
            line = line.replaceAll(",", "");

            ar.add(Double.parseDouble(line));

            line = reader.readLine();
        }

        reader.close();
        return ar.toArray(new Double[0]);
    }
}
