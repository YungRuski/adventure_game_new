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


        MeleeWeapon knife = new MeleeWeapon("Knife", "a hunting knife", 7);
        MeleeWeapon sword = new MeleeWeapon("Sword", "a shiny sword", 10);
        MeleeWeapon baton = new MeleeWeapon("Baton", "a big stick used on civilians.", 5);
        MeleeWeapon axe = new MeleeWeapon("Axe", "a heavy battle axe", 12);
        MeleeWeapon stone = new MeleeWeapon("Stone", "a small stone", 4);
        RangedWeapon slingshot = new RangedWeapon("Slingshot", "a little slingshot that shoots rocks", 6, 5);
        RangedWeapon shortbow = new RangedWeapon("Shortbow", "a bow used for short distances", 10, 10);
        RangedWeapon crossbow = new RangedWeapon("Crossbow", "a crossbow that shoots fire arrows", 15, 14);
        RangedWeapon wand = new RangedWeapon("Wand", "a wand used by common sorceress", 20, 25);
        RangedWeapon potions = new RangedWeapon("Potion", "an instant damage potion", 2, 25);

        MeleeWeapon enemyKnife = new MeleeWeapon("Knife", "A rusty knife.", 7);
        MeleeWeapon enemyStone = new MeleeWeapon("Stone", "A small stone", 4);
        MeleeWeapon enemySword = new MeleeWeapon("Sword", "a worn out sword.", 10);
        RangedWeapon enemyPotions = new RangedWeapon("Potion", "dangerous potions", 2, 25);




        Room room1 = new Room("Room 1", "A room with no distinct features, except two doors.");
        Room room2 = new Room("Room 2", "A room with no distinct features, except two doors.");
        Room room3 = new Room("Room 3", "A room with no distinct features, except two doors.");
        Room room4 = new Room("Room 4", "A room with no distinct features, except two doors.");
        Room room5 = new Room("Room 5", "A room with no distinct features, except one door.");
        Room room6 = new Room("Room 6", "A room with no distinct features, except two doors.");
        Room room7 = new Room("Room 7", "A room with no distinct features, except two doors.");
        Room room8 = new Room("Room 8", "A room with no distinct features, except three doors.");
        Room room9 = new Room("Room 9", "A room with no distinct features, except two doors.");

        Enemy troll = new Enemy("Troll", "a small ugly troll", 25, enemyKnife, room1);
        Enemy goblin = new Enemy("Goblin", "a money hungry goblin", 15, enemyStone, room3);
        Enemy skeleton = new Enemy("Skeleton", "a spooky scary skeleton", 30, enemySword, room5);
        Enemy witch = new Enemy("Witch", "A stinking ugly hag", 45, enemyPotions, room9);

        //Room 1 items
        room1.addItem(lamp);
        room1.addItem(knife);
        //Room 1 enemy
        room1.addEnemy(troll);
        //Room 2 items
        room2.addItem(ring);
        room2.addItem(slingshot);
        //Room 3 items
        room3.addItem(watch);
        room3.addItem(key);
        room3.addItem(Switch);
        //Room 3 enemy
        room3.addEnemy(goblin);
        //Room 4 items
        room4.addItem(baton);
        room4.addItem(shortbow);
        //Room 5 enemy
        room5.addEnemy(skeleton);
        //Room 6 items
        room6.addItem(sword);
        //Room 7 items
        room7.addItem(crossbow);
        //Room 8 items
        room8.addItem(axe);
        //Room 9 enemy
        room9.addEnemy(witch);
        //Room 9 items
        room9.addItem(wand);
        //Room 1 food
        room1.addItem(bread);
        //Room 2 food
        room2.addItem(mushroom);
        //Room 3 food
        room3.addItem(steak);
        //Room 4 food
        room4.addItem(suspiciousSteak);
        //Room 5 food
        room5.addItem(apple);

        firstRoom = room1;

        //Kobler rummene sammen
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