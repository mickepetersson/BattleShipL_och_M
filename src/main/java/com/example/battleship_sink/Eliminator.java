/*
*
* Author: Mikael Petersson
*
* Comment:
* This class is still under construction, and its purpose is to further develop,
* and hone the eliminator methods thus specified in ShipPlacer, and ultimately replace them,
*  as they are generally messy
* however, due to time constraints, it remains as is at the time of finishing this project
*
* */

package com.example.battleship_sink;

public class Eliminator {
    int[] tempArray;

    //Empty constructor

    public Eliminator() {
    }

    //eliminate right

    //dummy test method to plot a ship
    public Board setShip (Board board, int size, int row, int col){
        tempArray = new int[size];
        int tempArrayIndex = 0;
        for (int i = 0; i < size; i++){
            board.getBoard()[row][col + i].setHasShip(true);
            board.getBoard()[row][col + i].setCanPlaceShip(false);
            tempArray[tempArrayIndex + i] = board.getBoard()[0][i].getNumber();
        }
        eliminateRight(board, row, col, size);
        return board;
    }

    public Board eliminateRight(Board board, int row, int col, int size) {
        //check if position is 0, 0
        if (row == 0 && col == 0) {
            //loop through ship
            for (int i = 0; i <= size; i++) {
                //set square below ship to be eliminated
                board.getBoard()[row + 1][col + i].setisEliminated(true);
                board.getBoard()[row + 1][col + i].setCanPlaceShip(false);
                System.out.println("eliminated: " + board.getBoard()[row + 1][col + i].getNumber());
                if (i == size) {
                    //eliminate square after size
                    board.getBoard()[row][col + i].setisEliminated(true);
                    board.getBoard()[row][col + i].setCanPlaceShip(false);
                    System.out.println("eliminated: " + board.getBoard()[row][col + i].getNumber());
                }
            }
            //end of first loop
        } else if (row == 0 && col - 1 >= 0 && col + size < 9) {
            //if column - 1 is more than 0, and column + size is less than nine
            for (int i = 0; i <= size; i++) {
                //only first iteration: eliminate squares behind and diagonally below
                if (i == 0) {
                    board.getBoard()[row][col - 1].setisEliminated(true);
                    board.getBoard()[row][col - 1].setCanPlaceShip(false);
                    board.getBoard()[row + 1][col - 1].setisEliminated(true);
                    board.getBoard()[row + 1][col - 1].setCanPlaceShip(false);
                    System.out.println("eliminated: " + board.getBoard()[row][col - 1].getNumber() + " & " + board.getBoard()[row + 1][col - 1].getNumber());
                }
                //regular loop: set square below ship to be eliminated, as well as row + 1, col + size
                board.getBoard()[row + 1][col + i].setisEliminated(true);
                board.getBoard()[row + 1][col + i].setCanPlaceShip(false);
                System.out.println("eliminated: " + board.getBoard()[row + 1][col + i].getNumber());

                //to run at last iteration, at final square of size
                if (i == size) {
                    //eliminate size + 1
                    board.getBoard()[row][col + i].setisEliminated(true);
                    board.getBoard()[row][col + i].setCanPlaceShip(false);
                    System.out.println("eliminated: " + board.getBoard()[row][col + i].getNumber());
                }
            }
            //end of second loop
        } else if (row == 0 && col + size == 9) {
            //second extreme, if row == 0 and col == 9
            for (int i = 0; i < size; i++) {
                //only first iteration: eliminate squares behind and diagonally below
                if (i == 0) {
                    board.getBoard()[row][col - 1].setisEliminated(true);
                    board.getBoard()[row][col - 1].setCanPlaceShip(false);
                    board.getBoard()[row + 1][col - 1].setisEliminated(true);
                    board.getBoard()[row + 1][col - 1].setCanPlaceShip(false);
                }
                //regular loop: set square below ship to be eliminated
                board.getBoard()[row + 1][col + i].setisEliminated(true);
                board.getBoard()[row + 1][col + i].setCanPlaceShip(false);
            }
            //end of third loop
        } else if (row == 9 && col == 0) {
            //loop through ship
            for (int i = 0; i <= size; i++) {
                //set square above ship to be eliminated
                board.getBoard()[row - 1][col + i].setisEliminated(true);
                board.getBoard()[row - 1][col + i].setCanPlaceShip(false);
                if (i == size) {
                    //eliminate square after size
                    board.getBoard()[row][col + i].setisEliminated(true);
                    board.getBoard()[row][col + i].setCanPlaceShip(false);
                }
            }
            //end of fourth loop
        } else if (row == 9 && col + size == 9) {
            //fifth extreme
            for (int i = 0; i < size; i++) {
                //only first iteration: eliminate squares behind and diagonally above
                if (i == 0) {
                    board.getBoard()[row][col - 1].setisEliminated(true);
                    board.getBoard()[row][col - 1].setCanPlaceShip(false);
                    board.getBoard()[row - 1][col - 1].setisEliminated(true);
                    board.getBoard()[row - 1][col - 1].setCanPlaceShip(false);
                }
                //regular loop: set square below ship to be eliminated
                board.getBoard()[row - 1][col + i].setisEliminated(true);
                board.getBoard()[row - 1][col + i].setCanPlaceShip(false);
            }
            //end of fifth loop
        } else if (row == 9 && col > 0 && col + size < 9) {
            for (int i = 0; i <= size; i++) {
                //only first iteration: eliminate squares behind and diagonally above
                if (i == 0) {
                    board.getBoard()[row][col - 1].setisEliminated(true);
                    board.getBoard()[row][col - 1].setCanPlaceShip(false);
                    board.getBoard()[row - 1][col - 1].setisEliminated(true);
                    board.getBoard()[row - 1][col - 1].setCanPlaceShip(false);
                }
                //regular loop: set square below ship to be eliminated, as well as row + 1, col + size
                board.getBoard()[row - 1][col + i].setisEliminated(true);
                board.getBoard()[row - 1][col + i].setCanPlaceShip(false);
                //to run at last iteration, at final square of size
                if (i == size) {
                    //eliminate size + 1
                    board.getBoard()[row][col + i].setisEliminated(true);
                    board.getBoard()[row][col + i].setCanPlaceShip(false);
                }
            } // end of 6th loop
        } else if (row > 0 && row < 9) { // all other cases
            if (col == 0) {
                for (int i = 0; i <= size; i++) {
                    //set square below and above ship to be eliminated
                    board.getBoard()[row + 1][col + i].setisEliminated(true);
                    board.getBoard()[row + 1][col + i].setCanPlaceShip(false);
                    board.getBoard()[row - 1][col + i].setisEliminated(true);
                    board.getBoard()[row - 1][col + i].setCanPlaceShip(false);
                    if (i == size) {
                        //eliminate square after size
                        board.getBoard()[row][col + i].setisEliminated(true);
                        board.getBoard()[row][col + i].setCanPlaceShip(false);

                    }
                }
            } else if (col + size == 9) {
                for (int i = 0; i < size; i++) {
                    //only first iteration: eliminate squares behind and diagonally above & below
                    if (i == 0) {
                        board.getBoard()[row][col - 1].setisEliminated(true);
                        board.getBoard()[row][col - 1].setCanPlaceShip(false);
                        board.getBoard()[row - 1][col - 1].setisEliminated(true);
                        board.getBoard()[row - 1][col - 1].setCanPlaceShip(false);
                        board.getBoard()[row + 1][col - 1].setisEliminated(true);
                        board.getBoard()[row + 1][col - 1].setCanPlaceShip(false);
                    }
                    //regular loop: set square above and below ship to be eliminated
                    board.getBoard()[row - 1][col + i].setisEliminated(true);
                    board.getBoard()[row - 1][col + i].setCanPlaceShip(false);
                    board.getBoard()[row + 1][col + i].setisEliminated(true);
                    board.getBoard()[row + 1][col + i].setCanPlaceShip(false);
                    //to run at last iteration, at final square of size
                    if (i == size - 1) {
                        //eliminate size + 1
                        board.getBoard()[row][col + i].setisEliminated(true);
                        board.getBoard()[row][col + i].setCanPlaceShip(false);
                    }

                }

            } else if (col - 1 >= 0 && col + size < 9){
                for (int i = 0; i <= size; i++) {
                    //only first iteration: eliminate squares behind and diagonally above & below
                    if (i == 0) {
                        board.getBoard()[row][col - 1].setisEliminated(true);
                        board.getBoard()[row][col - 1].setCanPlaceShip(false);
                        board.getBoard()[row - 1][col - 1].setisEliminated(true);
                        board.getBoard()[row - 1][col - 1].setCanPlaceShip(false);
                        board.getBoard()[row + 1][col - 1].setisEliminated(true);
                        board.getBoard()[row + 1][col - 1].setCanPlaceShip(false);
                    }
                    //regular loop: set square above and below ship to be eliminated
                    board.getBoard()[row - 1][col + i].setisEliminated(true);
                    board.getBoard()[row - 1][col + i].setCanPlaceShip(false);
                    board.getBoard()[row + 1][col + i].setisEliminated(true);
                    board.getBoard()[row + 1][col + i].setCanPlaceShip(false);
                    //to run at last iteration, at final square of size
                    if (i == size) {
                        //eliminate size + 1
                        board.getBoard()[row][col + i].setisEliminated(true);
                        board.getBoard()[row][col + i].setCanPlaceShip(false);
                    }

                }

            }
//end of 7th loop
        }
        return board;
    }

    //Eliminate left
    public Board eliminateLeft(Board board, int row, int col, int size) {
        //check if position is 0, 9
        if (row == 0 && col == 9) {
            //loop through ship
            for (int i = 0; i <= size; i++) {
                //set square below ship to be eliminated
                board.getBoard()[row + 1][col + i].setisEliminated(true);
                board.getBoard()[row + 1][col + i].setCanPlaceShip(false);
                if (i == size) {
                    //eliminate square after size
                    board.getBoard()[row][col - i].setisEliminated(true);
                    board.getBoard()[row][col - i].setCanPlaceShip(false);
                }
            }
            //end of first loop
        } else if (row == 0 && col + 1 <= 9 && col - size > 0) {
            //if column - 1 is more than 0, and column + size is less than nine
            for (int i = 0; i <= size; i++) {
                //only first iteration: eliminate square behind and diagonally below
                if (i == 0) {
                    board.getBoard()[row][col + 1].setisEliminated(true);
                    board.getBoard()[row][col + 1].setCanPlaceShip(false);
                    board.getBoard()[row + 1][col + 1].setisEliminated(true);
                    board.getBoard()[row + 1][col + 1].setCanPlaceShip(false);
                }
                //regular loop: set square below ship to be eliminated, as well as row + 1, col - size + 1
                board.getBoard()[row + 1][col - i].setisEliminated(true);
                board.getBoard()[row + 1][col - i].setCanPlaceShip(false);

                //to run at last iteration, at final square of size
                if (i == size) {
                    //eliminate size + 1
                    board.getBoard()[row][col - i].setisEliminated(true);
                    board.getBoard()[row][col - i].setCanPlaceShip(false);
                }
            }
            //end of second loop
        } else if (row == 0 && col + size == 9) {
            //second extreme, if row == 0 and col == 9
            for (int i = 0; i < size; i++) {
                //only first iteration: eliminate squares behind and diagonally below
                if (i == 0) {
                    board.getBoard()[row][col - 1].setisEliminated(true);
                    board.getBoard()[row][col - 1].setCanPlaceShip(false);
                    board.getBoard()[row + 1][col - 1].setisEliminated(true);
                    board.getBoard()[row + 1][col - 1].setCanPlaceShip(false);
                }
                //regular loop: set square below ship to be eliminated
                board.getBoard()[row + 1][col + i].setisEliminated(true);
                board.getBoard()[row + 1][col + i].setCanPlaceShip(false);
            }
            //end of third loop
        } else if (row == 9 && col == 0) {
            //loop through ship
            for (int i = 0; i <= size; i++) {
                //set square above ship to be eliminated
                board.getBoard()[row - 1][col + i].setisEliminated(true);
                board.getBoard()[row - 1][col + i].setCanPlaceShip(false);
                if (i == size) {
                    //eliminate square after size
                    board.getBoard()[row][col + i].setisEliminated(true);
                    board.getBoard()[row][col + i].setCanPlaceShip(false);
                }
            }
            //end of fourth loop
        } else if (row == 9 && col + size == 9) {
            //fifth extreme
            for (int i = 0; i < size; i++) {
                //only first iteration: eliminate squares behind and diagonally above
                if (i == 0) {
                    board.getBoard()[row][col - 1].setisEliminated(true);
                    board.getBoard()[row][col - 1].setCanPlaceShip(false);
                    board.getBoard()[row - 1][col - 1].setisEliminated(true);
                    board.getBoard()[row - 1][col - 1].setCanPlaceShip(false);
                }
                //regular loop: set square below ship to be eliminated
                board.getBoard()[row - 1][col + i].setisEliminated(true);
                board.getBoard()[row - 1][col + i].setCanPlaceShip(false);
            }
            //end of fifth loop
        } else if (row == 9 && col > 0 && col + size < 9) {
            for (int i = 0; i <= size; i++) {
                //only first iteration: eliminate squares behind and diagonally above
                if (i == 0) {
                    board.getBoard()[row][col - 1].setisEliminated(true);
                    board.getBoard()[row][col - 1].setCanPlaceShip(false);
                    board.getBoard()[row - 1][col - 1].setisEliminated(true);
                    board.getBoard()[row - 1][col - 1].setCanPlaceShip(false);
                }
                //regular loop: set square below ship to be eliminated, as well as row + 1, col + size
                board.getBoard()[row - 1][col + i].setisEliminated(true);
                board.getBoard()[row - 1][col + i].setCanPlaceShip(false);
                //to run at last iteration, at final square of size
                if (i == size) {
                    //eliminate size + 1
                    board.getBoard()[row][col + i].setisEliminated(true);
                    board.getBoard()[row][col + i].setCanPlaceShip(false);
                }
            } // end of 6th loop
        } else if (row > 0 && row < 9) { // all other cases
            if (col == 0) {
                for (int i = 0; i <= size; i++) {
                    //set square below and above ship to be eliminated
                    board.getBoard()[row + 1][col + i].setisEliminated(true);
                    board.getBoard()[row + 1][col + i].setCanPlaceShip(false);
                    board.getBoard()[row - 1][col + i].setisEliminated(true);
                    board.getBoard()[row - 1][col + i].setCanPlaceShip(false);
                    if (i == size) {
                        //eliminate square after size
                        board.getBoard()[row][col + i].setisEliminated(true);
                        board.getBoard()[row][col + i].setCanPlaceShip(false);

                    }
                }
            } else if (col + size == 9) {
                for (int i = 0; i < size; i++) {
                    //only first iteration: eliminate squares behind and diagonally above & below
                    if (i == 0) {
                        board.getBoard()[row][col - 1].setisEliminated(true);
                        board.getBoard()[row][col - 1].setCanPlaceShip(false);
                        board.getBoard()[row - 1][col - 1].setisEliminated(true);
                        board.getBoard()[row - 1][col - 1].setCanPlaceShip(false);
                        board.getBoard()[row + 1][col - 1].setisEliminated(true);
                        board.getBoard()[row + 1][col - 1].setCanPlaceShip(false);
                    }
                    //regular loop: set square above and below ship to be eliminated
                    board.getBoard()[row - 1][col + i].setisEliminated(true);
                    board.getBoard()[row - 1][col + i].setCanPlaceShip(false);
                    board.getBoard()[row + 1][col + i].setisEliminated(true);
                    board.getBoard()[row + 1][col + i].setCanPlaceShip(false);
                    //to run at last iteration, at final square of size
                    if (i == size - 1) {
                        //eliminate size + 1
                        board.getBoard()[row][col + i].setisEliminated(true);
                        board.getBoard()[row][col + i].setCanPlaceShip(false);
                    }

                }

            } else if (col - 1 >= 0 && col + size < 9){
                for (int i = 0; i <= size; i++) {
                    //only first iteration: eliminate squares behind and diagonally above & below
                    if (i == 0) {
                        board.getBoard()[row][col - 1].setisEliminated(true);
                        board.getBoard()[row][col - 1].setCanPlaceShip(false);
                        board.getBoard()[row - 1][col - 1].setisEliminated(true);
                        board.getBoard()[row - 1][col - 1].setCanPlaceShip(false);
                        board.getBoard()[row + 1][col - 1].setisEliminated(true);
                        board.getBoard()[row + 1][col - 1].setCanPlaceShip(false);
                    }
                    //regular loop: set square above and below ship to be eliminated
                    board.getBoard()[row - 1][col + i].setisEliminated(true);
                    board.getBoard()[row - 1][col + i].setCanPlaceShip(false);
                    board.getBoard()[row + 1][col + i].setisEliminated(true);
                    board.getBoard()[row + 1][col + i].setCanPlaceShip(false);
                    //to run at last iteration, at final square of size
                    if (i == size) {
                        //eliminate size + 1
                        board.getBoard()[row][col + i].setisEliminated(true);
                        board.getBoard()[row][col + i].setCanPlaceShip(false);
                    }

                }

            }
//end of 7th loop
        }
        return board;
    }


}