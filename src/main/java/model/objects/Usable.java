package model.objects;
/**
 * Clase Padre que especifica elementos de tipo Usable.
 */
public interface Usable {
    String getName();
    String getDescription();
    int getPrice();
    void setName(String name);
    boolean getIsTaken();
    void setTaken(boolean isTaken);
    void setPrice(int price);
}
