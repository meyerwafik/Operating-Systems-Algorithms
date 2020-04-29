
package peterson;

public class Peterson {

    public static void main(String[] args) {
        Processes I = new iProcess();
         Processes J = new jProcess();
         I.start();
         J.start();


    }
    
}
