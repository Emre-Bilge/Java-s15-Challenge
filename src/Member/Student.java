package Member;

import java.time.LocalDate;

public class Student extends MemberRecord{


    public Student(int memberId,  LocalDate dateOfMembership, int noBooksIssued,
                   String name, String address, int phoneNo) {
        super(memberId, "Student", dateOfMembership, noBooksIssued, name, address, phoneNo);
    }

    @Override
    public String getType() {
        return "Student" ;
    }
}
