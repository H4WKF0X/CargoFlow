package backend.domain.repository;

import backend.domain.company.Site;
import java.util.List;

public interface SiteRepository extends Repository<Site> {
    List<Site> findByCompanyId(String companyId);
}
