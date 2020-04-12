package P1SistemGestiuneInscrieri;

import java.util.ArrayList;

public class GuestList {
    private final int numberOfSlots;
    private ArrayList<Guest> participants, waitingList;

    public int getNumberOfSlots() {
        return numberOfSlots;
    }

    public ArrayList<Guest> getParticipants() {
        return participants;
    }

    public ArrayList<Guest> getWaitingList() {
        return waitingList;
    }

    public GuestList(int numberOfSlots){
        this.numberOfSlots = numberOfSlots;
        this.participants = new ArrayList<>(numberOfSlots);
        this.waitingList = new ArrayList<>();
    }

    public Guest searchByName(Guest who, ArrayList<Guest> list){
        if(list.isEmpty()){
            return null;
        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getFirstName().equals(who.getFirstName()) &&
                    list.get(i).getLastName().equals(who.getLastName())){
                return list.get(i);
            }
        }
        return null;
    }

    public Guest searchByEmail(Guest who, ArrayList<Guest> list){
        if(list.isEmpty()){
            return null;
        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getEmail().equals(who.getEmail())){
                return list.get(i);
            }
        }
        return null;
    }
    public Guest searchByPhone(Guest who, ArrayList<Guest> list){
        if(list.isEmpty()){
            return null;
        }
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getPhoneNumber().equals(who.getPhoneNumber())){
                return list.get(i);
            }
        }
        return null;
    }

    public int addToList(Guest addGuest){
        if(this.participants.size() == 0 && this.numberOfSlots > 0){
            this.participants.add(addGuest);
            System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!.");
            return 0;
        }
        if(searchByName(addGuest,this.participants) != null
                || searchByEmail(addGuest,this.participants) != null
                    || searchByPhone(addGuest,this.participants) != null){
            System.out.println("Esti deja inscris pe lista de participanti!");
            return -1;
        }
        if(this.participants.size() + 1 <= this.numberOfSlots){
            this.participants.add(addGuest);
            System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!.");
            return 0;
        }
        if(searchByName(addGuest,this.waitingList) != null
                || searchByEmail(addGuest,this.waitingList) != null
                || searchByPhone(addGuest,this.waitingList) != null){
            System.out.println("Esti deja inscris pe lista de asteptare!");
            return -1;
        }
        waitingList.add(addGuest);
        System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine <"
                + (waitingList.indexOf(addGuest) + 1) + ">. Te vom notifica daca un loc devine disponibil.");
        return waitingList.indexOf(addGuest) + 1;
    }

    public Guest isOnWaitingList(Guest who, int searchKey){
        if(searchKey == 1){
            return searchByName(who, this.waitingList);
        }
        if(searchKey == 2){
            return searchByEmail(who,this.waitingList);
        }
        if(searchKey == 3){
            return searchByPhone(who,this.waitingList);
        }
        return null;
    }

    public Guest isOnParticipantList(Guest who, int searchKey){
        if(searchKey == 1){
            return searchByName(who, this.participants);
        }
        if(searchKey == 2){
            return searchByEmail(who,this.participants);
        }
        if(searchKey == 3){
            return searchByPhone(who,this.participants);
        }
        return null;
    }

    private boolean removeFromParticipants(Guest who){
        if(!this.participants.isEmpty()){
            this.participants.remove(who);
            if(!this.waitingList.isEmpty()){
                this.participants.add(waitingList.get(0));
                System.out.println("Felicitari, " + this.participants.get(this.participants.size() - 1).getFirstName() +
                        " " + this.participants.get(this.participants.size() - 1).getLastName() +
                        "! Locul tau la eveniment este confirmat. Te asteptam!.");
                removeFromWaitingList(waitingList.get(0));
            }
            return true;
        }
        return false;
    }

    private boolean removeFromWaitingList(Guest who){
        if(!this.waitingList.isEmpty()){
            this.waitingList.remove(who);
            return true;
        }
        return false;
    }

    public boolean deleteParticipant(Guest who, int searchKey){
        Guest toRemoveParticipant = isOnParticipantList(who,searchKey);
        if(toRemoveParticipant != null){
            return removeFromParticipants(toRemoveParticipant);
        } else {
            Guest removeWaiting = isOnWaitingList(who,searchKey);
            if(removeWaiting != null){
                return removeFromWaitingList(removeWaiting);
            }
        }
        return false;
    }

    public boolean update(Guest who, int searchKey, Guest updateTo, int updateKey){
        Guest findParticipant = isOnParticipantList(who,searchKey);
        if(findParticipant != null && updateTo != null) {
            boolean hasSameUpdateDetails;
            for (int i = 0; i < this.participants.size(); i++) {
                if (this.participants.get(i).getFirstName().equals(updateTo.getFirstName()) ||
                        this.participants.get(i).getLastName().equals(updateTo.getLastName()) ||
                        this.participants.get(i).getEmail().equals(updateTo.getEmail()) ||
                        this.participants.get(i).getPhoneNumber().equals(updateTo.getPhoneNumber())) {
                    return false;
                }
            }
        }
            if(findParticipant != null && updateTo != null && updateKey == 1){
                findParticipant.setFirstName(updateTo.getFirstName());
                findParticipant.setLastName(updateTo.getLastName());
                return true;
            }
            if(findParticipant != null && updateTo != null && updateKey == 2){
                findParticipant.setEmail(updateTo.getEmail());
                return true;
            }
            if(findParticipant != null && updateTo != null && updateKey == 3){
                findParticipant.setPhoneNumber(updateTo.getPhoneNumber());
                return true;
            } else {
            Guest findWaitingList = isOnWaitingList(who,searchKey);
            if(findWaitingList != null && findParticipant != null && updateTo != null) {
                for (int i = 0; i < this.waitingList.size(); i++) {
                    if (this.waitingList.get(i).getFirstName().equals(updateTo.getFirstName()) ||
                            this.waitingList.get(i).getLastName().equals(updateTo.getLastName()) ||
                            this.waitingList.get(i).getEmail().equals(updateTo.getEmail()) ||
                            this.waitingList.get(i).getPhoneNumber().equals(updateTo.getPhoneNumber())) {
                        System.out.println("Actualizare esuata. Detaliile exista deja in sistem.");
                        return false;
                    }
                }
            }
                if(findWaitingList != null && updateTo != null && updateKey == 1){
                    findWaitingList.setFirstName(updateTo.getFirstName());
                    findWaitingList.setLastName(updateTo.getLastName());
                    return true;
                }
                if(findWaitingList != null && updateTo != null && updateKey == 2){
                    findWaitingList.setEmail(updateTo.getEmail());
                    return true;
                }
                if(findWaitingList != null && updateTo != null && updateKey == 3){
                    findWaitingList.setPhoneNumber(updateTo.getPhoneNumber());
                    return true;
                }
            }
        return false;
    }

    public void printParticipants(){
        if(this.participants.size() == 0){
            System.out.println("Niciun participant inscris…");
        } else {
            for(int i = 0; i < this.participants.size(); i++){
                System.out.println(i + 1 + ". Nume: " + this.participants.get(i).getFirstName() + " " +
                        this.participants.get(i).getLastName() + ", Email: " + this.participants.get(i).getEmail() +
                        ", Telefon: " + this.participants.get(i).getPhoneNumber());
            }
        }
    }

    public void printWaitingList(){
        if(this.waitingList.size() == 0){
            System.out.println("Lista de asteptare este goala.");
        } else {
            for(int i = 0; i < this.waitingList.size(); i++){
                System.out.println(i + 1 + ". Nume: " + this.waitingList.get(i).getFirstName() + " " +
                        this.waitingList.get(i).getLastName() + ", Email: " + this.waitingList.get(i).getEmail() +
                        ", Telefon: " + this.waitingList.get(i).getPhoneNumber());
            }
        }
    }

    public int showAvailableSlots(){
        return this.numberOfSlots - this.participants.size();
    }

    public int showParticipantListSize(){
        return this.participants.size();
    }

    public int showWaitingListSize(){
        return this.waitingList.size();
    }

    public int showTotalParticipants(){
        return this.waitingList.size() + this.participants.size();
    }

    public ArrayList<Guest> partialSearch(String searchWord){
        ArrayList<Guest> searchResults = new ArrayList<>();
        for(int i = 0; i < this.participants.size(); i++){
            if(this.participants.get(i).getFirstName().toLowerCase().contains(searchWord.toLowerCase()) ||
                    this.participants.get(i).getLastName().toLowerCase().contains(searchWord.toLowerCase()) ||
                        this.participants.get(i).getEmail().toLowerCase().contains(searchWord.toLowerCase()) ||
                            this.participants.get(i).getPhoneNumber().toLowerCase().contains(searchWord.toLowerCase())){
                searchResults.add(this.participants.get(i));
            }
        }

        for(int i = 0; i < this.waitingList.size(); i++){
            if(this.waitingList.get(i).getFirstName().toLowerCase().contains(searchWord.toLowerCase()) ||
                    this.waitingList.get(i).getLastName().toLowerCase().contains(searchWord.toLowerCase()) ||
                    this.waitingList.get(i).getEmail().toLowerCase().contains(searchWord.toLowerCase()) ||
                    this.waitingList.get(i).getPhoneNumber().toLowerCase().contains(searchWord.toLowerCase())){
                searchResults.add(this.waitingList.get(i));
            }
        }
        return searchResults;
    }



}
