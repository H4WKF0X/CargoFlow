package backend.domain.company;

/** Bankruptcy report (kept simple for MVP). */
public record BankruptcyReport(String companyId, String siteId, long tick, double fitness, String note) { }
