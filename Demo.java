public class Account {
     
    protected String accId;
    protected String name;
    protected double money;
     
    public Account (String accId,String name){
        this(accId,name,0);
    }
     
    public Account (String accId,String name,double money){
        this.accId = accId;
        this.name = name;
        this.money = money;
    }
     
    public void saveMoney(double money){
        if(money <= 0){
            System.out.println("�����������0");
        }
        this.money += money;
        System.out.println("���ɹ�");
    }
     
    public double getMoney(double money){
        if(money <= 0){
            System.out.println("ȡ����������0");
            return 0;
        }
        if(this.money <= money){
            System.out.println("���㣬�޷�ȡ��");
            return 0;
        }
        this.money -= money;
        System.out.println("ȡ��ɹ�");
        return money;
    }
     
    public double getBalance(){
        return this.money;
    }
     
    protected double getOverdraft(){
        return 0;
    }
     
    // ʵ����equals������list�Ƚ�ʱ������ȷ
    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(this == obj){
            return true;
        }
        if(obj instanceof Account){
            return this.accId.equals(((Account)obj).accId);
        }
        return false;
    }
     
    @Override
    public String toString() {
        return "�˻�=" + accId + ",����=" + name + ",���=" + money;
    }
     
}
public class Bank {
 
    // Accountʵ����equals������list����ʱ������ȷ
    private List<Account> usersAccounts;
 
    public Bank() {
        usersAccounts = new ArrayList<Account>();
    }
 
    public void addAccount(Account account) {
        if (usersAccounts.contains(account)) {
            System.out.println("���ʧ�ܣ��������ͬ�����˻�");
            return;
        }
        usersAccounts.add(account);
    }
 
    public boolean delAccount(Account account) {
        return usersAccounts.remove(account);
    }
 
    public boolean delAccount(String accId) {
        return delAccount(new Account(accId, null));
    }
 
    public boolean existAccount(Account account) {
        return usersAccounts.contains(account);
    }
 
    public boolean existAccount(String accId) {
        return existAccount(new Account(accId, null));
    }
     
    public Account getAccount(String accId){
        return usersAccounts.get(usersAccounts.indexOf(new Account(accId, null)));
    }
 
    public double getAllMoney() {
        // �������Ƿ������ֻ�ǰ������û�������
        double result = 0;
        for (Account account : usersAccounts) {
            result += account.getBalance();
        }
        return result;
    }
 
    public double getAllOverdraft() {
        // �������Ƿ����
        double result = 0;
        for (Account account : usersAccounts) {
            result += account.getOverdraft();
        }
        return result;
    }
 
    public int getAccountNum() {
        return usersAccounts.size();
    }
 
    public int getCreditAccountNum() {
        int num = 0;
        for (Account account : usersAccounts) {
            // instanceof ����û�м򵥵ķ����졣
            if (account instanceof CreditAccount) {
                num++;
            }
        }
        return num;
    }
 
    public int getSavingAccountNum() {
        int num = 0;
        for (Account account : usersAccounts) {
            if (account instanceof SavingAccount) {
                num++;
            }
        }
        return num;
    }
 
    public List<Account> getAllAccount() {
        return usersAccounts;
    }
}
public class CreditAccount extends Account{
     
    private double overdraft;
     
    public CreditAccount(String accId,String name){
        super(accId, name);
        this.overdraft = 1000;
    }
     
    public CreditAccount(String accId,String name,double money){
        this(accId, name,money,1000);
    }
     
    public CreditAccount(String accId,String name,double money,double overdraft){
        super(accId, name,money);
        this.overdraft = overdraft;
    }
     
    @Override
    public double getMoney(double money) {
        if(money <= 0){
            System.out.println("ȡ����������0");
            return 0;
        }
        if(this.money + overdraft <= money){
            System.out.println("���㣬�޷�ȡ��");
            return 0;
        }
        this.money -= money;
        System.out.println("ȡ��ɹ�");
        return money;
    }
     
    @Override
    public double getOverdraft(){
        return overdraft;
    }
     
    @Override
    public String toString() {
        return "�˻�=" + accId + ",����=" + name + ",���=" + money + ",͸֧=" + overdraft;
    }
}
public class SavingAccount extends Account {
 
    public SavingAccount(String accId, String name) {
        super(accId, name);
    }
 
    public SavingAccount(String accId, String name, double money) {
        super(accId, name, money);
    }
 
    @Override
    public double getMoney(double money) {
        return super.getMoney(money);
    }
 
    @Override
    public double getOverdraft() {
        return super.getOverdraft();
    }
     
}
public class Test {
     
    private static Bank bank = new Bank();
    public static void main(String[] args) {
        Test.genAccount();
        // ����
        Account a1 = new CreditAccount("1", "1", 200, 2000);
        Account a2 = new SavingAccount("2", "2", 300);
        Account a3 = new SavingAccount("3", "3", 400);
        Account a4 = new CreditAccount("4", "4", 500, 2000);
        Account a5 = new CreditAccount("4", "5", 600, 2000); // �ʺ�4��
        bank.addAccount(a1);
        bank.addAccount(a2);
        bank.addAccount(a3);
        bank.addAccount(a4);
        bank.addAccount(a5);
        showNowAccount();
        // ����
        bank.delAccount("1");
        bank.delAccount("2");
        showNowAccount();
        // ���
        if(bank.existAccount("3")){
            Account acc  = bank.getAccount("3");
            acc.saveMoney(100);
        }
        showNowAccount();
        // ȡ��
        if(bank.existAccount("3")){
            Account acc  = bank.getAccount("3");
            System.out.println("���=" + acc.getBalance());
            acc.getMoney(100);
            System.out.println("���=" + acc.getBalance());
            acc.getMoney(1000);
            System.out.println("���=" + acc.getBalance());
        }
        if(bank.existAccount("4")){
            Account acc  = bank.getAccount("4");
            System.out.println("���=" + acc.getBalance());
            acc.getMoney(100);
            System.out.println("���=" + acc.getBalance());
            acc.getMoney(1000);
            System.out.println("���=" + acc.getBalance());
            acc.getMoney(10000);
            System.out.println("���=" + acc.getBalance());
        }
        System.out.println(bank.getAccountNum());
        System.out.println(bank.getAllMoney());
        System.out.println(bank.getAllOverdraft());
        System.out.println(bank.getCreditAccountNum());
        System.out.println(bank.getSavingAccountNum());
    }
     
    public static void genAccount(){
        String s = "1000 0000 0000 000";
        Account a = null;
        for(int i = 1; i < 11; i ++){
            if((i & 2) == 0){
                a = new CreditAccount(s + String.valueOf(i), "�˻�" + String.valueOf(i));
            } else {
                a = new SavingAccount(s + String.valueOf(i), "�˻�" + String.valueOf(i));
            }
            bank.addAccount(a);
        }
    }
     
    public static void showNowAccount(){
        for(Account account : bank.getAllAccount()){
            System.out.println(account);
        }
    }
}