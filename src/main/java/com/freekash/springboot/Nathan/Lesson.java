package com.freekash.springboot.Nathan;

public class Lesson {

    public class CarLot {

        private Vehicle[] usedVehicles;
        private Vehicle[] newVehicles;

        public CarLot(Vehicle[] vehicles){
            /*
             * Implement CarLot constructor:
             * - Filter vehicles by whether they are used or new
             * - Used vehicles go into 'usedVehicles'
             * - New vehicles go into 'newVehicles'
             */
        }

        /*
         * Calculates the necessary markup to get specified profit
         *
         * @param profit the desired profit from the sale of all vehicles
         * @returns the necessary markup applied to sale of all vehicles to achieve profit (.2 = 20% markup)
         */
        public double calculateMarkup(int profit){
            /*
             * Implement calculateMarkup method:
             * - The same percentage markup will be applied to all of the vehicles
             * - If the vehicle's price is $10,000, markup is 20%, the sale will be $12,000 and the profit will be $2000
             */
            return 0.0;
        }

    }

    public class Vehicle{
        private int price;
        private String model;
        private int isUsed;
        public Vehicle(int price, String model){
            this.price = price;
            this.model = model;
        }

        public int getIsUsed() {
            return isUsed;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return String.format("Vehicle: %s, Price: %s", model, price);
        }
    }

    public class Truck {
        /*
         * Create a Truck Class that extends off of the Vehicle class
         * - Should be able to be added to the CarLot
         * - Should have additional parameter: int wheels
         * - Param 'wheels' will be initialized in constructor
         * - Param should be added to toString ("Vehicle: ford, Price: 50000, Wheels: 18")
         */

    }



}
