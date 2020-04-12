package P1SistemGestiuneInscrieri;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void printCommands() {
        System.out.println("help         - Afiseaza aceasta lista de comenzi\n" +
                "add          - Adauga o noua persoana (inscriere)\n" +
                "check        - Verifica daca o persoana este inscrisa la eveniment\n" +
                "remove       - Sterge o persoana existenta din lista\n" +
                "update       - Actualizeaza detaliile unei persoane\n" +
                "guests       - Lista de persoane care participa la eveniment\n" +
                "waitlist     - Persoanele din lista de asteptare\n" +
                "available    - Numarul de locuri libere\n" +
                "guests_no    - Numarul de persoane care participa la eveniment\n" +
                "waitlist_no  - Numarul de persoane din lista de asteptare\n" +
                "subscribe_no - Numarul total de persoane inscrise\n" +
                "search       - Cauta toti invitatii conform sirului de caractere introdus\n" +
                "quit         - Inchide aplicatia");
    }

    public static int add(GuestList guestList) {
        String firstName, lastName, email, phoneNumber;
        System.out.println("Se adauga o noua persoana…");
        System.out.println("Introduceti numele de familie:");
        lastName = sc.next();
        System.out.println("Introduceti prenumele:");
        firstName = sc.next();
        System.out.println("Introduceti emailul:");
        email = sc.next();
        System.out.println("Introduceti numarul de telefon:");
        phoneNumber = sc.next();

        Guest toAdd = new Guest(firstName, lastName, email, phoneNumber);
        return guestList.addToList(toAdd);
    }

    public static void check(GuestList guestList) {
        System.out.println("Alege modul de autentificare, tastand:\n" +
                "\"1\" - Nume si prenume\n" +
                "\"2\" - Email\n" +
                "\"3\" - Numar de telefon (format \"+40733386463\")");
        int searchKey = sc.nextInt();
        if (searchKey == 1) {
            System.out.println("Introduceti numele de familie, urmat de tasta enter.");
            String firstName = sc.next();
            System.out.println("Introduceti prenumele, urmat de tasta enter.");
            String lastName = sc.next();

            Guest searchGuest = new Guest(firstName, lastName, "UNKNOWN", "UNKNOWN");
            if (guestList.searchByName(searchGuest, guestList.getParticipants()) != null) {
                System.out.println(searchGuest.getFirstName() + " " + searchGuest.getLastName() +
                        ", esti inscris pe lista de participanti.");
            }
            if (guestList.searchByName(searchGuest, guestList.getWaitingList()) != null) {
                System.out.println(searchGuest.getFirstName() + " " + searchGuest.getLastName() +
                        ", esti inscris pe lista de asteptare.");
            }
            System.out.println(searchGuest.getFirstName() + " " + searchGuest.getLastName() +
                    ", nu esti inscris la eveniment");
        }

        if (searchKey == 2) {
            System.out.println("Introduceti emailul, urmat de tasta enter.");
            String email = sc.next();
            Guest searchGuest = new Guest("UNKNOWN", "UNKNOWN", email, "UNKNOWN");
            if (guestList.searchByEmail(searchGuest, guestList.getParticipants()) != null) {
                System.out.println(searchGuest.getFirstName() + " " + searchGuest.getLastName() +
                        ", esti inscris pe lista de participanti.");
            }
            if (guestList.searchByEmail(searchGuest, guestList.getWaitingList()) != null) {
                System.out.println(searchGuest.getFirstName() + " " + searchGuest.getLastName() +
                        ", esti inscris pe lista de asteptare.");
            } else {
                System.out.println(searchGuest.getFirstName() + " " + searchGuest.getLastName() +
                        ", nu esti inscris la eveniment");
            }
        }

        if (searchKey == 3) {
            System.out.println("Introduceti numar de telefon (format \"+40733386463\"):, urmat de tasta enter.");
            String phone = sc.next();
            Guest searchGuest = new Guest("UNKNOWN", "UNKNOWN", "UNKNOWN", phone);
            if (guestList.searchByEmail(searchGuest, guestList.getParticipants()) != null) {
                System.out.println(searchGuest.getFirstName() + " " + searchGuest.getLastName() +
                        ", esti inscris pe lista de participanti.");
            }
            if (guestList.searchByEmail(searchGuest, guestList.getWaitingList()) != null) {
                System.out.println(searchGuest.getFirstName() + " " + searchGuest.getLastName() +
                        ", esti inscris pe lista de asteptare.");
            } else {
                System.out.println(searchGuest.getFirstName() + " " + searchGuest.getLastName() +
                        ", nu esti inscris la eveniment");
            }
        }
    }

    public static void remove(GuestList guestList) {
        boolean isDeleted;
        System.out.println("Se sterge o persoana existenta din lista…");
        System.out.println("Alege modul de autentificare, tastand:\n" +
                "\"1\" - Nume si prenume\n" +
                "\"2\" - Email\n" +
                "\"3\" - Numar de telefon (format \"+40733386463\")");
        int searchKey = sc.nextInt();
        if (searchKey == 1) {
            System.out.println("Introduceti numele de familie, urmat de tasta enter.");
            String lastName = sc.next();
            System.out.println("Introduceti prenumele, urmat de tasta enter.");
            String firstName = sc.next();

            Guest removeParticipant = new Guest(firstName, lastName, "UNKNOWN", "UNKNOWN");
            isDeleted = guestList.deleteParticipant(removeParticipant, 1);
            if(isDeleted){
                System.out.println("Stergerea persoanei s-a realizat cu succes.");
            } else {
                System.out.println("Persoana nu a putut fi gasita.");
            }
        }

        if (searchKey == 2) {
            System.out.println("Introduceti emailul, urmat de tasta enter.");
            String email = sc.next();
            Guest removeParticipant = new Guest("UNKNOWN", "UNKNOWN", email, "UNKNOWN");
            isDeleted = guestList.deleteParticipant(removeParticipant, 2);
            if(isDeleted){
                System.out.println("Stergerea persoanei s-a realizat cu succes.");
            } else {
                System.out.println("Persoana nu a putut fi gasita.");
            }
        }

        if (searchKey == 3) {
            System.out.println("Introduceti numar de telefon (format \"+40733386463\"):, urmat de tasta enter.");
            String phone = sc.next();
            Guest removeParticipant = new Guest("UNKNOWN", "UNKNOWN", "UNKNOWN", phone);
            isDeleted = guestList.deleteParticipant(removeParticipant, 3);
            if(isDeleted){
                System.out.println("Stergerea persoanei s-a realizat cu succes.");
            } else {
                System.out.println("Persoana nu a putut fi gasita.");
            }
        }
    }

    public static void update(GuestList guestList) {
        boolean isUpdated;
        int searchKey;
        Guest searchFor;
        String searchFirstName = "UNKNOWN";
        String searchLastName = "UNKNOWN";
        String searchEmail = "UNKNOWN";
        String searchPhone = "UNKNOWN";
        int updateKey;
        Guest updateTo;
        String updateFirstName = "UNKNOWN";
        String updateLastName = "UNKNOWN";
        String updateEmail = "UNKNOWN";
        String updatePhone = "UNKNOWN";
        System.out.println("Alege modul de autentificare, tastand:\n" +
                "\"1\" - Nume si prenume\n" +
                "\"2\" - Email\n" +
                "\"3\" - Numar de telefon (format \"+40733386463\")");
        searchKey = sc.nextInt();
        if (searchKey == 1) {
            System.out.println("Introduceti numele de familie, urmat de tasta enter.");
            searchFirstName = sc.next();
            System.out.println("Introduceti prenumele, urmat de tasta enter.");
            searchLastName = sc.next();
        }

        if (searchKey == 2) {
            System.out.println("Introduceti emailul, urmat de tasta enter.");
            searchEmail = sc.next();
        }

        if (searchKey == 3) {
            System.out.println("Introduceti numar de telefon (format \"+40733386463\"):, urmat de tasta enter.");
            searchPhone = sc.next();
        }

        System.out.println("Alege campurile pentru update, tastand:\n" +
                "\"1\" - Nume si prenume\n" +
                "\"2\" - Email\n" +
                "\"3\" - Numar de telefon (format \"+40733386463\")");

        updateKey = sc.nextInt();

        if (updateKey == 1) {
            System.out.println("Introduceti prenumele, urmat de tasta enter.");
            updateFirstName = sc.next();
            System.out.println("Introduceti numele de familie" +
                    ", urmat de tasta enter.");
            updateLastName = sc.next();
        }

        if (updateKey == 2) {
            System.out.println("Introduceti emailul, urmat de tasta enter.");
            updateEmail = sc.next();
        }

        if (searchKey == 3) {
            System.out.println("Introduceti numar de telefon (format \"+40733386463\"):, urmat de tasta enter.");
            updatePhone = sc.next();
        }
        searchFor = new Guest(searchFirstName, searchLastName, searchEmail, searchPhone);
        updateTo = new Guest(updateFirstName, updateLastName, updateEmail, updatePhone);
        isUpdated =  guestList.update(searchFor, searchKey, updateTo, updateKey);
        if(isUpdated){
            System.out.println("Actualizarea a fost facuta cu succes");
        } else {
            System.out.println("Actualizarea a esuat.");
        }
    }

    public static void guests(GuestList guestList) {
        guestList.printParticipants();
    }

    public static void waitlist(GuestList guestList) {
        guestList.printWaitingList();
    }

    public static void available(GuestList guestList) {
        System.out.println("Numarul de locuri ramase: " + guestList.showAvailableSlots());
    }

    public static void guestsNo(GuestList guestList) {
        System.out.println("Numarul de participanti: " +guestList.showParticipantListSize());
    }

    public static void waitListNo(GuestList guestList) {
        System.out.println("Dimensiunea listei de asteptare: " + guestList.showWaitingListSize());
    }

    public static void subscribeNo(GuestList guestList) {
        System.out.println("Numarul total de persoane: " + guestList.showTotalParticipants());
    }

    public static void search(GuestList guestList) {
        System.out.println("Introduceti cuvantul de cautare");
        String substring = sc.next();
        ArrayList<Guest> searchResults = guestList.partialSearch(substring);
        if (searchResults.size() != 0) {
            System.out.println("Rezultatele cautarii:");
            for (int i = 0; i < searchResults.size(); i++) {
                System.out.println(i + 1 + ". " + searchResults.get(i).getFirstName() + " " +
                        searchResults.get(i).getLastName() + " " + searchResults.get(i).getEmail() + " " +
                        searchResults.get(i).getPhoneNumber());
            }
        } else {
            System.out.println("Nu am gasit niciun resultat.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bun venit! Introduceti numarul de locuri disponibile:");
        int noOfSlots = sc.nextInt();
        GuestList event1 = new GuestList(noOfSlots);
        String command;
        do {
            System.out.println("Asteapta Comanda: help - (Afiseaza lista de comenzi)");
            command = sc.next();
            switch (command) {
                case "help":
                    printCommands();
                    break;
                case "add":
                    add(event1);
                    break;
                case "check":
                    check(event1);
                    break;
                case "remove":
                    remove(event1);
                    break;
                case "update":
                    update(event1);
                    break;
                case "guests":
                    guests(event1);
                    break;
                case "waitlist":
                    waitlist(event1);
                    break;
                case "available":
                    available(event1);
                    break;
                case "guests_no":
                    guestsNo(event1);
                    break;
                case "waitlist_no":
                    waitListNo(event1);
                    break;
                case "subscribe_no":
                    subscribeNo(event1);
                    break;
                case "search":
                    search(event1);
                    break;
                case "quit":
                    break;


            }
        } while (!command.equals("quit")) ;
    }
}