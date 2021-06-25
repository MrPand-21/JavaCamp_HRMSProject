package kodlama.io.hrms.api.controllers;

import kodlama.io.hrms.business.abstracts.JobService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Job;
import kodlama.io.hrms.entities.dtos.JobForGetAllDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/jobs/")
public class JobController {

    private JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("getall")
    public DataResult<List<JobForGetAllDto>> getAll() {
        return this.jobService.getAll();
    }

    @GetMapping("getallbydate")
    public DataResult<List<JobForGetAllDto>> getAllByDate() {
        return this.jobService.getAllByDate();
    }

    @PostMapping("getalljobsofemployer")
    public DataResult<List<Job>> getAllJobsOfEmployer(@RequestParam int employerId) {
        return this.jobService.getAllJobOfEmployer(employerId);
    }

    @Transactional
    @PostMapping("setinactivetojobvisibility")
    public Result setInactiveToJobVisibility(@RequestParam int id) {
        return this.jobService.setInactiveToJobVisibility(id);
    }

    @Transactional
    @PostMapping("setactivetojobvisibility")
    public Result setActiveToJobVisibility(@RequestParam int id) {
        return this.jobService.setActiveToJobVisibility(id);
    }

    @PostMapping("add")
    public Result add(@RequestBody Job job){
        return this.jobService.add(job);
    }
}
