
package View;

import Common.Library;
import java.util.ArrayList;


public abstract class Menu<T> {
    protected String title;
    protected ArrayList<T> Choose;
    Library l = new Library();
    
    public Menu() {
        Choose = new ArrayList<>();
    }
    
    public Menu(String td, String[] mc) {
        title = td;
        Choose = new ArrayList<>();
        for (String s : mc) {
            Choose.add((T) s);
        }
    }
    
    public void display() {
        System.out.println(title);
        System.out.println("++++++++++++++");
        for(int i = 0; i < Choose.size(); i++) {
            System.out.println((i + 1) + ":" + Choose.get(i));
        }
        System.out.println(" ");
    }
    
    
    public int getSelected() {
        display();
        return l.getInt("Enter your choice", 1, Choose.size() + 1);
    }
    
    public abstract void execute(int n);
    
    
    public void run() {
        while(true) {
            int n = getSelected();
            execute(n);
            if(n > Choose.size()) {
                break;
            }
        }
    }
}
