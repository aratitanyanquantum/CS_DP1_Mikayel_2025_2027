package lesson_2026_05_27.homework;
import java.util.ArrayList;

class TripAllocator {

    private Trip[] allTrips = new Trip[16];
    private Student[] allStudents = new Student[250];
    ArrayList<String> aList = new ArrayList<String>();

    public void showLowPopularityTrips(int[][] popularity) {
        int[] tripPop = new int[16];
        avgPopularity(popularity, tripPop);

        for (int i = 0; i < allTrips.length; i++) {
            if (popularity[i][0] < tripPop[i]) {
                System.out.println(allTrips[i].getTripTitle());
            }
        }
    }

    public void assignTrip(Student s) {
        for (int i = 0; i < s.getSPreferenceList().length; i++) {
            int preferredTripNumber = s.getSPreferenceList()[i];
            Trip t = allTrips[preferredTripNumber - 1];
            if (t.getPlacesFilled() < 25) {
                s.setTripAssigned(t.getTripTitle());
                t.addStudentToTripList(s);
                t.updatePlacesFilled();
                return;
            }
        }
    }

    public void displayPlacesLeft() {
        for (int i = 0; i < allTrips.length; i++) {
            Trip t = allTrips[i];
            if (t.isRunning() && t.getPlacesFilled() < 25) {
                int placesLeft = 25 - t.getPlacesFilled();
                System.out.println("Trip " + (i + 1) + ": " + t.getTripTitle()
                        + "           Places left: " + placesLeft);
            }
        }
    }

    public int noTrip() {
        int count = 0;
        for (int i = 0; i < allStudents.length; i++) {
            if (allStudents[i].getTripAssigned().equals("zzz")) {
                count++;
            }
        }
        return count;
    }

    public Trip[] getAllTrips() {
        return allTrips;
    }

    public Student[] getAllStudents() {
        return allStudents;
    }

    public void setAllTrips(Trip[] allTrips) {
        this.allTrips = allTrips;
    }

    public void setAllStudents(Student[] allStudents) {
        this.allStudents = allStudents;
    }



    public void avgPopularity(int[][] popularity, int[] tripPop) {
        for (int i = 0; i < popularity.length; i++) {
            int total = 0;
            for (int j = 0; j < popularity[i].length; j++) {
                total += popularity[i][j];
            }
            tripPop[i] = total / popularity[i].length;
        }
    }

    public void aMethod(int n) {
        for (int i = n; i >= 0; i--) {
            if (allTrips[i].isRunning() == false) {
                for (int j = 0; j < allTrips[i].getList().size(); j++) {
                    aList.add((String) allTrips[i].getList().get(j));
                }
            }
        }
    }


}




class Student {

    private String sId;
    private String sName;
    private int sGrade;
    private String tripAssigned;
    public int[] sPreferenceList = new int[10];

    public Student(String sID, String sName, int sGrade, int[] sPreferenceList) {
        this.sId = sID;
        this.sName = sName;
        this.sGrade = sGrade;
        this.sPreferenceList = sPreferenceList;
        this.tripAssigned = "zzz";
    }

    public void setTripAssigned(String tripAssigned) {
        this.tripAssigned = tripAssigned;}

    public String getName() {return sName;}

    public String getTripAssigned() {return tripAssigned;}


    public String getSId() {return sId;}

    public int getSGrade() {return sGrade;}

    public int[] getSPreferenceList() {return sPreferenceList;}

    public void setSId(String sId) {
        this.sId = sId;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public void setSGrade(int sGrade) {
        this.sGrade = sGrade;
    }

    public void setSPreferenceList(int[] sPreferenceList) {
        this.sPreferenceList = sPreferenceList;
    }

}



class Trip {

    private int tripNumber;
    private String tripTitle;
    private String tripDesc;
    private int placesFilled;
    private boolean isRunning;
    private ArrayList<String> tList = new ArrayList<String>();

    public Trip(int tripNumber, String tripTitle, String tripDesc) {
        this.tripNumber = tripNumber;
        this.tripTitle = tripTitle;
        this.tripDesc = tripDesc;
        this.placesFilled = 0;
        this.isRunning = false;
    }

    public String getTripTitle() {return tripTitle;}

    public ArrayList<String> getList() {return tList;}

    public int getPlacesFilled() {return placesFilled;}

    public boolean isRunning() {return isRunning;}

    public void setTripTitle(String tripTitle) {
        this.tripTitle = tripTitle;}

    public void updatePlacesFilled() {
        this.placesFilled++;
        if (this.placesFilled >= 10) {
            this.isRunning = true;
        }
    }

    public void addStudentToTripList(Student s){
        tList.add(s.getName());}


    public int getTripNumber() {return tripNumber;}

    public String getTripDesc() {return tripDesc;}

    public void setTripNumber(int tripNumber) {
        this.tripNumber = tripNumber;
    }

    public void setTripDesc(String tripDesc) {
        this.tripDesc = tripDesc;
    }

    public void setPlacesFilled(int placesFilled) {
        this.placesFilled = placesFilled;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void setList(ArrayList<String> tList) {
        this.tList = tList;
    }

}


public class SchoolTripDemo {
    static void main(String[] args) {

    }
}
