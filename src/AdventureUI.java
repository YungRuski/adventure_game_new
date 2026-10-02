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
                    adventure.printInventory();
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
                    switch (result){
                        case WeaponEquip.EQUIPPED -> IO.println("You have equipped " + argument);
                        case WeaponEquip.NO_WEAPON -> IO.println("You cannot equip " + argument);
                        case WeaponEquip.CANNOT_ATTACK -> IO.println("There is no " + argument + " in your inventory");
                    }
                }
                case "ATTACK" -> {
                    WeaponEquip result = adventure.attack();

                    switch (result){
                        case WeaponEquip.EQUIPPED -> IO.println("You are attacking");
                        case WeaponEquip.NO_WEAPON -> IO.println("You dont have a weapon equipped");
                        case WeaponEquip.CANNOT_ATTACK -> IO.println("Out of ammunition");
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
