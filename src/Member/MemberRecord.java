package Member;


import LibrarySystem.Book;

import java.time.LocalDate;

public class MemberRecord {
    private int memberId;
    private String type ;
    private LocalDate dateOfMembership;
    private int noBooksIssued;
    private final int maxBookLimit = 5;
    private String name ;
    private String address;
    private int phoneNo;


    public MemberRecord(int memberId, String type, LocalDate dateOfMembership,
                        int noBooksIssued, String name, String address, int phoneNo) {
        this.memberId = memberId;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.noBooksIssued = noBooksIssued;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDateOfMembership() {
        return dateOfMembership;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public int incBookIssued(){
       if(noBooksIssued >= maxBookLimit){
           throw new IllegalArgumentException("limitinize ulaştığınız için daha fazla kitap alamazsınız.");
       }
       return noBooksIssued++ ;
    }
    public int decBookIssued(){            // member ve Book parametre alacakmı bılemedım .
       if(noBooksIssued > 0){
           noBooksIssued --;
       }
       else {
           System.out.println("iade edilecek kitap bulunamadı");
       }
        return noBooksIssued;
    }
    public void payBill(double amount) {
        if (amount <= 0) {
            System.out.println("geçersiz bir miktar girildi;");
            return;
        } else {
            System.out.println(name + " Adlı kullanıcı tarafından " + amount + " kadar ödeme yapıldı");
        }
    }


    }



