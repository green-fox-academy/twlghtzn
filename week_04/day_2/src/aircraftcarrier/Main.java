package aircraftcarrier;

public class Main {
  public static void main(String[] args) {
    Carrier heliCarrier = new Carrier("Helicarrier",1000, 5000 );

    F16 f1601 = new F16();
    F16 f1602 = new F16();
    F35 f3501 = new F35();
    F35 f3502 = new F35();
    F35 f3503 = new F35();
    F35 f3504 = new F35();

    heliCarrier.addAircraft(f1601);
    heliCarrier.addAircraft(f1602);
    heliCarrier.addAircraft(f3501);
    heliCarrier.addAircraft(f3502);
    heliCarrier.addAircraft(f3503);
    heliCarrier.addAircraft(f3504);

    heliCarrier.fillAircrafts();
    heliCarrier.getStatus();

    Carrier darkLily = new Carrier("Dark Lily",1000, 5000);

    F35 f3511 = new F35();
    F35 f3512 = new F35();
    F35 f3513 = new F35();
    F35 f3514 = new F35();
    F35 f3515 = new F35();
    F35 f3516 = new F35();

    darkLily.addAircraft(f3511);
    darkLily.addAircraft(f3512);
    darkLily.addAircraft(f3513);
    darkLily.addAircraft(f3514);
    darkLily.addAircraft(f3515);
    darkLily.addAircraft(f3516);

    darkLily.fillAircrafts();
    darkLily.getStatus();

    heliCarrier.fight(darkLily);
    heliCarrier.getStatus();
    darkLily.getStatus();

    darkLily.fight(heliCarrier);
    heliCarrier.getStatus();
    darkLily.getStatus();

    darkLily.fillAircrafts();
    heliCarrier.fillAircrafts();
    heliCarrier.getStatus();
    darkLily.getStatus();

    darkLily.fight(heliCarrier);
    heliCarrier.getStatus();
    darkLily.getStatus();
  }
}
