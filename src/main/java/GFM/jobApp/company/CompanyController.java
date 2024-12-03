package GFM.jobApp.company;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getCompanies() {
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCompany(@RequestBody Company company) {
        companyService.addCompany(company);
        return new ResponseEntity<>("Company created", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable long id, @RequestBody Company company) {
        companyService.updateCompany(id, company);
        return new ResponseEntity<>("Company Updated Successfully", HttpStatus.OK);
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable long id) {
        Company company = companyService.getCompany(id);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable long id) {
        boolean deleted = companyService.deleteCompany(id);
        if(deleted) {
            return new ResponseEntity<>("Company Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Company Not Found", HttpStatus.NOT_FOUND);
        }
    }
}
