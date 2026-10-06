import java.util.ArrayList;

public class AdventureUI {

    public void startGame() {
        Adventure adventure = new Adventure();


        boolean goingIntoRooms = false;
        IO.println("You have entered the most amazing dungeon!!!!");
        IO.println("-----------------------------------------------");
        printHelpMenu();


        while (!goingIntoRooms) {

            String input = IO.readln();

            String[] commandArray = input.split(" ");
            /*
              COMMAND   ARGUMENT
              go        north
              go        south
              take      sword
              drop      key
              inventory
              look
             */

            String command = commandArray[0];
            String argument = "";
            if (commandArray.length > 1) {

                argument = commandArray[1];
            }

            switch (command.toUpperCase()) {
                case "GO" -> go(argument, adventure);
                case "LOOK" -> IO.println(adventure.lookAround());
                case "EXIT" -> goingIntoRooms = true;
                case "HELP" -> printHelpMenu();
                case "TAKE" -> {
                    if (adventure.takeItem(argument)) {
                        IO.println("Picking up " + argument);
                    } else {
                        IO.println("There is no " + argument + " in this room.");
                    }
                }
                case "DROP" -> {
                    if (adventure.dropItem(argument)) {
                        IO.println("Dropping " + argument);
                    } else {
                        IO.println("Nothing to drop");
                    }
                }
                case "INVENTORY" -> {
                    ArrayList<Item> inventory = adventure.getInventory();
                    ArrayList<Weapon> equipped = adventure.getEquipped();
                    if (inventory.isEmpty() && equipped.isEmpty()) {
                        IO.println("Nothing in inventory.");
                    }
                    for (Item item : inventory) {
                        IO.println(item);
                    }
                    for (Weapon weapon : equipped) {
                        IO.println("Equipped: " + weapon);
                    }
                }
                case "HEALTH" -> {
                    adventure.printHealth();
                }
                case "EAT" -> {
                    EatResult result = adventure.eat(argument);
                    switch (result) {
                        case EatResult.EATEN -> IO.println("You are eating " + argument + ".");
                        case EatResult.NOT_FOOD -> IO.println("You can't eat a " + argument + ".");
                        case EatResult.NOT_FOUND -> IO.println("There is no " + argument + " in your inventory.");

                    }
                }
                case "EQUIP" -> {
                    WeaponEquip result = adventure.equip(argument);
                    switch (result) {
                        case WeaponEquip.EQUIPPED -> IO.println("You have equipped " + argument);
                        case WeaponEquip.NO_WEAPON -> IO.println("You cannot equip " + argument);
                        case WeaponEquip.CANNOT_ATTACK -> IO.println("There is no " + argument + " in your inventory");
                    }
                }
                case "ATTACK" -> {
                    int result = adventure.attack(argument);

                    if (result == -2) {
                        IO.println("You don't have a weapon equipped");
                    } else if (result == -1) {
                        IO.println("You are attacking with your melee weapon");
                        adventure.getEnemyHealth();
                    } else if (result == 0) {
                        IO.println("You have no ammunition left");
                    } else {
                        IO.println("You are attacking");
                        IO.println("You have " + (result - 1) + " shots left");
                        adventure.getEnemyHealth();
                    }
                }

                default -> {
                }
            }

        }
    }

    public void printHelpMenu() {
        IO.println("Type GO NORTH to go north, GO SOUTH to go south, GO WEST to go west, GO EAST to go east");
        IO.println("Type LOOK to look around");
        IO.println("Type EXIT to quit the program.");
        IO.println("Type HELP to get all commands.");
    }

    private void go(String direction, Adventure adventure) {
        switch (direction.toUpperCase()) {
            case "NORTH" -> {
                IO.println(adventure.goNorth() ? "going north" : "Could not go that way");
            }
            case "SOUTH" -> {
                IO.println(adventure.goSouth() ? "going south" : "Could not go that way");
            }
            case "EAST" -> {
                IO.println(adventure.goEast() ? "going east" : "Could not go that way");
            }
            case "WEST" -> {
                IO.println(adventure.goWest() ? "going west" : "Could not go that way");
            }
        }
    }


}
