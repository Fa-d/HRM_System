package go.faddy.hmrsystem.api.responses;

public class SupplierFetchResponseModel {
    private String supname, invnum, invdate, doctype;
    private int debit, credit, supcode;

    public SupplierFetchResponseModel(String supname, String invnum, String invdate,
                                      String doctype, int debit, int credit, int supcode) {
        this.supname = supname;
        this.invnum = invnum;
        this.invdate = invdate;
        this.doctype = doctype;
        this.debit = debit;
        this.credit = credit;
        this.supcode = supcode;
    }

    public String getSupname() {
        return supname;
    }

    public void setSupname(String supname) {
        this.supname = supname;
    }

    public String getInvnum() {
        return invnum;
    }

    public void setInvnum(String invnum) {
        this.invnum = invnum;
    }

    public String getInvdate() {
        return invdate;
    }

    public void setInvdate(String invdate) {
        this.invdate = invdate;
    }

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }

    public int getDebit() {
        return debit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getSupcode() {
        return supcode;
    }

    public void setSupcode(int supcode) {
        this.supcode = supcode;
    }
}
