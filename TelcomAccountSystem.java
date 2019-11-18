
class TelcomUser {
      private String phoneNumber;
      private String callTo;
     private StringBuffer communicationRecords;
     public TelcomUser (String phoneNuber){
            this.phoneNumber = phoneNumber;
            this.communicationRecords = new StringBuffer();
}
void generateCommunicateRecord(){ 
     int recordNum = new Random().nextInt(10);
     for (int i = 0;i <= recordNum; i++){
     


}}






















public class TelcomAccountSystem {
      public static void main (String[] args){
             TelcomUser telcomUser = new TelcomUser("13800138000");
             telcomUser.generateCommunicateRecord();
             telcomUser.printDetails();
}
}


