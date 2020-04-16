package csv.stauplan;

public class Container {
    private int nr;
    private int weight;


    public Container(int nr, int weight) {
        this.nr = nr;
        this.weight = weight;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Container{" +
                "nr=" + nr +
                ", weight=" + weight +
                '}';
    }
}
