package by.grodno.pvt.site.housingAndCommunalServicesApp.service.impl;

import by.grodno.pvt.site.housingAndCommunalServicesApp.domain.*;
import by.grodno.pvt.site.housingAndCommunalServicesApp.dto.WorkerDTO;
import by.grodno.pvt.site.housingAndCommunalServicesApp.exception.WorkerNotFoundException;
import by.grodno.pvt.site.housingAndCommunalServicesApp.repo.UserRepo;
import by.grodno.pvt.site.housingAndCommunalServicesApp.repo.WorkersRepo;
import by.grodno.pvt.site.housingAndCommunalServicesApp.service.WorkerService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class JPAWorkerService implements WorkerService{
    @Autowired
    private WorkersRepo repo;
    @Autowired
    private UserRepo userRepo;

    @Override
    public void addWorker(List<Worker> workers) {
        repo.saveAll(workers);
    }

    @Override
    public List<Worker> getWorkers() {
        return repo.findAll();
    }

    @Override
    public void deleteWorker(Integer number) {
        repo.deleteById(number);
    }

    @Override
    public List<Worker> findByExample(Worker worker) {
        Example<Worker> exp = Example.of(worker,
                ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));
        return repo.findAll(exp);
    }

    @Override
    public Page<Worker> getPage(Integer pageNum, Integer pageSize) {
        return repo.findAll(PageRequest.of(pageNum, pageSize, Sort.Direction.ASC, "worker"));
    }

    @Override
    public Worker getWorker(Integer id) {
        return repo.getOne(id);
    }

    @Override
    public void saveWorker(Worker worker) {
        repo.save(worker);

    }

    @Override
    public void edit(WorkerDTO workerDTO) {
        Worker findById = repo.findById(workerDTO.getId()).orElseThrow(() -> new WorkerNotFoundException());
        findById.setUser(workerDTO.getUser());
        findById.setWorkerRole(workerDTO.getWorkerRole());
        findById.setIsBusy(workerDTO.getIsBusy());
        repo.save(findById);
    }
}
