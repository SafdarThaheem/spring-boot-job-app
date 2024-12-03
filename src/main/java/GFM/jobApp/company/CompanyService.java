package GFM.jobApp.company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();
    boolean updateCompany(Long id, Company company);
    void addCompany(Company company);
    Company getCompany(Long id);
    boolean deleteCompany(Long id);
}
