import java.util.Random;
import java.util.Scanner;

public class Romeo_and_Juliet_Game {
    private static final int ENV_SIZE = 8;
    private static  int NUM_SOL = 2;
    private static final int NUM_ARROWS = 5;
    private static final int JULIET_LOCATION = (int) (Math.random()*(60-16+1))+16;

    private static final int ROMEO_START = 0;

    private static int romeoLocation;
    private static int julietLocation;
    private static int[] soldierLocations;
    private static int arrowsLeft;

    public static void main(String[] args) {
        initializeGame();

        System.out.println("Welcome to Romeo n Juliet game!");
        System.out.println("In this game, you are Romeo and your task is to find Juliet.");
        System.out.println("However, Juliet's father has sent a pack of soldiers to kill you before you find Juliet.\nFind Juliet before the soldiers find you.\nShoot the soldiers if you see any.");
        System.out.println("You can shoot a soldier only if he is 1 block away from you. You will be found if the soldier is an adjacent block.");
        
        while (true) {
        displayGrid();
            
        System.out.println("You are in room " + romeoLocation);
            System.out.println("You have " + arrowsLeft + " arrows left.");
            for(int soldier:soldierLocations){
            if(romeoLocation==soldier-1 || romeoLocation==soldier+1||romeoLocation==soldier-8 || romeoLocation==soldier+8){
                System.out.println("Got caught");
                System.exit(0);
            }
        }
            int action = getUserAction();
            movePlayer(action);
            if (romeoLocation == julietLocation-1 || romeoLocation == julietLocation+1 || romeoLocation== julietLocation+8 || romeoLocation== julietLocation-8) {
                    displayGrid();
                    System.out.println("You found Juliet! You won!");
                    break;
            }
        }
        }
    

    private static void initializeGame() {
        romeoLocation = ROMEO_START;
        julietLocation = JULIET_LOCATION;
        arrowsLeft = NUM_ARROWS;
    }
    
    private static int[] generateSoldierLocations() {
        Random random = new Random();
        int[] soldiers = new int[NUM_SOL];
        for (int i = 0; i < NUM_SOL; i++) {
            int soldierLocation;
            do {
                soldierLocation = random.nextInt(ENV_SIZE * ENV_SIZE);
            } while (soldierLocation == romeoLocation || soldierLocation== julietLocation || isSol(soldierLocation, soldiers));
            soldiers[i] = soldierLocation;
        }
        return soldiers;
    }

    private static boolean isSol(int location, int[] soldiers) {
        for (int soldier : soldiers) {
            if (soldier == location) {
                return true;
            }
        }
        return false;
    }

    private static void displayGrid() {
        soldierLocations = generateSoldierLocations();
        System.out.println("#################");
        for (int i = 0; i < ENV_SIZE; i++) {
            for (int j = 0; j < ENV_SIZE; j++) {
                int roomNumber = i * ENV_SIZE + j;
                if (roomNumber == romeoLocation) {
                    System.out.print("R ");
                } else if (roomNumber == julietLocation) {
                    System.out.print("J ");
                } else if (isSol(roomNumber, soldierLocations)) {
                    System.out.print("S ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
        System.out.println("#################");
    }

    private static int getUserAction() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your move (1: Move up, 2: Move down, 3: Move left, 4: Move right, 5: Shoot arrow): ");
        return scanner.nextInt();
    }

    private static void movePlayer(int direction) {
        switch (direction) {
            case 1: // Move up
                if (romeoLocation >= ENV_SIZE) {
                     romeoLocation -= ENV_SIZE;
                }
                break;
            case 2: // Move down
                if (romeoLocation < (ENV_SIZE * (ENV_SIZE - 1))) {
                    romeoLocation += ENV_SIZE;
                }
                break;
            case 3: // Move left
                if (romeoLocation % ENV_SIZE != 0) {
                    romeoLocation--;
                 }
                break;
            case 4: // Move right
                if (romeoLocation % ENV_SIZE != ENV_SIZE - 1) {
                    romeoLocation++;
                }
                break;
            case 5: // Shoot arrow
            for(int soldier:soldierLocations){
            if(romeoLocation==soldier-2 || romeoLocation==soldier+2||romeoLocation==soldier-9 || romeoLocation==soldier+9){
                 if (arrowsLeft > 0 ) {
                    arrowsLeft--;
                    NUM_SOL--;
                    System.out.println("One soldier eliminated");
                }
            }
        }
               
                break;
            }
                
            }
}
