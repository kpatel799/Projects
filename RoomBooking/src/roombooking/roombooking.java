package roombooking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class roombooking {

    private static boolean MainMenu = true;
    private static boolean SubMenu = true;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Room[] Rooms = new Room[5];
        Rooms[0] = new Room();
        Rooms[1] = new Room();
        Rooms[2] = new Room();
        Rooms[3] = new Room();
        Rooms[4] = new Room();

        int roomNum = 0;
        initialise(Rooms);
        while (MainMenu) {
            while (SubMenu) {

                System.out.println("Hello and Welcome to the room booking system ");
                System.out.println("Please select one of the options.");
                System.out.println("A: Book A New Room.");

                System.out.println("E: Display Empty Rooms.");

                System.out.println("V: View all Rooms.");

                System.out.println("D: Delete customer from room.");

                System.out.println("F: Find room from customer name.");

                System.out.println("O: View rooms Ordered alphabetically by name.");

                String Selection = input.next();
                Selection = Selection.toUpperCase();
                switch (Selection) {
                    case "A":
                        BookARoom(Rooms, roomNum);
                        break;
                    case "E":
                        CheckIfEmpty(Rooms);
                        break;
                    case "V":
                        ViewAllRooms(Rooms);
                        break;
                    case "D":
                        DeleteCustomerFromRoom(Rooms, roomNum);
                        break;
                    case "F":
                        FindRoomFromCustomerName(Rooms);
                        break;

                    case "O":
                        ViewRoomsOrderedAlphabeticallyByName(Rooms);
                        break;
                    default:
                        System.out.println("Invalid Selection");
                        break;
                }

                System.out.println("Would you like to Select another Option\n1 ) Yes\n2 ) No");

                if (input.nextInt() == 1) {
                    SubMenu = true;
                } else {
                    SubMenu = false;
                }
            }
            SubMenu = true;

            System.out.println("Would You Like To Continue With The Program\n1 ) Yes\n2 ) No");

            if (input.nextInt() == 1) {
                MainMenu = true;
            } else {
                System.out.println("");
                System.exit(0);

            }
        }

    }

    private static void initialise(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            myHotel[x].setName("nobody");
        }
    }

    private static void CheckIfEmpty(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            if (myHotel[x].getName().equals("nobody")) {
                System.out.println("room " + (x + 1) + " is empty");
            }
        }
    }

    private static void BookARoom(Room[] myHotel, int roomNum) {
        String roomName;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number (1-5)");
        System.out.println("Room 1 for 2 people");
        System.out.println("Room 2 for 4 people");
        System.out.println("Room 3 for 8 people");
        System.out.println("Room 4 for 15 people and wheelchair accsses");
        System.out.println("Room 5 for 50 people");

        roomNum = input.nextInt() - 1;
        System.out.println("Enter name for room " + (roomNum + 1) + " :");
        roomName = input.next();
        myHotel[roomNum].setName(roomName);
    }

    private static void ViewAllRooms(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            System.out.println("room " + (x + 1) + " occupied by " + myHotel[x].getName());
        }
    }

    private static void DeleteCustomerFromRoom(Room[] myHotel, int roomNum) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number to delete(1-5):");
        roomNum = input.nextInt() - 1;
        myHotel[roomNum].setName("nobody");
        System.out.println("Entery Deleted :)");
    }

    private static void FindRoomFromCustomerName(Room[] myHotel) {
        Scanner input = new Scanner(System.in);
        String roomName;
        System.out.println("Enter name to Search for:");
        roomName = input.next();
        int x;
        boolean Checker = false;
        for (x = 0; x < myHotel.length; x++) {
            if (roomName.equals(myHotel[x].getName())) {
                System.out.println("The Account That Matches That name is Account number " + x);
                Checker = true;
            }
        }
        if (Checker == false) {
            System.out.println("There are no Rooms Booked with that name");
        }
    }

    private static void ViewRoomsOrderedAlphabeticallyByName(Room[] myHotel) {
        String[] myStrArray = new String[myHotel.length];
        for (int i = 0; i < myHotel.length; i++) {
            myStrArray[i] = myHotel[1].getName();
        }

        Arrays.sort(myStrArray);
        for (int a = 0; a < myStrArray.length; a++) {
            System.out.println(myStrArray[a]);
        }

    }

    public static class Room {

        private String mainName;
        int guestsInRoom;

        public Room() {
            mainName = "k";

        }

        public void setName(String aName) {
            ;
            mainName = aName;
        }

        public String getName() {
            return mainName;
        }
    }
}
