package attempt;

import java.io.IOException;

public class IceCreamPrices {
	public String[][] iceCreamDetails; // Company, name, Type
	public double[][] sizeAndPrices; // Size, Price

	public IceCreamPrices(String filename) throws IOException {
		DatasetReader reader = new DatasetReader(filename);
		iceCreamDetails = reader.iceCreamDetails;
		sizeAndPrices = reader.sizeAndPrices;
	}

	/**
	 * YOUR JOB BEGINS BELOW THIS COMMENT
	 */

	/**
	 * P/CR
	 * 
	 * @param idx
	 * @return true if idx is a valid index in the arrays, false otherwise. A index
	 *         is valid if there is an item at that index. Assume that the two
	 *         arrays are of the same length.
	 * 
	 *         Remember these are two-dimensional arrays. Read the specifications
	 *         carefully and understand what they store and what is being asked.
	 * 
	 *         For example, if there are 20 different ice creams, there will be 20
	 *         arrays in iceCreamName, each containing 3 Strings, and there will be
	 *         20 arrays in sizeAndPrices, each containing 2 numerical values.
	 */
	public boolean validIndex(int idx) {
		if (idx < 0 || idx > iceCreamDetails.length - 1) {
			return false;
		}
		return true;
	}

	/**
	 * P/CR
	 * 
	 * @return the total cost if you would buy one of every ice cream.
	 */
	public double totalCost() {
		double sumOfPrice = 0;
		for (int i = 0; i < sizeAndPrices.length; i++) {
			sumOfPrice += sizeAndPrices[i][1];
		}
		return sumOfPrice;
	}

	/**
	 * P/CR
	 * 
	 * @param size
	 * @return the average cost of a ice cream with the given size.
	 */
	public double averageCostSize(int size) {
		double sumOfPrice = 0;
		int counter = 0;
		for (int i = 0; i < sizeAndPrices.length; i++) {
			if (sizeAndPrices[i][0] == size) {
				sumOfPrice += sizeAndPrices[i][1];
				counter++;
			}
		}
		return sumOfPrice / counter;
	}

	/**
	 * P/CR
	 * 
	 * @param target
	 * @return index within which the target exists, -1 if it doesn't exist. The
	 *         target can be either represent a Company, Ice Cream Name or Type.
	 *         Return the index of the first occurrence if there is more than 1.
	 */
	public int getIndex(String target) {
		int subArrays = 3;
		for (int i = 0; i < iceCreamDetails.length; i++) {
			for (int k = 0; k < subArrays; k++) {
				if (iceCreamDetails[i][k].equalsIgnoreCase(target)) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * P/CR
	 * 
	 * It can be of interest to know how many versions of ice creams a certain
	 * company has or how many different versions of a certain ice cream exist.
	 * Given an input, return the number of exact occurrences exists. Use
	 * String1.equalsIgnoreCase(String2) to not worry about the case.
	 * 
	 * Sample usage:
	 * 
	 * String a = "Hello"; String b = "hELLo"; String c = "Hello!"; boolean x =
	 * a.equalsIgnoreCase(b); //x is true boolean x = a.equalsIgnoreCase(c); //y is
	 * false
	 * 
	 * For example if the input is "hAagen-dazs", it should match "Haagen-Dazs"
	 * (case-insensitive) but not "Haagen-Dazs Special"
	 * 
	 * IMPORTANT: Don't double count if more than one value from iceCreamDetails
	 * sub-array match target
	 * 
	 * @param target
	 * @return the number of exact occurrences of target.
	 */
	public int countOccurances(String target) {
		int subArrays = 3;
		int counter = 0;
		for (int i = 0; i < iceCreamDetails.length; i++) {
			for (int k = 0; k < subArrays; k++) {
				if (iceCreamDetails[i][k].equalsIgnoreCase(target)) {
					counter++;
					break;
				}
			}
		}
		return counter;
	}

	/**
	 * P/CR
	 * 
	 * @param company
	 * @return the average cost of ice creams for the given company. If the company
	 *         doesn't exist, return -1.
	 */
	public double averageCostCompany(String company) {
		int counter = 0;
		double sumOfPrice = 0;
		double result = 0;
		boolean flag = false;
		for (int i = 0; i < iceCreamDetails.length; i++) {
			if (iceCreamDetails[i][0].equalsIgnoreCase(company)) {
				flag = true;
				counter++;
				sumOfPrice += sizeAndPrices[i][1];
			}
			result = sumOfPrice / counter;
		}
		if (flag) {
			return result;
		}
		return -1;
	}

	/**
	 * P/CR
	 * 
	 * The following keywords should be used for sizes: 1 - "Kids" 2 - "Small" 3 -
	 * "Normal" 4 - "Jumbo"
	 * 
	 * @param idx
	 * @return the ice cream as a string in the format:
	 * 
	 *         Company, Name, type - size $Price
	 * 
	 *         If the index is invalid, return null.
	 * 
	 *         IMPORTANT!!! If you don't understand the description, see test cases
	 *         for further detail.
	 */
	public String toString(int idx) {
		if (idx < 0 || idx > iceCreamDetails.length - 1) {
			return null;
		}
		if (sizeAndPrices[idx][0] == 1) {
			return iceCreamDetails[idx][0] + ", " + iceCreamDetails[idx][1] + ", " + iceCreamDetails[idx][2]
					+ " - Kids $" + sizeAndPrices[idx][1];
		}
		if (sizeAndPrices[idx][0] == 2) {
			return iceCreamDetails[idx][0] + ", " + iceCreamDetails[idx][1] + ", " + iceCreamDetails[idx][2]
					+ " - Small $" + sizeAndPrices[idx][1];
		}
		if (sizeAndPrices[idx][0] == 3) {
			return iceCreamDetails[idx][0] + ", " + iceCreamDetails[idx][1] + ", " + iceCreamDetails[idx][2]
					+ " - Normal $" + sizeAndPrices[idx][1];
		}
		if (sizeAndPrices[idx][0] == 4) {
			return iceCreamDetails[idx][0] + ", " + iceCreamDetails[idx][1] + ", " + iceCreamDetails[idx][2]
					+ " - Jumbo $" + sizeAndPrices[idx][1];
		}
		return "Something is going very wrong. Check your code again!";
	}

	/**
	 * P/CR
	 * 
	 * @param minSize
	 * @param type
	 * @return the minimum cost of a ice cream that has a size of at least minSize
	 *         and is of the correct type.
	 * 
	 *         return -1 if minSize is not between 1 and 4 (inclusive on both sides)
	 */
	public double minCost(int minSize, String type) {
		if (minSize < 1 || minSize > 4) {
			return -1;
		}
		double minCost = 0;
		for (int i = 0; i < iceCreamDetails.length; i++) {
			if (iceCreamDetails[i][2].equalsIgnoreCase(type)) {
				if (sizeAndPrices[i][0] >= minSize) {
					if (minCost == 0) {
						minCost = sizeAndPrices[i][1];
					}
					if (sizeAndPrices[i][1] < minCost) {
						minCost = sizeAndPrices[i][1];
					}
				}
			}
		}
		return minCost;
	}

	/**
	 * D
	 * 
	 * @return an array containing all the unique company names in the dataset. The
	 *         name that occurs first in the dataset should also occur first in the
	 *         returned array.
	 */
	public String[] getUniqueCompanies() {
		int capacity = iceCreamDetails.length;
		int position = 0;
		int nullPosition = 0;
		String[] companyNames = new String[capacity];
		for (int i = 0; i < iceCreamDetails.length; i++) {
			String companyName = iceCreamDetails[i][0];
			boolean seen = false;
			for (int k = 0; k < companyNames.length; k++) {
				if (companyName.equalsIgnoreCase(companyNames[k])) {
					seen = true;
					break;
				}
			}
			if (!seen) {
				companyNames[position] = companyName;
				position++;
			}
		}
		for (int m = 0; m < position; m++) {
			if (companyNames[m] != null) {
				nullPosition++;
			}
		}
		String[] newCompanyNames = new String[nullPosition];
		for (int n = 0; n < nullPosition; n++) {
			newCompanyNames[n] = companyNames[n];
		}
		return newCompanyNames;
	}

	/**
	 * D/HD
	 * 
	 * @return the company that has the smallest difference in ice cream prices.
	 * 
	 *         That is, the smallest difference between the price of the most
	 *         expensive icecream they sell, and the price of the least expensive
	 *         icecream they sell.
	 * 
	 *         Choose the first company that occurs in the dataset if there is a
	 *         tie.
	 */
	public String minDiffPrice() {
		String[] companyNames = new String[iceCreamDetails.length];
		double[] companyDifference = new double[sizeAndPrices.length];
		for (int i = 0; i < sizeAndPrices.length; i++) {
			double minPrice = 0;
			double maxPrice = 0;
			double difference = 0;
			for (int k = 0; k < iceCreamDetails.length; k++) {
				if (iceCreamDetails[i][0].equalsIgnoreCase(iceCreamDetails[k][0])) {
					if (sizeAndPrices[k][1] > maxPrice) {
						maxPrice = sizeAndPrices[k][1];
					}
					if (minPrice == 0) {
						minPrice = sizeAndPrices[k][1];
					}
					if (sizeAndPrices[k][1] < minPrice) {
						minPrice = sizeAndPrices[k][1];
					}
				}
			}
			difference = maxPrice - minPrice;
			companyNames[i] = iceCreamDetails[i][0];
			companyDifference[i] = difference;
		}
		double minCompanyDifference = 0;
		int minDifferenceIndex = 0;
		for (int m = 0; m < sizeAndPrices.length; m++) {
			if (minCompanyDifference == 0) {
				minCompanyDifference = companyDifference[m];
				minDifferenceIndex = m;
			}
			if (companyDifference[m] < minCompanyDifference) {
				minCompanyDifference = companyDifference[m];
				minDifferenceIndex = m;
			}
		}
		return companyNames[minDifferenceIndex];
	}

	/**
	 * D/HD
	 * 
	 * @return an array contains the number of unique ice cream names at every
	 *         company. The order of items in the returned arrays should be the same
	 *         as the order of the first occurrences of the companies.
	 */
	public int[] uniqueIceCreamsCompany() {
		String[] uniqueCompanies = getUniqueCompanies();
		int[] numberOfUniqueIceCreamFlavours = new int[uniqueCompanies.length];
		for (int i = 0; i < uniqueCompanies.length; i++) {
			String company = uniqueCompanies[i];
			int counter = 0;
			for (int n = 0; n < iceCreamDetails.length; n++) {
				if (!company.equalsIgnoreCase(iceCreamDetails[n][0])) {
					continue;
				}
				String iceCreamFlavour = iceCreamDetails[n][1];
				boolean seen = false;
				for (int k = 0; k < n; k++) {
					if (iceCreamFlavour.equalsIgnoreCase(iceCreamDetails[k][1])
							&& company.equalsIgnoreCase(iceCreamDetails[k][0])) {
						seen = true;
						break;
					}
				}
				if (!seen) {
					counter++;
				}
			}
			numberOfUniqueIceCreamFlavours[i] = counter;
		}
		return numberOfUniqueIceCreamFlavours;
	}
}
