package by.grodno.pvt.site.webappsample.service;

import by.grodno.pvt.site.webappsample.domain.Worker;
import by.grodno.pvt.site.webappsample.dto.WorkerDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface WorkerService {
    List<Worker> getWorkers();

    Worker getWorker(Integer id);

    void addWorker(List<Worker> workers);

    void saveWorker(Worker worker);

    void deleteWorker(Integer number);

    List<Worker> findByExample(Worker worker);

    Page<Worker> getPage(Integer pageNum, Integer pageSize);

    void edit(WorkerDTO workerDTO);
}
