package testing;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.annotation.Generated;

import com.opencsv.CSVWriter;

public class Test {

	public static void main(String[] args) {

		generateRandomTrueFalseObj();

	}

	private static void writeToFile(int number) {
		String roadObjsOnEdgeCSVFile = "GeneratedFiles/custom" + ".txt";

		try {

			FileWriter outputFile = new FileWriter(roadObjsOnEdgeCSVFile);

			for (int i = 0; i < number; i++) {
				String a = String.valueOf(i);
				outputFile.write(a);

				outputFile.write(System.lineSeparator()); // new line
			}

			outputFile.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void generateRandomTrueFalseObj() {
		Random rand = new Random();

		ArrayList<Boolean> values = new ArrayList<Boolean>();

		for (int i = 0; i < 5; i++) {
			values.add(true);
		}
		for (int i = 0; i < 10; i++) {
			values.add(false);
		}

		System.out.println("Size of values: " + values.size());
		System.out.println(values);
		System.out.println(" ");
		System.out.println("after shuffling");
		Collections.shuffle(values);
		System.out.println(values);
		System.out.println("-------------------------------------------");
		ArrayList<Boolean> newValues = new ArrayList<Boolean>();
		for (int i = 0; i < values.size(); i++) {
			int randomIndex = rand.nextInt(values.size());
			newValues.add(values.get(randomIndex));
			
		}
		System.out.println("Size of values: " + newValues.size());
		System.out.println(newValues);
		System.out.println("after shuffling");
		Collections.shuffle(newValues);
		System.out.println(newValues);

	}
}
