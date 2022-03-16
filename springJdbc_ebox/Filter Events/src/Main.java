import com.spring.dao.EventDAO;
import com.spring.entity.Event;
import com.spring.entity.Hall;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static void main(String[] args) {
		Logger log = Logger.getLogger("org.hibernate");
		log.setLevel(Level.OFF);
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EventDAO dao = context.getBean("eventDAO", EventDAO.class);
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Select from the list\n" +
                    "1) Display Hall and Events\n" +
                    "2) Find Events\n" +
                    "3) Exit"
            );
            int p = Integer.parseInt(sc.nextLine());
            if(p == 3){
                System.out.println("Thank you"); break;
            }
            List<Event> list = null;
            switch (p) {
                case 1:
                    list = dao.getAllEvents();
                    System.out.println("...Hall and Event List...");
                    System.out.printf("%-15s %-15s %-15s %-15s %-15s %s\n","Id","Event Name","Organiser Name","Organiser Number", "Hall Name", "Location");
                    for(Event e : list) {
                        System.out.print(e.toString());
                    }
                    break;
                case 2:
                    System.out.println("Enter the hall name to display events");
                    String hname = sc.nextLine();
                    Hall h = dao.findHallByName(hname);
                    if(h == null) {
                        System.out.println("No such hall");
                        break;
                    }
                    list = dao.findEventsByHallId(h.getId());
                    int count = 1;
                    for(Event e : list) {
                        System.out.println(count + ") " + e.getEventName()); count++;
                    }
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }
	}
}

