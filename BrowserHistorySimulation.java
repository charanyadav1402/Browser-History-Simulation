import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class BrowserHistorySimulation {
    private LinkedList<String> list = new LinkedList<>();
    private ListIterator<String> listItr = list.listIterator();
    private String currentPage = null;

    public void visitPage(String url) {
        while (listItr.hasNext()) {
            listItr.next();
            listItr.remove();
        }
        listItr.add(url);
        currentPage = url;
        System.out.println("Visted:" + url);
    }

    public void goBack() {
        if(listItr.hasPrevious()){
            currentPage=listItr.previous();
            System.out.println("Back to:"+ currentPage);
        }else{
            System.out.println("NO previous page exits");
        }
    }

    public void goForward() {
        if(listItr.hasNext()){
            currentPage=listItr.next();
            System.out.println("Forward to:"+ currentPage);
        }else{
            System.out.println("No forward page exits");
        }
    }

    public void currentPage() {
        if(currentPage==null){
            System.out.println("No page visited yet...");
        }else {
            System.out.println("current page:"+ currentPage);
        }
    }

    public static void main(String args[]) {
        BrowserHistorySimulation browser = new BrowserHistorySimulation();
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************");
        System.out.println("Mini Project-Browser History Simulation");
        System.out.println("*****************************");

        while (true) {
            System.out.println("\n ------Browser Menu-------");
            System.out.println("1. Visit new page");
            System.out.println("2. Go Back");
            System.out.println("3. Go forward");
            System.out.println("4. Show current page");
            System.out.println("5. Exit");

            System.out.println("enter your choice:");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter URL:");
                    String url = sc.nextLine();
                    browser.visitPage(url);
                    break;
                case 2:
                    browser.goBack();
                    break;
                case 3:
                    browser.goForward();
                    break;
                case 4:
                    browser.currentPage();
                    break;
                case 5:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid choice, please enter again");
            }
        }
    }
}
