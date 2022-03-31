package gov.irs;

public interface IRS {
    public void register(TaxPayer payer);
    public void collectTaxes();

    public static IRS getInstance() {
        return IRSEnum.INSTANCE; // IRSEnum IS-A IRS
    }
}
