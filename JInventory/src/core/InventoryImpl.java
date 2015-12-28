package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exceptions.EmptyCellException;
import exceptions.InsuranceCannotBeNull;
import plainObjects.AccessoryInventory;
import plainObjects.CarInventory;
import plainObjects.CarStandingOrder;
import plainObjects.MotorInsurance;
import plainObjects.TaxRate;

public class InventoryImpl implements InventoryInterface {

	private static final String VENDOR = "vendor";
	private static final String MODEL = "model";
	private static final String VARIANT = "variant";
	private static final String COLOR = "color";

	@SuppressWarnings("static-access")
	public Map<String, CarInventory> readCarInventoryFromCSV() {

		CarInventory carInventory;
		Map<String, CarInventory> carInventoryMap = new HashMap<>();

		String csvFile = "C:/Users/binoy.j.cherian/Music/csv/carInventory.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		boolean firstLine = false;

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				carInventory = new CarInventory();
				String[] carDetails = line.split(cvsSplitBy);

				// handle vendor

				if (carDetails[0].equalsIgnoreCase(VENDOR))
					firstLine = true;

				else if (carDetails[0] == null) {
					throw new EmptyCellException(VENDOR);
				} else {
					firstLine = false;
					carInventory.setVendor(carDetails[0]);
				}

				// handle model

				if (carDetails[1].equalsIgnoreCase(MODEL)) {

				}

				else if (carDetails[1] == null) {
					throw new EmptyCellException(MODEL);
				} else {
					carInventory.setModel(carDetails[1]);
				}

				// handle variant

				if (carDetails[2].equalsIgnoreCase(VARIANT)) {

				}

				else if (carDetails[2] == null) {
					throw new EmptyCellException(VARIANT);
				} else {
					carInventory.setVariant(carDetails[2]);
				}

				// handle color

				if (carDetails[3].equalsIgnoreCase(COLOR)) {

				}

				else if (carDetails[3] == null) {
					throw new EmptyCellException(COLOR);
				} else {
					carInventory.setColor(carDetails[3]);
				}

				// handle base price

				if (carDetails[4].equalsIgnoreCase("basePrice")) {

				}

				else if (carDetails[4] == null) {
					throw new EmptyCellException("basePrice");
				} else {
					carInventory.setBasePrice(Long.parseLong(carDetails[4]));
				}

				// handle quantity available

				if (carDetails[5].equalsIgnoreCase("quantityAvailable")) {

				}

				else if (carDetails[5] == null) {
					throw new EmptyCellException("quantityAvailable");
				} else {
					carInventory.setQuantityAvailable(Integer.parseInt(carDetails[5]));
				}

				if ((carInventory.getKey() != null) && (!firstLine)) {
					// System.out.println("-------------------------------------");
					// System.out.println(carInventory);
					carInventoryMap.put(carInventory.getKey(), carInventory);
				}
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (EmptyCellException e) {

			e.printStackTrace();
		}

		finally {
			try {

				System.out.println("Car Inventory Map Size: " + carInventoryMap.size());
				if ((br != null) || (br == null))
					br.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		return carInventoryMap;

	}

	@SuppressWarnings("static-access")
	@Override
	public Map<String, AccessoryInventory> readAccessoryInventoryfromCSV() {
		String csvFile = "C:/Users/binoy.j.cherian/Music/csv/accessoryInventory.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		AccessoryInventory accessoryObject;
		Map<String, AccessoryInventory> accessoryMap = new HashMap<>();
		boolean firstLine = false;

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				accessoryObject = new AccessoryInventory();

				// use comma as separator
				String[] accessories = line.split(cvsSplitBy);

				// handle accessories

				if (accessories[0].equalsIgnoreCase(VENDOR)) {
					firstLine = true;
				}

				else if (accessories[0] == null) {
					throw new EmptyCellException(VENDOR);
				}

				else {
					firstLine = false;
					accessoryObject.setVendor(accessories[0]);

				}

				// handle model

				if (accessories[1].equalsIgnoreCase(MODEL)) {

				}

				else if (accessories[1] == null) {
					throw new EmptyCellException(MODEL);
				} else {
					accessoryObject.setModel(accessories[1]);
				}

				// handle accessories

				if (accessories[2].equalsIgnoreCase("accessories")) {

				}

				else if (accessories[2] == null) {

					throw new EmptyCellException("accessories");
				} else {
					accessoryObject.setAccessory(accessories[2]);
				}

				// handle price

				if (accessories[3].equalsIgnoreCase("price")) {

				} else if (accessories[3] == null) {

					throw new EmptyCellException("price");
				}

				else {
					accessoryObject.setPrice(Long.parseLong(accessories[3]));
				}

				// handle quantity available

				if (accessories[4].equalsIgnoreCase("quantityAvailable")) {

				} else if (accessories[4] == null) {

					throw new EmptyCellException("quantityAvailable");
				}

				else {
					accessoryObject.setQuantitiyAvailable(Long.parseLong(accessories[4]));
				}

				if ((accessoryObject.getKey() != null) && (!firstLine)) {

					// System.out.println(accessoryObject);
					accessoryMap.put(accessoryObject.getKey(), accessoryObject);

				} else if (firstLine) {
					System.out.println("Ignoring firstLine");
				}

			}
		} catch (IOException e) {

			e.printStackTrace();
		} catch (EmptyCellException e) {

			e.printStackTrace();
		}

		finally {
			try {

				System.out.println("Accessory Map Size: " + accessoryMap.size());

				if ((br != null) || (br == null))
					br.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return accessoryMap;
	}

	@Override
	public ArrayList<CarStandingOrder> readCarStandingOrderFromCSV() {

		ArrayList<CarStandingOrder> orders = new ArrayList<>();
		String csvFile = "C:/Users/binoy.j.cherian/Music/csv/carStandingOrders.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		boolean firstLine = false;
		CarStandingOrder orderObject = null;

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				orderObject = new CarStandingOrder();

				String[] ordersStringArray = line.split(cvsSplitBy);

				// handle customer name

				if (ordersStringArray[0].equalsIgnoreCase("customerName")) {
					// System.out.println("firstline");
					firstLine = true;
				} else if (ordersStringArray[0] == null) {
					throw new EmptyCellException("customerName");
				} else {
					firstLine = false;
					orderObject.setCustomerName(ordersStringArray[0]);
				}

				// handle region
				if (ordersStringArray[1].equalsIgnoreCase("region")) {

				} else if (ordersStringArray[1] == null) {
					throw new EmptyCellException("region");
				} else {
					orderObject.setRegion(ordersStringArray[1]);
				}

				// handle vendor
				if (ordersStringArray[2].equalsIgnoreCase(VENDOR)) {

				} else if (ordersStringArray[2] == null) {
					throw new EmptyCellException(VENDOR);
				} else {
					orderObject.setVendor(ordersStringArray[2]);
				}

				// handle model

				if (ordersStringArray[3].equalsIgnoreCase(MODEL)) {

				} else if (ordersStringArray[3] == null) {
					throw new EmptyCellException(MODEL);
				} else {
					orderObject.setModel(ordersStringArray[3]);
				}

				// handle variant
				if (ordersStringArray[4].equalsIgnoreCase(VARIANT)) {

				} else if (ordersStringArray[4] == null) {
					throw new EmptyCellException(VARIANT);
				} else {
					orderObject.setVariant(ordersStringArray[4]);
				}

				// handle color
				if (ordersStringArray[5].equalsIgnoreCase(COLOR)) {

				} else if (ordersStringArray[5] == null) {
					throw new EmptyCellException(COLOR);
				} else {
					orderObject.setColor(ordersStringArray[5]);
				}

				// handle accessories
				ArrayList<String> accessories = new ArrayList<>();

				if (ordersStringArray[6].equalsIgnoreCase("accessories")) {

				} else if (ordersStringArray[6] == null) {
					accessories.add(null);

				} else {

					String[] accessoriesSplited = ordersStringArray[6].split(":");

					for (int count = 0; count < accessoriesSplited.length; count++) {
						accessories.add(accessoriesSplited[count]);

					}

				}

				orderObject.setAccessories(accessories);

				// handle motor insurance

				if (ordersStringArray[7].equalsIgnoreCase("motorInsurance")) {

				} else if (ordersStringArray[7] == null)

				{
					throw new InsuranceCannotBeNull("Insurance null");
				} else {
					orderObject.setMotorInsurance(ordersStringArray[7]);
				}

				// handle personal protection plan

				if (ordersStringArray[8].equalsIgnoreCase("personalProtectPlan")) {

				} else if (ordersStringArray[8] == null)

				{
					throw new EmptyCellException("Insurance null");
				} else {
					orderObject.setPersonalProtectPlan(ordersStringArray[8]);
				}

				// System.out.println(orderObject);

				if ((orderObject.getKey() != null) && (!firstLine)) {
					// System.out.println("--------------------------\n"+orderObject);
					orders.add(orderObject);
				}

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (EmptyCellException e) {

			e.printStackTrace();
		} catch (InsuranceCannotBeNull e) {

			e.printStackTrace();
		}

		finally {
			try {
				System.out.println("Car Standing Orders Size: " + orders.size());
				if ((br != null) || (br == null))
					br.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return orders;
	}

	@Override
	public List<MotorInsurance> readMotorInsuranceFromCSV() {

		ArrayList<MotorInsurance> motorInsurance = new ArrayList<>();
		String csvFile = "C:/Users/binoy.j.cherian/Music/csv/motorInsurance.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		boolean firstLine = false;
		MotorInsurance insuranceObject = null;

		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				insuranceObject = new MotorInsurance();
				String[] insuranceLine = line.split(cvsSplitBy);

				// motorInsurance

				if ("motorInsuranceProvider".equalsIgnoreCase(insuranceLine[0])) {
					firstLine = true;
					// logg
				} else if (insuranceLine[0] == null) {
					throw new EmptyCellException("motorInsurance");
				} else {
					firstLine = false;
					insuranceObject.setMotorInsuranceName(insuranceLine[0]);
				}

				// personalProtectPlanOffered
				if ("personalProtectPlanOffered".equalsIgnoreCase(insuranceLine[1])) {

				} else if (insuranceLine[1] == null) {

					throw new EmptyCellException("personalProtectPlanOffered");
				} else {
					insuranceObject.setPersonalProtectPlan(insuranceLine[1]);
				}

				// firstYearPremium

				if ("firstYearPremium".equalsIgnoreCase(insuranceLine[2])) {

				} else if (insuranceLine[2] == null) {
					throw new EmptyCellException("firstYearPremium");
				} else {
					insuranceObject.setFirstYearPremium(insuranceLine[2]);
				}

				if ((insuranceObject != null) && (!firstLine)) {
					// System.out.println("----------------------------\n"+insuranceObject);
					motorInsurance.add(insuranceObject);
				}

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (EmptyCellException e) {

			e.printStackTrace();
		}

		finally {
			System.out.println("Motor Insurance Map Size: " + motorInsurance.size());
			if ((br == null) || (br != null)) {
				try {
					br.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}

		return motorInsurance;
	}

	@Override
	public List<TaxRate> readTaxRateFromCSV() {

		ArrayList<TaxRate> taxRateList = new ArrayList<>();
		String csvFile = "C:/Users/binoy.j.cherian/Music/csv/regionalTaxConfiguration.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		boolean firstLine = false;
		TaxRate rate = null;

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				rate = new TaxRate();
				String[] taxArray = line.split(cvsSplitBy);

				if (taxArray[0].equalsIgnoreCase("state")) {
					firstLine = true;
				} else if (taxArray[0] == null) {
					throw new EmptyCellException("state");
				} else {
					firstLine = false;
					rate.setState(taxArray[0]);
				}

				// handle percent
				if (taxArray[1].equalsIgnoreCase("taxRate")) {

				} else if (taxArray[1] == null) {
					throw new EmptyCellException("taxRate");
				} else {
					rate.setTaxRate(Long.parseLong(taxArray[1]));
				}

				if ((rate != null) && (!firstLine)) {
					// System.out.println("--------\n"+rate);
					taxRateList.add(rate);
				}

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (EmptyCellException e) {

			e.printStackTrace();
		}

		finally {

			System.out.println("Tax Rate Map Size: " + taxRateList.size());
			if ((br == null) || (br != null)) {
				try {
					br.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}

		return taxRateList;
	}

}
