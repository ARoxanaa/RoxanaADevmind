package P1SistemGestiuneInscrieri;

import java.util.ArrayList;

public class GuestList {
    private final int availableSlots;
    private ArrayList<Guest> participants, waitingList;

    public GuestList(int availableSlots){
        this.availableSlots = availableSlots;
        ArrayList<Guest> participants = new ArrayList<Guest>();
        ArrayList<Guest> waitingList = new ArrayList<Guest>();
    }

    public int searchByName(String firstName, String lastName, ArrayList<Guest> list){
        if(list.isEmpty()){
            return -1;
        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getFirstName().equals(firstName) &&
                    list.get(i).getLastName().equals(lastName)){
                return i;
            }
        }
        return -1;
    }

    public int searchByEmail(String email, ArrayList<Guest> list){
        if(list.isEmpty()){
            return -1;
        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getEmail().equals(email)){
                return i;
            }
        }
        return -1;
    }
    public int searchByPhone(String phone, ArrayList<Guest> list){
        if(list.isEmpty()){
            return -1;
        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getPhoneNumber().equals(phone)){
                return i;
            }
        }
        return -1;
    }

    public int addToList(Guest addGuest){
        if(searchByName(addGuest.getFirstName(),addGuest.getLastName(),this.participants) >= 0
                || searchByEmail(addGuest.getEmail(),this.participants) >= 0
                    || searchByPhone(addGuest.getPhoneNumber(),this.participants) >= 0){
            System.out.println("Esti deja inscris pe lista de participanti!");
            return -1;
        }
        if(this.participants.size() + 1 <= this.availableSlots){
            participants.add(addGuest);
            System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!.");
            return 0;
        }
        if(searchByName(addGuest.getFirstName(),addGuest.getLastName(),this.waitingList) >= 0
                || searchByEmail(addGuest.getEmail(),this.waitingList) >= 0
                || searchByPhone(addGuest.getPhoneNumber(),this.waitingList) >= 0){
            System.out.println("Esti deja inscris pe lista de asteptare!");
            return -1;
        }
        waitingList.add(addGuest);
        System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine <"
                + (waitingList.indexOf(addGuest) + 1) + ">. Te vom notifica daca un loc devine disponibil.");
        return waitingList.indexOf(addGuest) + 1;
    }

    public int isOnWaitingList(String param1, String param2, int searchKey){
        if(searchKey == 1){
            return searchByName(param1, param2, this.waitingList);
        }
        if(searchKey == 2){
            return searchByEmail(param1,this.waitingList);
        }
        if(searchKey == 3){
            return searchByPhone(param1,this.waitingList);
        }
        return -1;
    }

    public int isOnParticipantList(String param1, String param2, int searchKey){
        if(searchKey == 1){
            return searchByName(param1, param2, this.participants);
        }
        if(searchKey == 2){
            return searchByEmail(param1,this.participants);
        }
        if(searchKey == 3){
            return searchByPhone(param1,this.participants);
        }
        return -1;
    }

    private boolean removeFromParticipants(int position){
        if(!this.participants.isEmpty()){
            this.participants.remove(position);
            if(!this.waitingList.isEmpty()){
                this.participants.add(waitingList.get(0));
                System.out.println("Felicitari, " + this.participants.get(this.participants.size() - 1).getFirstName() +
                        " " + this.participants.get(this.participants.size() - 1).getLastName() +
                        "! Locul tau la eveniment este confirmat. Te asteptam!.");
                removeFromWaitingList(0);
            }
            return true;
        }
        return false;
    }

    private boolean removeFromWaitingList(int position){
        if(!this.waitingList.isEmpty()){
            this.waitingList.remove(0);
            return true;
        }
        return false;
    }

    public boolean deleteParticipant(String param1, String param2, int searchKey){
        int positionParticipants = isOnParticipantList(param1,param2,searchKey);
        if(positionParticipants >= 0){
            return removeFromParticipants(positionParticipants);
        } else {
            int positionWaitingList = isOnWaitingList(param1,param2,searchKey);
            if(positionWaitingList >= 0){
                return removeFromWaitingList(positionWaitingList);
            }
        }
        return false;
    }

}
