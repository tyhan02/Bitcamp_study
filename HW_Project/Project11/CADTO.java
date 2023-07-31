package Project11;


public class CADTO {

    //Member테이블
    String id;
    String pwd;
    String name;
    String inputdate;

    //Account테이블
    String accDiv;		//구분 : 입출금/예적금
    String bank; 		//은행명
    String accName;		//예금주
    String accno;		//계좌번호
    String bankNick;	//계좌 간편 이름
    int accAmount;		//계좌금액

    //Card테이블
    String card;		//카드사명
    String cardName;	//명의자
    String cardno;		//카드번호
    String cardNick;	//카드 간편 이름
    int cardAmount;

    //CardWithdraw테이블, AccountDisposit 테이블, AccountWithdraw테이블
    String CADate;		//사용 일자
    String category;	//사용유형(식대, 쇼핑 등)
    int CAAmount;		//입/출금 금액
    String CANick;		//카드/계좌 간편 이름


    //Member테이블
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getInputdate() {
        return inputdate;
    }
    public void setInputdate(String inputdate) {
        this.inputdate = inputdate;
    }

    //Account테이블
    public String getAccDiv() {
        return accDiv;
    }
    public void setAccDiv(String accDiv) {
        this.accDiv = accDiv;
    }

    public String getBank() {
        return bank;
    }
    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccName() {
        return accName;
    }
    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccno() {
        return accno;
    }
    public void setAccno(String accno) {
        this.accno = accno;
    }

    public String getBankNick() {
        return bankNick;
    }
    public void setBankNick(String bankNick) {
        this.bankNick = bankNick;
    }

    public int getAccAmount() {
        return accAmount;
    }
    public void setAccAmount(int accAmount) {
        this.accAmount = accAmount;
    }

    //Card테이블
    public String getCard() {
        return card;
    }
    public void setCard(String card) {
        this.card = card;
    }

    public String getCardName() {
        return cardName;
    }
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardno() {
        return cardno;
    }
    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getCardNick() {
        return cardNick;
    }
    public void setCardNick(String cardNick) {
        this.cardNick = cardNick;
    }

    public int getCardAmount() {
        return cardAmount;
    }
    public void setCardAmount(int cardAmount) {
        this.cardAmount = cardAmount;
    }

    //CardWithdraw테이블, AccountDisposit 테이블, AccountWithdraw테이블
    public String getCADate() {
        return CADate;
    }
    public void setCADate(String cADate) {
        CADate = cADate;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public int getCAAmount() {
        return CAAmount;
    }
    public void setCAAmount(int cAAmount) {
        CAAmount = cAAmount;
    }

    public String getCANick() {
        return CANick;
    }
    public void setCANick(String cANick) {
        CANick = cANick;
    }

    public void printAcc() {
        System.out.printf("%6s통장\t%10s\t%10s\t%20s\t%10d\t%8s\n",accDiv,bank,accName,accno,accAmount,bankNick);

    }

    public void printCard() {
        String str = "카드";
        System.out.printf("     %6s\t%10s\t%10s\t%20s\t%10d\t%8s\n",str,card,cardName,cardno,cardAmount,cardNick);

    }

    public void print(){
        System.out.printf("%s %s %5s %10d %6s \n", id, CADate, CANick, accAmount, category);
    }

}