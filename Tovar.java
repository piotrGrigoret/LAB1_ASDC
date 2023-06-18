import java.io.BufferedReader;
import java.io.IOException;
import java.util.Formatter;

public class Tovar  {
    private String name;
    private String description;
    private Prices price;
    private int number;
    private String unit;
    private int ID;

    public Tovar() {
        name = "None";
        description = "None";
        number = 0;
        unit = "None";
        ID = 0;
    }

    public Tovar(Tovar other) {
        name = other.name;
        description = other.description;
        price = other.price;
        number = other.number;
        unit = other.unit;
        ID = other.ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getID() {
        return ID;
    }

    public Prices getPrice() {
        return price;
    }

    public Tovar clone() {
        return new Tovar(this);
    }

    public boolean equal(Tovar other) {
        return (name.equals(other.name) &&
                description.equals(other.description) &&
                price == other.price &&
                number == other.number &&
                unit.equals(other.unit) &&
                ID == other.ID);
    }


    public void readingFile(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        String[] fields = line.split(", ");

        name = fields[0];
        description = fields[1];
        price = Prices.getPrice(Integer.parseInt(fields[2]));
        number = Integer.parseInt(fields[3]);
        unit = fields[4];
        ID = Integer.parseInt(fields[5]);
    }

    public String toString(){
        return (name + " " + description + " " + price + " " + number + " "  + unit + " " + ID);
    }

    public void writeElement() {
        System.out.println(name + ", " +
                description + ", " +
                price + ", " +
                number + ", " +
                unit + ", " +
                ID);
    }


    public void writeTable(Formatter formatter) {
        formatter.format("%s %s %d %d %s %-4d\n", name, description, price, number, unit, ID);
    }
}