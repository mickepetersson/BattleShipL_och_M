package com.example.battleship_sink;

/*
* Author: Mikael Petersson
*
* Comment:
* Decided to keep class "as is", as I feel that it represents more or less
* where my mind was at, at the time of writing. Although the tips concerning
* replacing the int[] with BoardSquare[] was much appreciated and will be put into
* the think bank for next time!
*
*/

import java.util.Arrays;


    public class Ship {
        private int[] body;
        private boolean isDestroyed;


        public Ship() {

        }

        public Ship(int[] body, boolean isDestroyed) {
            this.body = Arrays.copyOf(body, body.length);
            this.isDestroyed = isDestroyed;
        }
        //getters and setters

        public int[] getBody() {
            return body;
        }

        public void setBody(int[] body) {
            this.body = body;
        }

        public boolean isDestroyed() {
            return isDestroyed;
        }

        public void setDestroyed(boolean destroyed) {
            isDestroyed = destroyed;
        }

        public int[] assignBodyArray(int number){
        return null;
        }


        @Override
        public String toString() {
            return "Ship{" +
                    "body=" + Arrays.toString(body);
        }
    }
