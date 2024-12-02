public class Girl {
    private String name;
    private Diamond diamond;

    public Girl(String name) {
        this.name = name;
        this.diamond = null;
    }

    public String getName() {
        return name;
    }

    public Diamond getDiamond() {
        return diamond;
    }

    public boolean acceptDiamond(Diamond d) {
        if (d == null) return false;
        if (diamond == null || d.getValue() > diamond.getValue()) {
            diamond = d;
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        if (diamond == null) {
            return name + " has no best friend";
        } else {
            return name + " has a diamond, " + diamond.getCarats() + " carats, worth $" + diamond.getValue();
        }
    }
}
