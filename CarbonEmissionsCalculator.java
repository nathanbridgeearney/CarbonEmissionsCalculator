// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP-102-112 - 2021T1, Assignment 1
 * Name: Nathan Bridge-Earney
 * Username: bridgnath1
 * ID:300565456
 */

import ecs100.*;

/** Program for calculating carbon emissions */

public class CarbonEmissionsCalculator{

    public static final double EMISSION_FACTOR_POWER = 0.0977;   // emissions factor of electricity per kWh
    public static final double EMISSION_FACTOR_WASTE = 0.299;    // emissions factor of food waste per kg
    public static final double EMISSION_FACTOR_PETROL = 0.317;
    public static final double EMISSION_FACTOR_DIESEL = 0.296;
    public static final double EMISSION_FACTOR_HPETROL = 0.250;
    public static final double EMISSION_FACTOR_HDIESEL = 0.265;
    public static final double ANNUAL_AVERAGE_POWER_EMISSION_NZ = 266.5;   //Annual average carbon emissions in NZ (kg) from electricity use
    public static final double ANNUAL_AVERAGE_FOOD_WASTE_EMISSION_NZ = 18; //Annual average carbon emissions in NZ (kg) from food waste


    /**
     * Calculates and prints carbon emissions
     */
    public void calculateEmissions(){
        /*# YOUR CODE HERE */
        /* I would like to have made another function one to check the inputs and one to give the answers */
        /* But I wasn't sure if I was allowed */
        var foodWaste = UI.askDouble("How much food waste do you have each week in kgs?");
        var electricUse = UI.askInt("How much energy do you use per month in kwh?");
        var factCheck = UI.askBoolean("Is this correct? You eat " + foodWaste + " kgs of food and use " + electricUse + " kwh of energy?");
        if (!factCheck) calculateEmissions();
        /* I could probably just reuse the previous variable names */
        var carbonP = Double.parseDouble(String.format("%.2f",electricUse * EMISSION_FACTOR_POWER));
        var carbonF = Double.parseDouble(String.format("%.2f",foodWaste * EMISSION_FACTOR_WASTE));
        /*Here is where I would have made another function to call out to */
        /* Then you wouldn't have to restart the whole program*/
        factCheck = UI.askBoolean("Would you like to continue?");
        if (!factCheck) {
            UI.print("Please press the quit button then");
        } else {
            UI.println("You produce " + carbonP + "kgs of CO2 each month through your energy usage.");
            UI.println("You produce " + carbonF + "kgs of CO2 each week through your food waste.");
        }
        /*Here is where I would have made another function to call out to */
        /* Then you wouldn't have to restart the whole program*/
        var people = UI.askInt("How many people reside in your house hold?");
        factCheck = UI.askBoolean("Is " + people + " the amount of people in your home?");
        if (!factCheck) {
            UI.println("Please start again");
            calculateEmissions();
        }

        var totalAvgF = carbonF * 52 * 100 / ANNUAL_AVERAGE_FOOD_WASTE_EMISSION_NZ;
        var perPersonAvg = Double.parseDouble(String.format("%.2f",totalAvgF / people));
        UI.println("Emissions are "+ perPersonAvg + " of NZ average for food");

        var totalAvgP = carbonP * 12 * 100 / ANNUAL_AVERAGE_POWER_EMISSION_NZ;
        perPersonAvg = Double.parseDouble(String.format("%.2f",totalAvgP / people));
        UI.println("Emissions are " + perPersonAvg + " of NZ average for power");

    }

    public void calculateEmissionsCompletion(){
        var foodWaste = UI.askDouble("How much food waste do you have each week in kgs?");
        var electricUse = UI.askInt("How much energy do you use per month in kwh?");
        var factCheck = UI.askBoolean("Is this correct? You eat " + foodWaste + " kgs of food, use " + electricUse + " kwh of energy");
        if (!factCheck) calculateEmissionsCompletion();
        /* I could probably just reuse the previous variable names */
        var carbonP = Double.parseDouble(String.format("%.2f",electricUse * EMISSION_FACTOR_POWER));
        var carbonF = Double.parseDouble(String.format("%.2f",foodWaste * EMISSION_FACTOR_WASTE));
        /*Here is where I would have made another function to call out to */
        /* Then you wouldn't have to restart the whole program*/
        factCheck = UI.askBoolean("Would you like to continue?");
        if (!factCheck) {
            UI.print("Please press the quit button then");
        } else {
            UI.println("You produce " + carbonP + "kgs of CO2 each month through your energy usage.");
            UI.println("You produce " + carbonF + "kgs of CO2 each week through your food waste.");
        }
        /*Here is where I would have made another function to call out to */
        /* Then you wouldn't have to restart the whole program*/
        var people = UI.askInt("How many people reside in your house hold?");
        factCheck = UI.askBoolean("Is " + people + " the amount of people in your home?");
        if (!factCheck) {
            UI.println("Please start again");
            calculateEmissionsCompletion();
        }

        var totalAvgF = carbonF * 52 * 100 / ANNUAL_AVERAGE_FOOD_WASTE_EMISSION_NZ;
        var perPersonAvg = Double.parseDouble(String.format("%.2f",totalAvgF / people));
        UI.println("Emissions are "+ perPersonAvg + " of NZ average for food");

        var totalAvgP = carbonP * 12 * 100 / ANNUAL_AVERAGE_POWER_EMISSION_NZ;
        perPersonAvg = Double.parseDouble(String.format("%.2f",totalAvgP / people));
        UI.println("Emissions are " + perPersonAvg + " of NZ average for power");
        carUse ();
    }

    public void carUse (){
        var carType = UI.askString("What car type do you drive?; Petrol, Diesel, Petrol Hybrid, Diesel Hybrid");

        if (carType.equals("Petrol")){
            var kms = UI.askDouble("How many kilometers do you drive a month");
            var fuelWaste = Double.parseDouble(String.format("%.2f",kms * EMISSION_FACTOR_PETROL));
            UI.println("You produce " + fuelWaste +" kgs of fuel waste a month");
        }
        else if (carType.equals("Diesel")){
            var kms = UI.askDouble("How many kilometers do you drive a month");
            var fuelWaste = Double.parseDouble(String.format("%.2f",kms * EMISSION_FACTOR_DIESEL));
            UI.println("You produce " + fuelWaste +" kgs of fuel waste a month");
        }
        else if (carType.equals("Petrol Hybrid")){
            var kms = UI.askDouble("How many kilometers do you drive a month");
            var fuelWaste = Double.parseDouble(String.format("%.2f",kms * EMISSION_FACTOR_HPETROL));
            UI.println("You produce " + fuelWaste +" kgs of fuel waste a month");
        }
        else if (carType.equals("Diesel Hybrid")){
            var kms = UI.askDouble("How many kilometers do you drive a month");
            var fuelWaste = Double.parseDouble(String.format("%.2f",kms * EMISSION_FACTOR_HDIESEL));
            UI.println("You produce " + fuelWaste +" kgs of fuel waste a month");
        }
        else {
            UI.askString("Please input exactly as printed above.");
            carUse ();
        }

    }



    public void setupGUI(){
        UI.initialise();
        UI.addButton("Calculate Emissions", this::calculateEmissions);
        UI.addButton("Calculate Emissions Completion", this::calculateEmissionsCompletion);
        UI.addButton("Quit", UI::quit);
        UI.setDivider(1);    // Expand the Text pane

    }


    public static void main(String[] args){
        CarbonEmissionsCalculator cec = new CarbonEmissionsCalculator();
        cec.setupGUI();
    }

}
