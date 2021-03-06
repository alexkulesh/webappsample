package by.grodno.pvt.site.housingAndCommunalServicesApp.converter;

import by.grodno.pvt.site.housingAndCommunalServicesApp.domain.WorkBrigade;
import by.grodno.pvt.site.housingAndCommunalServicesApp.dto.WorkBrigadeDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WorkBrigadeToDTOConverter  implements Converter<WorkBrigade, WorkBrigadeDTO> {
    @Override
    public WorkBrigadeDTO convert(WorkBrigade source) {
        WorkBrigadeDTO workBrigadeDTO = new WorkBrigadeDTO();
        workBrigadeDTO.setId(source.getId());
        workBrigadeDTO.setWorkStartTime(source.getWorkStartTime());
        workBrigadeDTO.setWorkEndTime(source.getWorkEndTime());
        workBrigadeDTO.setRequestForm(source.getRequestForm());
        workBrigadeDTO.setPlumber(source.getPlumber());
        workBrigadeDTO.setElectrician(source.getElectrician());
        workBrigadeDTO.setRepairer(source.getRepairer());
        return workBrigadeDTO;
    }
}
