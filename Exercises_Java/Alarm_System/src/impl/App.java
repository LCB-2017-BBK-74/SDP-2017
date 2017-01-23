package impl;

import java.io.IOException;
import java.util.Scanner;

public class App {

  private static final String EXIT = "exit";
  private static final String POLL = "poll";

  public static void main(String[] args) throws IOException {
      ControlUnit cu = new ControlUnit();
      cu.addSensor("Lobby_1st_floor", "Fire");
      cu.addSensor("Auditorium", "Smoke");
      cu.addSensor("Cloakroom","Smoke");
      cu.addSensor("Meeting_room_1","Fire");

      SecurityControlUnit scu = new SecurityControlUnit();
      scu.addSensor("Lobby_ground_floor","Motion");
      scu.addSensor("Cloakroom","Motion");
      scu.addSensor("Meeting_room_2","Motion");

      Scanner scanner = new Scanner(System.in);
      String input = "";
      while (!input.equals(EXIT)) {
        System.out.println("Type \"poll\" to poll all sensors once or \"exit\" to exit");
        input = scanner.nextLine();
        if (input.equals(POLL)) {
            cu.pollSensors();
            scu.pollSensors();
        }
      }
  }
}
