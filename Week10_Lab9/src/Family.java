public class Family {
    private Person[] people;
    private int numberOfPeople;
    private int totalAge;


    //default constructor
    public Family() {
        people = new Person[10];
        numberOfPeople = 0;
        totalAge = 0;
    }

    //IO method to display family members
    public void display() {
        for (int i = 0; i < numberOfPeople; i++) {
            System.out.println(people[i]);
        }
    }


    public boolean addPerson(String name, int age) {
        if (numberOfPeople < 10) {
            people[numberOfPeople] = new Person(name, age);
            numberOfPeople++;
            totalAge += age;
            return true;
        } else {
            return false;
        }
    }

    public void birthday(String name) {
        for (int i = 0; i < numberOfPeople; i++) {
            if (people[i].getName().equalsIgnoreCase(name)) {
                people[i].incrementAge();
                totalAge++;
                break;
            }
        }
    }

    // Accessor method to return the number of people
    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    // Accessor method to return the total age
    public int getTotalAge() {
        return totalAge;
    }
}
