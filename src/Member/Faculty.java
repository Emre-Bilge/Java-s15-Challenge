package Member;

import java.time.LocalDate;

public class Faculty extends MemberRecord {

    public Faculty(int memberId, LocalDate dateOfMembership, int noBooksIssued, String name, String address, int phoneNo) {
        super(memberId, "faculty",  dateOfMembership, noBooksIssued, name, address, phoneNo);
    }

    @Override
    public String getType() {
        return "faculty" ;
    }
}
