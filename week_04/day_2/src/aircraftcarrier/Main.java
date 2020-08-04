package aircraftcarrier;

public class Main {
  public static void main(String[] args) {
    Carrier heliCarrier = new Carrier(1000, 5000 );
    heliCarrier.getStatus();

    F16 f1601 = new F16();
    F16 f1602 = new F16();
    F16 f1603 = new F16();
    F35 f3501 = new F35();
    F35 f3502 = new F35();
    F35 f3503 = new F35();

    heliCarrier.addAircraft(f1601);
    heliCarrier.addAircraft(f1602);
    heliCarrier.addAircraft(f1603);
    heliCarrier.addAircraft(f3501);
    heliCarrier.addAircraft(f3502);
    heliCarrier.addAircraft(f3503);

    heliCarrier.getStatus();

    heliCarrier.fillAircrafts();
    heliCarrier.getStatus();

  }
}
