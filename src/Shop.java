import java.util.List;

public class Shop extends User {
    /** class that shish **/
    double importo;
    int id;


    public Shop(double importo, int id) {
        this.importo = importo;
        this.id = id;
    }


    @Override
    public String toString() {
        return "Shop{" + "importo=" + importo + ", id=" + id + '}';
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
