package LaboratoriskiVezbi.vezba7;

import AuditoriskiVezbi.aud07.CBHT;
import AuditoriskiVezbi.aud07.MapEntry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

class Medicine implements Comparable<Medicine>{
    private String name;
    private boolean isPositive;
    private int price;
    private int amount;

    public Medicine(String name) {
        this.name = name;
        isPositive = false;
        this.amount = 0;
        price = 0;
    }

    public Medicine(String name, boolean isPositive, int piecesAvailable, int amount) {
        this.name = name;
        this.isPositive = isPositive;
        this.price = piecesAvailable;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public boolean isPositive() {
        return isPositive;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public int hashCode(){
        return (29* (29*(29*0+ (int) name.charAt(0))+ (int) name.charAt(1))+ (int)name.charAt(2)) % 102780 ;
    }


    public int compareTo(Medicine med) {
        return this.name.compareTo(med.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return name.equals(medicine.name);
    }

    public String toString(){
        return String.format("%s\n%s\n%d\n%d", name, !isPositive ? "NEG":"POS", price, amount);
    }


}

public class Apteka {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        CBHT<Medicine, Integer> medicines = new CBHT<>(102780);

        int N = Integer.parseInt(bf.readLine());

        for(int i=0; i<N; i++){
            String line = bf.readLine();
            String[] parts = line.split(" ");
            medicines.insert(new Medicine(parts[0].toUpperCase(), !parts[1].equals("0"),
                            Integer.parseInt(parts[2]), Integer.parseInt(parts[3])),
                    Integer.parseInt(parts[3]));
        }
        while (true){
            String name = bf.readLine().toUpperCase();
            System.out.println(name);
            if(name.equals("KRAJ"))
                break;
            int amount = Integer.parseInt(bf.readLine());
            if(medicines.search(new Medicine(name)) == null)
                System.out.println("Nema takov lek");
            else if(medicines.search(new Medicine(name)).element.element >= amount){
                Medicine med = medicines.search(new Medicine(name)).element.key;
                System.out.println(med);
                Integer num = medicines.search(new Medicine(name)).element.element;
                System.out.println(med);
                medicines.insert(new Medicine(med.getName(), med.isPositive(), med.getPrice(), med.getAmount() - amount),
                        med.getAmount() - amount);
            }
            else{
                System.out.println(medicines.search(new Medicine(name)).element.key);
                System.out.println("Nema dovolno lekovi");
            }
        }
    }
}
