package LaboratoriskiVezbi.vezba3.Zadaca1;

public class Operation {
    int a;
    int b;
    char operation;

    public Operation(char a, char b, char operation){
        this.a = Integer.parseInt (String.valueOf (a)) ;
        this.b = Integer.parseInt (String.valueOf (b));
        this.operation = operation;
    }

    public int getOperation(){
        if(operation == '+')
            return a+b;
        return a-b;
    }
}
