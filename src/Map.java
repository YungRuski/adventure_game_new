public class Map {

    private Room firstRoom;

    public Map() {
        makeRooms();
    }

    public Room getFirstRoom() {
        return firstRoom;
    }

    private void makeRooms() {


        Item lamp = new Item("lamp", "a shiny brass lamp");
        Item key = new Item("key", "a rusty old boken key");
        Item ring = new Item("ring", "a gold ring");
        Item Switch = new Item("switch", "a switch on the wall");
        Item watch = new Item("watch", "a broken watch");

        Food bread = new Food("Bread", "a loaf of bread", 10);
        Food apple = new Food ("Apple", "a red shiny apple", 15);
        Food mushroom = new Food ("Mushroom", "a suspicious shroom", -10);
        Food suspiciousSteak = new Food ("Steak", "a steak filled with maggots", -20);
        Food steak = new Food ("Wagyu steak", "a steak filled with fat marbling", 50);

        MeleeWeapon knife = new MeleeWeapon("Knife", "a hunting knife.");
        MeleeWeapon sword = new MeleeWeapon("Sword", "a shiny sword.");
        MeleeWeapon baton = new MeleeWeapon("Baton", "a big stick used on civilians.");
        MeleeWeapon axe = new MeleeWeapon("Axe", "a heavy battle axe.");
        RangedWeapon slingshot = new RangedWeapon("Slingshot", "a little slingshot that shoots rocks.", 6);
        RangedWeapon shortbow = new RangedWeapon("Shortbow", "a bow used for short distances.", 10);
        RangedWeapon crossbow = new RangedWeapon("Crossbow", "a crossbow that shoots fire arrows.", 15);
        RangedWeapon wand = new RangedWeapon("Wand", "a wand used by common sorceress", 20);


        Room room1 = new Room("Room 1", "A room with no distinct features, except two doors.");
        Room room2 = new Room("Room 2", "A room with no distinct features, except two doors.");
        Room room3 = new Room("Room 3", "A room with no distinct features, except two doors.");
        Room room4 = new Room("Room 4", "A room with no distinct features, except two doors.");
        Room room5 = new Room("Room 5", "A room with no distinct features, except one door.");
        Room room6 = new Room("Room 6", "A room with no distinct features, except two doors.");
        Room room7 = new Room("Room 7", "A room with no distinct features, except two doors.");
        Room room8 = new Room("Room 8", "A room with no distinct features, except three doors.");
        Room room9 = new Room("Room 9", "A room with no distinct features, except two doors.");

        room1.addItem(lamp);
        room1.addItem(knife);
        room2.addItem(ring);
        room2.addItem(slingshot);
        room3.addItem(watch);
        room3.addItem(key);
        room3.addItem(Switch);
        room4.addItem(baton);
        room4.addItem(shortbow);
        room6.addItem(sword);
        room7.addItem(crossbow);
        room8.addItem(axe);
        room9.addItem(wand);
        room1.addItem(bread);
        room2.addItem(mushroom);
        room3.addItem(steak);
        room4.addItem(suspiciousSteak);
        room5.addItem(apple);

        firstRoom = room1;

        room1.setEast(room2);
        room2.setEast(room3);
        room3.setSouth(room6);
        room6.setSouth(room9);
        room9.setWest(room8);
        room8.setNorth(room5);
        room8.setWest(room7);
        room7.setNorth(room4);
        room4.setNorth(room1);
    }
}